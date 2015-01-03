package controllers.management;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ejbs.EjbFieldInterview;
import ejbs.EjbRelatable;
import entities.entries.Person;
import entities.events.FieldInterview;
import entities.events.IncidentReport;


/**
 * @author hamadalmarri
 * 
 * @Pages
 *        - addFieldInterview.xhtml
 *        - editFieldInterview.xhtml
 *        - listFieldInterviews.xhtml
 *        - viewFieldInterview.xhtml
 * 
 * @Relative_Objects
 *                   - Person as subsciber for this field interview
 *                   - Person as in case of emergency contact for this field
 *                   interview
 *                   - IncidentReport that this field interview is for
 * 
 */
@ManagedBean(name = "controllerFieldInterview")
@ViewScoped
public class ControllerFieldInterview implements Serializable {

	private static final long serialVersionUID = 4953095639244656668L;

	// EJB for FieldInterview object
	@EJB
	protected EjbFieldInterview ejbFieldInterview;

	// EJB for Relatable object
	@EJB
	private EjbRelatable ejbRelatable;

	// the id of a FieldInterview object
	protected String id;

	// the FieldInterview object
	protected FieldInterview fieldInterview;

	// list of FieldInterview objects
	protected List<FieldInterview> fieldInterviewsList = null;

	// to indicate if the operation is to add
	// new FieldInterview or not
	protected boolean newEntity = false;

	// the id of a IncidentReport object
	private String incidentReportId;

	// the id of a Person as subsciber object
	private Long subscriberId = null;

	// the id of a Person as in case of emergency contact object
	private Long inCaseOfEmergencyPersonId = null;



	/**
	 * to submit changes on the FieldInterview object
	 * 
	 * @return "success"
	 *         which is used for navigation engine to redirect to the
	 *         proper page
	 * 
	 * @return "successForIncidentReport"
	 *         to navigate back to incident report page
	 *         "viewIncidentReport.xhtml", which added this field interview
	 * 
	 */
	public String submit() {

		/*
		 * update subscriber, in case of emr. persons based on their
		 * ids
		 */
		// load subscriber, and inCaseOfEmr objects
		Person subscriber = (Person) this.ejbRelatable.getEntity(this.getSubscriberId());
		Person inCaseOfEmr = (Person) this.ejbRelatable.getEntity(this.getInCaseOfEmergencyPersonId());

		// set subscriber, and inCaseOfEmr objects to this field interview
		this.getFieldInterviewFromId().setSubscriber(subscriber);
		this.getFieldInterviewFromId().setInCaseOfEmergencyPerson(inCaseOfEmr);

		// if incidentReportId is not null, then we need to set it to this field
		// interview
		if (this.incidentReportId != null) {

			// load the incident report
			IncidentReport ir = (IncidentReport) this.ejbRelatable
					.getEntity(Long.parseLong(this.getIncidentReportId()));

			// set incident report to this field interview
			this.fieldInterview.setIncidentReport(ir);

			// and set this field interview to the incident report as well
			ir.addFieldInterview(this.fieldInterview);

			// saving the incident report to DB
			this.ejbRelatable.save(ir);

			// TODO: why not saving the field interview!

			return "successForIncidentReport";

		} else {
			ejbFieldInterview.save(this.fieldInterview);
			return "success";
		}
	}



	/**
	 * to initiate new object of FieldInterview. This function will be called
	 * from
	 * addFieldInterview.xhtml page at preRenderView phase
	 */
	public void createNewFieldInterview() {
		this.fieldInterview = new FieldInterview();
		this.setNewEntity(true);
	}



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	/**
	 * It will call getFieldInterview() function, which load the entity. The
	 * purpose is just to decouple loading the entity itself from loading its
	 * relations entities
	 * 
	 * @return the FieldInterview object
	 */
	public FieldInterview getFieldInterview() {

		// load the entity itself
		FieldInterview fi = this.getFieldInterviewFromId();

		// hold the id of subscriberId
		if (this.subscriberId == null && fi != null && fi.getSubscriber() != null)
			setSubscriberId(fi.getSubscriber().getId());

		// hold the id of inCaseOfEmergencyPersonId
		if (this.inCaseOfEmergencyPersonId == null && fi != null && fi.getInCaseOfEmergencyPerson() != null)
			setInCaseOfEmergencyPersonId(fi.getInCaseOfEmergencyPerson().getId());

		return fi;
	}



	/**
	 * it will load the object from DB if it is not loaded yet otherwise, it
	 * will return the FieldInterview object
	 * 
	 * @return the FieldInterview object
	 */
	private FieldInterview getFieldInterviewFromId() {

		// if the object was loaded already, just return it
		if (this.fieldInterview != null)
			return this.fieldInterview;

		// if the id is null do not try to load it from DB, just return null
		if (this.id == null)
			return null;

		// at this point object must be null but id is not,
		// so load it from DB
		this.fieldInterview = ejbFieldInterview.getEntity(Long.parseLong(this.id));

		return this.fieldInterview;
	}



	public void setFieldInterview(FieldInterview FieldInterview) {
		this.fieldInterview = FieldInterview;
	}



	public List<FieldInterview> getFieldInterviewsList() {
		if (this.fieldInterviewsList == null)
			this.fieldInterviewsList = ejbFieldInterview.getList();

		return fieldInterviewsList;
	}



	public void setFieldInterviewsList(List<FieldInterview> list) {
		this.fieldInterviewsList = list;
	}



	public boolean isNewEntity() {
		return newEntity;
	}



	public void setNewEntity(boolean newEntity) {
		this.newEntity = newEntity;
	}



	public String getIncidentReportId() {
		return incidentReportId;
	}



	public void setIncidentReportId(String incidentReportId) {
		this.incidentReportId = incidentReportId;
	}



	public Long getSubscriberId() {
		return subscriberId;
	}



	public void setSubscriberId(Long subscriberId) {
		this.subscriberId = subscriberId;
	}



	public Long getInCaseOfEmergencyPersonId() {
		return inCaseOfEmergencyPersonId;
	}



	public void setInCaseOfEmergencyPersonId(Long inCaseOfEmergencyPersonId) {
		this.inCaseOfEmergencyPersonId = inCaseOfEmergencyPersonId;
	}

}