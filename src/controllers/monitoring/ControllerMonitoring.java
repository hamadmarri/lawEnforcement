package controllers.monitoring;

import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


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



	// public void doFilter() {
	//
	// }



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

}
