package com.example.AES.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.AES.Equipo;
import com.example.AES.Deportista;
import com.example.AES.repositories.*;

@Controller
public class EquipoController {
	
	@Autowired
	EquipoRepository equipoRepository;
	
	@Autowired
	DeportistaRepository deportistaRepository;
	
	@RequestMapping("/equipoDeportista")
	public String Equipo (Model model, @RequestParam String eq) {
		
		
			Equipo equipo = (Equipo) equipoRepository.findByNombre(eq);
			
			//Si el deportista NO tiene equipo, muestra la tabla vacia
			if(equipo.getNombre().equals("sinEquipo")){
				
				model.addAttribute("nombreEquipo", "Sin equipo asociado");		
				model.addAttribute("deporte", "-");
				
				for(int i =1; i <= 6; i++) {
					model.addAttribute("componente" + i, "-");
					model.addAttribute("email" + i, "-");
				}
				
			//Si el deportista SI tiene equipo, muestra la lista de componentes del equipo
			}else{
				
				model.addAttribute("nombreEquipo", equipo.getNombre());		
				model.addAttribute("deporte", equipo.getDeporte());
			
				List<Deportista> listaComponentes = equipo.getDeportistas();
				
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
	public String EquipoEntrenador (Model model, @RequestParam String eq) {
		
		
			Equipo equipo = (Equipo) equipoRepository.findByNombre(eq);
			model.addAttribute("nombreEquipo", equipo.getNombre());		
			model.addAttribute("deporte", equipo.getDeporte());
			
			
			//Lista de deportistas que componen el equipo
			List<Deportista> listaComponentes = equipo.getDeportistas();
			
			for(int i = 1; i <= listaComponentes.size(); i++) {
				model.addAttribute("componente" + i, listaComponentes.get(i-1).getNombre());
				model.addAttribute("email" + i, listaComponentes.get(i-1).getEmail());
			}
			
			for(int i = listaComponentes.size()+1; i <= 6; i++) {
				model.addAttribute("componente" + i, "-");
				model.addAttribute("email" + i, "-");
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
	public String AñadirDeportista (Model model, @RequestParam String equ, @RequestParam String dep) {
		
		
			Equipo equipo = (Equipo) equipoRepository.findByNombre(equ);
			Deportista deportista = (Deportista) deportistaRepository.getByNombre(dep);
			
			deportista.setEquipo(equipo);
			
			deportistaRepository.save(deportista);
			
	
			return ("equipoEntrenador?eq="+ equ);
		
	}


}