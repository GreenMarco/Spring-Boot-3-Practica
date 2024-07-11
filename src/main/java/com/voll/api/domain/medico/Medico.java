package com.voll.api.domain.medico;

import com.voll.api.domain.direccion.Direccion;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "medicos")
@Entity(name = "Medico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String email;
    private String telefono;
    private String documento;

    private Boolean activo;

    @Enumerated(EnumType.STRING)
    private Especialidad especialidad;

    @Embedded
    private Direccion direccion;


    public Medico(DatosRegistroMedico datosRegistroMedico) {
        this.activo=true;
        this.nombre = datosRegistroMedico.nombre();
        this.email = datosRegistroMedico.email();
        this.telefono = datosRegistroMedico.telefono();
        this.documento = datosRegistroMedico.documento();
        this.especialidad = datosRegistroMedico.especialidad();
        this.direccion = new Direccion(datosRegistroMedico.direccion());
    }

    public void actualizarDatos(DatosActualizaMedico datosActualizaMedico) {
        if(datosActualizaMedico.nombre()!=null){
            this.nombre = datosActualizaMedico.nombre();
        }
        if(datosActualizaMedico.documento()!=null){
            this.documento = datosActualizaMedico.documento();
        }
        if(datosActualizaMedico.direccion()!=null){
            this.direccion = direccion.actualizarDatos(datosActualizaMedico.direccion());
        }


    }

    public void desactivarMedico() {
        this.activo = false;
    }
}
