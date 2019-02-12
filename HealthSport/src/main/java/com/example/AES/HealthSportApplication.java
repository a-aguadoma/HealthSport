package com.example.AES;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@SpringBootApplication
public class HealthSportApplication {

	public static void main(String[] args) {
		SpringApplication.run(HealthSportApplication.class, args);
	}
	
	@RequestMapping("/greeting")
	public String greeting(Model model, @RequestParam String name) {
		int [] array = {1,2,3,4};
		model.addAttribute("pepin", name);
		model.addAttribute("array", array);
		return "login";
	}
	
	@RequestMapping("/login100-form-btn")
	public String greeting(Model model, @RequestParam String name, @RequestParam String pass) {
				
		return "NewFile";
	}

}

