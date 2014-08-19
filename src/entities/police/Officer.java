package entities.police;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.*;

import entities.entries.PersonName;
import entities.events.Event;


/**
 * Entity implementation class for Entity: Officer
 * 
 */
@Entity
@NamedQueries({ @NamedQuery(name = "Officer.findAll", query = "select o from Officer o") })
public class Officer implements Serializable {

	private static final long serialVersionUID = -5522696147922682708L;

	@Id
	@GeneratedValue
	Long id;

	@Embedded
	private PersonName personName;

	@Temporal(TemporalType.DATE)
	private Calendar dateOfBirth;

	private String Gender;

	@ManyToMany(cascade = CascadeType.ALL)
	private List<Event> eventsResponsibleFor;

	@OneToMany(mappedBy = "officerWhoCreatedIt")
	private List<InvestigativeCase> createdCases;



	public Officer() {
		super();
	}



	public Officer(PersonName personName, String gender) {
		super();
		this.personName = personName;
		Gender = gender;
	}



	public PersonName getPersonName() {
		return personName;
	}



	public void setPersonName(PersonName personName) {
		this.personName = personName;
	}



	public void setPersonName(String personName) {
		this.personName.setFirstName(personName.substring(0, personName.indexOf(' ')));
		this.personName.setLastName(personName.substring(personName.indexOf(' ') + 1));
	}



	public Calendar getDateOfBirth() {
		return dateOfBirth;
	}



	public void setDateOfBirth(Calendar dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}



	public String getGender() {
		return Gender;
	}



	public void setGender(String gender) {
		Gender = gender;
	}



	public Long getId() {
		return id;
	}



	public List<Event> getEventsResponsibleFor() {
		return eventsResponsibleFor;
	}



	public void setEventsResponsibleFor(List<Event> eventsResponsibleFor) {
		this.eventsResponsibleFor = eventsResponsibleFor;
	}



	public void addEventResponsibleFor(Event eventResponsibleFor) {
		if (this.eventsResponsibleFor == null)
			this.eventsResponsibleFor = new ArrayList<Event>();

		this.eventsResponsibleFor.add(eventResponsibleFor);
	}



	public List<InvestigativeCase> getCreatedCases() {
		return createdCases;
	}

}
