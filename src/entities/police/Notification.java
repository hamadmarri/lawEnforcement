package entities.police;

import java.io.Serializable;
import java.util.Arrays;
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

import security.Authorizable;


@Entity
@NamedQueries({ @NamedQuery(name = "Notification.findAll", query = "select n from Notification n"),
		@NamedQuery(name = "Notification.findById", query = "select n from Notification n WHERE n.id = :id") })
public class Notification implements Serializable {

	private static final long serialVersionUID = -5548240389934469655L;

	@Id
	@GeneratedValue
	private Long id;

	private String text = new String();

	private String state = new String("sent");

	public static final String[] stateSuggestions = { "sent", "read" };

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateAndTime = new Date();

	@ManyToOne(cascade = CascadeType.MERGE)
	private Authorizable causedBy;

	@ManyToOne(cascade = CascadeType.MERGE)
	private Authorizable to;



	public Notification() {
		super();
	}



	public Notification(String text, Authorizable causedBy, Authorizable to) {
		super();
		this.text = text;
		this.causedBy = causedBy;
		this.to = to;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getText() {
		return text;
	}



	public void setText(String text) {
		this.text = text;
	}



	public String getState() {
		return state;
	}



	public void setState(String state) {
		if (Arrays.asList(Notification.stateSuggestions).contains(state))
			this.state = state;
	}



	public Date getDateAndTime() {
		return dateAndTime;
	}



	public Authorizable getCausedBy() {
		return causedBy;
	}



	public void setCausedBy(Authorizable causedBy) {
		this.causedBy = causedBy;
	}



	public Authorizable getTo() {
		return to;
	}



	public void setTo(Authorizable to) {
		this.to = to;
	}

}
