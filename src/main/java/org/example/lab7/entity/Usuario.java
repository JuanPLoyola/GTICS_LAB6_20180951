package org.example.lab7.entity;


import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name="Usuarios")
public class Usuario implements Serializable {

    @Id
    @GeneratedValue( strategy= GenerationType.IDENTITY)
    private int idUsuario;
    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    private String contrasena;
    @Column(nullable = false)
    private int idRol;



}
