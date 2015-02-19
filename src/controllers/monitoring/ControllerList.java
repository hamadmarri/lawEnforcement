package controllers.monitoring;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import ejbs.EjbMonitoring;
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
@RequestScoped
public class ControllerList {

	// EJB for InvestigativeCase object
	@EJB
	private EjbMonitoring ejbMonitoring;

	@ManagedProperty(value = "#{controllerMonitoring}")
	private ControllerMonitoring controllerMonitoring;

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

		// System.out.println("getInvestigativeCasesList()********** " +
		// controllerMonitoring.getSearch()
		// + controllerMonitoring.getStartDate() +
		// controllerMonitoring.getDueDate() + "***********");
		List<String> officers = controllerMonitoring.getOfficers();

		this.investigativeCasesList = ejbMonitoring.getInvestigativeCasesList(controllerMonitoring.getSearch(),
				controllerMonitoring.getStartDate(), controllerMonitoring.getDueDate(),
				controllerMonitoring.getStatus(), officers.toArray(new String[officers.size()]));

		return investigativeCasesList;
	}



	public void setInvestigativeCasesList(List<InvestigativeCase> list) {
		this.investigativeCasesList = list;
	}



	public ControllerMonitoring getControllerMonitoring() {
		return controllerMonitoring;
	}



	public void setControllerMonitoring(ControllerMonitoring controllerMonitoring) {
		this.controllerMonitoring = controllerMonitoring;
	}

}
