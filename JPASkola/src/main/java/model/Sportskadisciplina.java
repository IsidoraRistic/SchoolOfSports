package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the sportskadisciplina database table.
 * 
 */
@Entity
@Table(name="sportskadisciplina")
@NamedQuery(name="Sportskadisciplina.findAll", query="SELECT s FROM Sportskadisciplina s")
public class Sportskadisciplina implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idSportskaDisciplina;

	private String naziv;

	private String preduslovi;

	//bi-directional many-to-one association to Grupa
	@OneToMany(mappedBy="sportskadisciplina")
	private List<Grupa> grupas;

	//bi-directional many-to-one association to InstruktorHasSportskadisciplina
	@OneToMany(mappedBy="sportskadisciplina")
	private List<InstruktorHasSportskadisciplina> instruktorHasSportskadisciplinas;

	//bi-directional many-to-one association to Trening
	@OneToMany(mappedBy="sportskadisciplina")
	private List<Trening> trenings;

	public Sportskadisciplina() {
	}

	public int getIdSportskaDisciplina() {
		return this.idSportskaDisciplina;
	}

	public void setIdSportskaDisciplina(int idSportskaDisciplina) {
		this.idSportskaDisciplina = idSportskaDisciplina;
	}

	public String getNaziv() {
		return this.naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getPreduslovi() {
		return this.preduslovi;
	}

	public void setPreduslovi(String preduslovi) {
		this.preduslovi = preduslovi;
	}

	public List<Grupa> getGrupas() {
		return this.grupas;
	}

	public void setGrupas(List<Grupa> grupas) {
		this.grupas = grupas;
	}

	public Grupa addGrupa(Grupa grupa) {
		getGrupas().add(grupa);
		grupa.setSportskadisciplina(this);

		return grupa;
	}

	public Grupa removeGrupa(Grupa grupa) {
		getGrupas().remove(grupa);
		grupa.setSportskadisciplina(null);

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
		instruktorHasSportskadisciplina.setSportskadisciplina(this);

		return instruktorHasSportskadisciplina;
	}

	public InstruktorHasSportskadisciplina removeInstruktorHasSportskadisciplina(InstruktorHasSportskadisciplina instruktorHasSportskadisciplina) {
		getInstruktorHasSportskadisciplinas().remove(instruktorHasSportskadisciplina);
		instruktorHasSportskadisciplina.setSportskadisciplina(null);

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
		trening.setSportskadisciplina(this);

		return trening;
	}

	public Trening removeTrening(Trening trening) {
		getTrenings().remove(trening);
		trening.setSportskadisciplina(null);

		return trening;
	}

}