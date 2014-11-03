package entities.police;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import entities.entries.history.Action;
import entities.entries.history.Changeable;


@Entity
@NamedQueries({ @NamedQuery(name = "Activity.findAll", query = "select a from Activity a"),
		@NamedQuery(name = "Activity.findById", query = "select a from Activity a WHERE a.id = :id") })
public class Activity extends Changeable implements Serializable {

	private static final long serialVersionUID = -4496487588138153339L;

	// @Id
	// @GeneratedValue
	// Long id;

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



	//
	// public Long getId() {
	// return id;
	// }

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



	@Override
	public void logChanges(Object old) {
		Activity oldAct = (Activity) old;

		if (!this.type.equals(oldAct.type))
			this.getHistory().addAction(new Action("type", this.type, oldAct.type));

		if (!this.Data.equals(oldAct.Data))
			this.getHistory().addAction(new Action("Data", this.Data, oldAct.Data));

		if (this.DateAndTime != null && oldAct.DateAndTime != null
				&& this.DateAndTime.compareTo(oldAct.DateAndTime) != 0)
			this.getHistory().addAction(
					new Action("DateAndTime", this.DateAndTime.toString(), oldAct.DateAndTime.toString()));

		if (this.investigativeCase != null & oldAct.investigativeCase != null
				&& this.investigativeCase.getId().compareTo(oldAct.investigativeCase.getId()) != 0)
			this.getHistory().addAction(
					new Action("investigativeCase id", this.investigativeCase.getId().toString(),
							oldAct.investigativeCase.getId().toString()));

		if (this.investigator != null & oldAct.investigator != null
				&& this.investigator.getId().compareTo(oldAct.investigator.getId()) != 0)
			this.getHistory().addAction(
					new Action("investigativeCase id", this.investigator.getId().toString(), oldAct.investigator
							.getId().toString()));
	}

}
