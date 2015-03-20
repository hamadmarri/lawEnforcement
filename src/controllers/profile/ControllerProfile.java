package controllers.profile;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import security.Authorizable;
import security.login_system.UserSessionController;
import controllers.management.ControllerInvestigator;
import controllers.management.ControllerOfficer;
import ejbs.AbstractEjb;
import ejbs.EjbNotification;


/**
 * @author hamadalmarri
 * 
 * 
 */
@ManagedBean(name = "controllerProfile")
@ViewScoped
public class ControllerProfile implements Serializable {

	private static final long serialVersionUID = -5125021517784368433L;

	@ManagedProperty(value = "#{controllerOfficer}")
	private ControllerOfficer controllerOfficer;

	@ManagedProperty(value = "#{controllerInvestigator}")
	private ControllerInvestigator controllerInvestigator;

	@ManagedProperty(value = "#{userSessionController}")
	private UserSessionController userSessionController;

	@EJB
	private AbstractEjb<Authorizable> ejbAuthorizable;

	@EJB
	private EjbNotification ejbNotification;

	private String userId = null;
	private Authorizable authorizable;
	private boolean isOfficer = false;
	private boolean isInvestigator = false;
	private short newNotifications = -1;



	@PostConstruct
	public void init() {
		this.ejbAuthorizable.setEntityName("Authorizable");

		this.userId = Long.toString(userSessionController.getProfileId());

		if (this.userId == null || this.userId.isEmpty())
			return;

		this.authorizable = this.ejbAuthorizable.getEntity(Long.parseLong(this.userId));

		if (authorizable == null)
			return;

		if (this.authorizable.getType().equals("Officer")) {
			isOfficer = true;
			controllerOfficer.setId(userId);
		} else if (this.authorizable.getType().equals("Investigator")) {
			isInvestigator = true;
			controllerInvestigator.setId(userId);
		}

	}



	public boolean isOfficer() {
		return isOfficer;
	}



	public void setOfficer(boolean isOfficer) {
		this.isOfficer = isOfficer;
	}



	public boolean isInvestigator() {
		return isInvestigator;
	}



	public void setInvestigator(boolean isInvestigator) {
		this.isInvestigator = isInvestigator;
	}



	public String getUserId() {
		return userId;
	}



	public void setUserId(String userId) {
		this.userId = userId;
	}



	public Authorizable getAuthorizable() {
		return authorizable;
	}



	public void setAuthorizable(Authorizable authorizable) {
		this.authorizable = authorizable;
	}



	public ControllerOfficer getControllerOfficer() {
		return controllerOfficer;
	}



	public void setControllerOfficer(ControllerOfficer controllerOfficer) {
		this.controllerOfficer = controllerOfficer;
	}



	public ControllerInvestigator getControllerInvestigator() {
		return controllerInvestigator;
	}



	public void setControllerInvestigator(ControllerInvestigator controllerInvestigator) {
		this.controllerInvestigator = controllerInvestigator;
	}



	public UserSessionController getUserSessionController() {
		return userSessionController;
	}



	public void setUserSessionController(UserSessionController userSessionController) {
		this.userSessionController = userSessionController;
	}



	public void updateNewNotifications() {
		if (authorizable != null)
			newNotifications = ejbNotification.getCountNewNotifications(authorizable);
	}



	public short getNewNotifications() {
		if (newNotifications == -1)
			updateNewNotifications();

		return newNotifications;
	}



	public void setNewNotifications(short newNotifications) {
		this.newNotifications = newNotifications;
	}

}
