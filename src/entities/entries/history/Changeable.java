package entities.entries.history;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@NamedQueries({ @NamedQuery(name = "Changeable.findAll", query = "select c from Changeable c"),
		@NamedQuery(name = "Changeable.findById", query = "select c from Changeable c WHERE c.id = :id") })
public abstract class Changeable {

	@Id
	@GeneratedValue
	protected Long id;

	@OneToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private History history;



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public History getHistory() {
		if (this.history == null)
			this.history = new History();

		return history;
	}



	public void setHistory(History history) {
		this.history = history;
	}



	abstract public void logChanges(Object old);
}
