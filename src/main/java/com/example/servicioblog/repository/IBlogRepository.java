package com.example.servicioblog.repository;
import com.example.servicioblog.model.BlogModel;
import org.springframework.data.jpa.repository.JpaRepository;
public interface IBlogRepository extends JpaRepository<BlogModel, Long> {
}

