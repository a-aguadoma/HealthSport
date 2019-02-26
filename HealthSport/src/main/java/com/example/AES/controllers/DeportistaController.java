package com.example.AES.controllers;



import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.AES.repositories.*;

import com.example.AES.Deportista;
import com.example.AES.Estadisticas;
import com.example.AES.Evento;

@Controller
public class DeportistaController {
	
	@Autowired
	DeportistaRepository deportistaRepository;

	@PostMapping("/deportista")
	public String Deportista (Model model, @RequestParam String username,@RequestParam String pass, HttpServletRequest request) {
		
			Deportista deportista = (Deportista) deportistaRepository.findByEmail(username);
			model.addAttribute("nombreDeportista", deportista.getNombre());			
			model.addAttribute("equipoCliente", deportista.getEquipo().getNombre());
			model.addAttribute("emailCliente", deportista.getEmail());
			//model.addAttribute("Registrado como", "Deportista");		
			return "deportista";
		
	}
	
	@RequestMapping("/deportistaEjemplo")
	public String Deportista (Model model) {
		
		
			Deportista deportista = (Deportista) deportistaRepository.findByEmail("paco@urjc.es");
			model.addAttribute("nombreDeportista", deportista.getNombre());		
			model.addAttribute("equipoDeportista", deportista.getEquipo().getNombre());
			model.addAttribute("emailDeportista", deportista.getEmail());
			//model.addAttribute("Registrado como", "Deportista");		
			
			List<Evento> listaEventos = deportista.getEquipo().getEventos();
			System.out.println("en la lista hay " + listaEventos.size() + "Eventos");
			
			for(int i = 1; i <= listaEventos.size(); i++) {
				Estadisticas estadisticas = new Estadisticas(listaEventos.get(i-1), deportista);
				model.addAttribute("nombreEvento"+i, listaEventos.get(i-1).getNombre());
				model.addAttribute("tipoEvento"+i, listaEventos.get(i-1).getTipo());
				model.addAttribute("LPM"+i,estadisticas.getLpm() );
				model.addAttribute("distancia"+i, estadisticas.getDistancia());
				model.addAttribute("tiempo"+i, estadisticas.getTiempo());
				model.addAttribute("velocidad"+i, estadisticas.getVelocidad());
				
				/*System.out.println("creo estadistica");
				model.addAttribute("LPM"+i, estadisticas.getLpm());
				model.addAttribute("Distancia" + i, estadisticas.getDistancia());
				model.addAttribute("Tiempo"+i, estadisticas.getTiempo());
				model.addAttribute("Velocidad"+i, estadisticas.getVelocidad());
				model.addAttribute("Evento"+i, estadisticas.getEvento());
				System.out.println("guardo estadistica");*/
			}
			
			for(int i = listaEventos.size()+1; i <= 6; i++) {
				model.addAttribute("nombreEvento"+i, "-");
				model.addAttribute("tipoEvento"+i, "-");
				model.addAttribute("LPM"+i, "-");
				model.addAttribute("distancia"+i, "-");
				model.addAttribute("tiempo"+i, "-");
				model.addAttribute("velocidad"+i, "-");
				model.addAttribute("evento"+i, "-");


			}
			System.out.println("sale for");
			return "deportista";
		
	}

}