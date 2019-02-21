package com.example.AES.controllers;



import javax.servlet.http.HttpServletRequest;


import com.example.AES.repositories.*;

import com.example.AES.Deportista;
import com.example.AES.Entrenador;
import com.example.AES.Equipo;
import com.example.AES.Evento;

//import com.example.AES.

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


@Controller
public class RegistroController  implements CommandLineRunner {
	
	@Autowired
	private DeportistaRepository deportistaRepository;
	
	@Autowired
	private EquipoRepository equipoRepository;
	
	@Autowired
	private EntrenadorRepository entrenadorRepository;
	

	/*@PostMapping(value="/nuevoDeportista")	
	public String registroDeportista(@RequestParam String nombre,@RequestParam String email, @RequestParam String pass, @RequestParam String equipo){   
		
		
			Deportista nuevoDeportista = new Deportista (nombre, email, pass, equipoRep.findByNombre(equipo), null);
			deportistaRepository.save(nuevoDeportista);*/
			
		/*
		 * String url= "http://192.168.33.17/correo/" + nombre + "/" + email;
		 * RestTemplate rest = new RestTemplate(); rest.getForObject(url, String.class);
		 * System.out.println("Datos enviados!");
		 */
			
		/*	return("login");				
	}
	
	@PostMapping(value="/nuevoEntrenador")
	public String registroEntrenador(@RequestParam String nombre,@RequestParam String pass, @RequestParam String email, @RequestParam String equipo) {
		
		Entrenador nuevoEntrenador = new Entrenador(nombre, pass, email, equipoRep.findByNombre(equipo));
		
		
		return("login");
	}*/
	
	public void run(String... args) throws Exception {
		
		equipoRepository.save(new Equipo("invencibles", "baloncesto", "clave", null,  null, null));

		entrenadorRepository.save(new Entrenador("Antonio", "pass", "antonio@urjc.es", equipoRepository.findByClave("clave")));

		
		deportistaRepository.save(new Deportista("Paco", "paco@urjc.es", "pass", equipoRepository.findByClave("clave"), null));
		deportistaRepository.save(new Deportista("Chloe", "chloe@urjc.es", "pass", equipoRepository.findByNombre("invencibles"), null));
		 
		
		 }
	
	
}


