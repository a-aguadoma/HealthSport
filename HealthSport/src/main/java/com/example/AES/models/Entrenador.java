package com.example.AES.models;


import javax.persistence.*;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Entity
@SessionScope
public class Entrenador extends Usuario {
	
	
	@OneToOne(mappedBy = "entrenador")
	private Equipo equipo;
	
	public Entrenador() {}
	
	public Entrenador(String nombre,String email,String passwordHash, Equipo equipo,String... roles) {
		super(nombre,email,passwordHash,roles);
		this.equipo=equipo;
		
	}

	

	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}
	


	@Override
	public String toString() {
		return "Entrenador [nombre=" + super.getNombre() + ", email=" + super.getEmail() + ", pass=" + super.getPasswordHash() + ", equipo="
				+ equipo + "]";
	}
	
	

}
