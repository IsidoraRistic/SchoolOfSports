package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the oprema database table.
 * 
 */
@Entity
@Table(name="oprema")
@NamedQuery(name="Oprema.findAll", query="SELECT o FROM Oprema o")
public class Oprema implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idOpreme;

	private String napomene;

	//bi-directional many-to-one association to Inventaropreme
	@ManyToOne
	private Inventaropreme inventaropreme;

	//bi-directional many-to-one association to Tipopreme
	@ManyToOne
	private Tipopreme tipopreme;

	//bi-directional many-to-one association to TreningHasOprema
	@OneToMany(mappedBy="oprema")
	private List<TreningHasOprema> treningHasOpremas;

	public Oprema() {
	}

	public int getIdOpreme() {
		return this.idOpreme;
	}

	public void setIdOpreme(int idOpreme) {
		this.idOpreme = idOpreme;
	}

	public String getNapomene() {
		return this.napomene;
	}

	public void setNapomene(String napomene) {
		this.napomene = napomene;
	}

	public Inventaropreme getInventaropreme() {
		return this.inventaropreme;
	}

	public void setInventaropreme(Inventaropreme inventaropreme) {
		this.inventaropreme = inventaropreme;
	}

	public Tipopreme getTipopreme() {
		return this.tipopreme;
	}

	public void setTipopreme(Tipopreme tipopreme) {
		this.tipopreme = tipopreme;
	}

	public List<TreningHasOprema> getTreningHasOpremas() {
		return this.treningHasOpremas;
	}

	public void setTreningHasOpremas(List<TreningHasOprema> treningHasOpremas) {
		this.treningHasOpremas = treningHasOpremas;
	}

	public TreningHasOprema addTreningHasOprema(TreningHasOprema treningHasOprema) {
		getTreningHasOpremas().add(treningHasOprema);
		treningHasOprema.setOprema(this);

		return treningHasOprema;
	}

	public TreningHasOprema removeTreningHasOprema(TreningHasOprema treningHasOprema) {
		getTreningHasOpremas().remove(treningHasOprema);
		treningHasOprema.setOprema(null);

		return treningHasOprema;
	}

}