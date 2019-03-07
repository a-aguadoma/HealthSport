package com.example.AES.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.AES.Deportista;
import com.example.AES.Entrenador;
import com.example.AES.repositories.DeportistaRepository;
import com.example.AES.repositories.EntrenadorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


@Controller
public class LoginController {
	
	//a�ADIR FINDBYEMAILANDPASS EN LOS DOS REPOSITORIOS Y LOS CONTRASE�AS
	
	@RequestMapping("/loginerror")
	public String deportista(Model model) {
		return "loginerror";
	}
	
	@Autowired
	DeportistaRepository deportistaRepositorio;
	
	@Autowired
	EntrenadorRepository entrenadorRepositorio;
	

	@PostMapping(value="/login")
	public String login (Model model,@RequestParam String email, @RequestParam String pass) {
	
		while ((email!="")&&(pass!="")){
			
			
			if  (entrenadorRepositorio.findByEmailAndPass(email,pass)!=null) {
				
				return "entrenadorEjemplo";
				
			}
			
			if  (deportistaRepositorio.findByEmailAndPass(email,pass)!=null) {
				
				return "deportista?em="+email;
				
			} 	
			
			if ((deportistaRepositorio.findByEmailAndPass(email, pass)==null) 
					||  (deportistaRepositorio.findByEmailAndPass(email, pass)!=null)) {
					
					return "loginerror";
				}
			
		}
		
		return "loginerror";

	}
		
	
}
