package com.example.AES.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.AES.models.*;
import com.example.AES.repositories.*;

@Controller
public class EquipoController {
	
	@Autowired
	EquipoRepository equipoRepository;
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@RequestMapping("/equipoDeportista")
	public String Equipo (Model model, HttpServletRequest request, Authentication authentication) {
		
			Deportista deportista = (com.example.AES.models.Deportista) usuarioRepository.findByEmail(request.getUserPrincipal().getName());	
		    Equipo eq=deportista.getEquipo();
		
			
			//Si el deportista NO tiene equipo, muestra la tabla vacia
			if(eq.getNombre().equals("sinEquipo")){
				
				model.addAttribute("nombreEquipo", "Sin equipo asociado");		
				model.addAttribute("deporte", "-");
				
				for(int i =1; i <= 6; i++) {
					model.addAttribute("componente" + i, "-");
					model.addAttribute("email" + i, "-");
				}
				
			//Si el deportista SI tiene equipo, muestra la lista de componentes del equipo
			}else{
				
				model.addAttribute("nombreEquipo", eq.getNombre());		
				model.addAttribute("deporte", eq.getDeporte());
			
				List<Deportista> listaComponentes = eq.getDeportistas();
				
				for(int i = 1; i <= listaComponentes.size(); i++) {
					model.addAttribute("componente" + i, listaComponentes.get(i-1).getNombre());
					model.addAttribute("email" + i, listaComponentes.get(i-1).getEmail());
				}
				
				for(int i = listaComponentes.size()+1; i <= 6; i++) {
					model.addAttribute("componente" + i, "-");
					model.addAttribute("email" + i, "-");
				}
			}
			
			
			return "equipoDeportista";
		
	}
	
	@RequestMapping("/equipoEntrenador")
	public String EquipoEntrenador (Model model, HttpServletRequest request) {
		
		
			Entrenador entrenador = (com.example.AES.models.Entrenador) usuarioRepository.findByEmail(request.getUserPrincipal().getName());	
			Equipo equipo=entrenador.getEquipo();
			
			model.addAttribute("nombreEquipo", equipo.getNombre());		
			model.addAttribute("deporte", equipo.getDeporte());
			
			
			//Lista de deportistas que componen el equipo
			
			List<Deportista> listaComponentes = equipo.getDeportistas();
			
			if(listaComponentes!=null) {
			
			for(int i = 1; i <= listaComponentes.size(); i++) {
				model.addAttribute("componente" + i, listaComponentes.get(i-1).getNombre());
				model.addAttribute("email" + i, listaComponentes.get(i-1).getEmail());
			}
			
			for(int i = listaComponentes.size()+1; i <= 6; i++) {
				model.addAttribute("componente" + i, "-");
				model.addAttribute("email" + i, "-");
			}
			
			}
			//Lista de deportistas sin equipo
			Equipo se = (Equipo) equipoRepository.findByNombre("sinEquipo");
			
			List<Deportista> listaSinEquipo= se.getDeportistas();
			
			for(int i = 1; i <= listaSinEquipo.size(); i++) {
				model.addAttribute("SEcomponente" + i, listaSinEquipo.get(i-1).getNombre());
				model.addAttribute("SEemail" + i, listaSinEquipo.get(i-1).getEmail());
			}
			
			for(int i = listaSinEquipo.size()+1; i <= 6; i++) {
				model.addAttribute("SEcomponente" + i, "-");
				model.addAttribute("SEemail" + i, "-");
			}
			
			return "equipoEntrenador";
		
	}
	
	@RequestMapping("/añadirDeportista")
	public void AñadirDeportista (Model model, @RequestParam String dep, HttpServletRequest request, HttpServletResponse response) {
		
			if (!dep.equals("-")) {
		
				Entrenador entrenador = (com.example.AES.models.Entrenador) usuarioRepository.findByEmail(request.getUserPrincipal().getName());	
				Equipo equipo=entrenador.getEquipo();
			
				Deportista deportista = (Deportista) usuarioRepository.findByNombre(dep);
				deportista.setEquipo(equipo);
				
				usuarioRepository.save(deportista);
			
			}
			
			try {
				response.sendRedirect("/equipoEntrenador");
			} catch (IOException e) {
				
				
			}
			
		
	}


}