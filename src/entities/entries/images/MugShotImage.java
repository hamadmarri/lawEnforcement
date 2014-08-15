package entities.entries.images;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import entities.entries.Person;
import entities.entries.images.Image;


@Entity
public class MugShotImage extends Image {

	private static final long serialVersionUID = 3574723745426542751L;

	@ManyToOne
	private Person person;



	public MugShotImage() {
		super();
	}



	public MugShotImage(String caption, String link, Person person) {
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
