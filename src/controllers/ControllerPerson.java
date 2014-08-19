package controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ejbs.EjbView;
import entities.entries.Person;


@ManagedBean(name = "controllerPerson")
@ViewScoped
public class ControllerPerson implements Serializable {

	private static final long serialVersionUID = -328811918930855338L;

	@EJB
	private EjbView ejbPerson;

	private String id;
	private Person person; // = new Person();;
	private List<Map.Entry<String, String>> identificationsAsList = new ArrayList<Map.Entry<String, String>>();



	// @PostConstruct
	// public void init() {
	// // this.id = new String("1");
	// // this.person = (Person)
	// // ejbPerson.getView(Long.parseLong(this.id)).get(0);
	// // this.person = new Person();
	// // this.person.setPersonName(new PersonName());
	// }

	public String submit() {
		System.out.println("******** save ********");
		System.out.println("******** " + this.person.getPersonName().getFirstName());
		ejbPerson.save(this.person);
		return "success"; // ?faces-redirect=true";
	}



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public Person getPerson() {
		if (this.person != null)
			return this.person;

		if (this.id == null)
			return null;

		this.person = (Person) ejbPerson.getView(Long.parseLong(this.id)).get(0);

		this.identificationsAsList = new ArrayList<Map.Entry<String, String>>(this.person.getIdentifications()
				.entrySet());

		return this.person;
	}



	public void setPerson(Person person) {
		this.person = person;
	}



	public List<java.util.Map.Entry<String, String>> getIdentificationsAsList() {
		if (this.person == null)
			this.getPerson();

		return this.identificationsAsList;
	}



	public void setIdentificationsAsList(List<Map.Entry<String, String>> identificationsAsList) {
		this.identificationsAsList = identificationsAsList;
	}

}
