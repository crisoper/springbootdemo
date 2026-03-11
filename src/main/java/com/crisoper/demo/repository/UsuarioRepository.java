package com.crisoper.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crisoper.demo.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
