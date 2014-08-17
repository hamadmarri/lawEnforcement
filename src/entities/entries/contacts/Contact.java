package entities.entries.contacts;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import entities.entries.Person;


@Entity
public abstract class Contact implements Serializable {

	private static final long serialVersionUID = 2529485375399002589L;

	@Id
	@GeneratedValue
	protected Long id;

	protected String name;
	protected String content;

	@ManyToOne
	protected Person owner;



	public Contact() {

	}



	public Contact(Person p) {
		this.owner = p;
	}



	public abstract String getContent();



	public abstract void setContent(String content);



	public String getName() {
		return this.name;
	}



	public void setOwner(Person owner) {
		this.owner = owner;
	}



	public Person getOwner() {
		return owner;
	}

}
