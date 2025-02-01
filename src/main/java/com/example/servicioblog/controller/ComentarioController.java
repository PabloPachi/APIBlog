package com.example.servicioblog.controller;
import com.example.servicioblog.model.ComentarioModel;
import com.example.servicioblog.service.ComentarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blogs/{blogId}/comentarios")
public class ComentarioController {
    @Autowired
    private ComentarioService comentarioService;

    @PostMapping
    public ComentarioModel comentarBlog(@PathVariable Long blogId, @RequestBody ComentarioModel comentario) {
        return comentarioService.comentarBlog(blogId, comentario);
    }

    @GetMapping
    public List<ComentarioModel> obtenerComentarioPorId(@PathVariable Long blogId) {
        return comentarioService.obtenerComentarioPorId(blogId);
    }

    @GetMapping("/puntuacion")
    public ComentarioService.Puntuacion getCommentStats(@PathVariable Long blogId) {
        return comentarioService.getCommentStatsByBlogId(blogId);
    }
}
