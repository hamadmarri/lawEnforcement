package controllers.management;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ejbs.AbstractEjb;
import entities.entries.history.Action;
import entities.entries.history.History;


/**
 * @author hamadalmarri
 * 
 * @Pages
 *        - listHistories.xhtml
 *        TODO: - viewHistory.xhtml
 * 
 * @Relative_Objects
 *                   - Action, for list of this history's actions
 * 
 */
@ManagedBean(name = "controllerHistory")
@ViewScoped
public class ControllerHistory implements Serializable {

	private static final long serialVersionUID = -5117906001059099847L;

	// EJB for History object
	@EJB
	protected AbstractEjb<History> ejbHistory;

	// the id of a History object
	private String id;

	// the History object
	private History history;

	// list of History objects
	private List<History> historyList = null;

	// list of Action objects
	private List<Action> actions = null;



	/**
	 * will be called automatically right after the class is constructed since
	 * it has the PostConstruct annotation
	 */
	@PostConstruct
	public void init() {
		// at the beginning, set the entitiy name to be History
		this.ejbHistory.setEntityName("History");
	}



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
		getHistory();
	}



	/**
	 * it will load the object from DB if it is not loaded yet otherwise, it
	 * will return the History object
	 * 
	 * @return the History object
	 */
	public History getHistory() {

		// if the object was loaded already, just return it
		if (this.history != null)
			return this.history;

		// if the id is null do not try to load it from DB, just return null
		if (this.id == null)
			return null;

		// at this point object must be null but id is not,
		// so load it from DB
		this.history = ejbHistory.getEntity(Long.parseLong(this.id));

		return this.history;
	}



	public void setHistory(History relation) {
		this.history = relation;
	}



	public List<History> getHistorysList() {
		if (this.historyList == null)
			this.historyList = ejbHistory.getList();

		return historyList;
	}



	public void setHistorysList(List<History> list) {
		this.historyList = list;
	}



	public List<Action> getActions() {
		if (this.actions == null) {
			this.actions = new ArrayList<Action>();

			List<History> hs = getHistorysList();

			for (History h : hs) {
				for (Action a : h.getActions()) {
					this.actions.add(a);
				}
			}
		}

		return actions;
	}

}
