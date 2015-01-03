package controllers.management;

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

	// the id of a InvestigativeGroup object
	protected String id;

	// the InvestigativeGroup object
	protected InvestigativeGroup investigativeGroup;

	// list of InvestigativeGroup objects
	protected List<InvestigativeGroup> InvestigativeGroupsList = null;

	// to indicate if the operation is to add
	// new activity or not
	protected boolean newEntity = false;

	// list of Authorizable objects
	private List<Authorizable> authorizables = null;

	// the id of authorizable to be added to this group
	private String newAuthorizableId;



	/**
	 * will be called automatically right after the class is constructed since
	 * it has the PostConstruct annotation
	 */
	@PostConstruct
	public void init() {
		// at the beginning, set the entitiy name to be InvestigativeGroup
		this.ejbInvestigativeGroup.setEntityName("InvestigativeGroup");
	}



	/**
	 * to submit changes on the InvestigativeGroup object
	 * 
	 * @return "success" which is used for navigation engine to redirect to the
	 *         proper page
	 */
	public String submit() {

		// if new object it will add the object to DB,
		// otherwise, it will just update it in DB
		if (isNewEntity())
			ejbInvestigativeGroup.add(this.investigativeGroup);
		else
			ejbInvestigativeGroup.save(this.investigativeGroup);

		// return "success" for navigation engine
		return "success";
	}



	/**
	 * to initiate new object of InvestigativeGroup. This function will be
	 * called from
	 * addInvestigativeGroup.xhtml page at preRenderView phase
	 */
	public void createNewInvestigativeGroup() {
		this.investigativeGroup = new InvestigativeGroup();
		this.setNewEntity(true);
	}



	/**
	 * It is called from viewInvestigativeGroup.xhtml
	 * to add an Authorizable object to this group
	 */
	public void addAuthorizable() {
		Authorizable a = this.ejbAuthorizable.getEntity(Long.parseLong(newAuthorizableId), "Authorizable");
		this.investigativeGroup.addAuthorizable(a);
		this.ejbInvestigativeGroup.save(investigativeGroup);
	}



	/**
	 * It will remove authorizable from this group
	 * 
	 * @param authorizable
	 *            to be removed from this group
	 */
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



	/**
	 * it will load the object from DB if it is not loaded yet otherwise, it
	 * will return the InvestigativeGroup object
	 * 
	 * @return the InvestigativeGroup object
	 */
	public InvestigativeGroup getInvestigativeGroup() {

		// if the object was loaded already, just return it
		if (this.investigativeGroup != null)
			return this.investigativeGroup;

		// if the id is null do not try to load it from DB, just return null
		if (this.id == null)
			return null;

		// at this point object must be null but id is not,
		// so load it from DB
		this.investigativeGroup = ejbInvestigativeGroup.getEntity(Long.parseLong(this.id));

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
