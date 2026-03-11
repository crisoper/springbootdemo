package com.crisoper.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.crisoper.demo.model.Usuario;

@RestController
public class HelloController {

	
	@GetMapping("/")
	public String home() {
		return "Hola desde Spring Boot!, estamos en la semana 01, 00001	";
	}
	
	
	@GetMapping("/saludo")
	public String saludo() {
		return "Hola, mi nombre es Percy Crisólogo";
	}
	
	@GetMapping("/saludo/{nombre}")
	public String saludoPersonalizado(@PathVariable String nombre) {
		return "Hola, " + nombre + ", sea bievenido!";
	}
	
}
