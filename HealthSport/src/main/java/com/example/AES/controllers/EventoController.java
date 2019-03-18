package com.example.AES.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.AES.models.*;
import com.example.AES.repositories.*;

@Controller
public class EventoController {
	
	@Autowired
	private EventoRepository eventoRepository;
	
	@Autowired
	private EquipoRepository equipoRepository;
	
	@PostMapping(value="/nuevoEvento")	
	public void crearEvento(@RequestParam String nombreEvento,@RequestParam String deporteEvento,@RequestParam String tipoEvento, @RequestParam String fecha, @RequestParam String lugar, @RequestParam String equipo, HttpServletRequest request, HttpServletResponse response) {
		
		//Añadir un nuevo evento asociado a un equipo
		Equipo eq = (Equipo) equipoRepository.findByNombre(equipo);
		
		eventoRepository.save(new Evento(nombreEvento,deporteEvento, tipoEvento, fecha, lugar, eq));
		
		try {
			response.sendRedirect("/entrenador");
		} catch (IOException e) {
			
			
		}
	}
		
}
