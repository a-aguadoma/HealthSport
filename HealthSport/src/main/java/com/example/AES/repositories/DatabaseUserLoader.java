package com.example.AES.repositories;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.AES.models.Entrenador;
import com.example.AES.models.Equipo;
import com.example.AES.models.Usuario;
import com.example.AES.repositories.UsuarioRepository;

@Component
public class DatabaseUserLoader {
	
	 @Autowired
	 private UsuarioRepository userRepository;
	 @PostConstruct
	 private void initDatabase() {

	
	
	userRepository.save(
	 new Usuario("s", "s@urjc.com", "pass", "equipochachi", "ROLE_USER"));
	
	userRepository.save(
			 new Usuario("e", "e@urjc.com", "pass", "equipochachi", "ROLE_ENTRENADOR"));
	
	userRepository.save(
			 new Usuario("d", "d@urjc.com", "pass", "equipochachi", "ROLE_DEPORTISTA"));
	 
	 userRepository.save(
	 new Usuario("a","a","entrenador"));
	 }
	
	
}
