package controllers.management;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ejbs.EjbOffenderProfile;
import entities.intelligence.OffenderProfile;


/**
 * @author hamadalmarri
 * 
 * @Pages
 *        - listOffenderProfiles.xhtml
 *        - viewOffenderProfile.xhtml
 *        - addOffenderProfile.xhtml
 *        - editOffenderProfile.xhtml
 * 
 * @Relative_Objects
 *                   - InvisigativeCase/s that this OffenderProfile responsible
 *                   of
 * 
 */
@ManagedBean(name = "controllerOffenderProfile")
@ViewScoped
public class ControllerOffenderProfile implements Serializable {

	private static final long serialVersionUID = -8332230579861778723L;

	// EJB for OffenderProfile object
	@EJB
	EjbOffenderProfile ejbOffenderProfile;

	// the id of a OffenderProfile object
	protected String id;

	// the OffenderProfile object
	protected OffenderProfile offenderProfile = null;

	// list of OffenderProfile objects
	protected List<OffenderProfile> offenderProfilesList = null;

	// to indicate if the operation is to add
	// new activity or not
	protected boolean newEntity = false;

	// OffenderProfile id who will be added to investigative case
	private String newOffenderProfileId;



	/**
	 * will be called automatically right after the class is constructed since
	 * it has the PostConstruct annotation
	 */
	@PostConstruct
	public void init() {
	}



	/**
	 * to submit changes on the OffenderProfile object
	 * 
	 * @return "success" which is used for navigation engine to redirect to the
	 *         proper page
	 */
	public String submit() {

		// if new object it will add the object to DB,
		// otherwise, it will just update it in DB
		if (isNewEntity())
			ejbOffenderProfile.add(this.offenderProfile);
		else
			ejbOffenderProfile.save(this.offenderProfile);

		// return "success" for navigation engine
		return "success";
	}



	/**
	 * to initiate new object of OffenderProfile. This function will be called
	 * from
	 * addOffenderProfile.xhtml page at preRenderView phase
	 */
	public void createNewOffenderProfile() {
		this.offenderProfile = new OffenderProfile();
		this.setNewEntity(true);
	}



	/**
	 * it will load the object from DB if it is not loaded yet otherwise, it
	 * will return the OffenderProfile object
	 * 
	 * @return the OffenderProfile object
	 */
	public OffenderProfile getOffenderProfile() {

		// if the object was loaded already, just return it
		if (this.offenderProfile != null)
			return this.offenderProfile;

		// if the id is null do not try to load it from DB, just return null
		if (this.id == null)
			return null;

		// at this point object must be null but id is not,
		// so load it from DB
		this.offenderProfile = ejbOffenderProfile.getEntity(Long.parseLong(this.id));

		return this.offenderProfile;
	}



	public void setOffenderProfile(OffenderProfile offenderProfile) {
		this.offenderProfile = offenderProfile;
	}



	public List<OffenderProfile> getOffenderProfilesList() {
		if (this.offenderProfilesList == null)
			this.offenderProfilesList = ejbOffenderProfile.getList();

		return offenderProfilesList;
	}



	public void setOffenderProfilesList(List<OffenderProfile> list) {
		this.offenderProfilesList = list;
	}



	public boolean isNewEntity() {
		return newEntity;
	}



	public String getNewOffenderProfileId() {
		return newOffenderProfileId;
	}



	public void setNewOffenderProfileId(String newOffenderProfileId) {
		this.newOffenderProfileId = newOffenderProfileId;
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
