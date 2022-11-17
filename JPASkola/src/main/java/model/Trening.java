package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the trening database table.
 * 
 */
@Entity
@Table(name="trening")
@NamedQuery(name="Trening.findAll", query="SELECT t FROM Trening t")
public class Trening implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idTreninga;

	@Temporal(TemporalType.DATE)
	private Date datumOdrzavanja;

	//bi-directional many-to-one association to Odrzavanjetestiranja
	@OneToMany(mappedBy="trening")
	private List<Odrzavanjetestiranja> odrzavanjetestiranjas;

	//bi-directional many-to-one association to Prisustvo
	@OneToMany(mappedBy="trening")
	private List<Prisustvo> prisustvos;

	//bi-directional many-to-one association to Grupa
	@ManyToOne
	private Grupa grupa;

	//bi-directional many-to-one association to Instruktor
	@ManyToOne
	private Instruktor instruktor;

	//bi-directional many-to-one association to Sportskadisciplina
	@ManyToOne
	private Sportskadisciplina sportskadisciplina;

	//bi-directional many-to-one association to Teren
	@ManyToOne
	private Teren teren;

	//bi-directional many-to-one association to TreningHasOprema
	@OneToMany(mappedBy="trening")
	private List<TreningHasOprema> treningHasOpremas;

	public Trening() {
	}

	public int getIdTreninga() {
		return this.idTreninga;
	}

	public void setIdTreninga(int idTreninga) {
		this.idTreninga = idTreninga;
	}

	public Date getDatumOdrzavanja() {
		return this.datumOdrzavanja;
	}

	public void setDatumOdrzavanja(Date datumOdrzavanja) {
		this.datumOdrzavanja = datumOdrzavanja;
	}

	public List<Odrzavanjetestiranja> getOdrzavanjetestiranjas() {
		return this.odrzavanjetestiranjas;
	}

	public void setOdrzavanjetestiranjas(List<Odrzavanjetestiranja> odrzavanjetestiranjas) {
		this.odrzavanjetestiranjas = odrzavanjetestiranjas;
	}

	public Odrzavanjetestiranja addOdrzavanjetestiranja(Odrzavanjetestiranja odrzavanjetestiranja) {
		getOdrzavanjetestiranjas().add(odrzavanjetestiranja);
		odrzavanjetestiranja.setTrening(this);

		return odrzavanjetestiranja;
	}

	public Odrzavanjetestiranja removeOdrzavanjetestiranja(Odrzavanjetestiranja odrzavanjetestiranja) {
		getOdrzavanjetestiranjas().remove(odrzavanjetestiranja);
		odrzavanjetestiranja.setTrening(null);

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
		prisustvo.setTrening(this);

		return prisustvo;
	}

	public Prisustvo removePrisustvo(Prisustvo prisustvo) {
		getPrisustvos().remove(prisustvo);
		prisustvo.setTrening(null);

		return prisustvo;
	}

	public Grupa getGrupa() {
		return this.grupa;
	}

	public void setGrupa(Grupa grupa) {
		this.grupa = grupa;
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

	public Teren getTeren() {
		return this.teren;
	}

	public void setTeren(Teren teren) {
		this.teren = teren;
	}

	public List<TreningHasOprema> getTreningHasOpremas() {
		return this.treningHasOpremas;
	}

	public void setTreningHasOpremas(List<TreningHasOprema> treningHasOpremas) {
		this.treningHasOpremas = treningHasOpremas;
	}

	public TreningHasOprema addTreningHasOprema(TreningHasOprema treningHasOprema) {
		getTreningHasOpremas().add(treningHasOprema);
		treningHasOprema.setTrening(this);

		return treningHasOprema;
	}

	public TreningHasOprema removeTreningHasOprema(TreningHasOprema treningHasOprema) {
		getTreningHasOpremas().remove(treningHasOprema);
		treningHasOprema.setTrening(null);

		return treningHasOprema;
	}

}