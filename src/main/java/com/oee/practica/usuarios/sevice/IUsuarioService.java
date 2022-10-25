package com.oee.practica.usuarios.sevice;

import java.util.List;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.transaction.annotation.Transactional;

import com.oee.practica.usuarios.entity.Usuario;

public interface IUsuarioService extends UserDetailsService {

	public void delete(Long id);
	
	public List<Usuario> list();
	
	@Transactional
	public Usuario save(Usuario usuario);
	
	public Usuario getByEmail (String email);

	
	public Usuario finById (Long id);
	
	
}
