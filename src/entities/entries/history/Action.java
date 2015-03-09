package entities.entries.history;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

 
@Embeddable
public class Action implements Serializable {

	private static final long serialVersionUID = 1019588440452680728L;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateAndTime;
	private String field;
	private String oldData;
	private String newData;



	public Action() {
		super();
		this.dateAndTime = new Date();
		this.oldData = new String();
		this.newData = new String();
	}
  


	public Action(String field, String newDate, String oldDate) {
		super();
		this.dateAndTime = new Date();
		this.field = field;
		this.oldData = oldDate;
		this.newData = newDate;
	}



	public Action(Date dateAndTime, String field, String newDate, String oldDate) {
		super();
		this.dateAndTime = dateAndTime;
		this.field = field;
		this.oldData = oldDate;
		this.newData = newDate;
	}



	public Date getDateAndTime() {
		return dateAndTime;
	}



	public void setDateAndTime(Date dateAndTime) {
		this.dateAndTime = dateAndTime;
	}



	public String getField() {
		return field;
	}



	public void setField(String field) {
		this.field = field;
	}



	public String getOldData() {
		return oldData;
	}



	public void setOldData(String oldDate) {
		this.oldData = oldDate;
	}



	public String getNewData() {
		return newData;
	}



	public void setNewData(String newDate) {
		this.newData = newDate;
	}

}
