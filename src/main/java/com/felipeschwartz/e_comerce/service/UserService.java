package com.felipeschwartz.e_comerce.service;

import com.felipeschwartz.e_comerce.dto.request.ChangePasswordRequestDTO;
import com.felipeschwartz.e_comerce.model.entities.User;
import org.apache.coyote.BadRequestException;

public class UserService {

    public void changePassword(ChangePasswordRequestDTO dto, String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado"));

        // Valida se a senha atual está correta
        if (!passwordEncoder.matches(dto.getCurrentPassword(), user.getPassword())) {
            throw new BadRequestException("Senha atual incorreta");
        }

        // Salva a nova senha encodada
        user.setPassword(passwordEncoder.encode(dto.getNewPassword()));
        userRepository.save(user);
    }
}
