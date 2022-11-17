package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the prisustvo database table.
 * 
 */
@Entity
@Table(name="prisustvo")
@NamedQuery(name="Prisustvo.findAll", query="SELECT p FROM Prisustvo p")
public class Prisustvo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idPrisustva;

	private String napomene;

	//bi-directional many-to-one association to Trening
	@ManyToOne
	private Trening trening;

	//bi-directional many-to-one association to Ucenik
	@ManyToOne
	private Ucenik ucenik;

	public Prisustvo() {
	}

	public int getIdPrisustva() {
		return this.idPrisustva;
	}

	public void setIdPrisustva(int idPrisustva) {
		this.idPrisustva = idPrisustva;
	}

	public String getNapomene() {
		return this.napomene;
	}

	public void setNapomene(String napomene) {
		this.napomene = napomene;
	}

	public Trening getTrening() {
		return this.trening;
	}

	public void setTrening(Trening trening) {
		this.trening = trening;
	}

	public Ucenik getUcenik() {
		return this.ucenik;
	}

	public void setUcenik(Ucenik ucenik) {
		this.ucenik = ucenik;
	}

}