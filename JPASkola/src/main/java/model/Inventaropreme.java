package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the inventaropreme database table.
 * 
 */
@Entity
@Table(name="inventaropreme")
@NamedQuery(name="Inventaropreme.findAll", query="SELECT i FROM Inventaropreme i")
public class Inventaropreme implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idInventarOpreme;

	private int kolicinaOpremeUkupno;

	//bi-directional many-to-one association to Oprema
	@OneToMany(mappedBy="inventaropreme")
	private List<Oprema> opremas;

	public Inventaropreme() {
	}

	public int getIdInventarOpreme() {
		return this.idInventarOpreme;
	}

	public void setIdInventarOpreme(int idInventarOpreme) {
		this.idInventarOpreme = idInventarOpreme;
	}

	public int getKolicinaOpremeUkupno() {
		return this.kolicinaOpremeUkupno;
	}

	public void setKolicinaOpremeUkupno(int kolicinaOpremeUkupno) {
		this.kolicinaOpremeUkupno = kolicinaOpremeUkupno;
	}

	public List<Oprema> getOpremas() {
		return this.opremas;
	}

	public void setOpremas(List<Oprema> opremas) {
		this.opremas = opremas;
	}

	public Oprema addOprema(Oprema oprema) {
		getOpremas().add(oprema);
		oprema.setInventaropreme(this);

		return oprema;
	}

	public Oprema removeOprema(Oprema oprema) {
		getOpremas().remove(oprema);
		oprema.setInventaropreme(null);

		return oprema;
	}

}