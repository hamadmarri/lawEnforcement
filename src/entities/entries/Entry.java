package entities.entries;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import entities.Describable;
import entities.Relatable;
import entities.entries.history.History;
import entities.events.Event;


/**
 * Entity implementation class for Entity: Entry
 * 
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@NamedQueries({ @NamedQuery(name = "Entry.findAll", query = "SELECT e FROM Entry e") })
public class Entry extends Relatable implements Serializable, Describable {

	private static final long serialVersionUID = 2034421404091295704L;

	@OneToOne(cascade = CascadeType.ALL)
	private History history;



	public Entry() {
		this.type = "Entry";
	}



	public History getHistory() {
		return history;
	}



	public void setHistory(History history) {
		this.history = history;
	}



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
