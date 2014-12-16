package controllers;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import entities.events.ArrestReport;
import entities.events.IncidentReport;


/**
 * @author hamadalmarri
 * 
 * @Pages
 *        - addArrestReport.xhtml
 *        - editArrestReport.xhtml
 *        - listArrestReports.xhtml
 *        - viewArrestReport.xhtml
 * 
 * @Relative_Objects
 *                   - IncidentReport, which this ArrestReport according to
 * 
 * 
 * @TODO
 *       TODO: add the ability to link an existed arrest report to an
 *       existed incident report, for now, from
 *       viewIncidentReport.xhtml page the user able to click on add below
 *       Arrest Reports List and that will
 *       open addArrestReport.xthml page and pass the IncidentReport id in
 *       page prameters.
 */
@ManagedBean(name = "controllerArrestReport")
@ViewScoped
public class ControllerArrestReport extends AbstractController<ArrestReport> implements Serializable {

	private static final long serialVersionUID = 8531943717512800497L;

	// the id of incident report that this Arrest report according to
	private String incidentReportId;



	/**
	 * will be called automatically right after the class is constructed since
	 * it has the PostConstruct annotation
	 */
	@PostConstruct
	public void init() {
		// at the beginning, set the entitiy name to be ArrestReport
		this.type = "ArrestReport";
	}



	/**
	 * to submit changes on the ArrestReport object
	 * 
	 * @return
	 * 
	 *         "success" which is used for navigation engine to redirect to the
	 *         proper page
	 * 
	 *         "successForIncidentReport" to redirect page to incident report
	 *         page
	 */
	@Override
	public String submit() {
		
		// check if incident report id is not null to
		// add it to this arrest report 
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



	/**
	 * to initiate new object of ArrestReport. This function will be called from
	 * addArrestReport.xhtml page at preRenderView phase
	 */
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
