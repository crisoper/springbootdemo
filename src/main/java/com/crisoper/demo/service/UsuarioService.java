package com.crisoper.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.crisoper.demo.model.Usuario;
import com.crisoper.demo.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	private final UsuarioRepository repo;
	
	public UsuarioService(UsuarioRepository repo) {
		// TODO Auto-generated constructor stub
		this.repo = repo;
	}
	
	// Crear usuario
    public Usuario crearUsuario(Usuario usuario) {
        return repo.save(usuario);
    }

    public List<Usuario> obtenerUsuarios() {
        return repo.findAll();
    }

    public Usuario obtenerUsuario(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Usuario actualizarUsuario(Long id, Usuario usuario) {
        usuario.setId(id);
        return repo.save(usuario);
    }

    public void eliminarUsuario(Long id) {
        repo.deleteById(id);
    }
	
	
}
