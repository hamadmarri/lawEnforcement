package controllers;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import entities.events.IncidentReport;


@ManagedBean(name = "controllerIncidentReport")
@ViewScoped
public class ControllerIncidentReport extends AbstarctController<IncidentReport> implements Serializable {

	private static final long serialVersionUID = 9039079017243262913L;



	@PostConstruct
	public void init() {
		this.type = "IncidentReport";
	}



	public IncidentReport getIncidentReport() {
		return super.getRelatable();
	}



	public void setIncidentReport(IncidentReport incidentReport) {
		this.relatable = incidentReport;
	}



	public List<IncidentReport> getIncidentReportsList() {
		return super.getList();
	}



	public void setIncidentReportsList(List<IncidentReport> incidentReport) {
		super.setList(incidentReport);
	}

}
