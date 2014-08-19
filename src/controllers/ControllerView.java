package controllers;

import java.io.IOException;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import developmentUtilities.EJB_of_test;
import entities.Relatable;
import entities.entries.Person;


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

//	@Inject
//	private ControllerPerson controllerPerson;

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
		System.out.println("******** ControllerView.id = " + this.id);
	}



	public void getProperViewPage() throws IOException {

		Relatable r = this.getRelatable();
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();

		if (r == null)
			ec.redirect("/lawEnforcement/management/view.xhtml?id=");

		if (r.getType().equals("Person")) {
//			this.controllerPerson.setPerson((Person) r);
			ec.redirect("/lawEnforcement/management/entries/person/viewPerson.xhtml?id=" + this.id);
		} else if (r.getType().equals("Conveyance")) {
			ec.redirect("/lawEnforcement/management/entries/conveyance/viewConveyance.xhtml?id=" + this.id);
		} else if (r.getType().equals("Image") || r.getType().equals("MugShotImage")
				|| r.getType().equals("PhotographicImage") || r.getType().equals("FingerprintImage")) {
			ec.redirect("/lawEnforcement/management/image/viewImage.xhtml?id=" + this.id);
		} else if (r.getType().equals("Location")) {
			ec.redirect("/lawEnforcement/management/entries/location/viewLocation.xhtml?id=" + this.id);
		} else if (r.getType().equals("Address")) {
			ec.redirect("/lawEnforcement/management/entries/address/viewAddress.xhtml?id=" + this.id);
		} else if (r.getType().equals("Organization")) {
			ec.redirect("/lawEnforcement/management/entries/organization/viewOrganization.xhtml?id=" + this.id);
		} else if (r.getType().equals("Property")) {
			ec.redirect("/lawEnforcement/management/entries/property/viewProperty.xhtml?id=" + this.id);
		} else if (r.getType().equals("IncidentReport")) {
			ec.redirect("/lawEnforcement/management/events/incidentReport/viewIncidentReport.xhtml?id=" + this.id);
		} else if (r.getType().equals("ArrestReport")) {
			ec.redirect("/lawEnforcement/management/events/arrestReport/viewArrestReport.xhtml?id=" + this.id);
		}
		ec.redirect("/");
	}



	public String getProperEditPage() throws IOException {
		Relatable r = this.getRelatable();
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();

		if (r == null)
			return("");

		if (r.getType().equals("Person")) {
//			this.controllerPerson.setPerson((Person) r);
			return ("/WEB-INF/composites/entries/person/editPerson.xhtml");
		} else if (r.getType().equals("Conveyance")) {
			ec.redirect("/lawEnforcement/management/entries/conveyance/editConveyance.xhtml?id=" + this.id);
		} else if (r.getType().equals("Image") || r.getType().equals("MugShotImage")
				|| r.getType().equals("PhotographicImage") || r.getType().equals("FingerprintImage")) {
			ec.redirect("/lawEnforcement/management/image/editImage.xhtml?id=" + this.id);
		} else if (r.getType().equals("Location")) {
			ec.redirect("/lawEnforcement/management/entries/location/editLocation.xhtml?id=" + this.id);
		} else if (r.getType().equals("Address")) {
			ec.redirect("/lawEnforcement/management/entries/address/editAddress.xhtml?id=" + this.id);
		} else if (r.getType().equals("Organization")) {
			ec.redirect("/lawEnforcement/management/entries/organization/editOrganization.xhtml?id=" + this.id);
		} else if (r.getType().equals("Property")) {
			ec.redirect("/lawEnforcement/management/entries/property/editProperty.xhtml?id=" + this.id);
		} else if (r.getType().equals("IncidentReport")) {
			ec.redirect("/lawEnforcement/management/events/incidentReport/editIncidentReport.xhtml?id=" + this.id);
		} else if (r.getType().equals("ArrestReport")) {
			ec.redirect("/lawEnforcement/management/events/arrestReport/editArrestReport.xhtml?id=" + this.id);
		}

		// ec.redirect("/lawEnforcement/management/edit.xhtml?id=" + this.id);
		return "";
	}

}
