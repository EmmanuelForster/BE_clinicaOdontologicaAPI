package edu.dh.API_clinicaOdontologica.model.DTO;

import edu.dh.API_clinicaOdontologica.model.Odontologo;
import edu.dh.API_clinicaOdontologica.model.Paciente;
import edu.dh.API_clinicaOdontologica.model.Turno;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;


@Getter @Setter
public class TurnoDTO implements Serializable {

    private Long id;

    private Paciente paciente;

    private Odontologo odontologo;

    private LocalDate date;

    public TurnoDTO(){

    }

    public TurnoDTO(Turno turno) {
        this.paciente = paciente;
        this.odontologo = odontologo;
        this.date = date;
    }

}

