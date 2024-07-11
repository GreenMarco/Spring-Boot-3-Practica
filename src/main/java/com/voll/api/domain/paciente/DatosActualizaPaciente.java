package com.voll.api.domain.paciente;

import com.voll.api.domain.direccion.DatosDireccion;
import jakarta.validation.constraints.NotNull;

public record DatosActualizaPaciente(@NotNull Long id, String nombre, String documento, DatosDireccion direccion) {

}
