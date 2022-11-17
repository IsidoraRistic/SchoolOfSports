package com.example.demo.controller;

import java.util.ArrayList;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.repository.GrupaRepository;
import com.example.demo.repository.InstruktorRepository;
import com.example.demo.repository.SportskaDisciplinaRepository;

import model.Grupa;
import model.Instruktor;
import model.Sportskadisciplina;


@Controller
@RequestMapping(value="/grupe")
public class GrupaController {
	
	@Autowired
	SportskaDisciplinaRepository sdr;
	
	
	@Autowired
	InstruktorRepository ir;
	
	@Autowired
	GrupaRepository gr;
	
	/*@RequestMapping(value="/sveGrupeMesta", method=RequestMethod.GET)
	public String sveGrupeMesta(HttpServletRequest request) {
		
		Grupa g = gr.findById(4).get();
		int br = gr.brojUcenikaGrupe(g);
		int kap = g.getKapacitet();
		int ostalomesta = kap-br;
		request.getSession().setAttribute("grupa", g);
		request.getSession().setAttribute("broj", ostalomesta);
		return "prikaz/SveGrupe";
	}*/
	@RequestMapping(value="/sveGrupeMesta", method=RequestMethod.GET)
	public String sveGrupeMesta(HttpServletRequest request) {
		
		List<Grupa> grupe = gr.findAll();
		int i = 1;
		List<String> podaci = new ArrayList<String>();
		for (Grupa grupa : grupe) {
			int popunjeno = gr.brojUcenikaGrupe(grupa);
			int kap = grupa.getKapacitet();
			int ostalomesta = kap - popunjeno;
			String pod = grupa.getNazivGrupe() + ","+kap+","+ostalomesta;
			podaci.add(pod);
			
		}
		request.getSession().setAttribute("podaci", podaci);
		return "prikaz/SveGrupe";
	}
	
	
	//	/Skola/grupe/getGrupeSl
	@RequestMapping(value="/getGrupeSl", method=RequestMethod.GET)
	public String getGrupeSl(Integer idSportskaDisciplina, HttpServletRequest request) {
		
		Sportskadisciplina sd = sdr.findById(idSportskaDisciplina).get();
		List<Grupa> grupeDiscipline= gr.findBySportskadisciplina(sd);
		
		List<Grupa> grupeSaMestima = new ArrayList<Grupa>();
		
		for (Grupa grupa : grupeDiscipline) {
			if(gr.brojUcenikaGrupe(grupa) < grupa.getKapacitet()) {
				grupeSaMestima.add(grupa);
				
			}
		}
		
		request.getSession().setAttribute("grupeSaMestima", grupeSaMestima);
		return "/prikaz/OdabirDiscipline";
	}
	
	
	//izaberiInstruktora
	@RequestMapping(value="/izaberiInstruktora", method=RequestMethod.GET)
	public String izaberiInstruktora(Model m) {
		
		
		List<Instruktor> instruktoriG = ir.findAll();
		m.addAttribute("instruktoriG", instruktoriG);
		
		return "/prikaz/InstruktorZaGrupu";
	}
	
	
	
	//getZaInstruktora
	@RequestMapping(value="/getZaInstruktora", method=RequestMethod.GET)
	public String getZaInstruktora(Integer idInstruktora, Model m) {
		
		Instruktor i = ir.findById(idInstruktora).get();
		
		List<Grupa> grupe = gr.findByInstruktor(i);
		m.addAttribute("grupeI", grupe);
		
		
		return "/prikaz/InstruktorZaGrupu";
	}
}
