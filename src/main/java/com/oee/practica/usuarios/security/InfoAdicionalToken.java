package com.oee.practica.usuarios.security;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import com.oee.practica.usuarios.entity.Usuario;
import com.oee.practica.usuarios.sevice.IUsuarioService;

@Component
public class InfoAdicionalToken implements TokenEnhancer{
	
	@Autowired
	private IUsuarioService usuarioService;

	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		
		Map<String, Object> info = new HashMap<>();
		
		Usuario usuario = usuarioService.getByEmail(authentication.getName());
		
		info.put("info adional", "Hola que tal:".concat(authentication.getName()));
		
		info.put("nombre", usuario.getNombre());
		info.put("email", usuario.getEmail());
		info.put("edad", usuario.getEdad());
		
		((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(info);
		
		return accessToken;
	}

}
