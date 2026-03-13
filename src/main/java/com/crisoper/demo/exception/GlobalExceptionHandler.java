package com.crisoper.demo.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler {
	
	
	// Manejo de recurso no encontrado personalizado
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponseError> manejarResourceNotFound(ResourceNotFoundException ex, HttpServletRequest request) {

        ApiResponseError error = new ApiResponseError(
                false,
                HttpStatus.NOT_FOUND.value(),
                List.of(ex.getMessage()), // lista con un solo error
                "Autor no encontrado",
                request.getRequestURI()
        );

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    // Manejo de errores de validación (campos DTO)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponseError> manejarValidacion(MethodArgumentNotValidException ex, HttpServletRequest request) {

        List<String> errores = ex.getBindingResult()
                                .getFieldErrors()
                                .stream()
                                .map(fe -> fe.getField() + ": " + fe.getDefaultMessage())
                                .collect(Collectors.toList());

        ApiResponseError error = new ApiResponseError(
                false,
                HttpStatus.BAD_REQUEST.value(),
                errores,
                "Error de validación",
                request.getRequestURI()
        );

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    // Manejo global para cualquier otra excepción inesperada
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponseError> manejarExcepcionGenerica(Exception ex, HttpServletRequest request) {

        ApiResponseError error = new ApiResponseError(
                false,
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                List.of("Error interno del servidor"),
                ex.getMessage(),
                request.getRequestURI()
        );

        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
	 
}
