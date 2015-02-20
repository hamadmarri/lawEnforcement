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
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import entities.Relatable;
import entities.entries.SuspectPerson;
import entities.entries.history.Action;
import entities.events.IncidentReport;
import entities.intelligence.CrimeScene;


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

	@OneToOne(cascade = CascadeType.ALL)
	private CrimeScene crimeScene;

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private List<SuspectPerson> suspectPersons;

	private static String[] statusSuggestions = { "Open", "Pending", "In progress", "Refused", "Closed" };
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



	public CrimeScene getCrimeScene() {
		return crimeScene;
	}



	public void setCrimeScene(CrimeScene crimeScene) {
		this.crimeScene = crimeScene;
	}



	public List<SuspectPerson> getSuspectPersons() {
		return suspectPersons;
	}



	public void setSuspectPersons(List<SuspectPerson> suspectPersons) {
		this.suspectPersons = suspectPersons;
	}



	public void addSuspectPerson(SuspectPerson suspectPerson) {
		if (this.suspectPersons == null)
			this.suspectPersons = new ArrayList<SuspectPerson>();

		this.suspectPersons.add(suspectPerson);
	}



	@Override
	public String toString() {
		return "id: " + this.id + this.officerWhoCreatedIt.toString();
	}



	@Override
	public void logChanges(Object old) {
		InvestigativeCase oldinvC = (InvestigativeCase) old;

		if (!this.status.equals(oldinvC.status))
			this.getHistory().addAction(new Action("status", this.status, oldinvC.status));

		if (!this.description.equals(oldinvC.description))
			this.getHistory().addAction(new Action("description", this.description, oldinvC.description));

		if (this.startDate != null && oldinvC.startDate != null && this.startDate.compareTo(oldinvC.startDate) != 0)
			this.getHistory().addAction(
					new Action("startDate", this.startDate.toString(), oldinvC.startDate.toString()));

		if (this.dueDate != null && oldinvC.dueDate != null && this.dueDate.compareTo(oldinvC.startDate) != 0)
			this.getHistory().addAction(new Action("dueDate", this.dueDate.toString(), oldinvC.dueDate.toString()));

		if (this.officerWhoCreatedIt != null & oldinvC.officerWhoCreatedIt != null
				&& this.officerWhoCreatedIt.getId().compareTo(oldinvC.officerWhoCreatedIt.getId()) != 0)
			this.getHistory().addAction(
					new Action("officerWhoCreatedIt id", this.officerWhoCreatedIt.getId().toString(),
							oldinvC.officerWhoCreatedIt.getId().toString()));

		if (this.investigators.size() != oldinvC.investigators.size()) {
			StringBuilder newData = new StringBuilder();
			StringBuilder oldData = new StringBuilder();

			for (Investigator id : this.investigators)
				newData.append(id.toString() + " ");

			for (Investigator id : oldinvC.investigators)
				oldData.append(id.toString() + " ");

			this.getHistory().addAction(new Action("investigators", newData.toString(), oldData.toString()));
		} else {
			for (int i = 0; i < this.investigators.size(); i++) {
				if (this.investigators.get(i).getId().compareTo(oldinvC.investigators.get(i).getId()) != 0)
					this.getHistory().addAction(
							new Action("investigators", this.investigators.get(i).toString(), oldinvC.investigators
									.get(i).toString()));
			}
		}

		if (this.suspectPersons.size() != oldinvC.suspectPersons.size()) {
			StringBuilder newData = new StringBuilder();
			StringBuilder oldData = new StringBuilder();

			for (SuspectPerson id : this.suspectPersons)
				newData.append(id.toString() + " ");

			for (SuspectPerson id : oldinvC.suspectPersons)
				oldData.append(id.toString() + " ");

			this.getHistory().addAction(new Action("suspectPersons", newData.toString(), oldData.toString()));
		} else {
			for (int i = 0; i < this.suspectPersons.size(); i++) {
				if (this.suspectPersons.get(i).getId().compareTo(oldinvC.suspectPersons.get(i).getId()) != 0)
					this.getHistory().addAction(
							new Action("suspectPersons", this.suspectPersons.get(i).toString(), oldinvC.suspectPersons
									.get(i).toString()));
			}
		}

	}

}
