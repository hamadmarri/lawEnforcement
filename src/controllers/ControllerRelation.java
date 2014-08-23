package controllers;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ejbs.AbstractEjb;
import entities.Relation;


@ManagedBean(name = "controllerRelation")
@ViewScoped
public class ControllerRelation implements Serializable {

	private static final long serialVersionUID = -3794654476345847009L;

	@EJB
	protected AbstractEjb<Relation> ejbRelation;
	protected String id;
	protected Relation relation;
	protected List<Relation> relationsList = null;
	protected boolean newEntity = false;



	@PostConstruct
	public void init() {
		this.ejbRelation.setEntityName("Relation");
	}



	public String submit() {
		if (isNewEntity())
			ejbRelation.add(this.relation);
		else
			ejbRelation.save(this.relation);
		return "success";
	}



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public Relation getrelation() {
		if (this.relation != null)
			return this.relation;

		if (this.id == null)
			return null;

		this.relation = ejbRelation.getView(Long.parseLong(this.id)).get(0);

		return this.relation;
	}



	public void setrelation(Relation relation) {
		this.relation = relation;
	}



	public List<Relation> getRelationsList() {
		if (this.relationsList == null)
			this.relationsList = ejbRelation.getList();

		return relationsList;
	}



	public void setRelationsList(List<Relation> list) {
		this.relationsList = list;
	}



	public boolean isNewEntity() {
		return newEntity;
	}



	public void setNewEntity(boolean newEntity) {
		this.newEntity = newEntity;
	}
	
}
