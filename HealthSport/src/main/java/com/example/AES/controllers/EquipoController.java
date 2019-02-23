package com.example.AES.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.AES.Equipo;
import com.example.AES.Deportista;
import com.example.AES.repositories.*;

@Controller
public class EquipoController {
	
	@Autowired
	EquipoRepository equipoRepository;
	
	@RequestMapping("/equipoEjemplo")
	public String Equipo (Model model) {
		
		
			Equipo equipo = (Equipo) equipoRepository.findByNombre("invencibles");
			model.addAttribute("nombreEquipo", " " + equipo.getNombre());		
			model.addAttribute("deporte", " " + equipo.getDeporte());
			
			List<Deportista> listaComponentes = equipo.getDeportistas();
			
			for(int i = 1; i <= listaComponentes.size(); i++) {
				model.addAttribute("componente" + i, listaComponentes.get(i-1).getNombre());
				model.addAttribute("email" + i, listaComponentes.get(i-1).getEmail());
			}
			
			for(int i = listaComponentes.size()+1; i <= 6; i++) {
				model.addAttribute("componente" + i, "-");
				model.addAttribute("email" + i, "-");
			}
			
			return "equipo";
		
	}

}