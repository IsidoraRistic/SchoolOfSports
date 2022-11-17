package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipopreme database table.
 * 
 */
@Entity
@Table(name="tipopreme")
@NamedQuery(name="Tipopreme.findAll", query="SELECT t FROM Tipopreme t")
public class Tipopreme implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idTipOpreme;

	private int kolicinaTipa;

	private String nazivTipa;

	//bi-directional many-to-one association to Oprema
	@OneToMany(mappedBy="tipopreme")
	private List<Oprema> opremas;

	public Tipopreme() {
	}

	public int getIdTipOpreme() {
		return this.idTipOpreme;
	}

	public void setIdTipOpreme(int idTipOpreme) {
		this.idTipOpreme = idTipOpreme;
	}

	public int getKolicinaTipa() {
		return this.kolicinaTipa;
	}

	public void setKolicinaTipa(int kolicinaTipa) {
		this.kolicinaTipa = kolicinaTipa;
	}

	public String getNazivTipa() {
		return this.nazivTipa;
	}

	public void setNazivTipa(String nazivTipa) {
		this.nazivTipa = nazivTipa;
	}

	public List<Oprema> getOpremas() {
		return this.opremas;
	}

	public void setOpremas(List<Oprema> opremas) {
		this.opremas = opremas;
	}

	public Oprema addOprema(Oprema oprema) {
		getOpremas().add(oprema);
		oprema.setTipopreme(this);

		return oprema;
	}

	public Oprema removeOprema(Oprema oprema) {
		getOpremas().remove(oprema);
		oprema.setTipopreme(null);

		return oprema;
	}

}