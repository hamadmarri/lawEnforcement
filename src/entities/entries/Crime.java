package entities.entries;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import entities.Describable;
import entities.entries.history.Changeable;


@Entity
public class Crime extends Changeable implements Describable {

	@ManyToOne(cascade = CascadeType.MERGE)
	private CriminalRecord criminalRecord;

	@Lob
	@Column(length = 20000)
	protected String description;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateAndTime;

	private String typeOfCrime = new String();

	public static final String[] typeOfCrimeSuggestions = { "murder", "theft", "fraud", "burglary", "violence",
			"committingDamage", "disorderlyConduct" };

	



	public Crime() {
		super();
	}



	public Crime(CriminalRecord criminalRecord, String description, Date dateAndTime, String typeOfCrime) {
		super();
		this.criminalRecord = criminalRecord;
		this.description = description;
		this.dateAndTime = dateAndTime;
		this.typeOfCrime = typeOfCrime;
	}



	public CriminalRecord getCriminalRecord() {
		return criminalRecord;
	}



	public void setCriminalRecord(CriminalRecord criminalRecord) {
		this.criminalRecord = criminalRecord;
	}



	@Override
	public void setDescription(String description) {
		this.description = description;
	}



	@Override
	public String getDescription() {
		return description;
	}



	public Date getDateAndTime() {
		return dateAndTime;
	}



	public void setDateAndTime(Date dateAndTime) {
		this.dateAndTime = dateAndTime;
	}



	public String getTypeOfCrime() {
		return typeOfCrime;
	}



	public void setTypeOfCrime(String typeOfCrime) {
		this.typeOfCrime = typeOfCrime;
	}







	@Override
	public void logChanges(Object old) {
		// TODO Auto-generated method stub
	}

}
