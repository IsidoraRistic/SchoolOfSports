package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import model.InstruktorHasSportskadisciplina;
import model.Sportskadisciplina;

public interface InstruktorHasSportskadisciplinaRepository extends JpaRepository< InstruktorHasSportskadisciplina, Integer> {

	
	List<InstruktorHasSportskadisciplina> findBySportskadisciplina(Sportskadisciplina sd);
}
