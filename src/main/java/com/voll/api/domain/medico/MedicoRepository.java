package com.voll.api.domain.medico;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;

public interface MedicoRepository extends JpaRepository <Medico, Long> {

    Page<Medico> findByActivoTrue(Pageable pageable);


    @Query("""
            SELECT m FROM Medico m
            where m.activo = 1 AND
            m.especialidad=:especialidad AND
            m.id not in(
            select c.medico.id from Consulta c
            c.data=: fecha
            )
            order by rand()
            limit 1
            """)
    Medico seleccionarMedicoConEspecialidadEnFecha(Especialidad especialidad, LocalDateTime fecha);
}
