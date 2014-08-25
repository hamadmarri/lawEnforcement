package controllers;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ejbs.AbstractEjb;
import ejbs.EjbRelatable;
import entities.Relatable;
import entities.Relation;


@ManagedBean(name = "controllerRelation")
@ViewScoped
public class ControllerRelation implements Serializable {

	private static final long serialVersionUID = -3794654476345847009L;

	@EJB
	protected AbstractEjb<Relation> ejbRelation;

	@EJB
	private EjbRelatable ejbRelatable;

	protected String id;
	protected Relation relation;
	protected List<Relation> relationsList = null;
	protected boolean newEntity = false;
	private Long somethingId;
	private Long somethingElseId;



	@PostConstruct
	public void init() {
		this.ejbRelation.setEntityName("Relation");
	}



	public String submit() {

		setupRelation();

		if (isNewEntity())
			ejbRelation.add(this.relation);
		else
			ejbRelation.save(this.relation);
		return "success";
	}



	public void createNewRelation() {
		this.relation = new Relation();
		this.setNewEntity(true);
	}



	private void setupRelation() {
		Relatable something = this.ejbRelatable.getEntity(somethingId);
		Relatable somethingElse = this.ejbRelatable.getEntity(somethingElseId);
		this.relation.setSomething(something);
		this.relation.setSomethingElse(somethingElse);
	}



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
		getRelation();
	}



	public Relation getRelation() {
		if (this.relation != null)
			return this.relation;

		if (this.id == null)
			return null;

		this.relation = ejbRelation.getEntity(Long.parseLong(this.id));
		setSomethingId(this.relation.getSomething().getId());
		setSomethingElseId(this.relation.getSomethingElse().getId());

		return this.relation;
	}



	public void setRelation(Relation relation) {
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



	public Long getSomethingId() {
		return somethingId;
	}



	public void setSomethingId(Long somethingId) {
		this.somethingId = somethingId;
	}



	public Long getSomethingElseId() {
		return somethingElseId;
	}



	public void setSomethingElseId(Long somethingElseId) {
		this.somethingElseId = somethingElseId;
	}

}
