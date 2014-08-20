package controllers;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ejbs.EjbSuspectPerson;
import entities.events.SuspectPerson;


@ManagedBean(name = "controllerSuspectPerson")
@ViewScoped
public class ControllerSuspectPerson implements Serializable {

	private static final long serialVersionUID = -3794654476345847009L;

	@EJB
	protected EjbSuspectPerson ejbSuspectPerson;
	protected String id;
	protected SuspectPerson SuspectPerson;
	protected List<SuspectPerson> SuspectPersonsList = null;



	public String submit() {
		ejbSuspectPerson.save(this.SuspectPerson);
		return "success";
	}



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public SuspectPerson getSuspectPerson() {
		if (this.SuspectPerson != null)
			return this.SuspectPerson;

		if (this.id == null)
			return null;

		this.SuspectPerson = ejbSuspectPerson.getView(Long.parseLong(this.id)).get(0);

		return this.SuspectPerson;
	}



	public void setSuspectPerson(SuspectPerson suspectPerson) {
		this.SuspectPerson = suspectPerson;
	}



	public List<SuspectPerson> getSuspectPersonsList() {
		if (this.SuspectPersonsList == null)
			this.SuspectPersonsList = ejbSuspectPerson.getList();

		return SuspectPersonsList;
	}



	public void setSuspectPersonsList(List<SuspectPerson> list) {
		this.SuspectPersonsList = list;
	}

}
