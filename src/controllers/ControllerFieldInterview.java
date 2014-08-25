package controllers;

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


@ManagedBean(name = "controllerFieldInterview")
@ViewScoped
public class ControllerFieldInterview implements Serializable {

	private static final long serialVersionUID = 4953095639244656668L;

	@EJB
	protected EjbFieldInterview ejbFieldInterview;
	@EJB
	private EjbRelatable ejbRelatable;

	protected String id;
	protected FieldInterview fieldInterview;
	protected List<FieldInterview> fieldInterviewsList = null;
	protected boolean newEntity = false;
	private String incidentReportId;

	private Long subscriberId = null;
	private Long inCaseOfEmergencyPersonId = null;



	public String submit() {

		// update subscriber, in case of emr. persons based on their ids
		Person subscriber = (Person) this.ejbRelatable.getEntity(this.getSubscriberId());
		Person inCaseOfEmr = (Person) this.ejbRelatable.getEntity(this.getInCaseOfEmergencyPersonId());

		this.getFieldInterviewFromId().setSubscriber(subscriber);
		this.getFieldInterviewFromId().setInCaseOfEmergencyPerson(inCaseOfEmr);

		if (this.incidentReportId != null) {

			// add this suspect person to the passed incident report
			IncidentReport ir = (IncidentReport) this.ejbRelatable
					.getEntity(Long.parseLong(this.getIncidentReportId()));

			this.fieldInterview.setIncidentReport(ir);
			ir.addFieldInterview(this.fieldInterview);
			this.ejbRelatable.save(ir);

			return "successForIncidentReport";

		} else {
			ejbFieldInterview.save(this.fieldInterview);
			return "success";
		}
	}



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



	public FieldInterview getFieldInterview() {
		FieldInterview fi = this.getFieldInterviewFromId();

		// hold the id of subscriberId
		if (this.subscriberId == null && fi != null && fi.getSubscriber() != null)
			setSubscriberId(fi.getSubscriber().getId());

		// hold the id of inCaseOfEmergencyPersonId
		if (this.inCaseOfEmergencyPersonId == null && fi != null && fi.getInCaseOfEmergencyPerson() != null)
			setInCaseOfEmergencyPersonId(fi.getInCaseOfEmergencyPerson().getId());

		return fi;
	}



	private FieldInterview getFieldInterviewFromId() {
		if (this.fieldInterview != null)
			return this.fieldInterview;

		if (this.id == null)
			return null;

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
