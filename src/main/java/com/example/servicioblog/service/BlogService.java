package com.example.servicioblog.service;
import com.example.servicioblog.exception.BusinessException;
import com.example.servicioblog.model.AutorModel;
import com.example.servicioblog.model.BlogModel;
import com.example.servicioblog.model.ContenidoModel;
import com.example.servicioblog.repository.IAutorRepository;
import com.example.servicioblog.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogService {
    @Autowired
    private IBlogRepository blogRepositorio;

    @Autowired
    private IAutorRepository autorRepositorio;

    public List<BlogModel> obtenerBlogs() {
        return blogRepositorio.findAll();
    }

    public Optional<BlogModel> obtenerBlogPorId(Long id) {
        return blogRepositorio.findById(id);
    }

    public BlogModel crearBlog(BlogModel blog, Long autorId, List<ContenidoModel> contenidos) {
        // Obtener el autor existente
        AutorModel autor = autorRepositorio.findById(autorId)
                .orElseThrow(() -> new BusinessException("Autor no encontrado"));

        if (validarPeriodo(blog.getPeriodicidad()))
            blog.setPeriodicidad(blog.getPeriodicidad());
        else
            throw new BusinessException("Periodicidad incorrecto, valores permitidos = DIARIA, SEMANAL o MENSUAL");
        if (validarComentar(blog.getAceptaCometar()))
            blog.setAceptaCometar(blog.getAceptaCometar());
        else
            throw new BusinessException("AceptaCometar incorrecto, valores permitidos = SI, NO");
        // Asociar el autor con el blog
        blog.setAutor(autor);

        // Asociar el contenido compuesto con el blog
        for (ContenidoModel contenido : contenidos) {
            contenido.setBlog(blog);
        }

        blog.setContenido(contenidos);

        // Guardar el blog
        return blogRepositorio.save(blog);
    }

    public BlogModel actualizarBlog(Long id, BlogModel blogActual) {
        BlogModel blog = blogRepositorio.findById(id).orElseThrow(() -> new RuntimeException("Blog no encontrado"));
        blog.setInformacion(blogActual.getInformacion());
        blog.setTitulo(blogActual.getTitulo());
        blog.setTema(blogActual.getTema());
        blog.setTitulo(blogActual.getTitulo());
        if (validarPeriodo(blogActual.getPeriodicidad()))
            blog.setPeriodicidad(blogActual.getPeriodicidad());
        else
            throw new BusinessException("Periodicidad incorrecto, valores permitidos = DIARIA, SEMANAL o MENSUAL");
        if (validarComentar(blogActual.getAceptaCometar()))
            blog.setAceptaCometar(blogActual.getAceptaCometar());
        else
            throw new BusinessException("AceptaCometar incorrecto, valores permitidos = SI, NO");
        return blogRepositorio.save(blog);
    }
    private boolean validarPeriodo(String periodo) {
        if (periodo.equals("DIARIA")) {
            return true;
        }
        if (periodo.equals("SEMANAL")) {
            return true;
        }
        if (periodo.equals("MENSUAL")) {
            return true;
        }
        return false;
    }
    private boolean validarComentar(String comentar) {
        if (comentar.equals("SI")) {
            return true;
        }
        if (comentar.equals("NO")) {
            return true;
        }
        return false;
    }
}
