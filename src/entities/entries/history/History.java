package entities.entries.history;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;


@Entity
@NamedQueries({ @NamedQuery(name = "History.findAll", query = "select h from History h"),
	@NamedQuery(name = "History.findById", query = "select h from History h WHERE h.id = :id") })
public class History implements Serializable {

	private static final long serialVersionUID = 1899017063886895301L;

	@Id
	@GeneratedValue
	private Long id;

	@OneToOne(mappedBy = "history")
	private Changeable changeable;

	@ElementCollection
	private List<Action> actions;



	public History() {

	}



	public Changeable getChangeable() {
		return changeable;
	}



	public List<Action> getActions() {
		return actions;
	}



	public void setActions(List<Action> actions) {
		this.actions = actions;
	}



	public void addAction(Action action) {
		if (this.actions == null)
			this.actions = new ArrayList<Action>();

		this.actions.add(action);
	}

}
