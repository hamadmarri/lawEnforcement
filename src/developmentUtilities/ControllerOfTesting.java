package developmentUtilities;

import java.util.Calendar;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedProperty;
import javax.inject.Named;

import org.hibernate.validator.internal.util.privilegedactions.GetClassLoader;

import entities.Relatable;
import entities.Relation;
import entities.entries.Conveyance;
import entities.entries.Entry;
import entities.entries.Person;


@Named
@RequestScoped
public class ControllerOfTesting {

	@EJB
	private EJB_of_test ejb_of_test;

	private String id;
	private String mode = "";



	public Relatable getView() {
		if (this.id == null)
			return null;

		return ejb_of_test.getView(Long.parseLong(this.id)).get(0);
	}



	public String test() {
		ejb_of_test.test();
		return "success";
		// return "fail";
	}



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getMode() {
		return mode;
	}



	public void setMode(String mode) {
		this.mode = mode;
	}

}
