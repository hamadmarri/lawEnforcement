package entities.events;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;


/**
 * Entity implementation class for Entity: AccidentReport
 * 
 */
@Entity
public class AccidentReport extends Event {

	private static final long serialVersionUID = 5400414800729104618L;

	private String violation;
	private String severity; // low, midume, high
	
	@Lob
	@Column(length = 20000)
	private String summary;



	public AccidentReport() {
		super();
		this.violation = new String();
		this.severity = new String();
		this.summary = new String();
	}



	public AccidentReport(String violation, String severity, String summary) {
		super();
		this.violation = violation;
		this.severity = severity;
		this.summary = summary;
	}



	public String getViolation() {
		return violation;
	}



	public void setViolation(String violation) {
		this.violation = violation;
	}



	public String getSeverity() {
		return severity;
	}



	public void setSeverity(String severity) {
		this.severity = severity;
	}



	public String getSummary() {
		return summary;
	}



	public void setSummary(String summary) {
		this.summary = summary;
	}

}
