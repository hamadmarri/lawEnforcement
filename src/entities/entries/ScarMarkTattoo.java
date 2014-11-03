package entities.entries;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class ScarMarkTattoo implements Serializable {

	private static final long serialVersionUID = 9016028881418483366L;

	@Id
	@GeneratedValue
	protected Long id;

	protected String content;

	@ManyToOne
	protected Person person;



	public ScarMarkTattoo() {
		this.content = new String();
	}



	public ScarMarkTattoo(Person person, String content) {
		super();
		this.content = content;
		this.person = person;
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



	public boolean isEqual(ScarMarkTattoo another) {
		return (this.content.equals(another.content));
	}



	@Override
	public String toString() {
		return this.content;
	}

}
