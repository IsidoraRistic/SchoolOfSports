package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the odrzavanjetestiranja database table.
 * 
 */
@Entity
@Table(name="odrzavanjetestiranja")
@NamedQuery(name="Odrzavanjetestiranja.findAll", query="SELECT o FROM Odrzavanjetestiranja o")
public class Odrzavanjetestiranja implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idOdrzavanjeTestiranja;

	private int brojBodova;

	@Temporal(TemporalType.DATE)
	private Date datumTestiranja;

	private String napomene;

	//bi-directional many-to-one association to Trening
	@ManyToOne
	private Trening trening;

	//bi-directional many-to-one association to Ucenik
	@ManyToOne
	private Ucenik ucenik;

	public Odrzavanjetestiranja() {
	}

	public int getIdOdrzavanjeTestiranja() {
		return this.idOdrzavanjeTestiranja;
	}

	public void setIdOdrzavanjeTestiranja(int idOdrzavanjeTestiranja) {
		this.idOdrzavanjeTestiranja = idOdrzavanjeTestiranja;
	}

	public int getBrojBodova() {
		return this.brojBodova;
	}

	public void setBrojBodova(int brojBodova) {
		this.brojBodova = brojBodova;
	}

	public Date getDatumTestiranja() {
		return this.datumTestiranja;
	}

	public void setDatumTestiranja(Date datumTestiranja) {
		this.datumTestiranja = datumTestiranja;
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