package com.example.AES;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Evento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String nombre;
	private String deporte;
	private String tipo;
	private String lugar;
	
	@JsonIgnore
	@ManyToMany
	private List<Equipo> participantes;
	
	
	
	public Evento() {}
	
	public Evento(String nombre, String deporte, String tipo, String lugar, List<Equipo> participantes) {
		this.nombre = nombre;
		this.deporte=deporte;
		this.tipo = tipo;
		this.lugar=lugar;
		this.participantes=participantes;
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

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public List<Equipo> getParticipantes() {
		return participantes;
	}

	public void setParticipantes(List<Equipo> participantes) {
		this.participantes = participantes;
	}

	public String getDeporte() {
		return deporte;
	}

	public void setDeporte(String deporte) {
		this.deporte = deporte;
	}

	@Override
	public String toString() {
		return "Evento [id=" + id + ", nombre=" + nombre + ", deporte=" + deporte + ", tipo=" + tipo + ", lugar="
				+ lugar + ", participantes=" + participantes + "] ";
	}
	
}
