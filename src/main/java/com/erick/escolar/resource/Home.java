package com.erick.escolar.resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value="/")
public class Home {

	@GetMapping
	public ResponseEntity<?> home(){
		VersaoSoftware versao = new VersaoSoftware();
		return ResponseEntity.ok(versao);
	}
	
}

class VersaoSoftware {
	public final String versao = "1.0";
}	


