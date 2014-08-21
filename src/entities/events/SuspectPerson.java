package entities.events;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import entities.Describable;
import entities.entries.PersonName;
import entities.entries.PhysicalCharacteristic;
import entities.entries.ThreatAssessment;


@Entity
@NamedQueries({ @NamedQuery(name = "SuspectPerson.findAll", query = "select s from SuspectPerson s ORDER BY s.id"),
		@NamedQuery(name = "SuspectPerson.findById", query = "select s from SuspectPerson s WHERE s.id = :id") })
public class SuspectPerson implements Serializable, Describable {

	private static final long serialVersionUID = 6230656995120526177L;

	@Id
	@GeneratedValue
	Long id;

	@Embedded
	private PersonName personName;

	@Embedded
	private PhysicalCharacteristic physicalCharacteristic;

	@Embedded
	private ThreatAssessment threatAssessment;

	private String description;

	@ManyToMany(mappedBy = "suspectPersons")
	private List<IncidentReport> incidentReports;



	public SuspectPerson() {

	}



	public SuspectPerson(PhysicalCharacteristic physicalCharacteristic, ThreatAssessment threatAssessment,
			String description) {
		super();
		this.physicalCharacteristic = physicalCharacteristic;
		this.threatAssessment = threatAssessment;
		this.description = description;
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



	public Long getId() {
		return id;
	}



	@Override
	public void setDescription(String description) {
		this.description = description;
	}



	@Override
	public String getDescription() {
		return this.description;
	}

}
