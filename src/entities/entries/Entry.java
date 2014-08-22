package entities.entries;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

import entities.Relatable;
import entities.entries.history.History;


/**
 * Entity implementation class for Entity: Entry
 * 
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@NamedQueries({ @NamedQuery(name = "Entry.findAll", query = "SELECT e FROM Entry e") })
public class Entry extends Relatable implements Serializable {

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

}
