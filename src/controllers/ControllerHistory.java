package controllers;

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


@ManagedBean(name = "controllerHistory")
@ViewScoped
public class ControllerHistory implements Serializable {

	private static final long serialVersionUID = -5117906001059099847L;

	@EJB
	protected AbstractEjb<History> ejbHistory;

	// @EJB
	// protected AbstractEjb<Action> ejbActions;

	private String id;
	private History history;
	private List<History> historyList = null;
	private List<Action> actions = null;



	@PostConstruct
	public void init() {
		this.ejbHistory.setEntityName("History");
	}



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
		getHistory();
	}



	public History getHistory() {
		if (this.history != null)
			return this.history;

		if (this.id == null)
			return null;

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
