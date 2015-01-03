package controllers.profile;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import security.Authorizable;
import security.mocks.UserSessionMock;
import ejbs.AbstractEjb;
import entities.police.Investigator;
import entities.police.Officer;

/**
 * @author hamadalmarri
 * 
 * 
 */
@ManagedBean(name = "controllerProfile")
@ViewScoped
public class ControllerProfile {

	// @ManagedProperty(value = "#{controllerList}")
	// private UserSessionMock mock;

	@EJB
	private AbstractEjb<Authorizable> ejbAuthorizable;

	private String userId;
	private Authorizable authorizable;
	private Officer officer = null;
	private Investigator investigator = null;
	private String name;

	@PostConstruct
	public void init() {
		this.ejbAuthorizable.setEntityName("Authorizable");
		this.userId = Long.toString(UserSessionMock.userId);
		this.authorizable = this.ejbAuthorizable.getEntity(Long
				.parseLong(this.userId));

		if (this.authorizable.getType().equals("Officer")) {
			this.officer = (Officer) this.authorizable;
			this.name = this.officer.getPersonName().getLastName() + ", "
					+ this.officer.getPersonName().getFirstName();
		} else if (this.authorizable.getType().equals("Investigator")) {
			this.investigator = (Investigator) this.authorizable;
			this.name = this.investigator.getPersonName().getLastName() + ", "
					+ this.investigator.getPersonName().getFirstName();
		}

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

	public Officer getOfficer() {
		return officer;
	}

	public void setOfficer(Officer officer) {
		this.officer = officer;
	}

	public Investigator getInvestigator() {
		return investigator;
	}

	public void setInvestigator(Investigator investigator) {
		this.investigator = investigator;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
