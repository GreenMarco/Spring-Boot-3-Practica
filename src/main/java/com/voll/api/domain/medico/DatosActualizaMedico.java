package com.voll.api.domain.medico;

import com.voll.api.domain.direccion.DatosDireccion;
import jakarta.validation.constraints.NotNull;

public record DatosActualizaMedico(@NotNull Long id, String nombre, String documento, DatosDireccion direccion) {

}
