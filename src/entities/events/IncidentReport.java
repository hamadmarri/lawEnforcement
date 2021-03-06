package entities.events;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import entities.entries.Crime;
import entities.entries.history.Action;
import entities.police.InvestigativeCase;


/**
 * Entity implementation class for Entity: IncidentReport TODO: need to take
 * care of witnesses, victims, complainants
 */
@Entity
@NamedQueries({ @NamedQuery(name = "IncidentReport.findAll", query = "select i from IncidentReport i"),
		@NamedQuery(name = "IncidentReport.findById", query = "select i from IncidentReport i WHERE i.id = :id") })
public class IncidentReport extends Event {

	private static final long serialVersionUID = 5529985766700573423L;

	@Lob
	@Column(length = 20000)
	private String offenseInformation;

	public static String[] statusOptions = { "open", "closed", "pending for approve", "under investigation" };
	private String caseStatus;

	@OneToMany(cascade = CascadeType.MERGE)
	private List<FieldInterview> fieldInterviews;

	@Lob
	@Column(length = 20000)
	private String summary;

	@ManyToOne(cascade = CascadeType.MERGE)
	private InvestigativeCase assignedCase;

	@ManyToMany(mappedBy = "incidentReportsAccordingTo")
	private List<ArrestReport> arrestReports;

	@OneToMany(mappedBy = "incidentReport")
	private List<Crime> crimes;



	public IncidentReport() {
		super();
		this.type = "IncidentReport";
		this.offenseInformation = new String();
		this.caseStatus = new String();
		this.summary = new String();
	}



	public IncidentReport(String offenseInformation, String caseStatus, String summary) {
		super();
		this.type = "IncidentReport";
		this.offenseInformation = offenseInformation;
		this.caseStatus = caseStatus;
		this.summary = summary;
	}



	public String getOffenseInformation() {
		return offenseInformation;
	}



	public void setOffenseInformation(String offenseInformation) {
		this.offenseInformation = offenseInformation;
	}



	public String getCaseStatus() {
		return caseStatus;
	}



	public void setCaseStatus(String caseStatus) {
		this.caseStatus = caseStatus;
	}



	public List<FieldInterview> getFieldInterviews() {
		return fieldInterviews;
	}



	public void setFieldInterviews(List<FieldInterview> fieldInterviews) {
		this.fieldInterviews = fieldInterviews;
	}



	public void addFieldInterview(FieldInterview fieldInterview) {
		if (this.fieldInterviews == null)
			this.fieldInterviews = new ArrayList<FieldInterview>();

		this.fieldInterviews.add(fieldInterview);
	}



	public String getSummary() {
		return summary;
	}



	public void setSummary(String summary) {
		this.summary = summary;
	}



	public static String[] getStatusOptions() {
		return statusOptions;
	}



	public void setAssignedCase(InvestigativeCase assignedCase) {
		this.assignedCase = assignedCase;
	}



	public InvestigativeCase getAssignedCase() {
		return assignedCase;
	}



	public List<ArrestReport> getArrestReports() {
		return arrestReports;
	}



	public void addArrestReport(ArrestReport arrestReport) {
		if (this.arrestReports == null)
			this.arrestReports = new ArrayList<ArrestReport>();

		this.arrestReports.add(arrestReport);
	}



	public List<Crime> getCrimes() {
		return crimes;
	}



	public void setCrimes(List<Crime> crimes) {
		this.crimes = crimes;
	}



	public void addCrime(Crime c) {
		if (crimes == null)
			crimes = new ArrayList<Crime>();

		this.crimes.add(c);
	}



	@Override
	public void logChanges(Object old) {
		IncidentReport oldInc = (IncidentReport) old;

		if (!this.offenseInformation.equals(oldInc.offenseInformation))
			this.getHistory().addAction(
					new Action("offenseInformation", this.offenseInformation, oldInc.offenseInformation));

		if (!this.caseStatus.equals(oldInc.caseStatus))
			this.getHistory().addAction(new Action("caseStatus", this.caseStatus, oldInc.caseStatus));

		if (!this.summary.equals(oldInc.summary))
			this.getHistory().addAction(new Action("summary", this.summary, oldInc.summary));

		if (this.assignedCase != null & oldInc.assignedCase != null
				&& this.assignedCase.getId().compareTo(oldInc.assignedCase.getId()) != 0)
			this.getHistory().addAction(
					new Action("assignedCase id", this.assignedCase.getId().toString(), oldInc.assignedCase.getId()
							.toString()));

		if (this.fieldInterviews.size() != oldInc.fieldInterviews.size()) {
			StringBuilder newData = new StringBuilder();
			StringBuilder oldData = new StringBuilder();

			for (FieldInterview id : this.fieldInterviews)
				newData.append(id.toString() + " ");

			for (FieldInterview id : oldInc.fieldInterviews)
				oldData.append(id.toString() + " ");

			this.getHistory().addAction(new Action("fieldInterviews", newData.toString(), oldData.toString()));
		} else {
			for (int i = 0; i < this.fieldInterviews.size(); i++) {
				if (this.fieldInterviews.get(i).getId().compareTo(oldInc.fieldInterviews.get(i).getId()) != 0)
					this.getHistory().addAction(
							new Action("fieldInterviews", this.fieldInterviews.get(i).toString(),
									oldInc.fieldInterviews.get(i).toString()));
			}
		}

	}



	@Override
	public String toString() {
		return this.type + ": " + this.offenseInformation;
	}

}
