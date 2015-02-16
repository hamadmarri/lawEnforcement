package controllers.management;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ejbs.EjbCrimeScene;
import entities.intelligence.CrimeScene;
import entities.intelligence.OffenderProfile;


/**
 * @author hamadalmarri
 * 
 * @Pages
 *        - listCrimeScenes.xhtml
 *        - viewCrimeScene.xhtml
 *        - addCrimeScene.xhtml
 *        - editCrimeScene.xhtml
 * 
 * @Relative_Objects
 *                   - InvisigativeCase/s that this CrimeScene responsible of
 * 
 */
@ManagedBean(name = "controllerCrimeScene")
@ViewScoped
public class ControllerCrimeScene implements Serializable {

	private static final long serialVersionUID = -8332230579861778723L;

	// EJB for CrimeScene object
	@EJB
	EjbCrimeScene ejbCrimeScene;

	// EJB for InvestigativeCase object
	// @EJB
	// EjbInvestigativeCase ejbInvestigativeCase;

	// the id of a CrimeScene object
	protected String id;

	// the CrimeScene object
	protected CrimeScene CrimeScene = null;

	// list of CrimeScene objects
	protected List<CrimeScene> CrimeScenesList = null;

	// to indicate if the operation is to add
	// new activity or not
	protected boolean newEntity = false;

	// CrimeScene id who will be added to investigative case
	private String newCrimeSceneId;

	private boolean showSuggestedOP = false;



	/**
	 * will be called automatically right after the class is constructed since
	 * it has the PostConstruct annotation
	 */
	@PostConstruct
	public void init() {
	}



	/**
	 * to submit changes on the CrimeScene object
	 * 
	 * @return "success" which is used for navigation engine to redirect to the
	 *         proper page
	 */
	public String submit() {

		// if new object it will add the object to DB,
		// otherwise, it will just update it in DB
		if (isNewEntity())
			ejbCrimeScene.add(this.CrimeScene);
		else
			ejbCrimeScene.save(this.CrimeScene);

		// return "success" for navigation engine
		return "success";
	}



	/**
	 * to initiate new object of CrimeScene. This function will be called from
	 * addCrimeScene.xhtml page at preRenderView phase
	 */
	public void createNewCrimeScene() {
		this.CrimeScene = new CrimeScene();
		this.setNewEntity(true);
	}



	public void linkOffenderProfile(OffenderProfile op) {
		CrimeScene cs = getCrimeScene();
		cs.setOffenderProfile(op);
		ejbCrimeScene.save(cs);
		showSuggestedOP = false;
	}



	/**
	 * it will load the object from DB if it is not loaded yet otherwise, it
	 * will return the CrimeScene object
	 * 
	 * @return the CrimeScene object
	 */
	public CrimeScene getCrimeScene() {

		// if the object was loaded already, just return it
		if (this.CrimeScene != null)
			return this.CrimeScene;

		// if the id is null do not try to load it from DB, just return null
		if (this.id == null)
			return null;

		// at this point object must be null but id is not,
		// so load it from DB
		this.CrimeScene = ejbCrimeScene.getEntity(Long.parseLong(this.id));

		return this.CrimeScene;
	}



	public void setCrimeScene(CrimeScene CrimeScene) {
		this.CrimeScene = CrimeScene;
	}



	public List<CrimeScene> getCrimeScenesList() {
		if (this.CrimeScenesList == null)
			this.CrimeScenesList = ejbCrimeScene.getList();

		return CrimeScenesList;
	}



	public void setCrimeScenesList(List<CrimeScene> list) {
		this.CrimeScenesList = list;
	}



	public boolean isNewEntity() {
		return newEntity;
	}



	public String getNewCrimeSceneId() {
		return newCrimeSceneId;
	}



	public void setNewCrimeSceneId(String newCrimeSceneId) {
		this.newCrimeSceneId = newCrimeSceneId;
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



	public boolean isShowSuggestedOP() {
		return showSuggestedOP;
	}



	public void setShowSuggestedOP(boolean showSuggestedOP) {
		this.showSuggestedOP = showSuggestedOP;
	}

}
