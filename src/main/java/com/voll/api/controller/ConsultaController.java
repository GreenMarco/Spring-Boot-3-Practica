package com.voll.api.controller;


import com.voll.api.domain.consulta.AgendaDeConsultaService;
import com.voll.api.domain.consulta.DatosAgendarConsulta;
import com.voll.api.domain.consulta.DatosDetalleConsulta;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@Component
@Controller
@RequestMapping("/consulta")
public class ConsultaController {

    @Autowired
    private AgendaDeConsultaService service;


    @PostMapping
    //Commit en la BD
    @Transactional
    public ResponseEntity agendar(@RequestBody @Valid DatosAgendarConsulta datos){




        service.agendar(datos);

        return ResponseEntity.ok(new DatosDetalleConsulta(null, null, null, null));
    }


}
