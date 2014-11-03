package entities.events;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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

	@ManyToOne()
	private IncidentReport incidentReport;

	@ManyToOne(cascade = CascadeType.MERGE)
	private Person subscriber;

	@ManyToOne(cascade = CascadeType.MERGE)
	private Person inCaseOfEmergencyPerson;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateAndTime;

	@Lob
	@Column(length = 20000)
	private String exactlyWhatOccurred;

	@Lob
	@Column(length = 20000)
	private String whenDidIthappen;

	@Lob
	@Column(length = 20000)
	private String whereDidItHappen;

	@Lob
	@Column(length = 20000)
	private String whoWasPresent;

	@Lob
	@Column(length = 20000)
	private String whoElseMayKnowRelevantInformation;

	@Lob
	@Column(length = 20000)
	private String howDidItHappen;

	@Lob
	@Column(length = 20000)
	private String whyDidItHappenAndCouldItHaveBeenAvoided;

	@Lob
	@Column(length = 20000)
	private String areThereNotes_documents_phone_messages_or_other_evidence;

	@Lob
	@Column(length = 20000)
	private String otherSayings;



	public FieldInterview() {
		this.dateAndTime = new Date();
		this.areThereNotes_documents_phone_messages_or_other_evidence = new String();
		this.exactlyWhatOccurred = new String();
		this.howDidItHappen = new String();
		this.whenDidIthappen = new String();
		this.whereDidItHappen = new String();
		this.whoElseMayKnowRelevantInformation = new String();
		this.whoWasPresent = new String();
		this.whyDidItHappenAndCouldItHaveBeenAvoided = new String();
		this.otherSayings = new String();
	}



	public FieldInterview(IncidentReport incidentReport, Person subscriber, Person inCaseOfEmergencyPerson,
			Date dateAndTime) {
		super();
		this.incidentReport = incidentReport;
		this.subscriber = subscriber;
		this.inCaseOfEmergencyPerson = inCaseOfEmergencyPerson;
		this.dateAndTime = dateAndTime;
		this.areThereNotes_documents_phone_messages_or_other_evidence = new String();
		this.exactlyWhatOccurred = new String();
		this.howDidItHappen = new String();
		this.whenDidIthappen = new String();
		this.whereDidItHappen = new String();
		this.whoElseMayKnowRelevantInformation = new String();
		this.whoWasPresent = new String();
		this.whyDidItHappenAndCouldItHaveBeenAvoided = new String();
		this.otherSayings = new String();
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



	public String getExactlyWhatOccurred() {
		return exactlyWhatOccurred;
	}



	public void setExactlyWhatOccurred(String exactlyWhatOccurred) {
		this.exactlyWhatOccurred = exactlyWhatOccurred;
	}



	public String getWhenDidIthappen() {
		return whenDidIthappen;
	}



	public void setWhenDidIthappen(String whenDidIthappen) {
		this.whenDidIthappen = whenDidIthappen;
	}



	public String getWhereDidItHappen() {
		return whereDidItHappen;
	}



	public void setWhereDidItHappen(String whereDidItHappen) {
		this.whereDidItHappen = whereDidItHappen;
	}



	public String getWhoWasPresent() {
		return whoWasPresent;
	}



	public void setWhoWasPresent(String whoWasPresent) {
		this.whoWasPresent = whoWasPresent;
	}



	public String getWhoElseMayKnowRelevantInformation() {
		return whoElseMayKnowRelevantInformation;
	}



	public void setWhoElseMayKnowRelevantInformation(String whoElseMayKnowRelevantInformation) {
		this.whoElseMayKnowRelevantInformation = whoElseMayKnowRelevantInformation;
	}



	public String getHowDidItHappen() {
		return howDidItHappen;
	}



	public void setHowDidItHappen(String howDidItHappen) {
		this.howDidItHappen = howDidItHappen;
	}



	public String getWhyDidItHappenAndCouldItHaveBeenAvoided() {
		return whyDidItHappenAndCouldItHaveBeenAvoided;
	}



	public void setWhyDidItHappenAndCouldItHaveBeenAvoided(String whyDidItHappenAndCouldItHaveBeenAvoided) {
		this.whyDidItHappenAndCouldItHaveBeenAvoided = whyDidItHappenAndCouldItHaveBeenAvoided;
	}



	public String getAreThereNotes_documents_phone_messages_or_other_evidence() {
		return areThereNotes_documents_phone_messages_or_other_evidence;
	}



	public void setAreThereNotes_documents_phone_messages_or_other_evidence(
			String areThereNotes_documents_phone_messages_or_other_evidence) {
		this.areThereNotes_documents_phone_messages_or_other_evidence = areThereNotes_documents_phone_messages_or_other_evidence;
	}



	public String getOtherSayings() {
		return otherSayings;
	}



	public void setOtherSayings(String otherSayings) {
		this.otherSayings = otherSayings;
	}



	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("MMMM dd, yyyy hh:mm");
		return this.subscriber.toString() + " " + this.inCaseOfEmergencyPerson.toString() + " "
				+ sdf.format(this.dateAndTime.getTime());
	}

}
