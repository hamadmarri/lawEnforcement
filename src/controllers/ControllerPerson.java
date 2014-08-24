package controllers;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import entities.entries.AliasNameOrMoniker;
import entities.entries.Person;
import entities.entries.ScarMarkTattoo;


@ManagedBean(name = "controllerPerson")
@ViewScoped
public class ControllerPerson extends RelatableController<Person> implements Serializable {

	private static final long serialVersionUID = -328811918930855338L;
	private AliasNameOrMoniker newAliasNameOrMoniker = new AliasNameOrMoniker();
	private ScarMarkTattoo newScarMarkTattoo = new ScarMarkTattoo();



	@PostConstruct
	public void init() {
		this.type = "Person";
	}



	public void createNewPerson() {
		this.relatable = new Person();
		super.setNewRelatable(true);
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



	public void addNewAliasName() {
		this.newAliasNameOrMoniker.setPerson(this.getPerson());
		this.getPerson().addAliasNameOrMoniker(this.newAliasNameOrMoniker);
		this.submit();
		this.newAliasNameOrMoniker = new AliasNameOrMoniker();
	}



	public void addNewScarMarkTattoo() {
		this.newScarMarkTattoo.setPerson(this.getPerson());
		this.getPerson().addScars_mark_tattoo(this.newScarMarkTattoo);
		this.submit();
		this.newScarMarkTattoo = new ScarMarkTattoo();
	}



	public AliasNameOrMoniker getNewAliasNameOrMoniker() {
		return newAliasNameOrMoniker;
	}



	public void setNewAliasNameOrMoniker(AliasNameOrMoniker newAliasNameOrMoniker) {
		this.newAliasNameOrMoniker = newAliasNameOrMoniker;
	}



	public ScarMarkTattoo getNewScarMarkTattoo() {
		return newScarMarkTattoo;
	}



	public void setNewScarMarkTattoo(ScarMarkTattoo newScarMarkTattoo) {
		this.newScarMarkTattoo = newScarMarkTattoo;
	}

}
