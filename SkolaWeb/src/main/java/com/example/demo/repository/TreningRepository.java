package com.example.demo.repository;

import java.util.Date;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import model.Grupa;
import model.Sportskadisciplina;
import model.Teren;
import model.Trening;
@Transactional
public interface TreningRepository extends JpaRepository<Trening, Integer> {

	List<Trening> findBySportskadisciplina(Sportskadisciplina sd);
	
	List<Trening> findByGrupa(Grupa g);
	
	@Query("SELECT t FROM Trening t WHERE t.datumOdrzavanja BETWEEN :datOd AND :datDo order by t.datumOdrzavanja")
	public List<Trening> getTreninziUPeriodu(@Param("datOd") Date datumOd, @Param("datDo") Date datumDo);
	
	
	@Modifying
	@Query("update Trening t  set t.teren =:ter where t.idTreninga =:idT")
	public void azurirajTerenTreninga(@Param("ter") Teren ter, @Param("idT") Integer idT);
}
