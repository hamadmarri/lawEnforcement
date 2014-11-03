package entities.entries;

import java.io.Serializable;

import javax.persistence.*;


/**
 * Entity implementation class for Entity: Identification
 * 
 */
@Entity
public class Identification implements Serializable {

	private static final long serialVersionUID = 5245866625576748003L;

	@Id
	@GeneratedValue
	private Long id;

	private String name;
	private String content;

	@ManyToOne(cascade = CascadeType.MERGE)
	private Person person;



	public Identification() {
		super();
		this.name = new String();
		this.content = new String();
	}



	public Identification(Person person) {
		this.person = person;
	}



	public Identification(Person person, String name, String content) {
		this.person = person;
		this.name = name;
		this.content = content;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getContent() {
		return content;
	}



	public void setContent(String content) {
		this.content = content;
	}



	public Person getPerson() {
		return person;
	}



	public void setPerson(Person person) {
		this.person = person;
	}



	public Long getId() {
		return id;
	}



	public boolean isEqual(Identification another) {
		return (this.name.equals(another.name) && this.content.equals(another.content));
	}



	@Override
	public String toString() {
		return this.name + " " + this.content;
	}

}
