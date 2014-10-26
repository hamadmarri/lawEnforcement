package entities.police;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import security.Authorizable;
import entities.entries.PersonName;
import entities.events.Event;


/**
 * Entity implementation class for Entity: Officer
 * 
 */
@Entity
@NamedQueries({ @NamedQuery(name = "Officer.findAll", query = "select o from Officer o"),
		@NamedQuery(name = "Officer.findById", query = "select o from Officer o WHERE o.id = :id") })
public class Officer extends Authorizable {

	private static final long serialVersionUID = -5522696147922682708L;

	// @Id
	// @GeneratedValue
	// Long id;

	@Embedded
	private PersonName personName;

	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;

	private String gender;

	@ManyToMany(cascade = CascadeType.ALL)
	private List<Event> eventsResponsibleFor;

	@OneToMany(mappedBy = "officerWhoCreatedIt")
	private List<InvestigativeCase> createdInvestigativeCases;



	public Officer() {
		super();
		this.personName = new PersonName();
		this.dateOfBirth = new Date();
		this.gender = new String();
	}



	public Officer(PersonName personName, String gender) {
		super();
		this.personName = personName;
		this.gender = gender;
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



	public Date getDateOfBirth() {
		return dateOfBirth;
	}



	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}



	public String getGender() {
		return gender;
	}



	public void setGender(String gender) {
		this.gender = gender;
	}



	// public Long getId() {
	// return id;
	// }

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



	public List<InvestigativeCase> getCreatedInvestigativeCases() {
		return createdInvestigativeCases;
	}



	@Override
	public String toString() {
		return this.personName.toString();
	}

}
