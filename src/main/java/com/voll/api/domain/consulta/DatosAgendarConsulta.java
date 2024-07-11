package com.voll.api.domain.consulta;

import com.voll.api.domain.medico.Especialidad;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DatosAgendarConsulta(Long id,
                                   @NotNull
                                   Long idPaciente,
                                   Long idMedico,
                                   @NotNull @Future
                                   LocalDateTime fecha,
                                   Especialidad especialidad) {
}
