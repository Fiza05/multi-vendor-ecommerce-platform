package com.fiza.ecommerce_multivendor.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.fiza.ecommerce_multivendor.config.JwtProvider;
import com.fiza.ecommerce_multivendor.domain.USER_ROLE;
import com.fiza.ecommerce_multivendor.exception.SellerException;
import com.fiza.ecommerce_multivendor.exception.UserException;
import com.fiza.ecommerce_multivendor.model.Cart;
import com.fiza.ecommerce_multivendor.model.User;
import com.fiza.ecommerce_multivendor.model.VerificationCode;
import com.fiza.ecommerce_multivendor.repository.CartRepository;
import com.fiza.ecommerce_multivendor.repository.UserRepository;
import com.fiza.ecommerce_multivendor.repository.VerificationCodeRepository;
import com.fiza.ecommerce_multivendor.request.LoginRequest;
import com.fiza.ecommerce_multivendor.request.SignupRequest;
import com.fiza.ecommerce_multivendor.response.AuthResponse;
import com.fiza.ecommerce_multivendor.service.AuthService;
import com.fiza.ecommerce_multivendor.service.EmailService;
import com.fiza.ecommerce_multivendor.service.UserService;
import com.fiza.ecommerce_multivendor.utils.OtpUtils;

import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserService userService;

    private final VerificationCodeRepository verificationCodeRepository;
    private final EmailService emailService;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    private final JwtProvider jwtProvider;
    private final CustomeUserServiceImplementation customUserDetails;
    private final CartRepository cartRepository;

    @Override
    public void sentLoginOtp(String email) throws UserException, MessagingException {

        String SIGNING_PREFIX = "signing_";

        if (email.startsWith(SIGNING_PREFIX)) {
            email = email.substring(SIGNING_PREFIX.length());
            userService.findUserByEmail(email);
        }

        VerificationCode isExist = verificationCodeRepository.findByEmail(email);

        if (isExist != null) {
            verificationCodeRepository.delete(isExist);
        }

        String otp = OtpUtils.generateOTP();

        VerificationCode verificationCode = new VerificationCode();
        verificationCode.setOtp(otp);
        verificationCode.setEmail(email);
        verificationCodeRepository.save(verificationCode);

        String subject = "Zosh Bazaar Login/Signup Otp";
        String text = "your login otp is - ";
        emailService.sendVerificationOtpEmail(email, otp, subject, text);
    }

    @Override
    public String createUser(SignupRequest req) throws SellerException {

        String email = req.getEmail();

        String fullName = req.getFullName();

        String otp = req.getOtp();

        VerificationCode verificationCode = verificationCodeRepository.findByEmail(email);

        if (verificationCode == null || !verificationCode.getOtp().equals(otp)) {
            throw new SellerException("wrong otp...");
        }

        User user = userRepository.findByEmail(email);

        if (user == null) {

            User createdUser = new User();
            createdUser.setEmail(email);
            createdUser.setFullName(fullName);
            createdUser.setRole(USER_ROLE.ROLE_CUSTOMER);
            createdUser.setMobile("9083476123");
            createdUser.setPassword(passwordEncoder.encode(otp));

            System.out.println(createdUser);

            user = userRepository.save(createdUser);

            Cart cart = new Cart();
            cart.setUser(user);
            cartRepository.save(cart);
        }

        List<GrantedAuthority> authorities = new ArrayList<>();

        authorities.add(new SimpleGrantedAuthority(USER_ROLE.ROLE_CUSTOMER.toString()));

        Authentication authentication =
                new UsernamePasswordAuthenticationToken(email, null, authorities);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        return jwtProvider.generateToken(authentication);
    }

    @Override
    public AuthResponse signin(LoginRequest req) throws SellerException {

        String username = req.getEmail();
        String otp = req.getOtp();

        System.out.println(username + " ----- " + otp);

        Authentication authentication = authenticate(username, otp);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtProvider.generateToken(authentication);
        AuthResponse authResponse = new AuthResponse();

        authResponse.setMessage("Login Success");
        authResponse.setJwt(token);
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

        String roleName =
                authorities.isEmpty() ? null : authorities.iterator().next().getAuthority();

        authResponse.setRole(USER_ROLE.valueOf(roleName));

        return authResponse;

    }

    private Authentication authenticate(String username, String otp) throws SellerException {
        UserDetails userDetails = customUserDetails.loadUserByUsername(username);

        System.out.println("sign in userDetails - " + userDetails);

        if (userDetails == null) {
            System.out.println("sign in userDetails - null ");
            throw new BadCredentialsException("Invalid username or password");
        }
        VerificationCode verificationCode = verificationCodeRepository.findByEmail(username);

        if (verificationCode == null || !verificationCode.getOtp().equals(otp)) {
            throw new SellerException("wrong otp...");
        }
        return new UsernamePasswordAuthenticationToken(userDetails, null,
                userDetails.getAuthorities());
    }
}
