package edu.dh.API_clinicaOdontologica.model.DTO;

import edu.dh.API_clinicaOdontologica.model.Domicilio;
import edu.dh.API_clinicaOdontologica.model.Paciente;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Getter @Setter
public class PacienteDTO implements Serializable {

    private Long id;

    private String apellido;

    private String nombre;

    private int dni;

    private String email;

    private LocalDate fechaAlta;

    private Domicilio domicilio;

    public PacienteDTO(){

    }

    public PacienteDTO(Paciente paciente) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.dni = dni;
        this.email = email;
        this.fechaAlta = fechaAlta;
    }
}
