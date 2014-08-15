package entities.entries.history;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import entities.entries.Entry;


@Entity
public class History implements Serializable {

	private static final long serialVersionUID = 2563374344096049059L;

	@Id
	@GeneratedValue
	private Long id;

	@OneToOne(mappedBy = "history")
	private Entry entry;

	@OneToMany(mappedBy = "history")
	private List<Action> actions;



	public History() {

	}



	public List<Action> getActions() {
		return actions;
	}



	public void setActions(List<Action> actions) {
		this.actions = actions;
	}

}
