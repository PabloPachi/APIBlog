package com.example.servicioblog.repository;
import com.example.servicioblog.model.ComentarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IComentarioRepository extends JpaRepository<ComentarioModel, Long> {
    List<ComentarioModel> findByBlogId(Long blogId);
    @Query("SELECT MIN(c.puntuacion) FROM ComentarioModel c WHERE c.blog.id = :blogId")
    Integer puntajeMinimoPorBlogId(@Param("blogId") Long blogId);

    // Obtener el máximo de las valoraciones de los comentarios de un blog
    @Query("SELECT MAX(c.puntuacion) FROM ComentarioModel c WHERE c.blog.id = :blogId")
    Integer puntajeMaximoPorBlogId(@Param("blogId") Long blogId);

    // Obtener el promedio de las valoraciones de los comentarios de un blog
    @Query("SELECT AVG(c.puntuacion) FROM ComentarioModel c WHERE c.blog.id = :blogId")
    Double puntajePromedioPorBlogId(@Param("blogId") Long blogId);
}