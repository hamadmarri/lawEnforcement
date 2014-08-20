package controllers;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import entities.entries.Person;


@ManagedBean(name = "controllerPerson")
@ViewScoped
public class ControllerPerson extends AbstarctController<Person> implements Serializable {

	private static final long serialVersionUID = -328811918930855338L;



	@PostConstruct
	public void init() {
		this.type = "Person";
	}



	public Person getPerson() {
		return super.getRelatable();
	}



	public void setPerson(Person person) {
		this.relatable = person;
	}



	public List<Person> getPersonsList() {
		return super.getList();
	}



	public void setPersonsList(List<Person> list) {
		super.setList(list);
	}
}
