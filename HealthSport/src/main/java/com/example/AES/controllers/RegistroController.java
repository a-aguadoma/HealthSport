package com.example.AES.controllers;



import javax.servlet.http.HttpServletRequest;


import com.example.AES.repositories.*;

import com.example.AES.Deportista;
import com.example.AES.Entrenador;
import com.example.AES.Equipo;
import com.example.AES.Evento;

import com.example.AES.*;

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
import org.springframework.ui.Model;
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
	

	@PostMapping(value="/nuevoDeportista")	
	public String registroDeportista(@RequestParam String nombre,@RequestParam String email, @RequestParam String pass){   
		
		//Registro del deportista
		Deportista nuevoDeportista = new Deportista (nombre, email, pass, equipoRepository.findByNombre("sinEquipo"), null);
		deportistaRepository.save(nuevoDeportista);
			
		//Envio de correo mediante servicio interno
		 String url= "http://localhost:8080/correo/" + nombre + "/" + email + "/" + "deportista";
		 RestTemplate rest = new RestTemplate(); 
		 rest.getForObject(url, String.class);
		 System.out.println("Datos enviados! " + nombre + " " + email);
		 
			
		return("deportista?em="+ email);				
	}
	
	@PostMapping(value="/nuevoEntrenador")
	public String registroEntrenador(@RequestParam String nombre,@RequestParam String email, @RequestParam String pass, @RequestParam String nombreEquipo, @RequestParam String deporte) {
		
		//Registro del equipo
		Equipo equipo = new Equipo(nombreEquipo, deporte, null, null, null, null);
		equipoRepository.save(equipo);
		
		//Registro del entrenador
		Entrenador nuevoEntrenador = new Entrenador(nombre, pass, email, equipoRepository.findByNombre(nombreEquipo));
		entrenadorRepository.save(nuevoEntrenador);	
		
		//Envio de correo mediante servicio interno
		 String url= "http://localhost:8080/correo/" + nombre + "/" + email + "/" + "entrenador";
		 RestTemplate rest = new RestTemplate(); 
		 rest.getForObject(url, String.class);
		 System.out.println("Datos enviados! " + nombre + " " + email);
		
		return("entrenador?em="+ email);
	}
	
	public void run(String... args) throws Exception {
		
		equipoRepository.save(new Equipo("invencibles", "baloncesto", "clave", null,  null, null));
		equipoRepository.save(new Equipo("sinEquipo", null , null, null,  null, null));

		entrenadorRepository.save(new Entrenador("Antonio", "pass", "antonio@urjc.es", equipoRepository.findByClave("clave")));

		deportistaRepository.save(new Deportista("Paco", "paco@urjc.es", "pass", equipoRepository.findByNombre("sinEquipo"), null));
		deportistaRepository.save(new Deportista("Chloe", "chloe@urjc.es", "pass", equipoRepository.findByNombre("sinEquipo"), null));
		 
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


