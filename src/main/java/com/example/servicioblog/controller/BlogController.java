package com.example.servicioblog.controller;

import com.example.servicioblog.model.BlogModel;
import com.example.servicioblog.model.ContenidoModel;
import com.example.servicioblog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/blogs")
public class BlogController {
    @Autowired
    private BlogService blogService;

    @GetMapping
    public List<BlogModel> obtenerBlogs() {
        return blogService.obtenerBlogs();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BlogModel> obtenerBlogPorId(@PathVariable Long id) {
        return blogService.obtenerBlogPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public BlogModel crearBlog(@RequestBody BlogModel blog, @RequestParam Long autorId) {
        return blogService.crearBlog(blog, autorId, blog.getContenido());
    }

    @PutMapping("/{id}")
    public ResponseEntity<BlogModel> actualizarBlog(@PathVariable Long id, @RequestBody BlogModel blogActual) {
        return ResponseEntity.ok(blogService.actualizarBlog(id, blogActual));
    }
}
