package org.example.lab7.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
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
    @NotBlank
    @Size(max=45, message = "correo muy grande")
    private String nombre;
    @Column(nullable = false)
    @NotBlank
    @NotBlank
    @Size(max=155, message = "contraseña muy grande")
    private String contrasena;
    @Column(nullable = false)
    @NotBlank
    @Digits(integer = 3,fraction = 0)
    @Max(value = 3)
    @Min(value = 1)
    private int idRol;



}
