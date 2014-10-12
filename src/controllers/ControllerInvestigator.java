package controllers;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ejbs.AbstractEjb;
import entities.police.InvestigativeCase;
import entities.police.Investigator;


@ManagedBean(name = "controllerInvestigator")
@ViewScoped
public class ControllerInvestigator implements Serializable {

	private static final long serialVersionUID = -8332230579861778723L;

	@EJB
	AbstractEjb<Investigator> ejbInvestigator;

	@EJB
	AbstractEjb<InvestigativeCase> ejbInvestigativeCase;
	
	protected String id;
	protected Investigator investigator = null;
	protected List<Investigator> investigatorsList = null;
	protected boolean newEntity = false;
	private String newInvestigatorId;



	@PostConstruct
	public void init() {
		this.ejbInvestigator.setEntityName("Investigator");
	}



	public String submit() {
		if (isNewEntity())
			ejbInvestigator.add(this.investigator);
		else
			ejbInvestigator.save(this.investigator);
		return "success";
	}



	public void createNewInvestigator() {
		this.investigator = new Investigator();
		this.setNewEntity(true);
	}



	public void addInvestigatorForInvestigativeCase(InvestigativeCase ic) {
		Investigator inv = this.ejbInvestigator.getEntity(Long.parseLong(newInvestigatorId));

		ic.addInvestigator(inv);
		ic.setStatus("pending");
		
		this.ejbInvestigativeCase.save(ic);
		this.newInvestigatorId = null;
	}



	public Investigator getInvestigator() {
		if (this.investigator != null)
			return this.investigator;

		if (this.id == null)
			return null;

		this.investigator = ejbInvestigator.getEntity(Long.parseLong(this.id));

		return this.investigator;
	}



	public void setInvestigator(Investigator investigator) {
		this.investigator = investigator;
	}



	public List<Investigator> getInvestigatorsList() {
		if (this.investigatorsList == null)
			this.investigatorsList = ejbInvestigator.getList();

		return investigatorsList;
	}



	public void setInvestigatorsList(List<Investigator> list) {
		this.investigatorsList = list;
	}



	public boolean isNewEntity() {
		return newEntity;
	}



	public String getNewInvestigatorId() {
		return newInvestigatorId;
	}



	public void setNewInvestigatorId(String newInvestigatorId) {
		this.newInvestigatorId = newInvestigatorId;
	}



	public void setNewEntity(boolean newEntity) {
		this.newEntity = newEntity;
	}



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}

}
