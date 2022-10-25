package com.oee.practica.usuarios.sevice;

import java.util.List;
import java.util.stream.Collectors;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oee.practica.usuarios.entity.Usuario;
import com.oee.practica.usuarios.repository.UsuarioRepository;



import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Service
public class UsuarioServiceImpl implements IUsuarioService {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	

	
	@Override
	public List<Usuario> list(){
		
		return usuarioRepository.findAll();
		
	}
	
	
	
	@Override
	public Usuario getByEmail (String email){
		
		return usuarioRepository.findByEmail(email);
		
	}
	
	@Override
	public Usuario save(Usuario usuario) {
		
		return usuarioRepository.save(usuario);
		
	};
	
	
	public void delete(Long id) {
		
		usuarioRepository.deleteById(id);
		
	}
	
	
	
	@Override
	@Transactional( readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

Usuario usuario = this.usuarioRepository.findByEmail(username);

if(usuario==null) {
	

	throw new UsernameNotFoundException("error, el usuario no existe");
	
}

List<GrantedAuthority> authorities = usuario.getRoles().stream()
.map(role-> new SimpleGrantedAuthority(role.getNombre()))
.peek(authority-> authority.getAuthority())
.collect(Collectors.toList());



return new User(usuario.getEmail(), usuario.getPassword(), usuario.getEnabled(), 
		true, true, true, authorities);
		
	}


	@Override
	public Usuario finById(Long id) {
		
		return usuarioRepository.findById(id).orElse(null);
	}






	

}
