package com.voll.api.domain.paciente;

import com.voll.api.domain.direccion.Direccion;
import com.voll.api.domain.medico.DatosActualizaMedico;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "pacientes")
@Entity(name = "Paciente")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String email;
    private String telefono;
    private String documento;

    private boolean activo;

    @Embedded
    private Direccion direccion;



    public Paciente(DatosRegistroPaciente datosRegistroPaciente) {
        this.nombre = datosRegistroPaciente.nombre();
        this.email = datosRegistroPaciente.email();
        this.telefono = datosRegistroPaciente.telefono();
        this.documento = datosRegistroPaciente.documento();
        this.direccion = new Direccion(datosRegistroPaciente.direccion());
    }
    public void actualizarDatos(DatosActualizaPaciente datosActualizaPaciente) {
        if(datosActualizaPaciente.nombre()!=null){
            this.nombre = datosActualizaPaciente.nombre();
        }
        if(datosActualizaPaciente.documento()!=null){
            this.documento = datosActualizaPaciente.documento();
        }
        if(datosActualizaPaciente.direccion()!=null){
            this.direccion = direccion.actualizarDatos(datosActualizaPaciente.direccion());
        }


    }

    public void desactivarPaciente() {

        this.activo = false;
    }
}