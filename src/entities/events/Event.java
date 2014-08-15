package entities.events;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import entities.Describable;


@Entity
public class Event implements Serializable, Describable {

	private static final long serialVersionUID = -7653133964450866716L;

	@Id
	@GeneratedValue
	private Long id;

	private Calendar dateAndTime;



	@Override
	public void setDescription(String description) {
		// TODO Auto-generated method stub

	}



	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}
}
