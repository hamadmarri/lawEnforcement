package developmentUtilities;

import java.util.Calendar;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
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



	public Relatable getView() {
		return ejb_of_test.getView().get(0);
	}


	public void test() {
		ejb_of_test.test();
	}

}
