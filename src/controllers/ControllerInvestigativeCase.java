package controllers;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ejbs.AbstractEjb;
import entities.events.IncidentReport;
import entities.police.InvestigativeCase;
import entities.police.Officer;


@ManagedBean(name = "controllerInvestigativeCase")
@ViewScoped
public class ControllerInvestigativeCase implements Serializable {

	private static final long serialVersionUID = 6798573244651897782L;

	@EJB
	protected AbstractEjb<InvestigativeCase> ejbInvestigativeCase;

	@EJB
	private AbstractEjb<Officer> ejbOfficer;

	@EJB
	private AbstractEjb<IncidentReport> ejbIncidentReport;

	protected String id;
	protected InvestigativeCase investigativeCase;
	protected List<InvestigativeCase> InvestigativeCasesList = null;
	protected boolean newEntity = false;
	private Long officerWhoCreatedItId = null;
	private String newIncidentReportId;



	@PostConstruct
	public void init() {
		this.ejbInvestigativeCase.setEntityName("InvestigativeCase");
	}



	public String submit() {

		// update officer based on its id
		if (this.officerWhoCreatedItId != null) {
			Officer of = (Officer) this.ejbOfficer.getEntity(this.officerWhoCreatedItId, "Officer");
			this.getInvestigativeCase().setOfficerWhoCreatedIt(of);
		}

		if (isNewEntity())
			ejbInvestigativeCase.add(this.investigativeCase);
		else
			ejbInvestigativeCase.save(this.investigativeCase);
		return "success";
	}



	public void createNewInvestigativeCase() {
		this.investigativeCase = new InvestigativeCase();
		this.setNewEntity(true);
	}



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public InvestigativeCase getInvestigativeCase() {
		if (this.investigativeCase != null)
			return this.investigativeCase;

		if (this.id == null)
			return null;

		this.investigativeCase = ejbInvestigativeCase.getEntity(Long.parseLong(this.id));

		// hold the id of officer
		if (this.officerWhoCreatedItId == null && this.investigativeCase != null
				&& this.investigativeCase.getOfficerWhoCreatedIt() != null)
			setOfficerWhoCreatedItId(this.investigativeCase.getOfficerWhoCreatedIt().getId());

		return this.investigativeCase;
	}



	public void addIncidentReport() {
		IncidentReport ir = this.ejbIncidentReport.getEntity(Long.parseLong(newIncidentReportId), "IncidentReport");
		ir.setAssignedCase(this.investigativeCase);
		this.ejbIncidentReport.save(ir);
		this.investigativeCase.addIncidentReport(ir);
		this.ejbInvestigativeCase.save(investigativeCase);
	}



	public void setInvestigativeCase(InvestigativeCase InvestigativeCase) {
		this.investigativeCase = InvestigativeCase;
	}



	public List<InvestigativeCase> getInvestigativeCasesList() {
		if (this.InvestigativeCasesList == null)
			this.InvestigativeCasesList = ejbInvestigativeCase.getList();

		return InvestigativeCasesList;
	}



	public void setInvestigativeCasesList(List<InvestigativeCase> list) {
		this.InvestigativeCasesList = list;
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

}
