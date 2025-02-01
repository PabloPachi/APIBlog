package com.example.servicioblog.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class AutorModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombres; // Nombres
    private String apPaterno; // Apellido Paterno
    private String apMaterno; // Apellido Materno

    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento; // Fecha de Nacimiento

    private String paisResidencia; // País de Residencia
    private String correo; // Correo electrónico
}
