package com.infnet.ghauth.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UsuarioRecordDTO(@NotBlank String nome,
                               @NotBlank @Email String email,
                               @NotBlank String telefone,
                               @NotBlank String senha
                               ) {
}
