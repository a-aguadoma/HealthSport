package com.example.AES;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Equipo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String nombre;
	private String deporte;
	private String competicion;
	private String idEquip;
	
	@JsonIgnore
	@OneToMany(mappedBy = "equipo")
	private List<Deportista> deportistas;
	
	@JsonIgnore
	@OneToOne(mappedBy = "equipo")
	private Entrenador entrenador;
	
	
	public Equipo() {}
	
	public Equipo(String nombre, String deporte, String competicion, String idEquip) {
		this.nombre = nombre;
		this.deporte = deporte;
		this.competicion = competicion;
		this.idEquip = idEquip;
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
	public String getCompeticion() {
		return competicion;
	}
	public void setCompeticion(String competicion) {
		this.competicion = competicion;
	}
	public String getIdEquip() {
		return idEquip;
	}
	public void setIdEquip(String idEquip) {
		this.idEquip = idEquip;
	}
	

}
