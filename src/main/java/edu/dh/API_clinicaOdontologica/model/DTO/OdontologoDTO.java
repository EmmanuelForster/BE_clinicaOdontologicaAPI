package edu.dh.API_clinicaOdontologica.model.DTO;

import edu.dh.API_clinicaOdontologica.model.Odontologo;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class OdontologoDTO implements Serializable {

    private Long id;

    private String apellido;

    private String nombre;

    private Integer matricula;

    public OdontologoDTO() {

    }

    public OdontologoDTO(Odontologo odontologo) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.matricula = matricula;
    }

}
