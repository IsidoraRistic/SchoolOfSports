package model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;


/**
 * The persistent class for the skola_uloga database table.
 * 
 */
@Entity
@Table(name="skola_korisnik")
@NamedQuery(name="SkolaKorisnik.findAll", query="SELECT s FROM SkolaKorisnik s")
public class SkolaKorisnik implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idKorisnik;

	private String korisnickoIme;

	private String sifra;

	private String ime;
	
	private String prezime;

	@ManyToMany(fetch = FetchType.EAGER, mappedBy="korisniks")
	private Set<SkolaUloga> ulogas =new HashSet<>();


	public int getIdKorisnik() {
		return idKorisnik;
	}


	public void setIdKorisnik(int idUser) {
		this.idKorisnik = idUser;
	}
	
	
	public String getKorisnickoIme() {
		return korisnickoIme;
	}


	public void setKorisnickoIme(String korisnickoIme) {
		this.korisnickoIme = korisnickoIme;
	}


	public String getSifra() {
		return sifra;
	}


	public void setSifra(String sifra) {
		this.sifra = sifra;
	}


	public String getIme() {
		return ime;
	}


	public void setIme(String ime) {
		this.ime = ime;
	}


	public String getPrezime() {
		return prezime;
	}


	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}


	public Set<SkolaUloga> getUlogas() {
		return ulogas;
	}


	public void setUlogas(Set<SkolaUloga> ulogas) {
		this.ulogas = ulogas;
	}


	public void setRoles(Set<SkolaUloga> uloge) {
		this.ulogas = uloge;
	}
	
	public void addRole(SkolaUloga r) {
		this.ulogas.add(r);
	}
}