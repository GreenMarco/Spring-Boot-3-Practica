package com.voll.api.domain.medico;

import com.voll.api.domain.direccion.DatosDireccion;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
//Es mejor Blank que Null pero los objetos requieren Null
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DatosRegistroMedico(@NotBlank(message = "nombre.obligatorio") String nombre,
                                  @NotBlank @Email (message = "{email.invalido}")String email,
                                  @NotBlank String telefono,
                                  @NotBlank @Pattern(regexp = "\\d{4,6}") String documento,
                                  @NotNull Especialidad especialidad,
                                  @NotNull @Valid DatosDireccion direccion) {
}
