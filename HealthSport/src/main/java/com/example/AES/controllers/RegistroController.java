package com.example.AES.controllers;

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



@Controller
public class RegistroController  /*implements CommandLineRunner */{
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private EquipoRepository equipoRepository;

	@PostMapping(value="/nuevoDeportista")	
	public String registroDeportista(@RequestParam String nombre,@RequestParam String email, @RequestParam String pass){   
		
		//Creacion del equipo vacio
		if(equipoRepository.findByNombre("sinEquipo")== null){
			
			equipoRepository.save(new Equipo("sinEquipo", "todos" , null, null, null, null));
		}
		
		if(usuarioRepository.findByEmail(email) == null) {
			//Registro del deportista
				Deportista nuevoDeportista = new Deportista (nombre, email, pass, equipoRepository.findByNombre("sinEquipo"), null, "ROLE_DEPORTISTA");
				usuarioRepository.save(nuevoDeportista);
			
				//Envio de correo mediante servicio interno
				
				//Creacion del objeto mensaje para enviarlo al servicio interno
				Mensaje user= new Mensaje(nombre, email, "ROLE_DEPORTISTA");
				
				String url= "http://172.20.0.7:7000/correo/";
				//RestTemplate rest = new RestTemplate(); 
				//rest.postForObject(url, user, Mensaje.class);
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
			
			//Creacion del objeto mensaje para enviarlo al servicio interno
			Mensaje user= new Mensaje(nombre, email, "ROLE_ENTRENADOR");
			
			 String url= "http://172.20.0.7:7000/correo/";
			 //RestTemplate rest = new RestTemplate(); 
			 //rest.postForObject(url, user, Mensaje.class);
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
	
	@RequestMapping("/registroGeneral")
	public String registroGeneral(Model model) {
		return "registroGeneral";
	}
}


