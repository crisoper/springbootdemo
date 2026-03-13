package com.crisoper.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crisoper.demo.model.Libro;

public interface LibroRepository extends JpaRepository<Libro, Long> {

}
