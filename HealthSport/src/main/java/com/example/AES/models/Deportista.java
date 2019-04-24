package com.example.AES.models;


import java.util.List;
import javax.persistence.*;



@Entity
public class Deportista extends Usuario{
	
	@ManyToOne
	private Equipo equipo;
	
	@OneToMany
	private List<Estadisticas> estadisticas;
	
	
	
	public Deportista() {}
	
	public Deportista(String nombre, String email, String passwordHash, Equipo equipo, List<Estadisticas> estadisticas, String... roles) {
		super(nombre,email,passwordHash,roles);
		this.equipo=equipo;
		this.estadisticas=estadisticas;
		
	}

	
	public Equipo getEquipo() {
		return equipo;
	}
	

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

	public List<Estadisticas> getEstadisticas() {
		return estadisticas;
	}

	public void setEstadisticas(List<Estadisticas> estadisticas) {
		this.estadisticas = estadisticas;
	}

	@Override
	public String toString() {
		return "Deportista [nombre=" + super.getNombre() + ", email=" + super.getEmail() + ", pass=" + super.getPasswordHash() + ", equipo="
				+ equipo + ", estadisticas=" + estadisticas + "]";
	}
	
	
	
}
