package developmentUtilities;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import entities.Relatable;


@ManagedBean(name = "controllerOfTesting")
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



	public void test() {
		ejb_of_test.test();
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
