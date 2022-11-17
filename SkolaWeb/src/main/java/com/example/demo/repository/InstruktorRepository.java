package com.example.demo.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import model.Instruktor;
import model.Sportskadisciplina;
@Transactional
public interface InstruktorRepository extends JpaRepository<Instruktor, Integer>{
	@Modifying
	@Query("update Instruktor i set i.ime =:novo where i.idInstruktora =:idU")
	public void azurirajIme(@Param("novo") String novo, @Param("idU") Integer idU);
	
	@Modifying
	@Query("update Instruktor i set i.prezime =:novop where i.idInstruktora =:idU")
	public void azurirajPrezime(@Param("novop") String novo, @Param("idU") Integer idU);
	
	@Modifying
	@Query("update Instruktor i set i.adresa =:novoa where i.idInstruktora =:idU")
	public void azurirajAdresu(@Param("novoa") String novo, @Param("idU") Integer idU);
	
	@Modifying
	@Query("update Instruktor i set i.datumRodjenja =:novod where i.idInstruktora =:idU")
	public void azurirajDatum(@Param("novod") Date novod, @Param("idU") Integer idU);
	
	@Modifying
	@Query("update Instruktor i set i.email =:novoe where i.idInstruktora =:idU")
	public void azurirajEmail(@Param("novoe") String novod, @Param("idU") Integer idU);
	
	
	
}
