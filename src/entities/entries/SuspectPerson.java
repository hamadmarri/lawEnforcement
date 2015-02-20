package entities.entries;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

import entities.entries.history.Action;
import entities.police.InvestigativeCase;


@Entity
@NamedQueries({ @NamedQuery(name = "SuspectPerson.findAll", query = "select s from SuspectPerson s ORDER BY s.id"),
		@NamedQuery(name = "SuspectPerson.findById", query = "select s from SuspectPerson s WHERE s.id = :id") })
public class SuspectPerson extends Entry implements Serializable {

	private static final long serialVersionUID = 6230656995120526177L;

	@Embedded
	private PersonName personName;

	@Embedded
	private PhysicalCharacteristic physicalCharacteristic;

	@Embedded
	private ThreatAssessment threatAssessment;

	@ManyToMany(mappedBy = "suspectPersons")
	private List<InvestigativeCase> investigativeCases; 

	@OneToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private Person person;



	public SuspectPerson() {
		super();
		this.type = "SuspectPerson";
		this.personName = new PersonName();
		this.physicalCharacteristic = new PhysicalCharacteristic();
		this.threatAssessment = new ThreatAssessment();
	}



	public SuspectPerson(PhysicalCharacteristic physicalCharacteristic, ThreatAssessment threatAssessment,
			String description) {
		super();
		this.type = "SuspectPerson";
		this.physicalCharacteristic = physicalCharacteristic;
		this.threatAssessment = threatAssessment;
	}



	public PersonName getPersonName() {
		return personName;
	}



	public void setPersonName(PersonName personName) {
		this.personName = personName;
	}



	public PhysicalCharacteristic getPhysicalCharacteristic() {
		return physicalCharacteristic;
	}



	public void setPhysicalCharacteristic(PhysicalCharacteristic suspectPhysicalCharacteristic) {
		this.physicalCharacteristic = suspectPhysicalCharacteristic;
	}



	public ThreatAssessment getThreatAssessment() {
		return threatAssessment;
	}



	public void setThreatAssessment(ThreatAssessment threatAssessment) {
		this.threatAssessment = threatAssessment;
	}



	public Person getPerson() {
		return person;
	}



	public void setPerson(Person person) {
		this.person = person;
	}



	public List<InvestigativeCase> getInvestigativeCases() {
		return investigativeCases;
	}



	@Override
	public void logChanges(Object old) {
		SuspectPerson oldP = (SuspectPerson) old;

		if (oldP.personName != null && !this.personName.getFirstName().equals(oldP.personName.getFirstName()))
			this.getHistory().addAction(
					new Action("first name", this.personName.getFirstName(), oldP.personName.getFirstName()));

		if (oldP.personName != null && !this.personName.getLastName().equals(oldP.personName.getLastName()))
			this.getHistory().addAction(
					new Action("last name", this.personName.getLastName(), oldP.personName.getLastName()));

		if (!this.physicalCharacteristic.isEqual(oldP.physicalCharacteristic))
			this.getHistory().addAction(
					new Action("physical characteristic", this.physicalCharacteristic.toString(),
							oldP.physicalCharacteristic.toString()));

		if (!this.threatAssessment.getThreatAssessmentLevel().equals(oldP.threatAssessment.getThreatAssessmentLevel()))
			this.getHistory().addAction(
					new Action("threat assessment", this.threatAssessment.getThreatAssessmentLevel(),
							oldP.threatAssessment.getThreatAssessmentLevel()));
	}

	// public Long getId() {
	// return id;
	// }

}
