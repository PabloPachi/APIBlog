package com.example.servicioblog.service;
import com.example.servicioblog.exception.BusinessException;
import com.example.servicioblog.model.BlogModel;
import com.example.servicioblog.model.ComentarioModel;
import com.example.servicioblog.repository.IBlogRepository;
import com.example.servicioblog.repository.IComentarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComentarioService {
    @Autowired
    private IComentarioRepository comentarioRepositorio;
    @Autowired
    private IBlogRepository blogRepositorio;
    public ComentarioModel comentarBlog(Long blogId, ComentarioModel comentario) {
        BlogModel blog = blogRepositorio.findById(blogId)
                .orElseThrow(() -> new RuntimeException("Blog no encontrado"));
        if(!blog.getAceptaCometar().equals("SI")){
            throw new BusinessException("No se puede adicionar comentarios a este blog");
        }
        int puntaje = comentario.getPuntuacion();
        if(puntaje < 0){
            throw new BusinessException("El valor de la puntuación debe ser al menos 1");
        }
        if(puntaje > 10){
            throw new BusinessException("El valor de la puntuación no puede ser mayor que 10");
        }
            // Asociar el comentario con el blog
        comentario.setBlog(blog);

        // Guardar el comentario
        return comentarioRepositorio.save(comentario);
    }

    public List<ComentarioModel> obtenerComentarioPorId(Long blogId) {
        return comentarioRepositorio.findByBlogId(blogId);
    }

    public Puntuacion getCommentStatsByBlogId(Long blogId) {
        Integer min = comentarioRepositorio.puntajeMinimoPorBlogId(blogId);
        Integer max = comentarioRepositorio.puntajeMaximoPorBlogId(blogId);
        Double pro = comentarioRepositorio.puntajePromedioPorBlogId(blogId);

        return new Puntuacion(min, max, pro);
    }

    // Clase interna para representar las estadísticas de los comentarios
    public static class Puntuacion {
        private final Integer minimo;
        private final Integer maximo;
        private final Double promedio;

        public Puntuacion(Integer min, Integer max, Double pro) {
            this.minimo = min;
            this.maximo = max;
            this.promedio = pro;
        }

        // Getters
        public Integer getMinimo() {
            return minimo;
        }

        public Integer getMaximo() {
            return maximo;
        }

        public Double getPromedio() {
            return promedio;
        }
    }
}
