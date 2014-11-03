package entities.events;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;


/**
 * Entity implementation class for Entity: ArrestReport
 */
@Entity
public class ArrestReport extends Event {

	private static final long serialVersionUID = 2412353059380453755L;

	@Lob
	@Column(length = 20000)
	private String document;

	@ManyToMany(cascade = CascadeType.MERGE)
	private List<IncidentReport> incidentReportsAccordingTo;



	public ArrestReport() {
		super();
		this.type = "ArrestReport";
		this.document = new String();
	}



	public String getDocument() {
		return document;
	}



	public void setDocument(String document) {
		this.document = document;
	}



	public List<IncidentReport> getIncidentReportsAccordingTo() {
		return incidentReportsAccordingTo;
	}



	public void setIncidentReportsAccordingTo(List<IncidentReport> incidentReportsAccordingTo) {
		this.incidentReportsAccordingTo = incidentReportsAccordingTo;
	}



	public void addIncidentReportAccordingTo(IncidentReport incidentReportAccordingTo) {
		if (this.incidentReportsAccordingTo == null)
			this.incidentReportsAccordingTo = new ArrayList<IncidentReport>();

		this.incidentReportsAccordingTo.add(incidentReportAccordingTo);
	}



	@Override
	public String toString() {
		return this.document;
	}

}
