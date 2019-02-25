package com.example.AES.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.AES.repositories.DeportistaRepository;
import com.example.AES.repositories.EventoRepository;

@Controller
public class EstadisticaController {
	
	@Autowired
	EventoRepository eventoRepository;
	
	@Autowired
	DeportistaRepository deportistaRepository;

}
