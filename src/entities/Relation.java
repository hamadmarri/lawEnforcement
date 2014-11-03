package entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

import entities.entries.Property;
import entities.entries.history.Action;
import entities.entries.history.Changeable;
import entities.entries.history.History;


@Entity
@NamedQueries({ @NamedQuery(name = "Relation.findAll", query = "select r from Relation r ORDER BY r.id"),
		@NamedQuery(name = "Relation.findById", query = "select r from Relation r WHERE r.id = :id") })
public class Relation extends Changeable implements Serializable {

	private static final long serialVersionUID = -8623094115473557995L;

	@ManyToOne(cascade = CascadeType.MERGE)
	private Relatable something;

	@Lob
	@Column(length = 20000)
	private String typeOfRelation;

	@ManyToOne(cascade = CascadeType.MERGE)
	private Relatable somethingElse;



	public Relation() {
		super();
	}



	public Relation(Relatable something, String typeOfRelation, Relatable somethingElse) {
		super();
		this.something = something;
		this.typeOfRelation = typeOfRelation;
		this.somethingElse = somethingElse;
	}



	public Relatable getSomething() {
		return something;
	}



	public void setSomething(Relatable something) {
		this.something = something;
	}



	public String getTypeOfRelation() {
		return typeOfRelation;
	}



	public void setTypeOfRelation(String typeOfRelation) {
		this.typeOfRelation = typeOfRelation;
	}



	public Relatable getSomethingElse() {
		return somethingElse;
	}



	public void setSomethingElse(Relatable somethingElse) {
		this.somethingElse = somethingElse;
	}



	@Override
	public void logChanges(Object old) {
		Relation oldR = (Relation) old;

		if (!this.typeOfRelation.equals(oldR.typeOfRelation))
			this.getHistory().addAction(new Action("typeOfRelation", this.typeOfRelation, oldR.typeOfRelation));

		if (this.something != null & oldR.something != null
				&& this.something.getId().compareTo(oldR.something.getId()) != 0)
			this.getHistory().addAction(
					new Action("something id", this.something.getId().toString(), oldR.something.getId().toString()));

		if (this.somethingElse != null & oldR.somethingElse != null
				&& this.somethingElse.getId().compareTo(oldR.somethingElse.getId()) != 0)
			this.getHistory().addAction(
					new Action("somethingElse id", this.somethingElse.getId().toString(), oldR.somethingElse.getId()
							.toString()));
	}
}
