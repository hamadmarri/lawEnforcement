package controllers.monitoring;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import entities.police.InvestigativeCase;


/**
 * @author hamadalmarri
 * 
 * @Pages
 * 
 * @Relative_Objects
 * 
 */
@ManagedBean(name = "controllerMonitoring")
@ViewScoped
public class ControllerMonitoring {

	private String search = new String();
	private Date startDate = new Date();
	private Date dueDate = new Date();
	private String[] status;
	private List<String> officers = new ArrayList<String>();
	private String officerToBeAdded;



	@PostConstruct
	public void init() {
		status = InvestigativeCase.getStatusSuggestions();
	}



	public void addOfficer() {
		officers.add(officerToBeAdded);
		officerToBeAdded = "";
	}



	public void removeOfficer(String officer) {
		officers.remove(officer);
	}



	public String getSearch() {
		return search;
	}



	public void setSearch(String search) {
		this.search = search;
	}



	public Date getStartDate() {
		return startDate;
	}



	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}



	public Date getDueDate() {
		return dueDate;
	}



	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}



	public String[] getStatus() {
		return status;
	}



	public void setStatus(String[] status) {
		this.status = status;
	}



	public List<String> getOfficers() {
		return officers;
	}



	public void setOfficers(List<String> officers) {
		this.officers = officers;
	}



	public String getOfficerToBeAdded() {
		return officerToBeAdded;
	}



	public void setOfficerToBeAdded(String officerToBeAdded) {
		this.officerToBeAdded = officerToBeAdded;
	}

}
