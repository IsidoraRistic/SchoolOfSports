package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Prisustvo;
import model.Trening;
import model.Ucenik;

public interface PrisustvoRepository extends JpaRepository<Prisustvo, Integer> {

	List<Prisustvo> findByUcenik(Ucenik u);
	
	List<Prisustvo> findByTrening(Trening t);
}
