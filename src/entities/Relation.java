package entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;


@Entity
@NamedQueries({ @NamedQuery(name = "Relation.findAll", query = "select r from Relation r ORDER BY r.id"),
		@NamedQuery(name = "Relation.findById", query = "select r from Relation r WHERE r.id = :id") })
public class Relation implements Serializable {

	private static final long serialVersionUID = -8623094115473557995L;

	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne(cascade = CascadeType.MERGE)
	private Relatable something;

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



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
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

}
