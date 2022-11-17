package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the trening_has_oprema database table.
 * 
 */
@Entity
@Table(name="trening_has_oprema")
@NamedQuery(name="TreningHasOprema.findAll", query="SELECT t FROM TreningHasOprema t")
public class TreningHasOprema implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idTreningOprema;

	//bi-directional many-to-one association to Oprema
	@ManyToOne
	private Oprema oprema;

	//bi-directional many-to-one association to Trening
	@ManyToOne
	private Trening trening;

	public TreningHasOprema() {
	}

	public int getIdTreningOprema() {
		return this.idTreningOprema;
	}

	public void setIdTreningOprema(int idTreningOprema) {
		this.idTreningOprema = idTreningOprema;
	}

	public Oprema getOprema() {
		return this.oprema;
	}

	public void setOprema(Oprema oprema) {
		this.oprema = oprema;
	}

	public Trening getTrening() {
		return this.trening;
	}

	public void setTrening(Trening trening) {
		this.trening = trening;
	}

}