package com.example.servicioblog.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import lombok.Data;

@Data
@Entity
public class ComentarioModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombreCompleto;
    private String paisResidencia; // País de Residencia
    private String correo; // Correo electrónico
    private String comentario;
    private int puntuacion;

    @ManyToOne
    @JoinColumn(name = "blog_id")
    @JsonIgnore
    private BlogModel blog;
}
