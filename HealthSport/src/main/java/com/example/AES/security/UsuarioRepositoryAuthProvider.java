package com.example.AES.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.example.AES.models.*;
import com.example.AES.repositories.*;


@Component
public class UsuarioRepositoryAuthProvider implements AuthenticationProvider{

	@Autowired
	private UsuarioRepository userRepository;
	@Override
	public Authentication authenticate(Authentication auth) throws AuthenticationException {
		
		Usuario user = userRepository.findByNombre(auth.getName());
	 
		 if (user == null) {
			 throw new BadCredentialsException("User not found");
		 }
		 
		 String password = (String) auth.getCredentials();
		 if (!new BCryptPasswordEncoder().matches(password, user.getPasswordHash())) {
			 throw new BadCredentialsException("Wrong password");
		 }
	
		 List<GrantedAuthority> roles = new ArrayList<>();
		 for (String role : user.getRoles()) {
			 roles.add(new SimpleGrantedAuthority(role));
		 }
		 
		 return new UsernamePasswordAuthenticationToken(user.getNombre(), password, roles);
		 }

	
/*
	@Autowired
	private UsuarioRepository usuarioRepositorio;
	
	
	public Authentication authenticate(Authentication auth) throws AuthenticationException {
		
		String email = auth.getName(); //getEmail
		String passwordHash = (String) auth.getCredentials();

		Usuario usuario = usuarioRepositorio.findByEmail(email);

		if (usuario == null || !new BCryptPasswordEncoder().matches(passwordHash, usuario.getPasswordHash())) {
			throw new BadCredentialsException("Usuario o contraseÃ±a incorrectos");
			
		} else {
			
			
			String role= usuario.getRoles();
			
			List<GrantedAuthority> roles = new ArrayList<>();
			roles.add(new SimpleGrantedAuthority(role));
				
			return new UsernamePasswordAuthenticationToken(usuario.getEmail(), passwordHash, roles);
			
		}	*/
	
	
	
	@Override
	public boolean supports(Class<?> authenticationObject) {
		return true;
	}
	

}

