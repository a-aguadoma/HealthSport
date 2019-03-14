package com.example.AES.models;


import javax.persistence.*;

@Entity
public class Entrenador extends Usuario {
	
	
	@OneToOne
	private Equipo equipo;
	
	public Entrenador() {}
	
	public Entrenador(String nombre,String email,String passwordHash, Equipo equipo,String rol) {
		super(nombre,email,passwordHash,rol);
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
