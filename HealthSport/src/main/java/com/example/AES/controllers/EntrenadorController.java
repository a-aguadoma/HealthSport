package com.example.AES.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.AES.Entrenador;
import com.example.AES.Evento;
import com.example.AES.repositories.*;

@Controller
public class EntrenadorController {
	
	@Autowired
	EntrenadorRepository entrenadorRepository;
	
	@RequestMapping("/entrenador")
	public String Entrenador (Model model, @RequestParam String em) {
		
		
			Entrenador entrenador = (Entrenador) entrenadorRepository.findByEmail(em);
			model.addAttribute("nombreEntrenador", entrenador.getNombre());		
			model.addAttribute("equipoEntrenador", entrenador.getEquipo().getNombre());
			model.addAttribute("emailEntrenador", entrenador.getEmail());		
			
			List<Evento> listaEventos = entrenador.getEquipo().getEventos();
			int lE=0;
			
			if(listaEventos!=null) {
				for(int i = 1; i <= listaEventos.size(); i++) {
					model.addAttribute("nombre" + i, listaEventos.get(i-1).getNombre());
					model.addAttribute("deporte" + i, listaEventos.get(i-1).getDeporte());
					model.addAttribute("tipo" + i, listaEventos.get(i-1).getTipo());
					model.addAttribute("fecha" + i, listaEventos.get(i-1).getFecha());
					model.addAttribute("lugar" + i, listaEventos.get(i-1).getLugar());
				}
				lE = listaEventos.size();			
			}

			for(int i = lE+1; i <= 6; i++) {
				model.addAttribute("nombre" + i, "-");
				model.addAttribute("deporte" + i, "-");
				model.addAttribute("tipo" + i, "-");
				model.addAttribute("fecha" + i, "-");
				model.addAttribute("lugar" + i, "-");
			}

			
			return "entrenador";
		
	}
	
	
	
	/*@RequestMapping("/entrenadorEjemplo")
	public String Entrenador (Model model) {
		
		
			Entrenador entrenador = (Entrenador) entrenadorRepository.findByEmail("antonio@urjc.es");
			model.addAttribute("nombreEntrenador", entrenador.getNombre());		
			model.addAttribute("equipoEntrenador", entrenador.getEquipo().getNombre());
			model.addAttribute("emailEntrenador", entrenador.getEmail());		
			
			List<Evento> listaEventos = entrenador.getEquipo().getEventos();
			
			for(int i = 1; i <= listaEventos.size(); i++) {
				model.addAttribute("nombre" + i, listaEventos.get(i-1).getNombre());
				model.addAttribute("deporte" + i, listaEventos.get(i-1).getDeporte());
				model.addAttribute("tipo" + i, listaEventos.get(i-1).getTipo());
				model.addAttribute("fecha" + i, listaEventos.get(i-1).getFecha());
				model.addAttribute("lugar" + i, listaEventos.get(i-1).getLugar());
			}
			
			for(int i = listaEventos.size()+1; i <= 6; i++) {
				model.addAttribute("nombre" + i, "-");
				model.addAttribute("deporte" + i, "-");
				model.addAttribute("tipo" + i, "-");
				model.addAttribute("fecha" + i, "-");
				model.addAttribute("lugar" + i, "-");
			}
			
			
			return "entrenador";
		
	}*/
	
	

}
