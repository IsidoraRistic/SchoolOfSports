package com.example.demo.controller;



import java.text.SimpleDateFormat;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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
import com.example.demo.repository.SportskaDisciplinaRepository;
import com.example.demo.repository.UcenikRepository;


import model.Grupa;
import model.Sportskadisciplina;
import model.Ucenik;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Controller
@RequestMapping(value="/ucenici")
public class UcenikController {
	
	@Autowired
	SportskaDisciplinaRepository sdr;
	
	@Autowired
	GrupaRepository gr;
	
	@Autowired
	UcenikRepository ur;
	
	@RequestMapping(value="/unosUcenika", method = RequestMethod.GET)
	public String unosUcenika() {
		return "unos/DodavanjeUcenika";
	}
	
	@ModelAttribute("ucenik")
	public Ucenik getUcenik() {
		return new Ucenik();
	}
	
	@ModelAttribute("grupe")
	public List<Grupa> getGrupe() {
		return gr.findAll();
	}
	@RequestMapping(value="/saveUcenik", method = RequestMethod.POST)
	public String saveUcenik(@ModelAttribute("ucenik") Ucenik ucenik, Model m) {
		Ucenik u = ur.save(ucenik);
		m.addAttribute("ucenikSaved", u);
		m.addAttribute("porukaSU", "porukaSU");
		
		return  "unos/DodavanjeUcenika";
		
		
	}
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sdf.setLenient(true);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf,true));
	}
	@RequestMapping(value="/sviUcenici", method = RequestMethod.GET)
	public String sviUcenici(HttpServletRequest request) {
		
		List<Ucenik> svi = ur.findAll();
		request.getSession().setAttribute("ucenici", svi);
		
		return "prikaz/PrikazSvihUcenika";
		
	}
	
	@RequestMapping(value="/sviUcenici2", method = RequestMethod.GET)
	public String sviUcenici2(HttpServletRequest request) {
		
		List<Ucenik> svi = ur.findAll();
		request.getSession().setAttribute("ucenici", svi);
		
		return "prikaz/PrikazSvihUcenika2";
		
	}
	
	
	@RequestMapping(value="/dodatniPodaci", method = RequestMethod.GET)
	public String dodatniPodaci(Integer idUcenika, HttpServletRequest request) {
		Ucenik u = ur.findById(idUcenika).get();
		request.getSession().setAttribute("u", u);
		
		return "prikaz/PrikazJednogUcenika";
	}
	
	@RequestMapping(value="/dodatniPodaci2", method = RequestMethod.GET)
	public String dodatniPodaci2(Integer idUcenika, HttpServletRequest request) {
		Ucenik u = ur.findById(idUcenika).get();
		request.getSession().setAttribute("u", u);
		
		return "prikaz/PrikazJednogUcenika2";
	}
	
	
	
	@RequestMapping(value="/azurirajPodatke", method = RequestMethod.GET)
	public String azurirajPodatke(Integer idUcenika, HttpServletRequest request) {
		Ucenik u = ur.findById(idUcenika).get();
		
		request.getSession().setAttribute("ucenikA", u);
		
		
		return "azuriranje/AzurirajUcenika";
	}
	
	
	
	@RequestMapping(value="/azurirajUcenika", method = RequestMethod.POST)
	public String azurirajUcenika(String ime,String prezime,String adresa,Date datumRodjenja, Model m, HttpServletRequest request) {
		
		Ucenik u = (Ucenik) request.getSession().getAttribute("ucenikA");
		if(!(ime.equals(""))) {
			ur.azurirajIme(ime, u.getIdUcenika());
		}
		
		
		if(!(prezime.equals(""))) {
			ur.azurirajPrezime(prezime, u.getIdUcenika());
		}
		if(!(adresa.equals(""))) {
			ur.azurirajAdresu(adresa, u.getIdUcenika());
		}
		if(datumRodjenja!=null) {
			ur.azurirajDatum(datumRodjenja, u.getIdUcenika());
		}
		
		m.addAttribute("poruka", "Ucenik je uspesno azuriran.");
		
		return "azuriranje/AzurirajUcenika";
	}
	
	
	//?idUcenika=${u.idUcenika} brisanjeUcenika
	@RequestMapping(value="/brisanjeUcenika", method = RequestMethod.GET)
	public String brisanjeUcenika(Integer idUcenika, Model m) {
		
		Ucenik u = ur.findById(idUcenika).get();
		ur.delete(u);
		m.addAttribute("poruka", "Ucenik uspesno izbrisan.");
		
		return "/brisanje/ObrisanUcenik";
	}
	//prijavaZaSport
	@RequestMapping(value="/prijavaZaSport", method = RequestMethod.GET)
	public String prijavaZaSport(HttpServletRequest request) {
		
		List<Sportskadisciplina> d = sdr.findAll();
		request.getSession().setAttribute("disc", d);
		
		return "/prikaz/OdabirDiscipline";
	}
	
	//
	@RequestMapping(value="/saveUcenik2", method = RequestMethod.POST)
	public String saveUcenik2(Integer idGrupe, String ime, String prezime, Date datumRodjenja,  String adresa, Model m) {
		Ucenik nu = new Ucenik();
		nu.setAdresa(adresa);
		Date datumPrijave = new Date();
		nu.setDatumPrijave(datumPrijave);
		nu.setDatumRodjenja(datumRodjenja);
		nu.setIme(ime);
		nu.setPrezime(prezime);
		Grupa g = gr.findById(idGrupe).get();
		nu.setGrupa(g);
		
		Ucenik ucenikSaved2 = ur.save(nu);
		
		m.addAttribute("ucenikSaved2", nu);
		m.addAttribute("poruka", "poruka");
		
		return  "/prikaz/OdabirDiscipline";
		
		
	}
	
	
	
	//getSviUceniciReport.pdf
	@RequestMapping(value="/getSviUceniciReport.pdf", method = RequestMethod.GET)
	public void showReport(HttpServletResponse response) throws Exception  {
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(ur.findAllByOrderByGrupa());
		java.io.InputStream inputStream = this.getClass().getResourceAsStream("/jasperreports/UceniciPoGrupama.jrxml");
		JasperReport jasperReport = JasperCompileManager.compileReport(inputStream);
		Map<String,Object> params =new HashMap<String, Object>();
		params.put("imeSkole", "Skola Sporta Petrovic M.");
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, dataSource);
		
		response.setContentType("application/x-download");
		response.addHeader("Content-disposition", "attachment; filename=SviUcenici.pdf");
		OutputStream out =response.getOutputStream();
		JasperExportManager.exportReportToPdfStream(jasperPrint, out);
	}
	
}
