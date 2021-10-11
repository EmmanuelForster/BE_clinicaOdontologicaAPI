package edu.dh.API_clinicaOdontologica.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import edu.dh.API_clinicaOdontologica.model.DTO.OdontologoDTO;
import edu.dh.API_clinicaOdontologica.model.DTO.PacienteDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name="Turnos")
@Getter
@Setter
public class Turno {


    @Id
    @SequenceGenerator(name = "turno_sequence", sequenceName = "turno_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "turno_sequence")
    private Long id;

    @Column
    private LocalDate date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn (name = "paciente_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Paciente paciente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn (name = "odontologo_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Odontologo odontologo;


    public Turno (Paciente paciente, Odontologo odontologo, LocalDate date){
        this.paciente = paciente;
        this.odontologo = odontologo;
        this.date = date;
    }

    public Turno() {
    }

}