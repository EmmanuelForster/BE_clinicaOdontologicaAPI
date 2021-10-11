package edu.dh.API_clinicaOdontologica.model.DTO;

import edu.dh.API_clinicaOdontologica.model.Domicilio;

import java.io.Serializable;

public class DomicilioDTO implements Serializable {

    private Long id;

    private String calle;

    private int numero;

    private String localidad;

    private String provincia;

    public DomicilioDTO(){

    }

    public DomicilioDTO(Domicilio domicilio) {
        this.calle = calle;
        this.numero = numero;
        this.localidad = localidad;
        this.provincia = provincia;
    }
}
