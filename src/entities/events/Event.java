package entities.events;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import entities.Relatable;
import entities.police.Officer;


@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Event extends Relatable implements Serializable {

	private static final long serialVersionUID = -7653133964450866716L;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateAndTime;

	@ManyToMany(mappedBy = "eventsResponsibleFor")
	private List<Officer> officersResponsibleFor;



	public Event() {
		this.dateAndTime = new Date();
	}



	public Date getDateAndTime() {
		return dateAndTime;
	}



	public void setDateAndTime(Date dateAndTime) {
		this.dateAndTime = dateAndTime;
	}



	public List<Officer> getOfficersResponsibleFor() {
		return officersResponsibleFor;
	}

}
