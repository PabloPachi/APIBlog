package com.example.servicioblog.service;

import com.example.servicioblog.model.AutorModel;
import com.example.servicioblog.repository.IAutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutorService {
    @Autowired
    private IAutorRepository autorRepositorio;

    public List<AutorModel> obtenerAutores() {
        return autorRepositorio.findAll();
    }

    public Optional<AutorModel> obtenerAutorPorId(Long id) {
        return autorRepositorio.findById(id);
    }

    public AutorModel crearAutor(AutorModel autor) {
        return autorRepositorio.save(autor);
    }

}
