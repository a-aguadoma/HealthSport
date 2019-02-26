package com.example.AES;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Evento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String nombre;
	private String deporte;
	private String tipo;
	private String fecha;
	private String lugar;
	
	@JsonIgnore
	@ManyToOne
	private Equipo equipo ;
	
	
	
	public Evento() {}
	
	public Evento(String nombre, String deporte, String tipo, String fecha, String lugar, Equipo equipo) {
		this.nombre = nombre;
		this.deporte=deporte;
		this.tipo = tipo;
		this.fecha=fecha;
		this.lugar=lugar;
		this.equipo=equipo;
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public String getFecha(){
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha=fecha;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

	public String getDeporte() {
		return deporte;
	}

	public void setDeporte(String deporte) {
		this.deporte = deporte;
	}

	@Override
	public String toString() {
		return "Evento [id=" + id + ", nombre=" + nombre + ", deporte=" + deporte + ", tipo=" + tipo + ", fecha=" + fecha + ", lugar="
				+ lugar + ", equipo=" + equipo + "] ";
	}
	
}
