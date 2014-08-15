package entities.entries.history;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Action implements Serializable {

	private static final long serialVersionUID = 2644199289425633332L;

	@Id
	@GeneratedValue
	private Long id;

	private Calendar dateAndTime;
	private Changeable oldDate;
	private Changeable newDate;

}
