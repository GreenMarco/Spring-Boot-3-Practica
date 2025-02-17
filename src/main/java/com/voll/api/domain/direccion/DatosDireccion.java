package com.voll.api.domain.direccion;

import jakarta.validation.constraints.NotBlank;

public record DatosDireccion(@NotBlank String calle,
                             @NotBlank String numero,
                             @NotBlank String complemento,
                             @NotBlank String distrito,
                             @NotBlank String ciudad) {
}