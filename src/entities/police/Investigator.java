package entities.police;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import security.Authorizable;
import entities.entries.PersonName;


/**
 * Entity implementation class for Entity: Investigator
 * 
 */
@Entity 
@NamedQueries({ @NamedQuery(name = "Investigator.findAll", query = "select i from Investigator i"),
		@NamedQuery(name = "Investigator.findById", query = "select i from Investigator i WHERE i.id = :id") })
public class Investigator extends Authorizable {

	private static final long serialVersionUID = 8113176629170268715L;

	@ManyToMany(mappedBy = "investigators", fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
//	@JoinFetch(value = JoinFetchType.OUTER)
	private List<InvestigativeCase> investigativeCases;

	@OneToMany(mappedBy = "investigator")
	private List<Activity> activities;

	@Embedded
	private PersonName personName;



	public Investigator() {
		super();
		this.type = "Investigator";
		// this.investigativeCases = new ArrayList<InvestigativeCase>();
		this.personName = new PersonName();
	}



	public Investigator(PersonName personName) {
		super();
		this.type = "Investigator";
		// this.investigativeCases = new ArrayList<InvestigativeCase>();
		this.personName = personName;
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



	public List<InvestigativeCase> getInvestigativeCases() {
		return investigativeCases;
	}



	public void addInvestigativeCase(InvestigativeCase ic) {
		if (this.investigativeCases == null)
			this.investigativeCases = new ArrayList<InvestigativeCase>();

		this.investigativeCases.add(ic);
	}



	public List<Activity> getActivities() {
		return activities;
	}



	public void addActivities(Activity a) {
		if (this.activities == null)
			this.activities = new ArrayList<Activity>();

		this.activities.add(a);
	}



	@Override
	public String toString() {
		return this.personName.toString();
	}



	@Override
	public String getName() {
		return this.toString();
	}
}
