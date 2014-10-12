package entities.police;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@NamedQueries({ @NamedQuery(name = "Activity.findAll", query = "select a from Activity a"),
		@NamedQuery(name = "Activity.findById", query = "select a from Activity a WHERE a.id = :id") })
public class Activity implements Serializable {

	private static final long serialVersionUID = -4496487588138153339L;

	@Id
	@GeneratedValue
	Long id;

	@ManyToOne(cascade = CascadeType.MERGE)
	private InvestigativeCase investigativeCase;

	@ManyToOne(cascade = CascadeType.MERGE)
	private Investigator investigator;

	private static String typeSuggestions[] = { "evidence", "developing leads", "conducting interviews",
			"interrogations", "requesting warrants", "supplemental reports" };
	private String type;
	private String Data;

	@Temporal(TemporalType.TIMESTAMP)
	private Date DateAndTime;



	public Activity() {
		super();
	}



	public Activity(InvestigativeCase investigativeCase, String type, String data) {
		Date d = Calendar.getInstance().getTime();
		init(investigativeCase, type, data, d);
	}



	public Activity(InvestigativeCase investigativeCase, String type, String data, Date dateAndTime) {
		super();
		init(investigativeCase, type, data, dateAndTime);
	}



	private void init(InvestigativeCase investigativeCase, String type, String data, Date dateAndTime) {
		this.investigativeCase = investigativeCase;
		this.type = type;
		Data = data;
		DateAndTime = dateAndTime;
	}



	public Long getId() {
		return id;
	}



	public InvestigativeCase getInvestigativeCase() {
		return investigativeCase;
	}



	public void setInvestigativeCase(InvestigativeCase investigativeCase) {
		this.investigativeCase = investigativeCase;
	}



	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	public String getData() {
		return Data;
	}



	public void setData(String data) {
		Data = data;
	}



	public Date getDateAndTime() {
		return DateAndTime;
	}



	public void setDateAndTime(Date dateAndTime) {
		DateAndTime = dateAndTime;
	}



	public static String[] getTypeSuggestions() {
		return typeSuggestions;
	}



	public Investigator getInvestigator() {
		return investigator;
	}



	public void setInvestigator(Investigator investigator) {
		this.investigator = investigator;
	}



	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

}
