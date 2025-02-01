package com.example.servicioblog.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class BlogModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String informacion;
    private String titulo;
    private String tema;
    private String periodicidad;
    private String aceptaCometar;

    @OneToMany(mappedBy = "blog", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ContenidoModel> contenido; // Contenido compuesto del blog

    @ManyToOne
    @JoinColumn(name = "autor_id", nullable = false)
    private AutorModel autor; // Relación con el autor

    @OneToMany(mappedBy = "blog", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ComentarioModel> comentarios;

}