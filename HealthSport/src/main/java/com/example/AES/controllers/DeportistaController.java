package com.example.AES.controllers;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.AES.repositories.*;

import com.example.AES.Deportista;

@Controller
public class DeportistaController {
	
	@Autowired
	DeportistaRepository deportistaRepository;

	@GetMapping("/deportista")
		public String Deportista (Model model, HttpServletRequest request) {
		
			Deportista deportista = (Deportista) deportistaRepository.findByEmail(request.getUserPrincipal().getName());
			model.addAttribute("nombreDeportista", " " + deportista.getNombre());
			model.addAttribute("apellidoDeportista", " " + deportista.getApellido());
			model.addAttribute("emailDeportista", " " + deportista.getEmail());
			model.addAttribute("", " " + deportista.getEquipo());
			model.addAttribute("Registrado como", " " + "Deportista");			
			return "Deportista";
		
	}

}