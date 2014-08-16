package entities.entries;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import entities.Relatable;


@Entity
public class Relation implements Serializable {

	private static final long serialVersionUID = -8623094115473557995L;

	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne(cascade = CascadeType.ALL)
	private Relatable something;

	private String typeOfRelation;

	@ManyToOne(cascade = CascadeType.ALL)
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
