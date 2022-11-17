package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the teren database table.
 * 
 */
@Entity
@Table(name="teren")
@NamedQuery(name="Teren.findAll", query="SELECT t FROM Teren t")
public class Teren implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idTerena;

	private String adresa;

	private String grad;

	//bi-directional many-to-one association to Trening
	@OneToMany(mappedBy="teren")
	private List<Trening> trenings;

	public Teren() {
	}

	public int getIdTerena() {
		return this.idTerena;
	}

	public void setIdTerena(int idTerena) {
		this.idTerena = idTerena;
	}

	public String getAdresa() {
		return this.adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getGrad() {
		return this.grad;
	}

	public void setGrad(String grad) {
		this.grad = grad;
	}

	public List<Trening> getTrenings() {
		return this.trenings;
	}

	public void setTrenings(List<Trening> trenings) {
		this.trenings = trenings;
	}

	public Trening addTrening(Trening trening) {
		getTrenings().add(trening);
		trening.setTeren(this);

		return trening;
	}

	public Trening removeTrening(Trening trening) {
		getTrenings().remove(trening);
		trening.setTeren(null);

		return trening;
	}

}