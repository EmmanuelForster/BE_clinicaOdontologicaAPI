package edu.dh.API_clinicaOdontologica.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Pacientes")
@Getter @Setter
public class Paciente {


    @Id
    @SequenceGenerator(name = "paciente_sequence", sequenceName = "paciente_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "paciente_sequence")
    private Long id;
    @Column
    private String apellido;
    @Column
    private String nombre;
    @Column
    private int dni;
    @Column
    private String email;
    @Column(name = "fecha_alta")
    private LocalDate fechaAlta;

    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL, orphanRemoval = true) // fetch "LAZY" por defecto desde la version 2 de Spring
    @JsonIgnore
    private Set<Turno> turnos = new HashSet<>();
    @OneToOne(cascade = CascadeType.ALL) // fetch "EAGER" por defecto desde la version 2 de Spring
    @JoinColumn(name = "id_domicilio" , referencedColumnName = "id")
    private Domicilio domicilio;

    public Paciente(){

    }

    public Paciente(String apellido, String nombre, String email, int dni, LocalDate fechaAlta) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.dni = dni;
        this.email = email;
        this.fechaAlta = fechaAlta;
    }

}
