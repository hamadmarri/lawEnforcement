package developmentUtilities;

import java.util.Calendar;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;


@Named
@RequestScoped
public class ControllerOfTesting {

	@EJB
	private EJB_of_test ejb_of_test;



	public int getPersonDOB() {
		return ejb_of_test.getPerson().getDateOfBirth().get(Calendar.HOUR_OF_DAY);
	}



	public void test() {
		ejb_of_test.test();
	}

}
