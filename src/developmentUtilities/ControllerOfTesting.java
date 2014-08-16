package developmentUtilities;

import java.util.Calendar;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import entities.entries.Conveyance;
import entities.entries.Person;
import entities.entries.Relation;


@Named
@RequestScoped
public class ControllerOfTesting {

	@EJB
	private EJB_of_test ejb_of_test;



	public String getView() {
		Relation r =  ejb_of_test.getView();
		Person p = (Person) r.getSomething();
		Conveyance c = (Conveyance) r.getSomethingElse();
		return p.getPersonName().getFirstName() + " " + r.getTypeOfRelation() + " " + c.getMake();
	}



	public void test() {
		ejb_of_test.test();
	}

}
