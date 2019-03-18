package com.example.AES.controllers;



import javax.servlet.http.HttpServletRequest;


import com.example.AES.repositories.*;

import com.example.AES.models.*;

import com.example.AES.*;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


@Controller
public class RegistroController  /*implements CommandLineRunner */{
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private EquipoRepository equipoRepository;

	@PostMapping(value="/nuevoDeportista")	
	public String registroDeportista(@RequestParam String nombre,@RequestParam String email, @RequestParam String pass){   
		
		
		if(usuarioRepository.findByEmail(email) == null) {
			//Registro del deportista
				Deportista nuevoDeportista = new Deportista (nombre, email, pass, equipoRepository.findByNombre("sinEquipo"), null, "ROLE_DEPORTISTA");
				usuarioRepository.save(nuevoDeportista);
			
			
			 //Envio de correo mediante servicio interno
			 String url= "http://localhost:8080/correo/" + nombre + "/" + email + "/" + "deportista";
			 RestTemplate rest = new RestTemplate(); 
			 rest.getForObject(url, String.class);
			 System.out.println("Datos enviados! " + nombre + " " + email);
		 
				return("login");		
		
		}
		
		else {
		
			return("registroDeportista");
		
		}
	}
		
	
	@PostMapping(value="/nuevoEntrenador")
	public String registroEntrenador(@RequestParam String nombre,@RequestParam String email, @RequestParam String pass, @RequestParam String nombreEquipo, @RequestParam String deporte) {
		
		if(usuarioRepository.findByEmail(email) == null) {
			
			
			//Registro del entrenador
			Entrenador nuevoEntrenador = new Entrenador(nombre, email, pass, null , "ROLE_ENTRENADOR");
			usuarioRepository.save(nuevoEntrenador);
			
			//Registro del equipo
			Equipo equipo = new Equipo(nombreEquipo, deporte, null, null, (Entrenador)usuarioRepository.findByEmail(email), null);
			equipoRepository.save(equipo);
			
			//Envio de correo mediante servicio interno
			 String url= "http://localhost:8080/correo/" + nombre + "/" + email + "/" + "entrenador";
			 RestTemplate rest = new RestTemplate(); 
			 rest.getForObject(url, String.class);
			 System.out.println("Datos enviados! " + nombre + " " + email);
			
			return("login");
		
		} else {
			
			return("registroEntrenador");
			
			}
	}
	

	
	@RequestMapping("/registroDeportista")
	public String registroDeportista(Model model) {
		return "registroDeportista";
	}
	@RequestMapping("/registroEntrenador")
	public String registroEntrenador(Model model) {
		return "registroEntrenador";
	}
	
	
}


