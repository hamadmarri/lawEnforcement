package entities.police;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import entities.Relatable;
import entities.events.IncidentReport;


/**
 * Entity implementation class for Entity: Case
 * 
 */
@Entity
@NamedQueries({
		@NamedQuery(name = "InvestigativeCase.findAll", query = "select ic from InvestigativeCase ic"),
		@NamedQuery(name = "InvestigativeCase.findById", query = "select ic from InvestigativeCase ic WHERE ic.id = :id") })
public class InvestigativeCase extends Relatable {

	private static final long serialVersionUID = 4471453776931939442L;

//	@Id
//	@GeneratedValue
//	Long id;

	@OneToMany(mappedBy = "assignedCase")
	private List<IncidentReport> incidentReports;

	@ManyToOne(cascade = CascadeType.MERGE)
	private Officer officerWhoCreatedIt;

	@ManyToMany(cascade = CascadeType.MERGE)
	private List<Investigator> investigators;

	@Temporal(TemporalType.DATE)
	private Date startDate;

	@Temporal(TemporalType.DATE)
	private Date dueDate;

	@OneToMany(mappedBy = "investigativeCase")
	private List<Activity> activities;

	@OneToMany(mappedBy = "investigativeCase")
	private List<Task> tasks;

	private String description;

	private static String[] statusSuggestions = { "Open", "Pending", "In progress", "Refuded", "Closed" };
	private String status;



	public InvestigativeCase() {
		super();
		this.type = "InvestigativeCase";
	}



	public InvestigativeCase(Date startDate, Date dueDate, String description, String status) {
		super();
		this.type = "InvestigativeCase";
		this.startDate = startDate;
		this.dueDate = dueDate;
		this.description = description;
		this.status = status;
	}



//	public Long getId() {
//		return id;
//	}



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



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public static String[] getStatusSuggestions() {
		return statusSuggestions;
	}



	public Date getStartDate() {
		return startDate;
	}



	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}



	public Date getDueDate() {
		return dueDate;
	}



	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}



	public List<Activity> getActivities() {
		return activities;
	}



	@Override
	public String toString() {
		return "id: " + this.id + this.officerWhoCreatedIt.toString();
	}

}
