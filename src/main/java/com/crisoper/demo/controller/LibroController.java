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

import com.crisoper.demo.dto.LibroDTO;
import com.crisoper.demo.model.Libro;
import com.crisoper.demo.service.LibroService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/libros")
public class LibroController {
	
	private final LibroService libroService;
	
	public LibroController(LibroService libroService) {
		// TODO Auto-generated constructor stub
		this.libroService = libroService;
	}
	
	
	// Crear libro
	@PostMapping
	public ResponseEntity<Libro> crearLibro(@Valid @RequestBody LibroDTO libroDTO) {

		Libro creado = libroService.crearLibro(libroDTO);

		return ResponseEntity.ok(creado);
	}

	// Obtener todos los libros
	@GetMapping
	public ResponseEntity<List<Libro>> obtenerLibros() {

		List<Libro> libros = libroService.obtenerLibros();

		return ResponseEntity.ok(libros);
	}

	// Obtener libro por id
	@GetMapping("/{id}")
	public ResponseEntity<Libro> obtenerLibro(@PathVariable Long id) {

		Libro libro = libroService.obtenerLibro(id);

		if (libro != null) {
			return ResponseEntity.ok(libro);
		}

		return ResponseEntity.notFound().build();
	}

	// Actualizar libro
	@PutMapping("/{id}")
	public ResponseEntity<Libro> actualizarLibro(
			@PathVariable Long id,
			@Valid @RequestBody LibroDTO libroDTO) {

		Libro libroActualizado = libroService.actualizarLibro(id, libroDTO);

		return ResponseEntity.ok(libroActualizado);
	}

	// Eliminar libro
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminaLibro(@PathVariable Long id) {

		libroService.eliminarLibro(id);

		return ResponseEntity.noContent().build();
	}
	

}






