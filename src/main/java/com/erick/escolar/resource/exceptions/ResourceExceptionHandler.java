package com.erick.escolar.resource.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.erick.escolar.services.exceptions.IntegridadeDeDados;
import com.erick.escolar.utils.Utilidades;

@ControllerAdvice
public class ResourceExceptionHandler {
	@ExceptionHandler(IntegridadeDeDados.class)
	public ResponseEntity<StandardError> dataIntegrity(IntegridadeDeDados e, HttpServletRequest request){
		StandardError err = new StandardError(HttpStatus.BAD_REQUEST.value(), e.getMessage(), Utilidades.timestampToDate(System.currentTimeMillis()));
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
	}
}