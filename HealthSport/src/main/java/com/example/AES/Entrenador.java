package com.example.AES;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Entrenador {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String nombre;
	private String apellido;
	private String pass;
	private String passEq;
	
	@OneToOne
	private Equipo equipo;
	
	public Entrenador() {}
	
	public Entrenador(String nombre, String apellido, String pass, String passEq) {
		this.nombre=nombre;
		this.apellido=apellido;
		this.pass=pass;
		this.passEq=passEq;
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
	public String getPassEq() {
		return passEq;
	}
	public void setPassEq(String passEq) {
		this.passEq = passEq;
	}
	
	

}
