package com.example.demo.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modelos.UsuariosDTO;
import com.example.demo.servicios.Servicio;

@RestController // Servicio
@RequestMapping("/api/usuario") // Forma de llamar datos
@CrossOrigin
public class UsuarioController {
	private final static Logger log = LoggerFactory.getLogger(UsuarioController.class);

	@Autowired
	Servicio servicios;

	@GetMapping("/login/{email}/{pass}")
	public ResponseEntity<?> login(@PathVariable("email") String email, @PathVariable("pass") String pass)
			throws Exception {
		// ejemplo
		// http://localhost:8080/api/usuario/login/david@gmail.com/123456
		UsuariosDTO dto = new UsuariosDTO(email, null, pass);

		return ResponseEntity.ok().body(servicios.buscarUsuario(dto));
	}

	@PostMapping("/registrar")
	public ResponseEntity<?> registrar(@RequestBody UsuariosDTO dto) throws Exception {
		// http://localhost:8080/api/usuario/registrar
		return ResponseEntity.ok().body(servicios.cargarUsuario(dto));

	}
}
