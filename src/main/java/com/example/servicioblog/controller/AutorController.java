package com.example.servicioblog.controller;

import com.example.servicioblog.model.AutorModel;
import com.example.servicioblog.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autores")
public class AutorController {
    @Autowired
    private AutorService autorService;

    @GetMapping
    public List<AutorModel> obtenerAutores() {
        return autorService.obtenerAutores();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AutorModel> obtenerAutorPorId(@PathVariable Long id) {
        return autorService.obtenerAutorPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public AutorModel createAuthor(@RequestBody AutorModel autor) {
        return autorService.crearAutor(autor);
    }

}
