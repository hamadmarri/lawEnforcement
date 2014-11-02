package controllers;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ejbs.AbstractEjb;
import entities.entries.Conveyance;
import entities.entries.Person;


@ManagedBean(name = "controllerConveyance")
@ViewScoped
public class ControllerConveyance extends AbstractController<Conveyance> implements Serializable {

	private static final long serialVersionUID = -3709992694215689104L;

	@EJB
	AbstractEjb<Person> ejbPerson;

	private Long registeredOwnerId = null;



	@PostConstruct
	public void init() {
		this.type = "Conveyance";
	}



	@Override
	public String submit() {
		// update person based on its id
		if (this.registeredOwnerId != null) {
			Person p = (Person) this.ejbPerson.getEntity(this.registeredOwnerId);
			this.getConveyance().setRegisteredOwner(p);
		}
		
		return super.submit();
	}



	public void createNewConveyance() {
		this.relatable = new Conveyance();
		setNewRelatable(true);
	}



	public Conveyance getConveyance() {
		// hold the id of RegisteredOwner
		Conveyance c = super.getRelatable();
		if (this.registeredOwnerId == null && c != null && c.getRegisteredOwner() != null)
			setRegisteredOwnerId(c.getRegisteredOwner().getId());

		return c;
	}



	public void setConveyance(Conveyance conveyance) {
		this.relatable = conveyance;
	}



	public List<Conveyance> getConveyancesList() {
		return super.getList();
	}



	public void setConveyancesList(List<Conveyance> list) {
		super.setList(list);
	}



	public Long getRegisteredOwnerId() {
		return registeredOwnerId;
	}



	public void setRegisteredOwnerId(Long registeredOwnerId) {
		this.registeredOwnerId = registeredOwnerId;
	}

}
