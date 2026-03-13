package com.crisoper.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.crisoper.demo.dto.RolDTO;
import com.crisoper.demo.model.Rol;
import com.crisoper.demo.repository.RolRespository;

@Service
public class RolService {

	private final RolRespository repo;

	public RolService(RolRespository repo) {
		super();
		this.repo = repo;
	}
		
	public Rol crearRol(Rol rol) {
		return repo.save(rol);
	}
		
	public List<Rol> obtenerRoles() {
		return repo.findAll();
	}
		
	public Rol obtenerRol(Long id) {
		return repo.findById(id).orElse(null);
	}
	
	public Rol actualizarRol(Long id, Rol rol) {
		rol.setId(id);
		return repo.save(rol);
	}
	
	public void eliminarRol(Long id) {
		repo.deleteById(id);
	}
	
}
