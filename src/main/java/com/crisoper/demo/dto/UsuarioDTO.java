package com.crisoper.demo.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UsuarioDTO {
	
	@NotBlank(message = "El nombre es obligatorio")
	@Size(min = 2, max = 50, message = "El nombre debe tener entre 2 y 50 caracteres")
	private String nombre;
	

	@Min(value = 1, message = "La edad debe ser mayor a 0")
	private int edad;


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public int getEdad() {
		return edad;
	}


	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	
	
}
