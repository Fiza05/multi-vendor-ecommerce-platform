package com.fiza.ecommerce_multivendor.service;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.fiza.ecommerce_multivendor.domain.USER_ROLE;
import com.fiza.ecommerce_multivendor.model.User;
import com.fiza.ecommerce_multivendor.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DataInitializationComponent implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {
        initializeAdminUser();
    }

    private void initializeAdminUser() {
        String adminUsername = "umakantdodtalle0@gmail.com";

        if (userRepository.findByEmail(adminUsername) == null) {
            User adminUser = new User();

            adminUser.setPassword(passwordEncoder.encode("Umakant@1304"));
            adminUser.setFullName("Umakant");
            adminUser.setEmail(adminUsername);
            adminUser.setRole(USER_ROLE.ROLE_ADMIN);

            User admin = userRepository.save(adminUser);
        }
    }

}
