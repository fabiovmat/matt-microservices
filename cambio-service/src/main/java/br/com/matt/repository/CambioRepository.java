package br.com.matt.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import br.com.matt.model.Cambio;

public interface CambioRepository extends JpaRepository<Cambio, Long> {
	
	Cambio findByFromAndTo(String from, String to);
	

}
