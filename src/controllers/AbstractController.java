package controllers;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ejbs.AbstractEjb;
import entities.Relatable;


@ManagedBean(name = "abstractController")
@ViewScoped
public class AbstractController<T> {

	@EJB
	protected AbstractEjb<Relatable> ejbRelatable;
	protected String id;
	protected T relatable;
	protected String type;
	protected List<T> list = null;
	protected boolean newRelatable = false;



	@PostConstruct
	public void initAbstract() {
		this.ejbRelatable.setEntityName("Relatable");
	}



	public String submit() {

		if (isNewRelatable())
			ejbRelatable.add((Relatable) this.relatable);
		else
			ejbRelatable.save((Relatable) this.relatable);

		return "success";
	}



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	@SuppressWarnings("unchecked")
	public T getRelatable() {
		if (this.relatable != null)
			return this.relatable;

		if (this.id == null)
			return null;

		this.relatable = (T) ejbRelatable.getEntity(Long.parseLong(this.id));

		return this.relatable;
	}



	public void setRelatable(T relatable) {
		this.relatable = relatable;
	}



	@SuppressWarnings("unchecked")
	public List<T> getList() {
		if (this.list == null)
			this.list = (List<T>) ejbRelatable.getList(this.type);

		return list;
	}



	public void setList(List<T> list) {
		this.list = list;
	}



	public boolean isNewRelatable() {
		return newRelatable;
	}



	public void setNewRelatable(boolean newRelatable) {
		this.newRelatable = newRelatable;
	}

}
