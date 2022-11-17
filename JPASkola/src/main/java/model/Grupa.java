package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the grupa database table.
 * 
 */
@Entity
@Table(name="grupa")
@NamedQuery(name="Grupa.findAll", query="SELECT g FROM Grupa g")
public class Grupa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idGrupe;

	private int brojPopunjenihMesta;

	@Temporal(TemporalType.DATE)
	private Date datumKreiranja;

	private int kapacitet;

	private String nazivGrupe;

	//bi-directional many-to-one association to Instruktor
	@ManyToOne
	private Instruktor instruktor;

	//bi-directional many-to-one association to Sportskadisciplina
	@ManyToOne
	private Sportskadisciplina sportskadisciplina;

	//bi-directional many-to-one association to Trening
	@OneToMany(mappedBy="grupa")
	private List<Trening> trenings;

	//bi-directional many-to-one association to Ucenik
	@OneToMany(mappedBy="grupa")
	private List<Ucenik> uceniks;

	public Grupa() {
	}

	public int getIdGrupe() {
		return this.idGrupe;
	}

	public void setIdGrupe(int idGrupe) {
		this.idGrupe = idGrupe;
	}

	public int getBrojPopunjenihMesta() {
		return this.brojPopunjenihMesta;
	}

	public void setBrojPopunjenihMesta(int brojPopunjenihMesta) {
		this.brojPopunjenihMesta = brojPopunjenihMesta;
	}

	public Date getDatumKreiranja() {
		return this.datumKreiranja;
	}

	public void setDatumKreiranja(Date datumKreiranja) {
		this.datumKreiranja = datumKreiranja;
	}

	public int getKapacitet() {
		return this.kapacitet;
	}

	public void setKapacitet(int kapacitet) {
		this.kapacitet = kapacitet;
	}

	public String getNazivGrupe() {
		return this.nazivGrupe;
	}

	public void setNazivGrupe(String nazivGrupe) {
		this.nazivGrupe = nazivGrupe;
	}

	public Instruktor getInstruktor() {
		return this.instruktor;
	}

	public void setInstruktor(Instruktor instruktor) {
		this.instruktor = instruktor;
	}

	public Sportskadisciplina getSportskadisciplina() {
		return this.sportskadisciplina;
	}

	public void setSportskadisciplina(Sportskadisciplina sportskadisciplina) {
		this.sportskadisciplina = sportskadisciplina;
	}

	public List<Trening> getTrenings() {
		return this.trenings;
	}

	public void setTrenings(List<Trening> trenings) {
		this.trenings = trenings;
	}

	public Trening addTrening(Trening trening) {
		getTrenings().add(trening);
		trening.setGrupa(this);

		return trening;
	}

	public Trening removeTrening(Trening trening) {
		getTrenings().remove(trening);
		trening.setGrupa(null);

		return trening;
	}

	public List<Ucenik> getUceniks() {
		return this.uceniks;
	}

	public void setUceniks(List<Ucenik> uceniks) {
		this.uceniks = uceniks;
	}

	public Ucenik addUcenik(Ucenik ucenik) {
		getUceniks().add(ucenik);
		ucenik.setGrupa(this);

		return ucenik;
	}

	public Ucenik removeUcenik(Ucenik ucenik) {
		getUceniks().remove(ucenik);
		ucenik.setGrupa(null);

		return ucenik;
	}

	@Override
	public String toString() {
		return "Grupa [nazivGrupe=" + nazivGrupe + "]";
	}
	

}