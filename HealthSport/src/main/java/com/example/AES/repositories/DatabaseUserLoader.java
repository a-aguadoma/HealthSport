package com.example.AES.repositories;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.AES.models.Deportista;
import com.example.AES.models.Entrenador;
import com.example.AES.models.Equipo;
import com.example.AES.models.Evento;
import com.example.AES.repositories.UsuarioRepository;

@Component
public class DatabaseUserLoader {
	
	@Autowired
	private EquipoRepository equipoRepository;
	
	@Autowired
	private UsuarioRepository userRepository;
	
	@Autowired
	private EventoRepository eventoRepository;
	 
	 
	@PostConstruct
	private void initDatabase() {

		equipoRepository.save(new Equipo("sinEquipo", "todos" , null, null, null, null));
		
		//Deportistas sin equipo
		
		userRepository.save(new Deportista("Diana", "diana@ejemplo.com", "pass", equipoRepository.findByNombre("sinEquipo"),null, "ROLE_DEPORTISTA"));
		
		userRepository.save(new Deportista("Dolores", "dolores@ejemplo.com", "pass", equipoRepository.findByNombre("sinEquipo"), null,"ROLE_DEPORTISTA"));
		
		
		//Entrenadores
		userRepository.save(new Entrenador("Enrique", "enrique@ejemplo.com", "pass", null , "ROLE_ENTRENADOR"));
				
		
		//Equipos
		equipoRepository.save(new Equipo("Stark", "Atletismo", null, null, (Entrenador)userRepository.findByEmail("enrique@ejemplo.com"), null));
		
		
		//Deportistas con equipo
		userRepository.save(new Deportista("Damian", "damian@ejemplo.com", "pass", equipoRepository.findByNombre("Stark"),null, "ROLE_DEPORTISTA"));
		userRepository.save(new Deportista("Dan", "dan@ejemplo.com", "pass", equipoRepository.findByNombre("Stark"),null, "ROLE_DEPORTISTA"));
		
		
		//Eventos
		eventoRepository.save(new Evento("San Silvestre", "Atletismo", "Carrera Popular", "31/12/2018", "Vallecas", equipoRepository.findByNombre("Stark")));
		eventoRepository.save(new Evento("Iron Man Segovia", "Triatlon", "Iron Man", "3/3/2019", "Segovia", equipoRepository.findByNombre("Stark")));
	 }
	
}
