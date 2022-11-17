



package model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;


/**
 * The persistent class for the skola_korisnik database table.
 * 
 */
@Entity
@Table(name="skola_uloga")
@NamedQuery(name="SkolaUloga.findAll", query="SELECT s FROM SkolaUloga s")
public class SkolaUloga implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idUloga")
	private int idUloga;

	private String naziv;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="skola_korisnik_uloga", joinColumns = @JoinColumn(name = "idUloga",referencedColumnName = "idUloga"),inverseJoinColumns = @JoinColumn(name = "idKorisnik"))
	private Set<SkolaKorisnik> korisniks =new HashSet<>();

	public int getIdUloga() {
		return idUloga;
	}

	public void setIdUloga(int idUloga) {
		this.idUloga = idUloga;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public Set<SkolaKorisnik> getKorisniks() {
		return korisniks;
	}

	public void setKorisniks(Set<SkolaKorisnik> korisniks) {
		this.korisniks = korisniks;
	}
	public void addKorisnik(SkolaKorisnik k) {
		this.korisniks.add(k);
	}

}