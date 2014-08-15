package entities.entries.images;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import entities.entries.Person;


@Entity
public class FingerprintImage extends Image {

	private static final long serialVersionUID = 2076018071218735536L;

	@ManyToOne
	private Person person;



	public FingerprintImage() {
		super();
	}



	public FingerprintImage(String caption, String link, Person person) {
		super(caption, link);
		this.person = person;
	}



	public Person getPerson() {
		return person;
	}



	public void setPerson(Person person) {
		this.person = person;
	}

}
