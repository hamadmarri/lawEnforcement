package controllers.monitoring;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ejbs.MonitoringEjb;
import entities.police.InvestigativeCase;


/**
 * @author hamadalmarri
 * 
 * @Pages
 * 
 * @Relative_Objects
 * 
 */
@ManagedBean(name = "controllerList")
@ViewScoped
public class ControllerList {

	// EJB for InvestigativeCase object
	@EJB
	private MonitoringEjb ejbMonitoring;

	// list of InvestigativeCase objects
	private List<InvestigativeCase> investigativeCasesList = null;



	/**
	 * will be called automatically right after the class is constructed since
	 * it has the PostConstruct annotation
	 */
	@PostConstruct
	public void init() {
	}



	public List<InvestigativeCase> getInvestigativeCasesList() {
		if (this.investigativeCasesList == null)
			this.investigativeCasesList = ejbMonitoring.getAllInvestigativeCasesList();

		return investigativeCasesList;
	}



	public void setInvestigativeCasesList(List<InvestigativeCase> list) {
		this.investigativeCasesList = list;
	}

}
