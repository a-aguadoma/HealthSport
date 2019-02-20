package com.example.AES.controllers;



import javax.servlet.http.HttpServletRequest;


import com.example.AES.repositories.*;

import com.example.AES.Deportista;

//import com.example.AES.

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


@Controller
public class RegistroController {
	
	@Autowired
	DeportistaRepository deportistaRepository;
	

	@PostMapping(value="/nuevoDeportista")	
	public String registroDeportista(@RequestParam String nombre,@RequestParam String apellido, @RequestParam String email, @RequestParam String password) {
		
		
			Deportista nuevoDeportista = new Deportista (nombre, apellido, email, password);
			deportistaRepository.save(nuevoDeportista);
			
		/*
		 * String url= "http://192.168.33.17/correo/" + nombre + "/" + email;
		 * RestTemplate rest = new RestTemplate(); rest.getForObject(url, String.class);
		 * System.out.println("Datos enviados!");
		 */
			
			return("login");
			
	
	}
	

}

