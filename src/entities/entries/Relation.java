package entities.entries;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Relation implements Serializable {

	private static final long serialVersionUID = -8623094115473557995L;

	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne
	private Entry something;

	private String typeOfRelation;

	@ManyToOne
	private Entry somethingElse;



	public Relation() {
		super();
	}



	public Relation(Entry something, String typeOfRelation, Entry somethingElse) {
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



	public Entry getSomething() {
		return something;
	}



	public void setSomething(Entry something) {
		this.something = something;
	}



	public String getTypeOfRelation() {
		return typeOfRelation;
	}



	public void setTypeOfRelation(String typeOfRelation) {
		this.typeOfRelation = typeOfRelation;
	}



	public Entry getSomethingElse() {
		return somethingElse;
	}



	public void setSomethingElse(Entry somethingElse) {
		this.somethingElse = somethingElse;
	}

}
