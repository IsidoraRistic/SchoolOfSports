package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.repository.GrupaRepository;
import com.example.demo.repository.PrisustvoRepository;
import com.example.demo.repository.TreningRepository;
import com.example.demo.repository.UcenikRepository;

import model.Grupa;
import model.Prisustvo;
import model.Trening;
import model.Ucenik;

@Controller
@RequestMapping(value="/prisustva")
public class PrisustvoController {

	@Autowired
	PrisustvoRepository pr;
	
	
	@Autowired
	TreningRepository tr;
	
	@Autowired
	GrupaRepository gr;
	
	@Autowired
	UcenikRepository ur;
	
	
	@RequestMapping(value="/dobaviPrisustva", method = RequestMethod.GET) 
	public String dobavi(Integer idUcenika, HttpServletRequest request) {
		Ucenik u = ur.findById(idUcenika).get();
		request.getSession().setAttribute("u", u);
		Grupa g = u.getGrupa();
		List<Trening> treninzi = tr.findByGrupa(g);
		request.getSession().setAttribute("treninzi", treninzi);
		return "unos/DodavanjePrisustva";
	}
	
	@RequestMapping(value="/dobaviPrisustvaNaTestiranju", method = RequestMethod.GET) 
	public String dobavi2(Integer idUcenika, HttpServletRequest request) {
		Ucenik u = ur.findById(idUcenika).get();
		request.getSession().setAttribute("u", u);
		Grupa g = u.getGrupa();
		List<Trening> treninzi = tr.findByGrupa(g);
		request.getSession().setAttribute("treninzi", treninzi);
		return "unos/DodavanjePrisustva";
	}
	
/*	@ModelAttribute("prisustvo")
	public Prisustvo getPrisustvo() {
		return new Prisustvo();
	}
	
	@ModelAttribute("grupe")
	public List<Grupa> getGrupe() {
		return gr.findAll();
	}
	@ModelAttribute("ucenici")
	public List<Ucenik> getUcenik() {
		return ur.findAll();
	}
	*/
	@RequestMapping(value="/savePrisustvo", method = RequestMethod.POST) 
	public String savePrisustvo(Integer idTreninga, HttpServletRequest request, String napomene) {
		
		
		Trening t = tr.findById(idTreninga).get();
		Ucenik u = (Ucenik) request.getSession().getAttribute("u");
		Prisustvo p = new Prisustvo();
		p.setTrening(t);
		p.setUcenik(u);
		p.setNapomene(napomene);
		Prisustvo pSaved = pr.save(p);
		request.getSession().setAttribute("prisustvo", p);
		
		return "unos/DodavanjePrisustva";
	}
	
	@RequestMapping(value="/prisustvaUcenika", method = RequestMethod.GET)
	public String prisustvaUcenika(Integer idUcenika, HttpServletRequest request) {
		Ucenik u = ur.findById(idUcenika).get();
		
		List<Prisustvo> prisustva = pr.findByUcenik(u);
		request.getSession().setAttribute("prisustva", prisustva);
		
		return "/prikaz/PrikazPrisustva";
	}
	
	
	
	//prisustvaZaTreningIDatum
	@RequestMapping(value="/prisustvaZaTreningIDatum", method = RequestMethod.GET)
	public String prisustvaZaTreningIDatum(HttpServletRequest request) {
		List<Trening> treninzi = tr.findAll();
		
		request.getSession().setAttribute("tren", treninzi);
		
		return "/prikaz/IzaberiTreningIDatum";
		
	}
	
	
	
	//prikaziZaTrening
	@RequestMapping(value="/prikaziZaTrening", method = RequestMethod.GET)
	public String prikaziZaTrening(Integer idTreninga, HttpServletRequest request, Model m) {
		Trening t = tr.findById(idTreninga).get();
		
		List<Prisustvo> prisustva = pr.findByTrening(t);
		
		request.getSession().setAttribute("prisustvaTrenings", prisustva);
		m.addAttribute("poruka1", "poruka1");
		
		return "/prikaz/IzaberiTreningIDatum";
		
	}
	
}
