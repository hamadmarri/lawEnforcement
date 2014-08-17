package entities.entries;

import javax.persistence.Embeddable;


@Embeddable
public class PersonName {

	private String firstName;
	private String lastName;



	public PersonName() {

	}



	public PersonName(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}



	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	@Override
	public String toString() {
		return this.firstName + " " + this.lastName;
	}

}
