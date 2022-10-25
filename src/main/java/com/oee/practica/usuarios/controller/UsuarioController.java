package com.oee.practica.usuarios.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import com.oee.practica.usuarios.entity.Role;
import com.oee.practica.usuarios.entity.Usuario;
import com.oee.practica.usuarios.sevice.IUsuarioService;





@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = "http://localhost:4200") 
public class UsuarioController {

	@Autowired
	IUsuarioService usuarioService;
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody Usuario usuario) {
		
		Usuario usuarioNew = null;
		
		Role role = new Role();
		role.setId(1L);
		role.setNombre("ROLE_ADMIN");
		List<Role> roles = new ArrayList<>();
		roles.add(role);
		usuario.setRoles(roles);
		
		String password = usuario.getPassword();
		String passwordBCrypt = passwordEncoder.encode(password);
		usuario.setPassword(passwordBCrypt);
		

		Map<String, Object> response = new HashMap<>();

		try {

			usuarioNew = usuarioService.save(usuario);
			

		} catch (DataAccessException e) {
			response.put("mensaje", "Error al insertar el usuario");
			response.put("error", e.getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "El usuario ha sido creado con exito");
		response.put("usuario", usuarioNew);

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
		
	}
	
	
	
	@GetMapping("/lista")
	public List<Usuario> list(){
		
		
		
	return  usuarioService.list();
		
	}
	
	

	@GetMapping("/detail/{id}")
	public ResponseEntity<?> getById(@PathVariable("id") Long id) {

		 Usuario usuario = null;
		 Map<String, Object> response = new HashMap<>();
		 
			try {

				usuario = usuarioService.finById(id);

			} catch (DataAccessException e) {
				response.put("mensaje", "El usuario ID ".concat(id.toString()).concat("no existe"));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
			if (usuario == null) {

				response.put("mensaje", "El usuario ID ".concat(id.toString()).concat("no existe"));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);

			}

		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);

		

	}


	@PutMapping("/update/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody Usuario usuario){
		
		Usuario usuarioActual = usuarioService.finById(id);
		
		Usuario usuarioUpdate = null;
		
		Map<String, Object> response = new HashMap<>();
		
		
		if (usuarioActual == null) {

			response.put("mensaje", "No se pudo editar, El usuario ID ".concat(id.toString()).concat("no existe"));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);

		}
		
		try {

			usuarioActual.setNombre(usuario.getNombre());
			usuarioActual.setEmail(usuario.getEmail());
			usuarioActual.setEdad(usuario.getEdad());
			usuarioActual.setPassword(usuario.getPassword());
			
			usuarioUpdate=usuarioService.save(usuarioActual);

		} catch (DataAccessException e) {
			response.put("mensaje", "Error al actualizar el usuario");
			response.put("error", e.getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
		response.put("mensaje", "El usuario ha sido actualizado con exito");
		response.put("usuario", usuarioUpdate);

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);

		
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {

		Map<String, Object> response = new HashMap<>();

		try {

			usuarioService.delete(id);

		} catch (DataAccessException e) {
			response.put("mensaje", "Error al eliminar el usuario");
			response.put("error", e.getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "El usuario ha sido eliminado con exito");

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	

	
	
	
	
}
