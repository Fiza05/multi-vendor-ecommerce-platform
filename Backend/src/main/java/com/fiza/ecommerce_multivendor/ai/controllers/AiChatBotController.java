package com.fiza.ecommerce_multivendor.ai.controllers;

import com.fiza.ecommerce_multivendor.ai.services.AiChatBotService;
import com.fiza.ecommerce_multivendor.model.User;
import com.fiza.ecommerce_multivendor.request.Prompt;
import com.fiza.ecommerce_multivendor.response.ApiResponse;
import com.fiza.ecommerce_multivendor.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/ai/chat")
public class AiChatBotController {

    private final AiChatBotService aiChatBotService;
    private final UserService userService;

    @PostMapping()
    public ResponseEntity<ApiResponse> generate(@RequestBody Prompt prompt,
            @RequestParam(required = false) Long userId,
            @RequestParam(required = false) Long productId,
            @RequestHeader(required = false, name = "Authorization") String jwt) throws Exception {

        String message = prompt.getPrompt();
        if (productId != null) {
            message = "the product id is " + productId + ", " + message;
        }

        User user = new User();
        if (jwt != null)
            user = userService.findUserProfileByJwt(jwt);

        // Long userId;
        // if(user!=null){
        // userId=user.getId();
        // }

        ApiResponse apiResponse = aiChatBotService.aiChatBot(message, productId, user.getId());

        return ResponseEntity.ok(apiResponse);

    }

}
