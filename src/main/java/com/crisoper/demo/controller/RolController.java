package com.crisoper.demo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crisoper.demo.dto.RolDTO;
import com.crisoper.demo.model.Rol;
import com.crisoper.demo.service.RolService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/roles")
public class RolController {

	private final RolService rolService;
	
	public RolController(RolService rolService) {
		// TODO Auto-generated constructor stub
		this.rolService = rolService;
	}
	
	// Crear rol
	@PostMapping
	public ResponseEntity<Rol> crearRol(@Valid @RequestBody RolDTO rolDTO) {
		Rol rol = new Rol();
		rol.setNombre(rolDTO.getNombre());
		
		Rol creado = rolService.crearRol(rol);
		
		return ResponseEntity.ok(creado);
	}
	
	
	// Obtener todos los roles
	@GetMapping
	public ResponseEntity<List<Rol>> obtenerRoles() {
		List<Rol> roles = rolService.obtenerRoles();
		return ResponseEntity.ok(roles);
	}
	
	// Obtener rol por id
	@GetMapping("/{id}")
	public ResponseEntity<Rol> obtenerRol(@PathVariable Long id){
		
		Rol rol = rolService.obtenerRol(id);
		
		if(rol != null) {
			return ResponseEntity.ok(rol);
		}
		
		return ResponseEntity.notFound().build();
	}
	
	
	// Actualizar registro
	@PutMapping("/{id}")
	public ResponseEntity<Rol> actualizzarRol(
			@PathVariable Long id,
			@Valid @RequestBody RolDTO rolDTO
			) {
		
		Rol rol = new Rol();
		rol.setNombre(rolDTO.getNombre());
		
		Rol rolActualizado = rolService.actualizarRol(id, rol);
		
		if(rolActualizado != null) {
			return ResponseEntity.ok(rolActualizado);
		}
		
		return ResponseEntity.notFound().build();
	}
	
	
	// Eliminar rol
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminarRol(@PathVariable Long id) {
		rolService.eliminarRol(id);
		
		return ResponseEntity.noContent().build();
	}
	
}








