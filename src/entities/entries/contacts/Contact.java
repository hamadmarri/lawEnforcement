package entities.entries.contacts;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;

import entities.entries.Person;


@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Contact implements Serializable {

	private static final long serialVersionUID = 2529485375399002589L;

	@Id
	@GeneratedValue
	protected Long id;

	protected String type;
	protected String content;

	@ManyToOne(cascade = CascadeType.MERGE)
	protected Person person;



	public Contact() {
		this.type = new String();
		this.content = new String();
	}



	public Contact(Person p) {
		this.person = p;
	}



	public Long getId() {
		return id;
	}



	public abstract String getContent();



	public abstract void setContent(String content);



	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	public void setPerson(Person owner) {
		this.person = owner;
	}



	public Person getPerson() {
		return person;
	}



	public boolean isEqual(Contact another) {
		return (this.type.equals(another.type) && this.content.equals(another.content));
	}



	@Override
	public String toString() {
		return this.type + " " + this.content;
	}

}
