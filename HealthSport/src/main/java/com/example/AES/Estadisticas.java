package com.example.AES;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.ManyToOne;

@Entity
public class Estadisticas {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private int lpm;
	private float distancia;
	private float tiempo;
	private float velocidad;
	private String otros;
	
	
	
	
	public Estadisticas() {}
	
	public Estadisticas(int lpm, float distancia, float tiempo, float velocidad, String otros) {
		this.lpm=lpm;
		this.distancia=distancia;
		this.tiempo=tiempo;
		this.otros=otros;
		
	}
	
	@ManyToOne
	private Evento evento;
	
	
	public int getLpm() {
		return lpm;
	}
	
	public void setLpm(int lpm) {
		this.lpm=lpm;
	}
	
	public float getDistancia() {
		return distancia;
	}
	
	public void setDistancia(float distancia) {
		this.distancia=distancia;
	}
	public float getTiempo() {
		return tiempo;
	}
	
	public void setTiempo(float tiempo) {
		this.tiempo=tiempo;
	}
	

	
	public String getOtros() {
		return otros;
	}
	
	public void setOtros(String otros) {
		this.otros=otros;
	}
	
	
	
	
	

}
