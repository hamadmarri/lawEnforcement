package entities.entries;

import java.io.Serializable;
import java.util.ArrayList;
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

	@OneToOne
	private History history;
	
	private List<Event> historyOfEvents;

	@OneToMany(mappedBy = "something")
	private List<Relation> relationsTo;

	@OneToMany(mappedBy = "somethingElse")
	private List<Relation> relationsWith;

	@Transient
	private List<Relation> allRelations;



	public List<Relation> getRelations() {
		if (this.allRelations == null) {
			allRelations = new ArrayList<Relation>();
			allRelations.addAll(relationsTo);
			allRelations.addAll(relationsWith);
		}
		return allRelations;
	}



	public History getHistory() {
		return history;
	}



	public void setHistory(History history) {
		this.history = history;
	}



	public List<Event> getHistoryOfEvents() {
		return historyOfEvents;
	}



	public void setHistoryOfEvents(List<Event> historyOfEvents) {
		this.historyOfEvents = historyOfEvents;
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
