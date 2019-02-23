package com.example.AES.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.AES.Evento;
import com.example.AES.repositories.EventoRepository;

@Controller
public class EventoController {
	
	@Autowired
	private EventoRepository eventoRepository;
	
	@PostMapping(value="/nuevoEvento")	
	public String crearEvento(@RequestParam String nombreEvento,@RequestParam String tipoEvento, @RequestParam String lugar) {
		
		eventoRepository.save(new Evento(nombreEvento,"Baloncesto", tipoEvento, lugar, null));
		
		return("index");
	}
		
}
