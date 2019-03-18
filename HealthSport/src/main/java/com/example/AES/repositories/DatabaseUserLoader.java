package com.example.AES.repositories;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.AES.models.Deportista;
import com.example.AES.models.Entrenador;
import com.example.AES.models.Equipo;
import com.example.AES.models.Usuario;
import com.example.AES.repositories.UsuarioRepository;

@Component
public class DatabaseUserLoader {
	/*
	@Autowired
	 private EquipoRepository er;
	
	 @Autowired
	 private UsuarioRepository userRepository;
	 @PostConstruct
	 private void initDatabase() {

	 
	er.save(new Equipo("sinEquipo", "todos" , null, null, null, null));
	//er.save(new Equipo("aprende", "programar", null, null, null, null));
	
	userRepository.save(
	 new Usuario("s", "s@urjc.com", "pass", "equipochachi", "ROLE_USER"));
	
	userRepository.save(
			 new Entrenador("eeeee", "e@urjc.com", "pass", null , "ROLE_ENTRENADOR"));
			
	
	userRepository.save(
			 new Deportista("duran", "d@urjc.com", "pass", er.findByNombre("sinEquipo"), null , "ROLE_DEPORTISTA"));
	
	er.save(new Equipo("aprende", "programar", null, null, (Entrenador)userRepository.findByEmail("e@urjc.com"), null));
	
	//System.out.println(er.findByDeportistas("duran"));
	
	 userRepository.save(
	 new Usuario("a","a","entrenador"));
	 }
	*/
	
}
