package controllers;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ejbs.AbstractEjb;
import entities.events.FieldInterview;


@ManagedBean(name = "controllerFieldInterview")
@ViewScoped
public class ControllerFieldInterview implements Serializable {

	private static final long serialVersionUID = 4953095639244656668L;

	@EJB
	protected AbstractEjb<FieldInterview> ejbFieldInterview;
	protected String id;
	protected FieldInterview FieldInterview;
	protected List<FieldInterview> FieldInterviewsList = null;
	protected boolean newEntity = false;



	@PostConstruct
	public void init() {
		this.ejbFieldInterview.setEntityName("FieldInterview");
	}



	public String submit() {
		if (isNewEntity())
			ejbFieldInterview.add(this.FieldInterview);
		else
			ejbFieldInterview.save(this.FieldInterview);
		return "success";
	}



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public FieldInterview getFieldInterview() {
		if (this.FieldInterview != null)
			return this.FieldInterview;

		if (this.id == null)
			return null;

		this.FieldInterview = ejbFieldInterview.getView(Long.parseLong(this.id)).get(0);

		return this.FieldInterview;
	}



	public void setFieldInterview(FieldInterview FieldInterview) {
		this.FieldInterview = FieldInterview;
	}



	public List<FieldInterview> getFieldInterviewsList() {
		if (this.FieldInterviewsList == null)
			this.FieldInterviewsList = ejbFieldInterview.getList();

		return FieldInterviewsList;
	}



	public void setFieldInterviewsList(List<FieldInterview> list) {
		this.FieldInterviewsList = list;
	}



	public boolean isNewEntity() {
		return newEntity;
	}



	public void setNewEntity(boolean newEntity) {
		this.newEntity = newEntity;
	}

}
