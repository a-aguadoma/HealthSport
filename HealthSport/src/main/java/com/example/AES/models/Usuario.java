package com.example.AES.models;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
public class Usuario {

	@Id @GeneratedValue (strategy = GenerationType.AUTO) 
	private long id;
	
	private String nombre;
	private String email; 
	private String passwordHash;
	
	@ElementCollection(fetch = FetchType.EAGER)
	private List<String> roles;
	
	
	
	protected Usuario() {}
	
	
	public Usuario (String nombre, String email, String passwordHash, String... roles) {
		this.nombre = nombre;
		this.email = email;
		this.passwordHash = new BCryptPasswordEncoder().encode(passwordHash); 
		this.roles = new ArrayList<>(Arrays.asList(roles));
		
	}
	

	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPasswordHash() {
		return passwordHash;
	}
	
	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	} 
	
	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
	
}
