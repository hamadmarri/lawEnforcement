package controllers;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import entities.Relatable;


@ManagedBean(name = "controllerRelatable")
@ViewScoped
public class ControllerRelatable extends AbstarctController<Relatable> implements Serializable {

	private static final long serialVersionUID = -216346142306245603L;



	@PostConstruct
	public void init() {
		this.type = "Relatable";
	}



	public Relatable getRelatable() {
		return super.getRelatable();
	}



	public void setRelatable(Relatable Relatable) {
		this.relatable = Relatable;
	}



	public List<Relatable> getRelatableesList() {
		return super.getList();
	}



	public void setRelatableesList(List<Relatable> list) {
		super.setList(list);
	}

}
