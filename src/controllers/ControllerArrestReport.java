package controllers;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import entities.events.ArrestReport;


@ManagedBean(name = "controllerArrestReport")
@ViewScoped
public class ControllerArrestReport extends RelatableController<ArrestReport> implements Serializable {

	private static final long serialVersionUID = 8531943717512800497L;



	@PostConstruct
	public void init() {
		this.type = "ArrestReport";
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

}
