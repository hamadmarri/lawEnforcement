package entities.events;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.persistence.Embeddable;
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

	private String sayings;



	public FieldInterview() {
	}



	public FieldInterview(Person subscriber, Person inCaseOfEmergencyPerson, Calendar dateAndTime, String sayings) {
		super();
		this.subscriber = subscriber;
		this.inCaseOfEmergencyPerson = inCaseOfEmergencyPerson;
		this.dateAndTime = dateAndTime;
		this.sayings = sayings;
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



	public Calendar getDateAndTime() {
		return dateAndTime;
	}



	public void setDateAndTime(Calendar dateAndTime) {
		this.dateAndTime = dateAndTime;
	}



	public String getSayings() {
		return sayings;
	}



	public void setSayings(String sayings) {
		this.sayings = sayings;
	}



	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("MMMM dd, yyyy hh:mm");
		return this.subscriber.toString() + " " + this.inCaseOfEmergencyPerson.toString() + " "
				+ sdf.format(this.dateAndTime.getTime()) + " " + this.sayings;
	}

}
