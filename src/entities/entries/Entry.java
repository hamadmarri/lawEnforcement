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
@Inheritance(strategy = InheritanceType.JOINED)
public class Entry implements Serializable, Describable {

	private static final long serialVersionUID = 2034421404091295704L;

	@Id
	@GeneratedValue
	private Long id;

	private String name;

	@OneToOne(cascade = CascadeType.ALL)
	private History history;

	@ManyToMany(mappedBy = "entriesAssociatedWith")
	private List<Event> eventsAssociatedWith;

	@OneToMany(mappedBy = "something")
	private List<Relation> relationsTo;

	@OneToMany(mappedBy = "somethingElse")
	private List<Relation> relationsWith;

	@Transient
	private List<Relation> allRelations;



	public Entry() {

	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



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



	public List<Event> getEventsAssociatedWith() {
		return eventsAssociatedWith;
	}



	public void setEventsAssociatedWith(List<Event> eventsAssociatedWith) {
		this.eventsAssociatedWith = eventsAssociatedWith;
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
