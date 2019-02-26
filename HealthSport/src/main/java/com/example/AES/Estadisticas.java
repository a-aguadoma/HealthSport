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
	
	@ManyToOne
	private Evento evento;
	
	@ManyToOne
	private Deportista deportista;
	
	
	public Estadisticas() {}
	
	public Estadisticas(int lpm, float distancia, float tiempo, float velocidad, Evento evento, Deportista deportista) {
		this.lpm=lpm;
		this.distancia=distancia;
		this.tiempo=tiempo;
		this.velocidad=velocidad;
		this.evento=evento;
		this.deportista=deportista;
		
	}
	
	public Estadisticas(Evento evento, Deportista deportista) {
		this.lpm=(int)(Math.random()*(135-70)+70);
		this.distancia=(float) (Math.round((float) (Math.random()*(11-2)+2)*100.0)/100.0);		
		this.velocidad=(float) (Math.round((float) (Math.random()*(21-6)+6)*100.0)/100.0);
		this.tiempo=(float) (Math.round((distancia/velocidad)*100.0)/100.0);
		this.evento=evento;
		this.deportista=deportista;
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getLpm() {
		return lpm;
	}

	public void setLpm(int lpm) {
		this.lpm = lpm;
	}

	public float getDistancia() {
		return distancia;
	}

	public void setDistancia(float distancia) {
		this.distancia = distancia;
	}

	public float getTiempo() {
		return tiempo;
	}

	public void setTiempo(float tiempo) {
		this.tiempo = tiempo;
	}

	public float getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(float velocidad) {
		this.velocidad = velocidad;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public Deportista getDeportista() {
		return deportista;
	}

	public void setDeportista(Deportista deportista) {
		this.deportista = deportista;
	}

	@Override
	public String toString() {
		return "Estadisticas [id=" + id + ", lpm=" + lpm + ", distancia=" + distancia + ", tiempo=" + tiempo
				+ ", velocidad=" + velocidad + ", evento=" + evento + ", deportista=" + deportista + "]";
	}
	
	
	

}
