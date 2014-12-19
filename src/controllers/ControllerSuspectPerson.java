package controllers;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ejbs.AbstractEjb;
import entities.events.IncidentReport;
import entities.events.SuspectPerson;


/**
 * @author hamadalmarri
 * 
 * @Pages
 *        - listSuspectPersons.xhtml
 *        - viewSuspectPerson.xhtml
 *        - addSuspectPerson.xhtml
 *        - editSuspectPerson.xhtml
 * 
 * @Relative_Objects
 *                   - IncidentReport that this person is suspect in
 * 
 */
@ManagedBean(name = "controllerSuspectPerson")
@ViewScoped
public class ControllerSuspectPerson extends AbstractController<SuspectPerson> implements Serializable {

	private static final long serialVersionUID = -3794654476345847009L;

	// EJB for IncidentReport object
	@EJB
	private AbstractEjb<IncidentReport> ejbIncidentReport;

	// IncidentReport id that this person is suspect in
	private String incidentReportId;



	/**
	 * will be called automatically right after the class is constructed since
	 * it has the PostConstruct annotation
	 */
	@PostConstruct
	public void init() {
		// at the beginning, set the entitiy name to be SuspectPerson
		this.type = "SuspectPerson";
	}



	/**
	 * to submit changes on the SuspectPerson object
	 * 
	 * @return "success" which is used for navigation engine to redirect to the
	 *         proper page
	 * @return "successForIncidentReport" to redirect to incident report page
	 */
	@Override
	public String submit() {

		// submit this suspect person's changes first
		super.submit();

		// then add this suspect person to the passed incident report
		if (this.incidentReportId != null) {

			// load incident report entity from DB
			IncidentReport ir = (IncidentReport) this.ejbIncidentReport.getEntity(Long.parseLong(this
					.getIncidentReportId()));

			// add this suspect person to the incident report
			ir.addSuspectPerson(this.relatable);

			// save the incident report
			this.ejbIncidentReport.save(ir);

			// redirect to incident report page
			return "successForIncidentReport";
		} else {
			return "success";
		}
	}



	/**
	 * to initiate new object of SuspectPerson. This function will be called
	 * from
	 * addSuspectPerson.xhtml page at preRenderView phase
	 */
	public void createNewSuspectPerson() {
		this.relatable = new SuspectPerson();
		super.setNewRelatable(true);
	}



	public SuspectPerson getSuspectPerson() {
		return super.getRelatable();
	}



	public void setSuspectPerson(SuspectPerson SuspectPerson) {
		this.relatable = SuspectPerson;
	}



	public List<SuspectPerson> getSuspectPersonsList() {
		return super.getList();
	}



	public void setSuspectPersonsList(List<SuspectPerson> list) {
		super.setList(list);
	}



	public String getIncidentReportId() {
		return incidentReportId;
	}



	public void setIncidentReportId(String incidentReportId) {
		this.incidentReportId = incidentReportId;
	}

}
