package developmentUtilities;

import java.util.Calendar;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import entities.Relatable;
import entities.entries.Conveyance;
import entities.entries.Entry;
import entities.entries.Person;
import entities.entries.Relation;


@Named
@RequestScoped
public class ControllerOfTesting {

	@EJB
	private EJB_of_test ejb_of_test;



	public String getView() {
		return ((Person) ejb_of_test.getView()).getPersonName().getFirstName();
	}



	public void test() {
		ejb_of_test.test();
	}

}
