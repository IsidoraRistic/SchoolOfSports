package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the instruktor_has_sportskadisciplina database table.
 * 
 */
@Entity
@Table(name="instruktor_has_sportskadisciplina")
@NamedQuery(name="InstruktorHasSportskadisciplina.findAll", query="SELECT i FROM InstruktorHasSportskadisciplina i")
public class InstruktorHasSportskadisciplina implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idInstruktorDisciplina;

	//bi-directional many-to-one association to Instruktor
	@ManyToOne
	private Instruktor instruktor;

	//bi-directional many-to-one association to Sportskadisciplina
	@ManyToOne
	private Sportskadisciplina sportskadisciplina;

	public InstruktorHasSportskadisciplina() {
	}

	public int getIdInstruktorDisciplina() {
		return this.idInstruktorDisciplina;
	}

	public void setIdInstruktorDisciplina(int idInstruktorDisciplina) {
		this.idInstruktorDisciplina = idInstruktorDisciplina;
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

}