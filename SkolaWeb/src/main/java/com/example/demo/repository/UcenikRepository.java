package com.example.demo.repository;

import java.util.Date;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import model.Grupa;
import model.Ucenik;
@Transactional
public interface UcenikRepository extends JpaRepository<Ucenik, Integer>{
	
	@Modifying
	@Query("update Ucenik u set u.ime =:novo where u.idUcenika =:idU")
	public void azurirajIme(@Param("novo") String novo, @Param("idU") Integer idU);
	
	@Modifying
	@Query("update Ucenik u set u.prezime =:novop where u.idUcenika =:idU")
	public void azurirajPrezime(@Param("novop") String novo, @Param("idU") Integer idU);
	
	@Modifying
	@Query("update Ucenik u set u.adresa =:novoa where u.idUcenika =:idU")
	public void azurirajAdresu(@Param("novoa") String novo, @Param("idU") Integer idU);
	
	@Modifying
	@Query("update Ucenik u set u.datumRodjenja =:novod where u.idUcenika =:idU")
	public void azurirajDatum(@Param("novod") Date novod, @Param("idU") Integer idU);
	
	public List<Ucenik> findAllByOrderByGrupa();
	public List<Ucenik> findByGrupa(Grupa g);
}
