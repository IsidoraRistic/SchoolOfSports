package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import model.SkolaUloga;


@Repository
@Transactional
public interface SkolaUlogaRepository extends JpaRepository<SkolaUloga, Integer>{

	
}
