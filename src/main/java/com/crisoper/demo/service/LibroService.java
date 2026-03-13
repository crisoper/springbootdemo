package com.crisoper.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.crisoper.demo.dto.LibroDTO;
import com.crisoper.demo.exception.ResourceNotFoundException;
import com.crisoper.demo.model.Libro;
import com.crisoper.demo.model.Usuario;
import com.crisoper.demo.repository.LibroRepository;
import com.crisoper.demo.repository.UsuarioRepository;

@Service
public class LibroService {

	private final LibroRepository repo;
	private final UsuarioRepository usuarioRepo;
	
	public LibroService(
			LibroRepository repo,
			UsuarioRepository usuarioRepo
	) {
		// TODO Auto-generated constructor stub
		this.repo = repo;
		this.usuarioRepo = usuarioRepo;
	}
	
	
	public Libro crearLibro(LibroDTO dto) {
		
		Usuario autor = usuarioRepo.findById(dto.getAutorId())
	            .orElseThrow(() -> new ResourceNotFoundException("Autor no encontrado"));
				
		Libro libro = new Libro();
	    libro.setNombre(dto.getNombre());
	    libro.setPrecio(dto.getPrecio());
	    libro.setAutor(autor);

		return repo.save(libro);
	}
	
	
	public List<Libro> obtenerLibros() {
		return repo.findAll();
	}
	

	public Libro obtenerLibro(Long id) {
		return repo.findById(id).orElse(null);
	}
	

	public Libro actualizarLibro(Long id, LibroDTO dto) {

		Libro libro = repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Libro no encontrado"));

		Usuario autor = usuarioRepo.findById(dto.getAutorId())
				.orElseThrow(() -> new ResourceNotFoundException("Autor no encontrado"));

		libro.setNombre(dto.getNombre());
		libro.setPrecio(dto.getPrecio());
		libro.setAutor(autor);

		return repo.save(libro);
	}
	

	public void eliminarLibro(Long id) {
		repo.deleteById(id);
	}
	
	
}

