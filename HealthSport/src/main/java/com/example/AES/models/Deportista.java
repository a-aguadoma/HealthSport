package com.example.AES.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity

public class Deportista {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String nombre;
	private String email;
	private String pass;
	
	@ElementCollection(fetch = FetchType.EAGER)
	private List<String> roles;
	
	@ManyToOne
	private Equipo equipo;
	
	@OneToMany
	private List<Estadisticas> estadisticas;
	
	public Deportista() {}
	
	public Deportista(String nombre, String email, String pass, Equipo equipo, List<Estadisticas> estadisticas,String... roles) {
		this.nombre=nombre;
		this.email=email;
		this.pass=new BCryptPasswordEncoder().encode(pass);
		this.equipo=equipo;
		this.estadisticas=estadisticas;		
		this.roles = new ArrayList<>(Arrays.asList(roles));
		
		/*List<Deportista> list = equipo.getDeportistas();
		list.add(this);
		
		equipo.setDeportistas(list);*/
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public Equipo getEquipo() {
		return equipo;
	}
	
	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
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
		return "Deportista [id=" + id + ", nombre=" + nombre + ", email=" + email + ", pass=" + pass + ", equipo="
				+ equipo + ", estadisticas=" + estadisticas + "]";
	}
	
	
	
}
