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



	// TODO: may need to be synchronized
	public static void convertCrimeToArray(Crime c, double[] cirmeAsArray) {

		String type = c.getTypeOfCrime();

		for (int i = 0; i < 7; i++)
			cirmeAsArray[i] = type.equals(typeOfCrimeSuggestions[i]) ? 1 : 0;
	}



	public synchronized static Crime convertArrayToCrime(double[] cirmeAsArray) {
		Crime c = new Crime();

		for (int i = 0; i < 7; i++) {
			if (Math.round(cirmeAsArray[i]) == 1) {
				c.setTypeOfCrime(Crime.typeOfCrimeSuggestions[i]);
				break;
			}
		}

		return c;
	}



	@Override
	public void logChanges(Object old) {
		// TODO Auto-generated method stub
	}

}
