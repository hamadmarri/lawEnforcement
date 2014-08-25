package controllers;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import entities.events.ArrestReport;
import entities.events.IncidentReport;


@ManagedBean(name = "controllerArrestReport")
@ViewScoped
public class ControllerArrestReport extends RelatableController<ArrestReport> implements Serializable {

	private static final long serialVersionUID = 8531943717512800497L;
	private String incidentReportId;



	@PostConstruct
	public void init() {
		this.type = "ArrestReport";
	}



	@Override
	public String submit() {
		if (this.incidentReportId != null) {
			// add the incident report to this arrest report
			IncidentReport ir = (IncidentReport) this.ejbRelatable.getEntity(Long.parseLong(this.incidentReportId));
			this.getArrestReport().addIncidentReportAccordingTo(ir);
			ir.addArrestReport(this.getArrestReport());
			super.submit();
			this.ejbRelatable.save(ir);
			return "successForIncidentReport";
		}

		super.submit();
		return "success";
	}



	public void createNewArrestReport() {
		this.relatable = new ArrestReport();
		setNewRelatable(true);
	}



	public ArrestReport getArrestReport() {
		return super.getRelatable();
	}



	public void setArrestReport(ArrestReport arrestReport) {
		this.relatable = arrestReport;
	}



	public List<ArrestReport> getArrestReportsList() {
		return super.getList();
	}



	public void setArrestReportsList(List<ArrestReport> arrestReports) {
		super.setList(arrestReports);
	}



	public String getIncidentReportId() {
		return incidentReportId;
	}



	public void setIncidentReportId(String incidentReportId) {
		this.incidentReportId = incidentReportId;
	}

}
