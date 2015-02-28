package controllers.management;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import controllers.profile.ControllerProfile;
import security.Authorizable;
import ejbs.AbstractEjb;
import ejbs.EjbCrimeScene;
import entities.events.IncidentReport;
import entities.police.CrimeScene;
import entities.police.InvestigativeCase;
import entities.police.Investigator;
import entities.police.Notification;
import entities.police.Officer;


/**
 * @author hamadalmarri
 * 
 * @Pages
 *        - listInvestigativeCases.xhtml
 *        - viewInvestigativeCase.xhtml
 *        - addInvestigativeCase.xhtml
 *        - editInvestigativeCase.xhtml
 * 
 * @Relative_Objects
 *                   - Officer: the officer who created this case
 *                   - IncidentReport that this investigative case initiated
 *                   from
 * 
 */
@ManagedBean(name = "controllerInvestigativeCase")
@ViewScoped
public class ControllerInvestigativeCase implements Serializable {

	private static final long serialVersionUID = 6798573244651897782L;

	// EJB for InvestigativeCase object
	@EJB
	protected AbstractEjb<InvestigativeCase> ejbInvestigativeCase;

	// EJB for Officer object
	@EJB
	private AbstractEjb<Officer> ejbOfficer;

	// EJB for IncidentReport object
	@EJB
	private AbstractEjb<IncidentReport> ejbIncidentReport;

	// EJB for CrimeScene object
	@EJB
	private EjbCrimeScene ejbCrimeScene;

	@ManagedProperty(value = "#{controllerNotification}")
	private ControllerNotification controllerNotification;

	@ManagedProperty(value = "#{controllerProfile}")
	private ControllerProfile controllerProfile;

	// the id of a InvestigativeCase object
	protected String id;

	// the InvestigativeCase object
	protected InvestigativeCase investigativeCase;

	// list of InvestigativeCase objects
	protected List<InvestigativeCase> investigativeCasesList = null;

	// to indicate if the operation is to add
	// new InvestigativeCase or not
	protected boolean newEntity = false;

	// the id of the officer who created this case
	private Long officerWhoCreatedItId = null;

	// the id of the incident report that this case will attach it
	private String newIncidentReportId;

	private Long crimeSceneId = null;



	/**
	 * will be called automatically right after the class is constructed since
	 * it has the PostConstruct annotation
	 */
	@PostConstruct
	public void init() {
		// at the beginning, set the entitiy name to be InvestigativeCase
		this.ejbInvestigativeCase.setEntityName("InvestigativeCase");
	}



	/**
	 * to submit changes on the InvestigativeCase object
	 * 
	 * @return "success" which is used for navigation engine to redirect to the
	 *         proper page
	 */
	public String submit() {

		// update officer based on its id
		if (this.officerWhoCreatedItId != null) {
			Officer of = (Officer) this.ejbOfficer.getEntity(this.officerWhoCreatedItId, "Officer");
			this.getInvestigativeCase().setOfficerWhoCreatedIt(of);
		}

		// update crime scene based on its id
		if (this.crimeSceneId != null) {
			CrimeScene cs = ejbCrimeScene.getEntity(crimeSceneId);
			this.getInvestigativeCase().setCrimeScene(cs);
			cs.setInvestigativeCase(getInvestigativeCase());
			ejbCrimeScene.save(cs);
		}

		// if new object it will add the object to DB,
		// otherwise, it will just update it in DB
		if (isNewEntity())
			ejbInvestigativeCase.add(this.investigativeCase);
		else
			ejbInvestigativeCase.save(this.investigativeCase);

		// return "success" for navigation engine
		return "success";
	}



	/**
	 * to initiate new object of InvestigativeCase. This function will be called
	 * from
	 * addInvestigativeCase.xhtml page at preRenderView phase
	 */
	public void createNewInvestigativeCase() {
		this.investigativeCase = new InvestigativeCase();
		this.setNewEntity(true);
	}



	public String openCase() {
		// make status open
		this.getInvestigativeCase().setStatus(InvestigativeCase.getStatusSuggestions()[0]);
		ejbInvestigativeCase.save(this.investigativeCase);

		sendNotification("opened the case");

		// return "success" for navigation engine
		return "success";
	}



	public String acceptCase() {
		// make status in progress
		this.getInvestigativeCase().setStatus(InvestigativeCase.getStatusSuggestions()[2]);
		ejbInvestigativeCase.save(this.investigativeCase);

		sendNotification("accepted the case");

		// return "success" for navigation engine
		return "success";
	}



	public String refuseCase() {
		// make status refused
		this.getInvestigativeCase().setStatus(InvestigativeCase.getStatusSuggestions()[3]);
		ejbInvestigativeCase.save(this.investigativeCase);

		sendNotification("refused the case");

		// return "success" for navigation engine
		return "success";
	}



	public String closeCase() {
		// make status closed
		this.getInvestigativeCase().setStatus(InvestigativeCase.getStatusSuggestions()[4]);
		ejbInvestigativeCase.save(this.investigativeCase);

		sendNotification("closed the case");

		// return "success" for navigation engine
		return "success";
	}



	@SuppressWarnings("unchecked")
	public void sendNotification(String text) {
		Authorizable causedBy = controllerProfile.getAuthorizable();
		Notification n = new Notification(text, causedBy, null, investigativeCase);

		List<? extends Authorizable> authorizables = investigativeCase.getInvestigators();
		controllerNotification.sendNotification((List<Authorizable>) authorizables, n);
	}



	public ControllerNotification getControllerNotification() {
		return controllerNotification;
	}



	public void setControllerNotification(ControllerNotification controllerNotification) {
		this.controllerNotification = controllerNotification;
	}



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	/**
	 * it will load the object from DB if it is not loaded yet otherwise, it
	 * will return the InvestigativeCase object
	 * 
	 * @return the InvestigativeCase object
	 */
	public InvestigativeCase getInvestigativeCase() {

		// if the object was loaded already, just return it
		if (this.investigativeCase != null)
			return this.investigativeCase;

		// if the id is null do not try to load it from DB, just return null
		if (this.id == null)
			return null;

		// at this point object must be null but id is not,
		// so load it from DB
		this.investigativeCase = ejbInvestigativeCase.getEntity(Long.parseLong(this.id));

		// hold the id of officer
		if (this.officerWhoCreatedItId == null && this.investigativeCase != null
				&& this.investigativeCase.getOfficerWhoCreatedIt() != null) {

			setOfficerWhoCreatedItId(this.investigativeCase.getOfficerWhoCreatedIt().getId());
		}

		// hold the id of crime scene
		if (this.crimeSceneId == null && this.investigativeCase != null
				&& this.investigativeCase.getCrimeScene() != null) {

			setCrimeSceneId(this.investigativeCase.getCrimeScene().getCrimeSceneId());
		}

		return this.investigativeCase;
	}



	/**
	 * Load the incident report from DB and set this case to it
	 */
	public void addIncidentReport() {

		// load the incident report entity
		IncidentReport ir = this.ejbIncidentReport.getEntity(Long.parseLong(newIncidentReportId), "IncidentReport");

		// set this case to the incident report
		ir.setAssignedCase(this.investigativeCase);

		// save the incident report in DB
		this.ejbIncidentReport.save(ir);

		// add the incident report to this case
		this.investigativeCase.addIncidentReport(ir);

		// save the this case in DB
		this.ejbInvestigativeCase.save(investigativeCase);
	}



	public void setInvestigativeCase(InvestigativeCase InvestigativeCase) {
		this.investigativeCase = InvestigativeCase;
	}



	public List<InvestigativeCase> getInvestigativeCasesList() {
		if (this.investigativeCasesList == null)
			this.investigativeCasesList = ejbInvestigativeCase.getList();

		return investigativeCasesList;
	}



	public void setInvestigativeCasesList(List<InvestigativeCase> list) {
		this.investigativeCasesList = list;
	}



	public boolean isNewEntity() {
		return newEntity;
	}



	public void setNewEntity(boolean newEntity) {
		this.newEntity = newEntity;
	}



	public Long getOfficerWhoCreatedItId() {
		return officerWhoCreatedItId;
	}



	public void setOfficerWhoCreatedItId(Long officerWhoCreatedItId) {
		this.officerWhoCreatedItId = officerWhoCreatedItId;
	}



	public String getNewIncidentReportId() {
		return newIncidentReportId;
	}



	public void setNewIncidentReportId(String newIncidentReportId) {
		this.newIncidentReportId = newIncidentReportId;
	}



	public Long getCrimeSceneId() {
		return crimeSceneId;
	}



	public void setCrimeSceneId(Long crimeSceneId) {
		this.crimeSceneId = crimeSceneId;
	}



	public ControllerProfile getControllerProfile() {
		return controllerProfile;
	}



	public void setControllerProfile(ControllerProfile controllerProfile) {
		this.controllerProfile = controllerProfile;
	}
}
