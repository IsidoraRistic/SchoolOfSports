package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Odrzavanjetestiranja;
import model.Trening;
import model.Ucenik;

public interface TestiranjeRepository extends JpaRepository<Odrzavanjetestiranja, Integer> {
	
	List<Odrzavanjetestiranja> findByUcenik(Ucenik u);
	
	List<Odrzavanjetestiranja> findByTrening(Trening tr);
}
