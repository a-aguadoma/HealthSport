package com.example.AES.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;


@Controller
public class LoginController {

	
	@RequestMapping("/deportista")
	public String deportista(Model model) {
		return "deportista";
	}
	
	@RequestMapping("/entrenador")
	public String entrenador(Model model) {
		return "entrenador";
	}
}
