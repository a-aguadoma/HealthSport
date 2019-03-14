package com.example.AES.models;


import javax.persistence.Entity;
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
	private String rol;
	
	
	
	protected Usuario() {}
	
	
	public Usuario (String nombre, String email, String passwordHash, String rol) {
		this.nombre = nombre;
		this.email = email;
		this.passwordHash = new BCryptPasswordEncoder().encode(passwordHash); 
		this.rol = rol;
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
	
	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}
	
	
}
