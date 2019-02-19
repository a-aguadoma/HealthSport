package com.example.AES.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

public class LoginController {
	@GetMapping("/")
	public String index(){
		
		return "index";
	}
	
	@GetMapping("/index")
    public String login () {
		return "login";
    }
	
	@RequestMapping("/deportista")
	public String deportista(Model model) {
		return "deportista";
	}
	
	@RequestMapping("/entrenador")
	public String entrenador(Model model) {
		return "entrenador";
	}
}
