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


@ManagedBean(name = "controllerSuspectPerson")
@ViewScoped
public class ControllerSuspectPerson extends ControllerRelatable<SuspectPerson> implements Serializable {

	private static final long serialVersionUID = -3794654476345847009L;

	@EJB
	private AbstractEjb<IncidentReport> ejbIncidentReport;
	private String incidentReportId;



	@PostConstruct
	public void init() {
		this.type = "SuspectPerson";
	}



	@Override
	public String submit() {
		super.submit();

		if (this.incidentReportId != null) {

			// add this suspect person to the passed incident report
			IncidentReport ir = (IncidentReport) this.ejbIncidentReport.getEntity(Long.parseLong(this
					.getIncidentReportId()));
			ir.addSuspectPerson(this.relatable);
			this.ejbIncidentReport.save(ir);

			return "successForIncidentReport";
		} else {
			return "success";
		}
	}



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
