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
import com.example.AES.repositories.EntrenadorRepository;

public class EntrenadorRepositoryAuthProvider implements AuthenticationProvider {
	
	@Autowired
	private EntrenadorRepository entrenadorRepository;
	
	
	public Authentication authenticate(Authentication auth) throws AuthenticationException {
		
		String email = auth.getName(); //getEmail
		String passwordHash = (String) auth.getCredentials();

		Entrenador entrenador = entrenadorRepository.findByEmail(email);

		if (entrenador == null || !new BCryptPasswordEncoder().matches(passwordHash, entrenador.getPass())) {
			throw new BadCredentialsException("Usuario o contraseña incorrectos");
			
		} else {
			
			List<GrantedAuthority> roles = new ArrayList<>();
			for (String role : entrenador.getRoles()) {
				roles.add(new SimpleGrantedAuthority(role));
			}

			return new UsernamePasswordAuthenticationToken(entrenador.getEmail(), passwordHash, roles);
			
		}	
	}
	
	
	@Override
	public boolean supports(Class<?> authenticationObject) {
		return true;
	}
	

}
