package entities.entries;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;


@Entity
public class Image extends Entry {

	private static final long serialVersionUID = 3099664754672904721L;

	private String caption;
	private String link;

	@ManyToOne
	private Person personOfMugShots;

	@ManyToOne
	private Person personOfFingerprints;

	@ManyToMany
	private List<Person> personsOfPhotos;



	public Image() {
		super();
	}



	public Image(String caption, String link, Person personOfMugShots, Person personOfFingerprints) {
		super();
		this.caption = caption;
		this.link = link;
		this.personOfMugShots = personOfMugShots;
		this.personOfFingerprints = personOfFingerprints;
	}



	public String getCaption() {
		return caption;
	}



	public void setCaption(String caption) {
		this.caption = caption;
	}



	public String getLink() {
		return link;
	}



	public void setLink(String link) {
		this.link = link;
	}



	public Person getPersonOfMugShots() {
		return personOfMugShots;
	}



	public void setPersonOfMugShots(Person personOfMugShots) {
		this.personOfMugShots = personOfMugShots;
	}



	public Person getPersonOfFingerprints() {
		return personOfFingerprints;
	}



	public void setPersonOfFingerprints(Person personOfFingerprints) {
		this.personOfFingerprints = personOfFingerprints;
	}



	public List<Person> getPersonsOfPhotos() {
		return personsOfPhotos;
	}



	public void setPersonsOfPhotos(ArrayList<Person> personsOfPhotos) {
		this.personsOfPhotos = personsOfPhotos;
	}



	public void addPersonOfPhotos(Person person) {
		if (this.personsOfPhotos == null)
			this.personsOfPhotos = new ArrayList<Person>();

		this.personsOfPhotos.add(person);
	}



	@Override
	public String toString() {
		return this.caption;
	}

}
