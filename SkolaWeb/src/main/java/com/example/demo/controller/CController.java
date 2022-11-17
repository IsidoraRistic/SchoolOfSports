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
import com.example.demo.repository.PrisustvoRepository;
import com.example.demo.repository.SportskaDisciplinaRepository;
import com.example.demo.repository.TestiranjeRepository;
import com.example.demo.repository.TreningRepository;
import com.example.demo.repository.UcenikRepository;

import model.Grupa;
import model.Odrzavanjetestiranja;
import model.Prisustvo;
import model.Sportskadisciplina;
import model.Trening;
import model.Ucenik;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Controller
@RequestMapping(value="/ulogaclana")
public class CController {
	
	@Autowired
	TreningRepository treningr;
	
	@Autowired
	TestiranjeRepository testiranjer;
	
	
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
		Odrzavanjetestiranja otSaved = testiranjer.save(ot);
		
		
		m.addAttribute("otSaved", otSaved);
		return "unos/DodajBodove";
	}
	
	@RequestMapping(value="/getRezTestiranja", method = RequestMethod.GET)
	public String getRezTestiranja(Integer idUcenika, HttpServletRequest request) {
		
		Ucenik u = ur.findById(idUcenika).get();
		
		List<Odrzavanjetestiranja> ot = testiranjer.findByUcenik(u);
		
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
		List<Odrzavanjetestiranja> ots =testiranjer.findByTrening(trening);
		
		request.setAttribute("odrzavanjas", ots);
		request.setAttribute("poruka", "izbor napravljen.");
		
		
		return "prikaz/IzborTestiranja";
	}
	//

	
	

	
	@Autowired
	GrupaRepository gr;
	

	
	
	@RequestMapping(value="/dobaviPrisustva", method = RequestMethod.GET) 
	public String dobavi(Integer idUcenika, HttpServletRequest request) {
		Ucenik u = ur.findById(idUcenika).get();
		request.getSession().setAttribute("u", u);
		Grupa g = u.getGrupa();
		List<Trening> treninzi = treningr.findByGrupa(g);
		request.getSession().setAttribute("treninzi", treninzi);
		return "unos/DodavanjePrisustva";
	}
	
	@RequestMapping(value="/dobaviPrisustvaNaTestiranju", method = RequestMethod.GET) 
	public String dobavi2(Integer idUcenika, HttpServletRequest request) {
		Ucenik u = ur.findById(idUcenika).get();
		request.getSession().setAttribute("u", u);
		Grupa g = u.getGrupa();
		List<Trening> treninzi = treningr.findByGrupa(g);
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
		
		
		Trening t = treningr.findById(idTreninga).get();
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
		List<Trening> treninzi = treningr.findAll();
		
		request.getSession().setAttribute("tren", treninzi);
		
		return "/prikaz/IzaberiTreningIDatum";
		
	}
	
	
	
	//prikaziZaTrening
	@RequestMapping(value="/prikaziZaTrening", method = RequestMethod.GET)
	public String prikaziZaTrening(Integer idTreninga, HttpServletRequest request) {
		Trening t = treningr.findById(idTreninga).get();
		
		List<Prisustvo> prisustva = pr.findByTrening(t);
		
		request.getSession().setAttribute("prisustvaTrenings", prisustva);
		
		return "/prikaz/IzaberiTreningIDatum";
		
	}
	
	
	
	@Autowired
	SportskaDisciplinaRepository sdr;
	

	
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
		request.getSession().setAttribute("porukaOdabirDisc", "porukaodabirdisc");
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
