package com.example.servicioblog.repository;
import com.example.servicioblog.model.AutorModel;
import org.springframework.data.jpa.repository.JpaRepository;
public interface IAutorRepository extends JpaRepository<AutorModel, Long> {
}
