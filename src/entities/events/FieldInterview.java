package entities.events;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Embeddable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import entities.entries.Person;


/**
 * Entity implementation class for Entity: FieldInterview
 * 
 */
@Embeddable
public class FieldInterview {

	@OneToOne
	Person subscriber;

	@OneToOne
	Person inCaseOfEmergencyPerson;

	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dateAndTime;

	private String Sayings;



	public FieldInterview() {
	}



	public FieldInterview(Person subscriber, Person inCaseOfEmergencyPerson, Calendar dateAndTime, String sayings) {
		super();
		this.subscriber = subscriber;
		this.inCaseOfEmergencyPerson = inCaseOfEmergencyPerson;
		this.dateAndTime = dateAndTime;
		Sayings = sayings;
	}



	public Person getSubscriber() {
		return subscriber;
	}



	public void setSubscriber(Person subscriber) {
		this.subscriber = subscriber;
	}



	public Person getInCaseOfEmergencyPerson() {
		return inCaseOfEmergencyPerson;
	}



	public void setInCaseOfEmergencyPerson(Person inCaseOfEmergencyPerson) {
		this.inCaseOfEmergencyPerson = inCaseOfEmergencyPerson;
	}



	// public void addInCaseOfEmergencyPerson(Person inCaseOfEmergencyPerson) {
	// if (this.inCaseOfEmergencyPersons == null)
	// this.inCaseOfEmergencyPersons = new ArrayList<Person>();
	//
	// this.inCaseOfEmergencyPersons.add(inCaseOfEmergencyPerson);
	// }

	public Calendar getDateAndTime() {
		return dateAndTime;
	}



	public void setDateAndTime(Calendar dateAndTime) {
		this.dateAndTime = dateAndTime;
	}



	public String getSayings() {
		return Sayings;
	}



	public void setSayings(String sayings) {
		Sayings = sayings;
	}

}
