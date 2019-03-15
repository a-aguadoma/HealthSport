package com.example.AES.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.AES.models.*;
import com.example.AES.repositories.*;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;


@Controller
public class LoginController {
	
	@RequestMapping("/loginerror")
	public String deportista(Model model) {
		return "loginerror";
	}
	
	@RequestMapping("/login")
	public String login(Model model, HttpServletRequest request) {

	 return "login";
	}
	
	@RequestMapping("/quienessomos")
	public String quienessomos(Model model,HttpServletRequest request) {

		return "quienessomos";
	}
		
	
}
