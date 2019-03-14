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
import com.example.AES.repositories.DeportistaRepository;

public class DeportistaRepositoryAuthProvider implements AuthenticationProvider{
	

	@Autowired
	private DeportistaRepository deportistaRepository;
	
	
	public Authentication authenticate(Authentication auth) throws AuthenticationException {
		
		String email = auth.getName(); //getEmail
		String passwordHash = (String) auth.getCredentials();

		Deportista deportista = deportistaRepository.findByEmail(email);

		if (deportista == null || !new BCryptPasswordEncoder().matches(passwordHash, deportista.getPass())) {
			throw new BadCredentialsException("Usuario o contraseña incorrectos");
			
		} else {
			
			List<GrantedAuthority> roles = new ArrayList<>();
			for (String role : deportista.getRoles()) {
				roles.add(new SimpleGrantedAuthority(role));
			}

			return new UsernamePasswordAuthenticationToken(deportista.getEmail(), passwordHash, roles);
			
		}	
	}
	
	
	@Override
	public boolean supports(Class<?> authenticationObject) {
		return true;
	}
	

}

