package entities.entries;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import entities.Describable;
import entities.entries.history.History;
import entities.events.Event;


/**
 * Entity implementation class for Entity: Entry
 * 
 */
@Entity
public class Entry implements Serializable, Describable {

	private static final long serialVersionUID = 2034421404091295704L;

	@Id
	@GeneratedValue
	private Long id;

	private History history;
	private List<Event> historyOfEvents;
	private List<Relation> relations;



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
