package entities.police;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import entities.events.IncidentReport;


/**
 * Entity implementation class for Entity: Case
 * 
 */
@Entity
public class InvestigativeCase implements Serializable {

	private static final long serialVersionUID = 4471453776931939442L;

	@Id
	@GeneratedValue
	Long id;

	@OneToMany(cascade = CascadeType.ALL)
	private List<IncidentReport> incidentReports;

	@ManyToOne(cascade = CascadeType.ALL)
	private Officer officerWhoCreatedIt;

	@ManyToMany(cascade = CascadeType.ALL)
	private List<Investigator> investigators;



	public InvestigativeCase() {
		super();
	}



	public Long getId() {
		return id;
	}



	public List<IncidentReport> getIncidentReports() {
		return incidentReports;
	}



	public void setIncidentReports(List<IncidentReport> incidentReports) {
		this.incidentReports = incidentReports;
	}



	public void addIncidentReport(IncidentReport incidentReport) {
		if (this.incidentReports == null)
			this.incidentReports = new ArrayList<IncidentReport>();

		this.incidentReports.add(incidentReport);
	}



	public Officer getOfficerWhoCreatedIt() {
		return officerWhoCreatedIt;
	}



	public void setOfficerWhoCreatedIt(Officer officerWhoCreatedIt) {
		this.officerWhoCreatedIt = officerWhoCreatedIt;
	}



	public List<Investigator> getInvestigators() {
		return investigators;
	}



	public void setInvestigators(List<Investigator> investigators) {
		this.investigators = investigators;
	}



	public void addInvestigator(Investigator investigator) {
		if (this.investigators == null)
			this.investigators = new ArrayList<Investigator>();

		this.investigators.add(investigator);
	}



	@Override
	public String toString() {
		return this.officerWhoCreatedIt.toString();
	}

}
