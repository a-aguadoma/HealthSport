package com.example.AES.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.AES.models.*;


public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	
	@SuppressWarnings("unchecked")
	Usuario save(Usuario user);
	
	Usuario findByEmail(String email);
	
	Usuario findByNombre(String nombre);
	
	Usuario findByEmailAndPasswordHash(String email,String passwordHash);
	
	String findByRolIn(String rol);
	
	

}
