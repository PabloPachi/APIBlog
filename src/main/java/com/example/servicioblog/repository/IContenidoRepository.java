package com.example.servicioblog.repository;
import com.example.servicioblog.model.ContenidoModel;
import org.springframework.data.jpa.repository.JpaRepository;
public interface IContenidoRepository extends JpaRepository<ContenidoModel, Long> {
}
