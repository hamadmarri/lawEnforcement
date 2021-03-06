package controllers.management;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import controllers.profile.ControllerProfile;
import security.Authorizable;
import ejbs.AbstractEjb;
import entities.police.Activity;
import entities.police.InvestigativeCase;
import entities.police.Investigator;
import entities.police.Notification;


/**
 * @author hamadalmarri
 * 
 * @Pages
 *        - listActivities.xhtml
 *        - viewActivity.xhtml
 *        - addActivity.xhtml
 *        - editActivity.xhtml
 * 
 * @Relative_Objects
 *                   - Invistigator who owen this Activity
 *                   - InvisigativeCase that this Activity is for
 * 
 */
@ManagedBean(name = "controllerActivity")
@ViewScoped
public class ControllerActivity implements Serializable { 

	private static final long serialVersionUID = 1737896155289958972L; 

	// EJB for Activity object
	@EJB
	protected AbstractEjb<Activity> ejbActivity;

	// EJB for Investigator object
	@EJB
	private AbstractEjb<Investigator> ejbInvestigator;

	// EJB for InvestigativeCase object
	@EJB
	private AbstractEjb<InvestigativeCase> ejbInvestigativeCase;

	@ManagedProperty(value = "#{controllerNotification}")
	private ControllerNotification controllerNotification;

	@ManagedProperty(value = "#{controllerProfile}")
	private ControllerProfile controllerProfile;

	// the id of a Activity object
	protected String id;

	// the Activity object
	protected Activity activity = null;

	// list of Activity objects
	protected List<Activity> list = null;

	// to indicate if the operation is to add
	// new activity or not
	protected boolean newActivity = false;

	// the id of investigator who owen this activity
	private Long investigatorId = null;

	// the id of investigativeCase which is this activity for
	private Long investigativeCaseId = null;



	/**
	 * will be called automatically right after the class is constructed since
	 * it has the PostConstruct annotation
	 */
	@PostConstruct
	public void initAbstract() {
		// at the beginning, set the entitiy name to be Activity
		this.ejbActivity.setEntityName("Activity");
	}



	/**
	 * to submit changes on the Activity object
	 * 
	 * @return "success" which is used for navigation engine to redirect to the
	 *         proper page
	 */
	public String submit() {
		InvestigativeCase invCase = null;

		// update investigator based on its id
		if (this.investigatorId != null) {
			Investigator inv = (Investigator) this.ejbInvestigator.getEntity(this.investigatorId, "Investigator");
			this.getActivity().setInvestigator(inv);
		}

		// update investigativeCase based on its id
		if (this.investigativeCaseId != null) {
			invCase = (InvestigativeCase) this.ejbInvestigativeCase.getEntity(this.investigativeCaseId,
					"InvestigativeCase");
			this.getActivity().setInvestigativeCase(invCase); 

//			this.ejbActivity.setEntityName("Activity");
		}

		// if new object it will add the object to DB,
		// otherwise, it will just update it in DB
		if (isNewActivity()) {
			sendNotification("added activity", invCase);
//			this.ejbActivity.setEntityName("Activity");

			ejbActivity.add(this.activity);
		
			invCase.getActivities().add(getActivity());
			ejbInvestigativeCase.save(invCase);
			
			return "toCase";
		} else {
			ejbActivity.save(this.activity);
		}
		// return "success" for navigation engine

		return "success";
	}



	@SuppressWarnings("unchecked")
	public void sendNotification(String text, InvestigativeCase investigativeCase) {
		Authorizable causedBy = controllerProfile.getAuthorizable();
		Notification n = new Notification(text, causedBy, null, investigativeCase);

		List<? extends Authorizable> authorizables = investigativeCase.getInvestigators();
		controllerNotification.sendNotification((List<Authorizable>) authorizables, n);
	}



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	/**
	 * to initiate new object of Activity. This function will be called from
	 * addActivity.xhtml page at preRenderView phase
	 */
	public void createNewActivity() {
		this.activity = new Activity();
		this.setNewActivity(true);
	}



	/**
	 * it will load the object from DB if it is not loaded yet otherwise, it
	 * will return the Activity object
	 * 
	 * @return the Activity object
	 */
	public Activity getActivity() {

		// if the object was loaded already, just return it
		if (this.activity != null)
			return this.activity;

		// if the id is null do not try to load it from DB, just return null
		if (this.id == null)
			return null;

		// at this point object must be null but id is not,
		// so load it from DB
		this.activity = (Activity) ejbActivity.getEntity(Long.parseLong(this.id), "Activity");

		// hold the id of investigator
		if (this.investigatorId == null && this.activity != null && this.activity.getInvestigator() != null)
			setInvestigatorId(this.activity.getInvestigator().getId());

		// hold the id of investigativeCase
		if (this.investigativeCaseId == null && this.activity != null && this.activity.getInvestigativeCase() != null)
			setInvestigativeCaseId(this.activity.getInvestigativeCase().getId());

		return this.activity;
	}



	public void setActivity(Activity activity) {
		this.activity = activity;
	}



	public List<Activity> getList() {
		if (this.list == null)
			this.list = (List<Activity>) ejbActivity.getList();

		return list;
	}



	public void setList(List<Activity> list) {
		this.list = list;
	}



	public boolean isNewActivity() {
		return newActivity;
	}



	public void setNewActivity(boolean newActivity) {
		this.newActivity = newActivity;
	}



	public Long getInvestigatorId() {
		return investigatorId;
	}



	public void setInvestigatorId(Long investigatorId) {
		this.investigatorId = investigatorId;
	}



	public Long getInvestigativeCaseId() {
		return investigativeCaseId;
	}



	public void setInvestigativeCaseId(Long investigativeCaseId) {
		this.investigativeCaseId = investigativeCaseId;
	}



	public ControllerNotification getControllerNotification() {
		return controllerNotification;
	}



	public void setControllerNotification(ControllerNotification controllerNotification) {
		this.controllerNotification = controllerNotification;
	}



	public ControllerProfile getControllerProfile() {
		return controllerProfile;
	}



	public void setControllerProfile(ControllerProfile controllerProfile) {
		this.controllerProfile = controllerProfile;
	}

}
