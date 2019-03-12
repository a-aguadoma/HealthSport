package com.example.AES;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@SpringBootApplication
public class HealthSportApplication {

	public static void main(String[] args) {
		SpringApplication.run(HealthSportApplication.class, args);
	}
	
	@RequestMapping("/index")
	public String greeting(Model model) {
		return "index";
	}

	@RequestMapping("/quienessomos")
	public String quienessomos(Model model) {
		return "quienessomos";
	}
	@RequestMapping("/login")
	public String login(Model model) {
		return "login";
	}
	@GetMapping("/loginerror")
	 public String loginerror() {
	 return "loginerror";
	 }
	@RequestMapping("/registroGeneral")
	public String registroGeneral(Model model) {
		return "registroGeneral";
	}
	@GetMapping("/home")
	 public String home() {
	 return "home";
	 }
	
	/*
	 * @RequestMapping("/calendario") public String calendario(Model model) { return
	 * "calendario"; }
	 */
	
	


}

