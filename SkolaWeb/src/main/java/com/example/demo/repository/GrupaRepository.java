package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import model.Grupa;
import model.Instruktor;
import model.Sportskadisciplina;
import model.Ucenik;


public interface GrupaRepository extends JpaRepository<Grupa, Integer>, GrupaRepoSpecific{
	//@Query("update Grupa set brojPopunjenihMesta =:broj where idGrupe =:grupaId ")
	//public Grupa updateBroj(@Param("grupaId") Integer grupaId, @Param("broj") Integer broj);

	@Query("select count(*) from Ucenik u where u.grupa =:g")
	public int brojUcenikaGrupe(@Param("g") Grupa g);
	
	List<Grupa> findByInstruktor(Instruktor i);
	List<Grupa> findBySportskadisciplina(Sportskadisciplina sd);
	
}
