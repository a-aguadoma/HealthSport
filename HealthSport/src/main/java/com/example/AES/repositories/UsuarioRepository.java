package com.example.AES.repositories;


import java.util.List;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.AES.models.*;

@CacheConfig(cacheNames="HealthSport")
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	
	@SuppressWarnings("unchecked")
	@CacheEvict
	Usuario save(Usuario user);
	
	@CachePut
	Usuario findByEmail(String email);
	
	//@Cacheable
	Usuario findByNombre(String nombre);
	

	Usuario findByEmailAndPasswordHash(String email,String passwordHash);
	

	List<Usuario> findByRolesIn(String roles);
	
}
