package com.example.demo.servicios;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.demo.modelos.UsuariosDTO;

/*
 * Esta clase tiene como proposito similar un base de datos temporal para 
 * guardar usuario y hacer petición de logeo
 * */
@Service
public class Servicio {

	private final static Logger log = LoggerFactory.getLogger(Servicio.class);
	List<UsuariosDTO> listaUsuario = new ArrayList<>();

	public Servicio() {
		log.info("CREANDO USUARIO");
		this.listaUsuario.add(new UsuariosDTO("david@gmail.com", "david", "123456"));
		this.listaUsuario.add(new UsuariosDTO("juan@gmail.com", "juan", "123456"));
		this.listaUsuario.add(new UsuariosDTO("sergio@gmail.com", "sergio", "123456"));
		this.listaUsuario.add(new UsuariosDTO("mauricio@gmail.com", "mauricio", "123456"));
		log.info("USUARIOS CREADOS");
	}

	public String cargarUsuario(UsuariosDTO dto) {
		this.listaUsuario.add(new UsuariosDTO(dto.getEmail(), dto.getNombre(), dto.getPassword()));
		log.info("Se agrego correctamente el usuario "+ dto.getNombre());
		return "Se agrego el usuario " + dto.getNombre();

	}

	public String buscarUsuario(UsuariosDTO dto) {

		for (UsuariosDTO usuario : this.listaUsuario) {

			if (usuario.getEmail().equals(dto.getEmail()) && usuario.getPassword().equals(dto.getPassword())) {
				return "Usuario Autenticado";
			}

		}
		return "Usuario" + dto.getEmail() + " No encontrado";

	}

}
