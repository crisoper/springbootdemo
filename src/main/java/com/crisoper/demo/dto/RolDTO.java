package com.crisoper.demo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class RolDTO {
	
	@NotBlank(message = "El nombre es obligatorio")
	@Size(min = 2, max = 50, message = "El nombre debe tener entre 2 y 50 caracteres")
	private String nombre;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
