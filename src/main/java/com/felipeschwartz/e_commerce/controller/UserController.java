package com.felipeschwartz.e_commerce.controller;

import com.felipeschwartz.e_commerce.dto.request.ChangePasswordRequestDTO;
import com.felipeschwartz.e_commerce.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PatchMapping("/change-password")
    public ResponseEntity<Void> changePassword(
            @Valid @RequestBody ChangePasswordRequestDTO dto,
            @AuthenticationPrincipal UserDetails userDetails
    ) {
        userService.changePassword(dto, userDetails.getUsername());
        return ResponseEntity.noContent().build();
    }
}