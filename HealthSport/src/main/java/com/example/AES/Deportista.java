package com.example.AES;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.OneToMany;

@Entity

public class Deportista {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String nombre;
	private String apellido;
	private String email;
	private String pass;
	
	@ManyToOne
	private Equipo equipo;
	
	@OneToMany
	private List<Estadisticas> estadisticas;
	
	public Deportista() {}
	
	public Deportista(String nombre, String apellido, String email, String pass) {
		this.nombre=nombre;
		this.apellido=apellido;
		this.email=email;
		this.pass=pass;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}



	public String getEmail() {
		return email;
	}

	public void setEmail(String correo) {
		this.email = correo;
	}

	public Equipo getEquipo(){
		return equipo;
	}
	
	public void setEquipo(Equipo equipo) {
		this.equipo=equipo;
	}
	
	
	@Override
	public String toString() {
		return "Deportista [nombre=" + nombre + ", apellido=" + apellido + ", pass=" + pass + "]";
	}
	
}
