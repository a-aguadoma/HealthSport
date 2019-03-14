package com.example.AES.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.AES.models.*;
import com.example.AES.repositories.*;

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
	UsuarioRepository usuarioRepositorio;
	

	@PostMapping(value="/login")
	public String login (Model model,@RequestParam String email, @RequestParam String pass) {
	
		while ((email!="")&&(pass!="")){
			
			
			if  (usuarioRepositorio.findByEmailAndPasswordHash(email,pass)!=null) {
				
				return("entrenador?em="+ email);
				
			}
			
			if  (usuarioRepositorio.findByEmailAndPasswordHash(email,pass)!=null) {
				
				return "deportista?em="+email;
				
			} 	
			
			if ((usuarioRepositorio.findByEmailAndPasswordHash(email, pass)==null) 
					||  (usuarioRepositorio.findByEmailAndPasswordHash(email, pass)!=null)) {
					
					return "loginerror";
				}
			
		}
		
		return "loginerror";

	}
		
	
}
