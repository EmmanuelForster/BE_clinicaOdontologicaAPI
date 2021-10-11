package edu.dh.API_clinicaOdontologica.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
//import java.util.Set;
//
//@Getter @Setter
//@Entity
//@Table(name= "Users")
//public class User {
//
//    @Id
//    @SequenceGenerator(name = "users_sequence", sequenceName = "users_sequence", allocationSize = 1)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_sequence")
//    private Long id;
//    @Column
//    private String name;
//    @Column
//    private String username;
//    @Column
//    private String email;
//    @Column
//    private String password;
//    @ManyToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
//    @JoinTable(name="users_roles", joinColumns= @JoinColumn(name="users_id"), inverseJoinColumns = @JoinColumn(name="roles_id"))
//    private Set<UserRole> roles;
//
//    public User(){
//
//    }
//
//    public User(String name, String username, String email, String password, Set<UserRole> roles) {
//        this.name = name;
//        this.username = username;
//        this.email = email;
//        this.password = password;
//        this.roles = roles;
//    }
//}
