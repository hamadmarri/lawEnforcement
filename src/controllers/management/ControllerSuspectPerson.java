package controllers.management;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ejbs.AbstractEjb;
import ejbs.EjbInvestigativeCase;
import entities.entries.SuspectPerson;
import entities.events.IncidentReport;
import entities.police.InvestigativeCase;


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
	private EjbInvestigativeCase ejbInvestigativeCase;

	// IncidentReport id that this person is suspect in
	private String investigativeCaseId;



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
		if (this.investigativeCaseId != null) {

			// load investigative case entity from DB
			InvestigativeCase invC = ejbInvestigativeCase.getEntity(Long.parseLong(getInvestigativeCaseId()));
			// IncidentReport ir = (IncidentReport)
			// this.ejbInvestigativeCase.getEntity(Long.parseLong(this
			// .getIncidentReportId()));

			// add this suspect person to the incident report
			invC.addSuspectPerson(this.relatable);

			// save the incident report
			this.ejbInvestigativeCase.save(invC);

			// TODO: change it to success for inve. case
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



	public String getInvestigativeCaseId() {
		return investigativeCaseId;
	}



	public void setInvestigativeCaseId(String investigativeCaseId) {
		this.investigativeCaseId = investigativeCaseId;
	}

}
