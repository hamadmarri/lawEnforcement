package controllers.management;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ejbs.EjbNotification;
import entities.police.Notification;


/**
 * @author hamadalmarri
 * 
 * @Pages
 *        - listNotifications.xhtml
 *        - viewNotification.xhtml
 * 
 * 
 */
@ManagedBean(name = "controllerNotification")
@ViewScoped
public class ControllerNotification implements Serializable {

	private static final long serialVersionUID = -7098717911400834042L;

	// EJB for Notification object
	@EJB
	EjbNotification ejbNotification;

	// the id of a Notification object
	protected String id;

	// the Notification object
	protected Notification Notification = null;

	// list of Notification objects
	protected List<Notification> NotificationsList = null;

	// to indicate if the operation is to add
	// new activity or not
	protected boolean newEntity = false;



	/**
	 * to submit changes on the Notification object
	 * 
	 * @return "success" which is used for navigation engine to redirect to the
	 *         proper page
	 */
	public String submit() {

		// if new object it will add the object to DB,
		// otherwise, it will just update it in DB
		if (isNewEntity())
			ejbNotification.add(this.Notification);
		else
			ejbNotification.save(this.Notification);

		// return "success" for navigation engine
		return "success";
	}



	/**
	 * to initiate new object of Notification. This function will be called from
	 * addNotification.xhtml page at preRenderView phase
	 */
	public void createNewNotification() {
		this.Notification = new Notification();
		this.setNewEntity(true);
	}



	/**
	 * it will load the object from DB if it is not loaded yet otherwise, it
	 * will return the Notification object
	 * 
	 * @return the Notification object
	 */
	public Notification getNotification() {

		// if the object was loaded already, just return it
		if (this.Notification != null)
			return this.Notification;

		// if the id is null do not try to load it from DB, just return null
		if (this.id == null)
			return null;

		// at this point object must be null but id is not,
		// so load it from DB
		this.Notification = ejbNotification.getEntity(Long.parseLong(this.id));

		return this.Notification;
	}



	public void setNotification(Notification Notification) {
		this.Notification = Notification;
	}



	public List<Notification> getNotificationsList() {
		if (this.NotificationsList == null)
			this.NotificationsList = ejbNotification.getList();

		return NotificationsList;
	}



	public void setNotificationsList(List<Notification> list) {
		this.NotificationsList = list;
	}



	public boolean isNewEntity() {
		return newEntity;
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
