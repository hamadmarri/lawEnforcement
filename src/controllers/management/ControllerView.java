package controllers.management;

import javax.ejb.EJB;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;

import developmentUtilities.EJB_of_test;
import entities.Relatable;


/**
 * 
 * @author hamadalmarri
 * 
 *         TODO: input security
 */
@Named
@RequestScoped
public class ControllerView {

	@EJB
	private EJB_of_test ejb_of_test;

	private String id;
	private Relatable relatable = null;



	public Relatable getRelatable() {
		if (this.relatable == null && this.id != null)
			this.relatable = ejb_of_test.getView(Long.parseLong(this.id)).get(0);

		return this.relatable;
	}



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}

}
