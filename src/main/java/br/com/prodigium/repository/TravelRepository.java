package br.com.prodigium.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.prodigium.model.Travel;

public interface TravelRepository extends JpaRepository<Travel, Long>{
	
}
