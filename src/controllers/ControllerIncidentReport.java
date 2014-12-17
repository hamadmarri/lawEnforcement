package controllers;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import entities.events.IncidentReport;


/**
 * @author hamadalmarri
 * 
 * @Pages
 *        - listIncidentReports.xhtml
 *        - viewIncidentReport.xhtml
 *        - addIncidentReport.xhtml
 *        - editIncidentReport.xhtml
 * 
 * @Relative_Objects
 *                   - Invistigator who owen this Activity
 *                   - InvisigativeCase that this Activity is for
 * 
 */
@ManagedBean(name = "controllerIncidentReport")
@ViewScoped
public class ControllerIncidentReport extends AbstractController<IncidentReport> implements Serializable {

	private static final long serialVersionUID = 9039079017243262913L;



	/**
	 * will be called automatically right after the class is constructed since
	 * it has the PostConstruct annotation
	 */
	@PostConstruct
	public void init() {
		// at the beginning, set the entitiy name to be IncidentReport
		this.type = "IncidentReport";
	}



	/**
	 * to initiate new object of IncidentReport. This function will be called
	 * from
	 * addIncidentReport.xhtml page at preRenderView phase
	 */
	public void createNewIncidentReport() {
		this.relatable = new IncidentReport();
		super.setNewRelatable(true);
	}



	public IncidentReport getIncidentReport() {
		IncidentReport ir = super.getRelatable();
		return ir;
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
