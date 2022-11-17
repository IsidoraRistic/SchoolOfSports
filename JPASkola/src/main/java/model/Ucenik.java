package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the ucenik database table.
 * 
 */
@Entity
@Table(name="ucenik")
@NamedQuery(name="Ucenik.findAll", query="SELECT u FROM Ucenik u")
public class Ucenik implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idUcenika;

	private String adresa;

	@Temporal(TemporalType.DATE)
	private Date datumPrijave;

	@Temporal(TemporalType.DATE)
	private Date datumRodjenja;

	private String ime;

	private String prezime;

	//bi-directional many-to-one association to Odrzavanjetestiranja
	@OneToMany(mappedBy="ucenik")
	private List<Odrzavanjetestiranja> odrzavanjetestiranjas;

	//bi-directional many-to-one association to Prisustvo
	@OneToMany(mappedBy="ucenik")
	private List<Prisustvo> prisustvos;

	//bi-directional many-to-one association to Grupa
	@ManyToOne
	private Grupa grupa;

	public Ucenik() {
	}

	public int getIdUcenika() {
		return this.idUcenika;
	}

	public void setIdUcenika(int idUcenika) {
		this.idUcenika = idUcenika;
	}

	public String getAdresa() {
		return this.adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public Date getDatumPrijave() {
		return this.datumPrijave;
	}

	public void setDatumPrijave(Date datumPrijave) {
		this.datumPrijave = datumPrijave;
	}

	public Date getDatumRodjenja() {
		return this.datumRodjenja;
	}

	public void setDatumRodjenja(Date datumRodjenja) {
		this.datumRodjenja = datumRodjenja;
	}

	public String getIme() {
		return this.ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return this.prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public List<Odrzavanjetestiranja> getOdrzavanjetestiranjas() {
		return this.odrzavanjetestiranjas;
	}

	public void setOdrzavanjetestiranjas(List<Odrzavanjetestiranja> odrzavanjetestiranjas) {
		this.odrzavanjetestiranjas = odrzavanjetestiranjas;
	}

	public Odrzavanjetestiranja addOdrzavanjetestiranja(Odrzavanjetestiranja odrzavanjetestiranja) {
		getOdrzavanjetestiranjas().add(odrzavanjetestiranja);
		odrzavanjetestiranja.setUcenik(this);

		return odrzavanjetestiranja;
	}

	public Odrzavanjetestiranja removeOdrzavanjetestiranja(Odrzavanjetestiranja odrzavanjetestiranja) {
		getOdrzavanjetestiranjas().remove(odrzavanjetestiranja);
		odrzavanjetestiranja.setUcenik(null);

		return odrzavanjetestiranja;
	}

	public List<Prisustvo> getPrisustvos() {
		return this.prisustvos;
	}

	public void setPrisustvos(List<Prisustvo> prisustvos) {
		this.prisustvos = prisustvos;
	}

	public Prisustvo addPrisustvo(Prisustvo prisustvo) {
		getPrisustvos().add(prisustvo);
		prisustvo.setUcenik(this);

		return prisustvo;
	}

	public Prisustvo removePrisustvo(Prisustvo prisustvo) {
		getPrisustvos().remove(prisustvo);
		prisustvo.setUcenik(null);

		return prisustvo;
	}

	public Grupa getGrupa() {
		return this.grupa;
	}

	public void setGrupa(Grupa grupa) {
		this.grupa = grupa;
	}

}