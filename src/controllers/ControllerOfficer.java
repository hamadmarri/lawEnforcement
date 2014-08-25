package controllers;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ejbs.AbstractEjb;
import entities.Relatable;
import entities.events.Event;
import entities.police.Officer;


@ManagedBean(name = "controllerOfficer")
@ViewScoped
public class ControllerOfficer implements Serializable {

	private static final long serialVersionUID = 7703146094170945295L;
	@EJB
	protected AbstractEjb<Officer> ejbOfficer;

	@EJB
	private AbstractEjb<Relatable> ejbRelatable;

	protected String id;
	protected Officer Officer;
	protected List<Officer> OfficersList = null;
	protected boolean newEntity = false;
	private String officerId;



	@PostConstruct
	public void init() {
		this.ejbOfficer.setEntityName("Officer");
	}



	public String submit() {
		if (isNewEntity())
			ejbOfficer.add(this.Officer);
		else
			ejbOfficer.save(this.Officer);
		return "success";
	}



	public void createNewOfficer() {
		this.Officer = new Officer();
		this.setNewEntity(true);
	}



	public void addOfficerForEvent(Event e) {
		Officer of = this.ejbOfficer.getEntity(Long.parseLong(officerId));
		of.addEventResponsibleFor(e);
		e.addOfficerResponsibleFor(of);
		this.ejbOfficer.save(of);
		this.ejbRelatable.save(e);
		this.officerId = null;
	}



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public Officer getOfficer() {
		if (this.Officer != null)
			return this.Officer;

		if (this.id == null)
			return null;

		this.Officer = ejbOfficer.getEntity(Long.parseLong(this.id));

		return this.Officer;
	}



	public void setOfficer(Officer Officer) {
		this.Officer = Officer;
	}



	public List<Officer> getOfficersList() {
		if (this.OfficersList == null)
			this.OfficersList = ejbOfficer.getList();

		return OfficersList;
	}



	public void setOfficersList(List<Officer> list) {
		this.OfficersList = list;
	}



	public boolean isNewEntity() {
		return newEntity;
	}



	public void setNewEntity(boolean newEntity) {
		this.newEntity = newEntity;
	}



	public String getOfficerId() {
		return officerId;
	}



	public void setOfficerId(String officerId) {
		this.officerId = officerId;
	}

}
