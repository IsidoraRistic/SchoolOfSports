package com.example.demo.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.repository.GrupaRepository;
import com.example.demo.repository.InstruktorRepository;

import model.Grupa;
import model.Instruktor;

@Controller
@RequestMapping(value="/instruktori")
public class InstruktorController {

	@Autowired
	GrupaRepository gr;
	
	
	@Autowired
	InstruktorRepository ir;
	@RequestMapping(value="/saveInstruktor", method = RequestMethod.POST)
	public String saveInstruktor(Instruktor i, Model m, HttpServletRequest request) {
		
		Instruktor instr = ir.save(i);
		request.getSession().setAttribute("instruktor", instr);
		m.addAttribute("poruka", "Uspesno sacuvan instruktor.");
		return "/unos/dodavanjeInstruktora";
	}
	@RequestMapping(value="/sviInstruktori", method = RequestMethod.GET)
	public String sviInstruktori(HttpServletRequest request) {
		
		List<Instruktor> instruktori = ir.findAll();
		request.getSession().setAttribute("instruktori", instruktori);
		
		return "/prikaz/PrikazSvihInstruktora";
	}
	
	@RequestMapping(value="/sviInstruktori2", method = RequestMethod.GET)
	public String sviInstruktori2(HttpServletRequest request) {
		
		List<Instruktor> instruktori = ir.findAll();
		request.getSession().setAttribute("instruktori", instruktori);
		
		return "/prikaz/PrikazSvihInstruktora2";
	}
	
	
	@RequestMapping(value="/PrikazJednog", method = RequestMethod.GET)
	public String pregledaj(Integer idInstruktora, HttpServletRequest request) {
		
		Instruktor i = ir.findById(idInstruktora).get();
		request.getSession().setAttribute("instruktor", i);
		
		
		return "prikaz/PrikazJednogInstruktora";/////////////////////
	}
	
	
	@RequestMapping(value="/getGrupeInstruktora", method = RequestMethod.GET)
	//getGrupeInstruktora
	public String getGrupeInstruktora(Integer idInstruktora, HttpServletRequest request) {
		Instruktor i = ir.findById(idInstruktora).get();
		List<Grupa> grupeInstruktora = gr.findByInstruktor(i);
		request.getSession().setAttribute("grupe", grupeInstruktora);
		
		return "prikaz/GrupeInstruktora";////////////
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sdf.setLenient(true);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf,true));
	}
	
	
	
	//azuriranjeInstruktora
	@RequestMapping(value="/azuriranjeInstruktora", method = RequestMethod.GET)
	public String azuriranjeInstruktora(Integer idInstruktora, HttpServletRequest request) {
		
		
		Instruktor i = ir.findById(idInstruktora).get();
		request.getSession().setAttribute("instruktorA", i);
		
		
		
		return "azuriranje/AzurirajInstruktora";
	}
	
	
	
	
	//azurirajInstruktora
	@RequestMapping(value="/azurirajInstruktora", method = RequestMethod.POST)
	public String azurirajInstruktora(String ime,String prezime,String adresa,Date datumRodjenja,String email, Model m, HttpServletRequest request) {
		
		Instruktor i = (Instruktor) request.getSession().getAttribute("instruktorA");
		int broj = i.getIdInstruktora();
		if(!(ime.equals(""))) {
			ir.azurirajIme(ime, broj);
		}
		
		
		if(!(prezime.equals(""))) {
			ir.azurirajPrezime(prezime, broj);
		}
		if(!(adresa.equals(""))) {
			ir.azurirajAdresu(adresa,broj);
		}
		if(datumRodjenja!=null) {
			ir.azurirajDatum(datumRodjenja,	broj);
		}
		
		if(!(email.equals(""))) {
			ir.azurirajEmail(email,broj);
		}
		
		m.addAttribute("poruka", "Uspesno ste azurirali instruktora.");
		return "azuriranje/AzurirajInstruktora";
	}
	
	@RequestMapping(value="/obrisiInstruktora", method = RequestMethod.GET)
	public String obrisiInstruktora(Integer idInstruktora, Model m) {
		
		Instruktor i = ir.findById(idInstruktora).get();
		
		ir.delete(i);
		
		m.addAttribute("poruka", "Instruktor je uspesno izbrisan.");
		
		
		
		return "/brisanje/ObrisanInstruktor";
	}
	
	
}
