package com.example.AES.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.AES.Evento;
import com.example.AES.Equipo;
import com.example.AES.repositories.*;

@Controller
public class EventoController {
	
	@Autowired
	private EventoRepository eventoRepository;
	
	@Autowired
	private EquipoRepository equipoRepository;
	
	@PostMapping(value="/nuevoEvento")	
	public String crearEvento(@RequestParam String nombreEvento,@RequestParam String deporteEvento,@RequestParam String tipoEvento, @RequestParam String fecha, @RequestParam String lugar, @RequestParam String equipo) {
		
		//Añadir un nuevo evento asociado a un equipo
		Equipo eq = (Equipo) equipoRepository.findByNombre(equipo);
		
		eventoRepository.save(new Evento(nombreEvento,deporteEvento, tipoEvento, fecha, lugar, eq));
		
		return("entrenador");
	}
		
}
