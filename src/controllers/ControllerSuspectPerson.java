package controllers;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import entities.events.SuspectPerson;


@ManagedBean(name = "controllerSuspectPerson")
@ViewScoped
public class ControllerSuspectPerson extends AbstarctController<SuspectPerson> implements Serializable {

	private static final long serialVersionUID = -3794654476345847009L;



	@PostConstruct
	public void init() {
		this.type = "SuspectPerson";
	}



	public SuspectPerson getSuspectPerson() {
		return super.getRelatable();
	}



	public void setSuspectPerson(SuspectPerson SuspectPerson) {
		this.relatable = SuspectPerson;
	}



	public List<SuspectPerson> getSuspectPersonsList() {
		return super.getList();
	}



	public void setSuspectPersonsList(List<SuspectPerson> list) {
		super.setList(list);
	}

}
