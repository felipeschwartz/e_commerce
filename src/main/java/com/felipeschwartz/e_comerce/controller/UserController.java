package com.felipeschwartz.e_comerce.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class UserController {

    @PatchMapping("/users/change-password")
    public ResponseEntity<Void> changePassword(
            @RequestBody ChangePasswordRequestDTO dto,
            @AuthenticationPrincipal UserDetails userDetails) {
        userService.changePassword(dto, userDetails.getUsername());
        return ResponseEntity.noContent().build();
    }
}
