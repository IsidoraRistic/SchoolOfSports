package com.example.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import model.SkolaKorisnik;


@Repository
@Transactional
public interface SkolaKorisnikRepository extends JpaRepository<SkolaKorisnik, Integer> {

	SkolaKorisnik findByKorisnickoIme(String korisnickoIme);
}
