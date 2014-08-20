package controllers;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ejbs.EjbView;
import entities.Relatable;


@ManagedBean(name = "abstarctController")
@ViewScoped
public class AbstarctController<T> {

	@EJB
	protected EjbView ejbRelation;
	protected String id;
	protected T relatable;



	public String submit() {
		// System.out.println("******** save ********");
		// System.out.println("******** " +
		// this.person.getPersonName().getFirstName());
		ejbRelation.save((Relatable) this.relatable);
		return "success"; // ?faces-redirect=true";
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

		this.relatable = (T) ejbRelation.getView(Long.parseLong(this.id)).get(0);

		return this.relatable;
	}



	public void setRelatable(T relatable) {
		this.relatable = relatable;
	}
}
