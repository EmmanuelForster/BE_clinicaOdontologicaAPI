package edu.dh.API_clinicaOdontologica.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="Roles")
@Setter @Getter
public class UserRole {

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "roles_sequence")
    @SequenceGenerator(name = "roles_sequence", sequenceName = "roles_sequence", allocationSize = 1)
    @Id
    Long id;
    @Column
    private String name;


    public UserRole(){

    }

    public UserRole(String name){
    this.name = name;
    }
}
