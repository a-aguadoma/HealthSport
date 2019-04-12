package com.example.AES;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpServletRequest;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
@EnableCaching
@SpringBootApplication
public class HealthSportApplication {

	public static void main(String[] args) {
		SpringApplication.run(HealthSportApplication.class, args);
	}
	@RequestMapping("/calendario")
	public String greeting(Model model) {
		return "calendario";
	}

	@RequestMapping("/quienessomos")
	public String quienessomos(Model model) {
		return "quienessomos";
	}
	
	@RequestMapping("/registroGeneral")
	public String registroGeneral(Model model) {
		return "registroGeneral";
	}
	
	@Bean
    public CacheManager cacheManager() {
    		return new ConcurrentMapCacheManager("HealthSport");
    }

}

