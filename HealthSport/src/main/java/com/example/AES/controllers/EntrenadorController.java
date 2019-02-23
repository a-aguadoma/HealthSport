package com.example.AES.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.AES.Entrenador;
import com.example.AES.repositories.*;

@Controller
public class EntrenadorController {
	
	@Autowired
	EntrenadorRepository entrenadorRepository;
	
	@RequestMapping("/entrenadorEjemplo")
	public String Entrenador (Model model) {
		
		
			Entrenador entrenador = (Entrenador) entrenadorRepository.findByEmail("antonio@urjc.es");
			model.addAttribute("nombreEntrenador", " " + entrenador.getNombre());
			//model.addAttribute("apellidoDeportista", " " + deportista.getApellido());			
			model.addAttribute("equipoEntrenador", " " + entrenador.getEquipo().getNombre());
			model.addAttribute("emailEntrenador", " " + entrenador.getEmail());
			//model.addAttribute("Registrado como", " " + "Deportista");		
			return "entrenador";
		
	}

}
