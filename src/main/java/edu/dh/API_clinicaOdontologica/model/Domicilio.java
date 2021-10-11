package edu.dh.API_clinicaOdontologica.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="Domicilios")
@Getter @Setter
public class Domicilio {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column
    String calle;
    @Column
    int numero;
    @Column
    String localidad;
    @Column
    String provincia;

    public Domicilio(){

    }

    public Domicilio(String calle, int numero, String localidad, String provincia) {
        this.calle = calle;
        this.numero = numero;
        this.localidad = localidad;
        this.provincia = provincia;
    }

}
