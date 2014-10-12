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
	protected Officer officer;
	protected List<Officer> officersList = null;
	protected boolean newEntity = false;
	private String officerId;



	@PostConstruct
	public void init() {
		this.ejbOfficer.setEntityName("Officer");
	}



	public String submit() {
		if (isNewEntity())
			ejbOfficer.add(this.officer);
		else
			ejbOfficer.save(this.officer);
		return "success";
	}



	public void createNewOfficer() {
		this.officer = new Officer();
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
		if (this.officer != null)
			return this.officer;

		if (this.id == null)
			return null;

		this.officer = ejbOfficer.getEntity(Long.parseLong(this.id));

		return this.officer;
	}



	public void setOfficer(Officer Officer) {
		this.officer = Officer;
	}



	public List<Officer> getOfficersList() {
		if (this.officersList == null)
			this.officersList = ejbOfficer.getList();

		return officersList;
	}



	public void setOfficersList(List<Officer> list) {
		this.officersList = list;
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
