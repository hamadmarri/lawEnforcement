package entities.entries;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import entities.entries.history.Changeable;


@Entity
public class CriminalRecord extends Changeable {

	@OneToOne(mappedBy = "criminalRecord")
	private Person committedBy;

	@OneToMany(mappedBy = "criminalRecord")
	private List<Crime> crimes = new ArrayList<Crime>();

	@OneToOne(mappedBy = "criminalRecord")
	private YouthRiskFactors youthRiskFactors;



	public CriminalRecord() {
		super();
	}



	public CriminalRecord(Person person) {
		super();
		this.committedBy = person;
	}



	public Person getCommittedBy() {
		return committedBy;
	}



	public void setCommittedBy(Person committedBy) {
		this.committedBy = committedBy;
	}



	public List<Crime> getCrimes() {
		return crimes;
	}



	public void setCrimes(List<Crime> crimes) {
		this.crimes = crimes;
	}



	public void addCrime(Crime c) {
		crimes.add(c);
	}



	public YouthRiskFactors getYouthRiskFactors() {
		return youthRiskFactors;
	}



	public void setYouthRiskFactors(YouthRiskFactors youthRiskFactors) {
		this.youthRiskFactors = youthRiskFactors;
	}



	public boolean isCriminal() {
		return (crimes.size() > 0);
	}



	@Override
	public void logChanges(Object old) {
		// TODO Auto-generated method stub

	}

}
