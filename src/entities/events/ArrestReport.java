package entities.events;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;

import entities.entries.ScarMarkTattoo;
import entities.entries.files.EntryFile;
import entities.entries.history.Action;


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
	public void logChanges(Object old) {
		ArrestReport oldAr = (ArrestReport) old;

		if (!this.document.equals(oldAr.document))
			this.getHistory().addAction(new Action("document", this.document, oldAr.document));

		if (this.incidentReportsAccordingTo.size() != oldAr.incidentReportsAccordingTo.size()) {
			StringBuilder newData = new StringBuilder();
			StringBuilder oldData = new StringBuilder();

			for (IncidentReport id : this.incidentReportsAccordingTo)
				newData.append(id.toString() + " ");

			for (IncidentReport id : oldAr.incidentReportsAccordingTo)
				oldData.append(id.toString() + " ");

			this.getHistory().addAction(
					new Action("incidentReportsAccordingTo", newData.toString(), oldData.toString()));
		} else {
			for (int i = 0; i < this.incidentReportsAccordingTo.size(); i++) {
				if (this.incidentReportsAccordingTo.get(i).getId()
						.compareTo(oldAr.incidentReportsAccordingTo.get(i).getId()) != 0)
					this.getHistory().addAction(
							new Action("incidentReportsAccordingTo", this.incidentReportsAccordingTo.get(i).toString(),
									oldAr.incidentReportsAccordingTo.get(i).toString()));
			}
		}

	}



	@Override
	public String toString() {
		return this.document;
	}

}
