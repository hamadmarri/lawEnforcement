package controllers.management;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ejbs.AbstractEjb;
import ejbs.EjbInvestigativeCase;
import ejbs.EjbInvestigator;
import entities.police.InvestigativeCase;
import entities.police.Investigator;


/**
 * @author hamadalmarri
 * 
 * @Pages
 *        - listInvestigators.xhtml
 *        - viewInvestigator.xhtml
 *        - addInvestigator.xhtml
 *        - editInvestigator.xhtml
 *        - viewInvestigativeCase.xhtml, but through listInvestigators.xhtml by
 *        including
 * 
 * @Relative_Objects
 *                   - InvisigativeCase/s that this investigator responsible of
 * 
 */
@ManagedBean(name = "controllerInvestigator")
@ViewScoped
public class ControllerInvestigator implements Serializable {

	private static final long serialVersionUID = -8332230579861778723L;

	// EJB for Investigator object
	@EJB
	EjbInvestigator ejbInvestigator;

	// EJB for InvestigativeCase object
	@EJB
	EjbInvestigativeCase ejbInvestigativeCase;

	// the id of a Investigator object
	protected String id;

	// the Investigator object
	protected Investigator investigator = null;

	// list of Investigator objects
	protected List<Investigator> investigatorsList = null;

	// to indicate if the operation is to add
	// new activity or not
	protected boolean newEntity = false;

	// investigator id who will be added to investigative case
	private String newInvestigatorId;



	/**
	 * will be called automatically right after the class is constructed since
	 * it has the PostConstruct annotation
	 */
	@PostConstruct
	public void init() {
		// at the beginning, set the entitiy name to be Investigator
		this.ejbInvestigator.setEntityName("Investigator");
	}



	/**
	 * to submit changes on the Investigator object
	 * 
	 * @return "success" which is used for navigation engine to redirect to the
	 *         proper page
	 */
	public String submit() {

		// if new object it will add the object to DB,
		// otherwise, it will just update it in DB
		if (isNewEntity())
			ejbInvestigator.add(this.investigator);
		else
			ejbInvestigator.save(this.investigator);

		// return "success" for navigation engine
		return "success";
	}



	/**
	 * to initiate new object of Investigator. This function will be called from
	 * addInvestigator.xhtml page at preRenderView phase
	 */
	public void createNewInvestigator() {
		this.investigator = new Investigator();
		this.setNewEntity(true);
	}



	/**
	 * Add an Investigator to handle an investigative case. This function will
	 * called from viewInvestigativeCase.xhtml page, but through
	 * listInvestigators.xhtml, which is
	 * included in viewInvestigativeCase.xhtml
	 * 
	 * @param icArg
	 *            is the investigative case that the investigator will be
	 *            handling
	 */
	public String addInvestigatorForInvestigativeCase(InvestigativeCase icArg) {

		// load InvestigativeCase entity from DB
		InvestigativeCase ic = this.ejbInvestigativeCase.getEntity(icArg.getId());

		// load Investigator entity from DB
		Investigator inv = this.ejbInvestigator.getEntity(Long.parseLong(newInvestigatorId));

		// add the investigator to the investigative case
		ic.addInvestigator(inv);

		// set status to pending
		ic.setStatus("Pending");

		// save investigative case
		ic = this.ejbInvestigativeCase.save(ic);

		// add the investigative case to the investigator
		inv.addInvestigativeCase(ic);

		// save investigator
		this.ejbInvestigator.save(inv);

		this.newInvestigatorId = null;
		
		return "success";
	}



	/**
	 * it will load the object from DB if it is not loaded yet otherwise, it
	 * will return the Investigator object
	 * 
	 * @return the Investigator object
	 */
	public Investigator getInvestigator() {

		// if the object was loaded already, just return it
		if (this.investigator != null)
			return this.investigator;

		// if the id is null do not try to load it from DB, just return null
		if (this.id == null)
			return null;

		// at this point object must be null but id is not,
		// so load it from DB
		this.investigator = ejbInvestigator.getEntity(Long.parseLong(this.id));

		return this.investigator;
	}



	public void setInvestigator(Investigator investigator) {
		this.investigator = investigator;
	}



	public List<Investigator> getInvestigatorsList() {
		if (this.investigatorsList == null)
			this.investigatorsList = ejbInvestigator.getList();

		return investigatorsList;
	}



	public void setInvestigatorsList(List<Investigator> list) {
		this.investigatorsList = list;
	}



	public boolean isNewEntity() {
		return newEntity;
	}



	public String getNewInvestigatorId() {
		return newInvestigatorId;
	}



	public void setNewInvestigatorId(String newInvestigatorId) {
		this.newInvestigatorId = newInvestigatorId;
	}



	public void setNewEntity(boolean newEntity) {
		this.newEntity = newEntity;
	}



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}

}
