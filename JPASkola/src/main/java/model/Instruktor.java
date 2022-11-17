package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the instruktor database table.
 * 
 */
@Entity
@Table(name="instruktor")
@NamedQuery(name="Instruktor.findAll", query="SELECT i FROM Instruktor i")
public class Instruktor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idInstruktora;

	private String adresa;

	@Temporal(TemporalType.DATE)
	private Date datumRodjenja;

	@Temporal(TemporalType.DATE)
	private Date datumZaposlenja;

	private String email;

	private String ime;

	private String prezime;

	//bi-directional many-to-one association to Grupa
	@OneToMany(mappedBy="instruktor")
	private List<Grupa> grupas;

	//bi-directional many-to-one association to InstruktorHasSportskadisciplina
	@OneToMany(mappedBy="instruktor")
	private List<InstruktorHasSportskadisciplina> instruktorHasSportskadisciplinas;

	//bi-directional many-to-one association to Trening
	@OneToMany(mappedBy="instruktor")
	private List<Trening> trenings;

	public Instruktor() {
	}

	public int getIdInstruktora() {
		return this.idInstruktora;
	}

	public void setIdInstruktora(int idInstruktora) {
		this.idInstruktora = idInstruktora;
	}

	public String getAdresa() {
		return this.adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public Date getDatumRodjenja() {
		return this.datumRodjenja;
	}

	public void setDatumRodjenja(Date datumRodjenja) {
		this.datumRodjenja = datumRodjenja;
	}

	public Date getDatumZaposlenja() {
		return this.datumZaposlenja;
	}

	public void setDatumZaposlenja(Date datumZaposlenja) {
		this.datumZaposlenja = datumZaposlenja;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public List<Grupa> getGrupas() {
		return this.grupas;
	}

	public void setGrupas(List<Grupa> grupas) {
		this.grupas = grupas;
	}

	public Grupa addGrupa(Grupa grupa) {
		getGrupas().add(grupa);
		grupa.setInstruktor(this);

		return grupa;
	}

	public Grupa removeGrupa(Grupa grupa) {
		getGrupas().remove(grupa);
		grupa.setInstruktor(null);

		return grupa;
	}

	public List<InstruktorHasSportskadisciplina> getInstruktorHasSportskadisciplinas() {
		return this.instruktorHasSportskadisciplinas;
	}

	public void setInstruktorHasSportskadisciplinas(List<InstruktorHasSportskadisciplina> instruktorHasSportskadisciplinas) {
		this.instruktorHasSportskadisciplinas = instruktorHasSportskadisciplinas;
	}

	public InstruktorHasSportskadisciplina addInstruktorHasSportskadisciplina(InstruktorHasSportskadisciplina instruktorHasSportskadisciplina) {
		getInstruktorHasSportskadisciplinas().add(instruktorHasSportskadisciplina);
		instruktorHasSportskadisciplina.setInstruktor(this);

		return instruktorHasSportskadisciplina;
	}

	public InstruktorHasSportskadisciplina removeInstruktorHasSportskadisciplina(InstruktorHasSportskadisciplina instruktorHasSportskadisciplina) {
		getInstruktorHasSportskadisciplinas().remove(instruktorHasSportskadisciplina);
		instruktorHasSportskadisciplina.setInstruktor(null);

		return instruktorHasSportskadisciplina;
	}

	public List<Trening> getTrenings() {
		return this.trenings;
	}

	public void setTrenings(List<Trening> trenings) {
		this.trenings = trenings;
	}

	public Trening addTrening(Trening trening) {
		getTrenings().add(trening);
		trening.setInstruktor(this);

		return trening;
	}

	public Trening removeTrening(Trening trening) {
		getTrenings().remove(trening);
		trening.setInstruktor(null);

		return trening;
	}

	@Override
	public String toString() {
		return "Instruktor :" +ime+" " +prezime+", adresa: "+adresa+", e-mail: "+email;
	}

}