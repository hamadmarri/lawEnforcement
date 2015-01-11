package controllers.management;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ejbs.AbstractEjb;
import ejbs.EjbOfficer;
import entities.Relatable;
import entities.events.Event;
import entities.police.Officer;


/**
 * @author hamadalmarri
 * 
 * @Pages
 *        - listOfficers.xhtml
 *        - viewOfficer.xhtml
 *        - addOfficer.xhtml
 *        - editOfficer.xhtml
 * 
 * @Relative_Objects
 *                   - Event object that this officer created
 * 
 */
@ManagedBean(name = "controllerOfficer")
@ViewScoped
public class ControllerOfficer implements Serializable {

	private static final long serialVersionUID = 7703146094170945295L;

	// EJB for Officer object
	@EJB
	protected EjbOfficer ejbOfficer;

	// EJB for Relatable object
	@EJB
	private AbstractEjb<Relatable> ejbRelatable;

	// the id of a Officer object
	protected String id;

	// the Officer object
	protected Officer officer;

	// list of Officer objects
	protected List<Officer> officersList = null;

	// to indicate if the operation is to add
	// new Officer or not
	protected boolean newEntity = false;

	// the id of officer to be added to an Event
	private String officerId;



	/**
	 * will be called automatically right after the class is constructed since
	 * it has the PostConstruct annotation
	 */
	@PostConstruct
	public void init() {
		// at the beginning, set the entitiy name to be Officer
		this.ejbOfficer.setEntityName("Officer");
	}



	/**
	 * to submit changes on the Officer object
	 * 
	 * @return "success" which is used for navigation engine to redirect to the
	 *         proper page
	 */
	public String submit() {

		// if new object it will add the object to DB,
		// otherwise, it will just update it in DB
		if (isNewEntity())
			ejbOfficer.add(this.officer);
		else
			ejbOfficer.save(this.officer);

		// return "success" for navigation engine
		return "success";
	}



	/**
	 * to initiate new object of Officer. This function will be called from
	 * addOfficer.xhtml page at preRenderView phase
	 */
	public void createNewOfficer() {
		this.officer = new Officer();
		this.setNewEntity(true);
	}



	/**
	 * Will relate this Officer with Event entity
	 * 
	 * @param e
	 *            Event that is initiated by this officer
	 */
	public void addOfficerForEvent(Event e) {

		// load Officer entity from DB
		Officer of = this.ejbOfficer.getEntity(Long.parseLong(officerId));

		// add the event to this officer's responsiblity
		of.addEventResponsibleFor(e);

		// add the officer to the Event
		e.addOfficerResponsibleFor(of);

		// save officer
		this.ejbOfficer.save(of);

		// save event
		this.ejbRelatable.save(e);

		this.officerId = null;
	}



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	/**
	 * it will load the object from DB if it is not loaded yet otherwise, it
	 * will return the Officer object
	 * 
	 * @return the Officer object
	 */
	public Officer getOfficer() {

		// if the object was loaded already, just return it
		if (this.officer != null)
			return this.officer;

		// if the id is null do not try to load it from DB, just return null
		if (this.id == null)
			return null;

		// at this point object must be null but id is not,
		// so load it from DB
		this.officer = ejbOfficer.getEntity(Long.parseLong(this.id));

		return this.officer;
	}



	public void setOfficer(Officer Officer) {
		this.officer = Officer;
	}



	public List<Officer> getOfficersList() {
		if (this.officersList == null)
			this.officersList = ejbOfficer.getList();

		return officersList;
	}



	public void setOfficersList(List<Officer> list) {
		this.officersList = list;
	}



	public boolean isNewEntity() {
		return newEntity;
	}



	public void setNewEntity(boolean newEntity) {
		this.newEntity = newEntity;
	}



	public String getOfficerId() {
		return officerId;
	}



	public void setOfficerId(String officerId) {
		this.officerId = officerId;
	}

}
