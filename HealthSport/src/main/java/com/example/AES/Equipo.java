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
public class Equipo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String nombre;
	private String deporte;
	private String clave;
	
	@JsonIgnore
	@OneToMany(mappedBy = "equipo")
	private List<Deportista> deportistas;
	
	@JsonIgnore
	@OneToOne(mappedBy = "equipo")
	private Entrenador entrenador;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "equipo")
	private List<Evento> eventos;
	
	
	public Equipo() {}
	
	public Equipo(String nombre, String deporte, String claveEquipo, List<Deportista> deportistas, Entrenador entrenador, List<Evento> eventos) {
		this.nombre = nombre;
		this.deporte = deporte;
		this.clave = claveEquipo;
		this.deportistas=deportistas;
		this.entrenador=entrenador;
		this.eventos=eventos;
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

	public String getDeporte() {
		return deporte;
	}

	public void setDeporte(String deporte) {
		this.deporte = deporte;
	}

	public String getClaveEquipo() {
		return clave;
	}

	public void setClaveEquipo(String claveEquipo) {
		this.clave = claveEquipo;
	}

	public List<Deportista> getDeportistas() {
		return deportistas;
	}

	public void setDeportistas(List<Deportista> deportistas) {
		this.deportistas = deportistas;
	}

	public Entrenador getEntrenador() {
		return entrenador;
	}

	public void setEntrenador(Entrenador entrenador) {
		this.entrenador = entrenador;
	}

	public List<Evento> getEventos() {
		return eventos;
	}

	public void setEventos(List<Evento> eventos) {
		this.eventos = eventos;
	}

	@Override
	public String toString() {
		return "Equipo [id=" + id + ", nombre=" + nombre + ", deporte=" + deporte + ", claveEquipo=" + clave
				+ ", deportistas=" + deportistas + ", entrenador=" + entrenador + ", eventos=" + eventos + "]";
	}
	
	
	

}
