package entities.entries.images;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import entities.entries.Person;


@Entity
public class PhotographicImage extends Image {

	private static final long serialVersionUID = -2930081503693862012L;

	@ManyToMany(cascade = CascadeType.ALL)
	private List<Person> persons;



	public PhotographicImage() {
		super();
		this.type = "PhotographicImage";
	}



	public PhotographicImage(String caption, String link) {
		super(caption, link);
		this.type = "PhotographicImage";
	}



	public PhotographicImage(String caption, String link, List<Person> persons) {
		super(caption, link);
		this.type = "PhotographicImage";
		this.persons = persons;
	}



	public List<Person> getPersons() {
		return persons;
	}



	public void setPersons(ArrayList<Person> persons) {
		this.persons = persons;
	}



	public void addPerson(Person person) {
		if (this.persons == null)
			this.persons = new ArrayList<Person>();

		this.persons.add(person);
	}

}
