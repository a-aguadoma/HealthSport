package com.example.AES.controllers;

import org.springframework.web.bind.annotation.GetMapping;

public class QuienesSomosController {
	@GetMapping("/")
	public String index(){
		
		return "index";
	}
	
	@GetMapping("/index")
    public String quienessomos () {
	   
	return "quienessomos";
    }
	

}
