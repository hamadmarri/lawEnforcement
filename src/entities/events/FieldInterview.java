package entities.events;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import entities.entries.Person;


/**
 * Entity implementation class for Entity: FieldInterview
 * 
 */
@Entity
@NamedQueries({
		@NamedQuery(name = "FieldInterview.findAll", query = "select fi from FieldInterview fi ORDER BY fi.id"),
		@NamedQuery(name = "FieldInterview.findById", query = "select fi from FieldInterview fi WHERE fi.id = :id") })
public class FieldInterview implements Serializable {

	private static final long serialVersionUID = 2403530587223678592L;

	@Id
	@GeneratedValue
	protected Long id;

	@ManyToOne
	private IncidentReport incidentReport;

	@OneToOne
	private Person subscriber;

	@OneToOne
	private Person inCaseOfEmergencyPerson;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateAndTime;

	private String sayings;



	public FieldInterview() {
	}



	public FieldInterview(IncidentReport incidentReport, Person subscriber, Person inCaseOfEmergencyPerson,
			Date dateAndTime, String sayings) {
		super();
		this.incidentReport = incidentReport;
		this.subscriber = subscriber;
		this.inCaseOfEmergencyPerson = inCaseOfEmergencyPerson;
		this.dateAndTime = dateAndTime;
		this.sayings = sayings;
	}



	public Long getId() {
		return id;
	}



	public IncidentReport getIncidentReport() {
		return incidentReport;
	}



	public void setIncidentReport(IncidentReport incidentReport) {
		this.incidentReport = incidentReport;
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



	public Date getDateAndTime() {
		return dateAndTime;
	}



	public void setDateAndTime(Date dateAndTime) {
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
