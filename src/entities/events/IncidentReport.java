package entities.events;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import entities.police.InvestigativeCase;


/**
 * Entity implementation class for Entity: IncidentReport TODO: need to take
 * care of witnesses, victims, complainants
 */
@Entity
@NamedQueries({ @NamedQuery(name = "IncidentReport.findAll", query = "select i from IncidentReport i") })
public class IncidentReport extends Event {

	private static final long serialVersionUID = 5529985766700573423L;

	private String offenseInformation;

	@ManyToMany(cascade = CascadeType.ALL)
	private List<SuspectPerson> suspectPersons;

	public static String[] statusOptions = { "open", "closed", "pending for approve", "under investigation" };
	private String caseStatus;

	@OneToMany(cascade = CascadeType.MERGE)
	private List<FieldInterview> fieldInterviews;

	private String summary;

	@ManyToOne(cascade = CascadeType.ALL)
	private InvestigativeCase assignedCase;

	@ManyToMany(mappedBy = "incidentReportsAccordingTo")
	private List<ArrestReport> arrestReports;



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



	public IncidentReport(String offenseInformation, List<SuspectPerson> suspectPersons, String caseStatus,
			String summary) {
		super();
		this.offenseInformation = offenseInformation;
		this.suspectPersons = suspectPersons;
		this.caseStatus = caseStatus;
		this.summary = summary;
	}



	public String getOffenseInformation() {
		return offenseInformation;
	}



	public void setOffenseInformation(String offenseInformation) {
		this.offenseInformation = offenseInformation;
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



	@Override
	public String toString() {
		return this.type + ": " + this.offenseInformation;
	}

}
