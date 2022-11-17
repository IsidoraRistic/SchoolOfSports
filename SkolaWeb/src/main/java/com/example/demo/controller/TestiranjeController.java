package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.repository.PrisustvoRepository;
import com.example.demo.repository.TestiranjeRepository;
import com.example.demo.repository.TreningRepository;
import com.example.demo.repository.UcenikRepository;

import model.Grupa;
import model.Odrzavanjetestiranja;
import model.Prisustvo;
import model.Trening;
import model.Ucenik;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
@Controller
@RequestMapping(value="/testiranja")
public class TestiranjeController {

	
	@Autowired
	TreningRepository treningr;
	
	@Autowired
	TestiranjeRepository tr;
	
	
	@Autowired
	PrisustvoRepository pr;
	
	@Autowired
	UcenikRepository ur;
	
	//getDatumeTestiranjaUcenika]
	@RequestMapping(value="/getDatumeTestiranjaUcenika", method = RequestMethod.GET)
	public String getDatume(Integer idUcenika, HttpServletRequest request) {
		
		Ucenik u = ur.findById(idUcenika).get();
		
		Grupa g = u.getGrupa();
		
		
		//List<Trening> treninzi = treningr.findByGrupa(g); 
		List<Trening> treninzi = treningr.findByGrupa(g);
		request.getSession().setAttribute("treninzi", treninzi);
		
		
		//request.getSession().setAttribute("treninzi", treninzi);
		request.getSession().setAttribute("ucenikD", u);
		return "unos/DodajBodove";
	}
	
	
	//saveTestiranje
	@RequestMapping(value="/saveTestiranje", method = RequestMethod.POST)
	public String saveTestiranje(Integer idTreninga, String napomene, Integer brojBodova, HttpServletRequest request, Model m) {
		Odrzavanjetestiranja ot = new Odrzavanjetestiranja();
		Trening t = treningr.findById(idTreninga).get();
		ot.setBrojBodova(brojBodova);
		ot.setNapomene(napomene);
		ot.setDatumTestiranja(t.getDatumOdrzavanja());
		ot.setTrening(t);
		Ucenik u = (Ucenik) request.getSession().getAttribute("ucenikD");
		ot.setUcenik(u);
		Odrzavanjetestiranja otSaved = tr.save(ot);
		
		
		m.addAttribute("otSaved", otSaved);
		return "unos/DodajBodove";
	}
	
	@RequestMapping(value="/getRezTestiranja", method = RequestMethod.GET)
	public String getRezTestiranja(Integer idUcenika, HttpServletRequest request) {
		
		Ucenik u = ur.findById(idUcenika).get();
		
		List<Odrzavanjetestiranja> ot = tr.findByUcenik(u);
		
		request.getSession().setAttribute("testiranja", ot);
		request.getSession().setAttribute("ucenikT", u);
		
		return "prikaz/PrikazTestiranja";
	}
	
	
	@RequestMapping(value="/izaberiTestiranje", method = RequestMethod.GET)
	public String izaberiTestiranje(HttpServletRequest request) {
		
		List<Trening> trainings = treningr.findAll();
		
		
		request.getSession().setAttribute("trainings", trainings);
		
		
		return "prikaz/IzborTestiranja";
	}
	
	
	
	//prikazSvihZaTrening
	
	
	@RequestMapping(value="/prikazSvihZaTrening", method = RequestMethod.GET)
	public String prikazSvihZaTrening(Integer idTreninga,HttpServletRequest request) {
		
		Trening trening = treningr.findById(idTreninga).get();
		List<Odrzavanjetestiranja> ots =tr.findByTrening(trening);
		
		request.getSession().setAttribute("odrzavanjas", ots);
		request.getSession().setAttribute("porukaPrikazSvih", "izbor napravljen.");
		
		
		return "prikaz/IzborTestiranja";
	}
	
	
}
