package com.example.AES.repositories;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.AES.Evento;

public interface EventoRepository extends JpaRepository<Evento, Long> {
	
	@SuppressWarnings("unchecked")
	Evento save(Evento evento);

}
