package com.crisoper.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import com.crisoper.demo.dto.UsuarioDTO;
import com.crisoper.demo.model.Usuario;
import com.crisoper.demo.service.UsuarioService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	private final UsuarioService usuarioService;
	
	UsuarioController(UsuarioService _usuarioservice) {
		this.usuarioService = _usuarioservice;
	}
	
	// Crear usuario
    @PostMapping
    public ResponseEntity<Usuario> crearUsuario(@Valid @RequestBody UsuarioDTO usuarioDTO) {
    	
    	Usuario usuario = new Usuario();
        usuario.setNombre(usuarioDTO.getNombre());
        usuario.setEdad(usuarioDTO.getEdad());
        
        Usuario creado = usuarioService.crearUsuario(usuario);
        
        return ResponseEntity.ok(creado);
    }

    // Obtener todos los usuarios
    @GetMapping
    public ResponseEntity<List<Usuario>> obtenerUsuarios() {
        return ResponseEntity.ok(usuarioService.obtenerUsuarios());
    }

    
    // Obtener usuario por id
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> obtenerUsuario(@PathVariable Long id) {

        Usuario usuario = usuarioService.obtenerUsuario(id);

        if (usuario != null) {
            return ResponseEntity.ok(usuario);
        }

        return ResponseEntity.notFound().build();
    }

    // Actualizar usuario
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> actualizarUsuario(@PathVariable Long id,@Valid @RequestBody UsuarioDTO usuarioDTO) {
    	
    	 Usuario usuario = new Usuario();
         usuario.setNombre(usuarioDTO.getNombre());
         usuario.setEdad(usuarioDTO.getEdad());
         
        Usuario usuarioActualizado = usuarioService.actualizarUsuario(id, usuario);

        if (usuarioActualizado != null) {
            return ResponseEntity.ok(usuarioActualizado);
        }

        return ResponseEntity.notFound().build();
    }

    // Eliminar usuario
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable Long id) {

        usuarioService.eliminarUsuario(id);

        return ResponseEntity.noContent().build();
    }
    
}
