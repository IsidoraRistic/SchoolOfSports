package com.example.demo.controller;

import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.repository.GrupaRepository;
import com.example.demo.repository.InstruktorRepository;
import com.example.demo.repository.OpremaRepository;
import com.example.demo.repository.SportskaDisciplinaRepository;
import com.example.demo.repository.TerenRepository;
import com.example.demo.repository.TipopremeRepository;
import com.example.demo.repository.TreningRepository;

import model.Grupa;
import model.Instruktor;
import model.Oprema;
import model.Sportskadisciplina;
import model.Teren;
import model.Tipopreme;
import model.Trening;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Controller
@RequestMapping(value="/treninzi")
public class TreningController {

	
	
	@Autowired
	TipopremeRepository tor;
	
	@Autowired
	SportskaDisciplinaRepository sdr;
	
	@Autowired
	TerenRepository tr;
	
	@Autowired
	TreningRepository treningr;
	
	
	@Autowired
	GrupaRepository gr;
	
	@Autowired
	InstruktorRepository ir;
	
	@RequestMapping(value="/zakaziTrening", method=RequestMethod.GET)
	public String zakaziTrening() {
		return "unos/DodavanjeTreninga";
	}
	
	@ModelAttribute("trening")
	public Trening getTrening() {
		return new Trening();
	}
	@ModelAttribute("grupe")
	public List<Grupa> getGrupe() {
		return gr.findAll();
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sdf.setLenient(true);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf,true));
	}
	@RequestMapping(value="/saveTrening", method = RequestMethod.POST)
	public String saveTrening(@ModelAttribute("trening") Trening trening, Model m) {
		Grupa g = trening.getGrupa();
		trening.setInstruktor(g.getInstruktor());
		Sportskadisciplina sd = g.getSportskadisciplina();
		trening.setSportskadisciplina(sd);
		Trening tr = treningr.save(trening);
		m.addAttribute("treningSaved", tr);
		return "unos/DodavanjeTreninga";
	}
	
	/*@ModelAttribute("instruktori")
	public List<Instruktor> getInstruktori() {
		return ir.findAll();
	}*/
	/*
	@ModelAttribute("sportskediscipline")
	public List<Sportskadisciplina> getSportskeDiscipline() {
		return sdr.findAll();
	}*/
	
	@ModelAttribute("tereni")
	public List<Teren> getTereni() {
		return tr.findAll();
	}
	
	//prikaziTrening
	@RequestMapping(value="/prikaziTreninge", method = RequestMethod.GET)
	public String prikaziTreninge(HttpServletRequest request) {
		/*List<Trening> treninzi = treningr.findAll();
		request.setAttribute("treninzi", treninzi);*/
		List<Sportskadisciplina> sd = sdr.findAll();
		request.getSession().setAttribute("discipline", sd);
		
		return "prikaz/PrikazTreninga";
	}
	@RequestMapping(value="/nadjiTreninge", method = RequestMethod.GET)
	public String nadjiInstruktore(Integer idSportskaDisciplina, HttpServletRequest request) {
		
		
		Sportskadisciplina sd = sdr.findById(idSportskaDisciplina).get();
		List<Trening> treninzi = treningr.findBySportskadisciplina(sd);
		request.getSession().setAttribute("treninzi", treninzi);
		request.getSession().setAttribute("poruka", "poruka");
		
		return "prikaz/PrikazTreninga";
	}
	
	@RequestMapping(value="/prikaziOpremu", method = RequestMethod.GET)
	public String prikaziOpremu(HttpServletRequest request) {
		
		//List<Oprema> svaOprema = or.findAll();
		List<Tipopreme> svaOprema = tor.findAll();
		request.getSession().setAttribute("oprema", svaOprema);
		
		return "prikaz/PrikazOpreme";
	}
	
	
	
	//TreninziUPeriodu.pdf
	@RequestMapping(value="/TreninziUPeriodu.pdf", method = RequestMethod.GET)
	public void showReport(HttpServletResponse response, Date datumOd, Date datumDo) throws Exception  {
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(treningr.getTreninziUPeriodu(datumOd, datumDo));
		java.io.InputStream inputStream = this.getClass().getResourceAsStream("/jasperreports/TreninziUPeriodu.jrxml");
		////////////////
		JasperReport jasperReport = JasperCompileManager.compileReport(inputStream);
		Map<String,Object> params =new HashMap<String, Object>();
		params.put("datumOd", datumOd);
		params.put("datumDo", datumDo);
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, dataSource);
		
		response.setContentType("application/x-download");
		/////////////////
		response.addHeader("Content-disposition", "attachment; filename=TreninziPeriod.pdf");
		OutputStream out =response.getOutputStream();
		JasperExportManager.exportReportToPdfStream(jasperPrint, out);
	}
	
}
