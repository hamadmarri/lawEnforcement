package controllers;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import security.Authorizable;
import ejbs.AbstractEjb;
import entities.police.InvestigativeGroup;
import entities.police.Officer;


/**
 * @author hamadalmarri
 * 
 * @Pages
 *        - listInvestigativeGroups.xhtml
 *        - viewInvestigativeGroup.xhtml
 *        - addInvestigativeGroup.xhtml
 *        - editInvestigativeGroup.xhtml
 * 
 * @Relative_Objects
 *                   - Officer who created this InvestigativeGroup
 *                   - Authorizable list of authorizable objects that this group
 *                   consists of
 * 
 */
@ManagedBean(name = "controllerInvestigativeGroup")
@ViewScoped
public class ControllerInvestigativeGroup implements Serializable {

	private static final long serialVersionUID = 6798573244651897782L;

	// EJB for InvestigativeGroup object
	@EJB
	protected AbstractEjb<InvestigativeGroup> ejbInvestigativeGroup;

	// EJB for Officer object
	@EJB
	private AbstractEjb<Officer> ejbOfficer;

	// EJB for Authorizable object
	@EJB
	private AbstractEjb<Authorizable> ejbAuthorizable;

	protected String id;
	protected InvestigativeGroup investigativeGroup;
	protected List<InvestigativeGroup> InvestigativeGroupsList = null;
	protected boolean newEntity = false;
	private List<Authorizable> authorizables = null;
	private String newAuthorizableId;



	@PostConstruct
	public void init() {
		this.ejbInvestigativeGroup.setEntityName("InvestigativeGroup");
	}



	public String submit() {

		// // update officer based on its id
		// if (this.officerWhoCreatedItId != null) {
		// Officer of = (Officer)
		// this.ejbOfficer.getEntity(this.officerWhoCreatedItId, "Officer");
		// this.getInvestigativeGroup().setOfficerWhoCreatedIt(of);
		// }

		if (isNewEntity())
			ejbInvestigativeGroup.add(this.investigativeGroup);
		else
			ejbInvestigativeGroup.save(this.investigativeGroup);
		return "success";
	}



	public void createNewInvestigativeGroup() {
		this.investigativeGroup = new InvestigativeGroup();
		this.setNewEntity(true);
	}



	public void addAuthorizable() {
		Authorizable a = this.ejbAuthorizable.getEntity(Long.parseLong(newAuthorizableId), "Authorizable");
		this.investigativeGroup.addAuthorizable(a);
		this.ejbInvestigativeGroup.save(investigativeGroup);
	}



	public void removeAuthorizable(Authorizable authorizable) {
		this.investigativeGroup.getAuthorizables().remove(authorizable);
		this.ejbInvestigativeGroup.save(investigativeGroup);
	}



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public InvestigativeGroup getInvestigativeGroup() {
		if (this.investigativeGroup != null)
			return this.investigativeGroup;

		if (this.id == null)
			return null;

		this.investigativeGroup = ejbInvestigativeGroup.getEntity(Long.parseLong(this.id));

		// // hold the id of officer
		// if (this.officerWhoCreatedItId == null && this.investigativeGroup !=
		// null
		// && this.investigativeGroup.getOfficerWhoCreatedIt() != null)
		// setOfficerWhoCreatedItId(this.investigativeGroup.getOfficerWhoCreatedIt().getId());

		return this.investigativeGroup;
	}



	public void setInvestigativeGroup(InvestigativeGroup InvestigativeGroup) {
		this.investigativeGroup = InvestigativeGroup;
	}



	public List<InvestigativeGroup> getInvestigativeGroupsList() {
		if (this.InvestigativeGroupsList == null)
			this.InvestigativeGroupsList = ejbInvestigativeGroup.getList();

		return InvestigativeGroupsList;
	}



	public void setInvestigativeGroupsList(List<InvestigativeGroup> list) {
		this.InvestigativeGroupsList = list;
	}



	public boolean isNewEntity() {
		return newEntity;
	}



	public void setNewEntity(boolean newEntity) {
		this.newEntity = newEntity;
	}



	public List<Authorizable> getAuthorizables() {
		if (this.authorizables == null)
			this.authorizables = investigativeGroup.getAuthorizables();

		return authorizables;
	}



	public void setAuthorizables(List<Authorizable> authorizables) {
		this.authorizables = authorizables;
	}



	public String getNewAuthorizableId() {
		return newAuthorizableId;
	}



	public void setNewAuthorizableId(String newAuthorizable) {
		this.newAuthorizableId = newAuthorizable;
	}

}
