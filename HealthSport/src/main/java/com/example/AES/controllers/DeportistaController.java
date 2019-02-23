package com.example.AES.controllers;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.AES.repositories.*;

import com.example.AES.Deportista;

@Controller
public class DeportistaController {
	
	@Autowired
	DeportistaRepository deportistaRepository;

	@PostMapping("/deportista")
	public String Deportista (Model model, @RequestParam String username,@RequestParam String pass, HttpServletRequest request) {
		
			Deportista deportista = (Deportista) deportistaRepository.findByEmail(username);
			model.addAttribute("nombreDeportista", " " + deportista.getNombre());
			//model.addAttribute("apellidoDeportista", " " + deportista.getApellido());			
			model.addAttribute("equipoCliente", " " + deportista.getEquipo().getNombre());
			model.addAttribute("emailCliente", " " + deportista.getEmail());
			//model.addAttribute("Registrado como", " " + "Deportista");		
			return "deportista";
		
	}
	
	@RequestMapping("/deportistaEjemplo")
	public String Deportista (Model model) {
		
		
			Deportista deportista = (Deportista) deportistaRepository.findByEmail("paco@urjc.es");
			model.addAttribute("nombreDeportista", " " + deportista.getNombre());
			//model.addAttribute("apellidoDeportista", " " + deportista.getApellido());			
			model.addAttribute("equipoDeportista", " " + deportista.getEquipo().getNombre());
			model.addAttribute("emailDeportista", " " + deportista.getEmail());
			//model.addAttribute("Registrado como", " " + "Deportista");		
			return "deportista";
		
	}

}