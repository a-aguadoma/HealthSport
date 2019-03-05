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
	
	//aŅADIR FINDBYEMAILANDPASS EN LOS DOS REPOSITORIOS Y LOS CONTRASEŅAS
	
	@RequestMapping("/loginerror")
	public String deportista(Model model) {
		return "loginerror";
	}
	
	@Autowired
	DeportistaRepository deportistaRepositorio;
	
	@Autowired
	EntrenadorRepository entrenadorRepositorio;
	

	@PostMapping(value="/login")
	public String login (@RequestParam String correo, @RequestParam String contraseņa) {
	
		Deportista deportista = new Deportista (correo,contraseņa);
		Entrenador entrenador = new Entrenador (correo,contraseņa);
		

		while ((deportista.getEmail()!="")&&(deportista.getPass()!="")
				&&(entrenador.getEmail()!="")&&(entrenador.getPass()!="")){
			
			
			if  (entrenadorRepositorio.findByEmailAndPass(correo, contraseņa)!=null) {
				
				return "entrenadorEjemplo";
				
			}
			
			if  (deportistaRepositorio.findByEmailAndPass(correo, contraseņa)!=null) {
				
				return "deportistaEjemplo";
				
			} 	
			
			if ((deportistaRepositorio.findByEmailAndPass(correo, contraseņa)==null) 
					||  (deportistaRepositorio.findByEmailAndPass(correo, contraseņa)!=null)) {
					
					return "loginerror";
				}
			
		}
		
		return "loginerror";

	}
		
	
}
