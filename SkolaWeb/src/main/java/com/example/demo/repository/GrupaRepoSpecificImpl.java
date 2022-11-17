package com.example.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import model.Grupa;

@Repository
@Transactional
public class GrupaRepoSpecificImpl implements GrupaRepoSpecific {

	
	@PersistenceContext
	EntityManager em;
	
	@Override
	public Grupa grupaUpdateBrojPopunjenih(Grupa g) {
		try {
			if(g!=null) {
				int broj = g.getBrojPopunjenihMesta();
				g.setBrojPopunjenihMesta(broj+1);
				Grupa apdejtovana = em.merge(g);
				return apdejtovana;
					}
			return null;
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
