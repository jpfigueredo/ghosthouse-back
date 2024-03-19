package com.infnet.ghauth.dto;

import jakarta.validation.constraints.NotBlank;

public record LoginDTO(@NotBlank String email,
                       @NotBlank String senha) {
}
