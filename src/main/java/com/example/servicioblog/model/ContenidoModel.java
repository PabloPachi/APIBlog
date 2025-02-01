package com.example.servicioblog.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class ContenidoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipo; // Tipo de contenido (texto, imagen, etc.)
    private String valor; // Valor del contenido (texto, URL de imagen, etc.)

    @ManyToOne
    @JoinColumn(name = "blog_id", nullable = false)
    @JsonIgnore
    private BlogModel blog; // Relación con el blog
}
