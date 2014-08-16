package entities.events;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import entities.Describable;
import entities.entries.PhysicalCharacteristic;


@Entity
public class SuspectPerson implements Serializable, Describable {

	private static final long serialVersionUID = 6230656995120526177L;

	@Id
	@GeneratedValue
	Long id;

	@Embedded
	private PhysicalCharacteristic suspectPhysicalCharacteristic;
	private String description;

	@ManyToMany(mappedBy = "suspectPersons")
	private List<IncidentReport> incidentReports;



	public SuspectPerson() {

	}



	public SuspectPerson(PhysicalCharacteristic suspectPhysicalCharacteristic, String description) {
		super();
		this.suspectPhysicalCharacteristic = suspectPhysicalCharacteristic;
		this.description = description;
	}



	public PhysicalCharacteristic getSuspectPhysicalCharacteristic() {
		return suspectPhysicalCharacteristic;
	}



	public void setSuspectPhysicalCharacteristic(PhysicalCharacteristic suspectPhysicalCharacteristic) {
		this.suspectPhysicalCharacteristic = suspectPhysicalCharacteristic;
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
