package controllers.management;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ejbs.EjbCriminalRecord;
import entities.entries.CriminalRecord;


/**
 * @author hamadalmarri
 * 
 * @Pages
 *        - listCriminalRecords.xhtml
 *        - viewCriminalRecord.xhtml
 *        - addCriminalRecord.xhtml
 *        - editCriminalRecord.xhtml
 * 
 * @Relative_Objects
 *                   - InvisigativeCase/s that this CriminalRecord responsible
 *                   of
 * 
 */
@ManagedBean(name = "controllerCriminalRecord")
@ViewScoped
public class ControllerCriminalRecord implements Serializable {

	private static final long serialVersionUID = -8332230579861778723L;

	// EJB for CriminalRecord object
	@EJB
	EjbCriminalRecord ejbCriminalRecord;

	// // EJB for Person object
	// @EJB
	// protected AbstractEjb<Person> ejbPerson;

	// the id of a CriminalRecord object
	protected String id;

	// the CriminalRecord object
	protected CriminalRecord CriminalRecord = null;

	// list of CriminalRecord objects
	protected List<CriminalRecord> CriminalRecordsList = null;

	// to indicate if the operation is to add
	// new activity or not
	protected boolean newEntity = false;

	// CriminalRecord id who will be added to investigative case
	private String newCriminalRecordId;



	/**
	 * will be called automatically right after the class is constructed since
	 * it has the PostConstruct annotation
	 */
	@PostConstruct
	public void init() {
	}



	/**
	 * to submit changes on the CriminalRecord object
	 * 
	 * @return "success" which is used for navigation engine to redirect to the
	 *         proper page
	 */
	public String submit() {

		// if new object it will add the object to DB,
		// otherwise, it will just update it in DB
		if (isNewEntity())
			ejbCriminalRecord.add(this.CriminalRecord);
		else
			ejbCriminalRecord.save(this.CriminalRecord);

		// return "success" for navigation engine
		return "success";
	}



	/**
	 * to initiate new object of CriminalRecord. This function will be called
	 * from
	 * addCriminalRecord.xhtml page at preRenderView phase
	 */
	public void createNewCriminalRecord() {
		this.CriminalRecord = new CriminalRecord();
		this.setNewEntity(true);
	}



	/**
	 * it will load the object from DB if it is not loaded yet otherwise, it
	 * will return the CriminalRecord object
	 * 
	 * @return the CriminalRecord object
	 */
	public CriminalRecord getCriminalRecord() {

		// if the object was loaded already, just return it
		if (this.CriminalRecord != null)
			return this.CriminalRecord;

		// if the id is null do not try to load it from DB, just return null
		if (this.id == null)
			return null;

		// at this point object must be null but id is not,
		// so load it from DB
		this.CriminalRecord = ejbCriminalRecord.getEntity(Long.parseLong(this.id));

		return this.CriminalRecord;
	}



	public void setCriminalRecord(CriminalRecord CriminalRecord) {
		this.CriminalRecord = CriminalRecord;
	}



	public List<CriminalRecord> getCriminalRecordsList() {
		if (this.CriminalRecordsList == null)
			this.CriminalRecordsList = ejbCriminalRecord.getList();

		return CriminalRecordsList;
	}



	public void setCriminalRecordsList(List<CriminalRecord> list) {
		this.CriminalRecordsList = list;
	}



	public boolean isNewEntity() {
		return newEntity;
	}



	public String getNewCriminalRecordId() {
		return newCriminalRecordId;
	}



	public void setNewCriminalRecordId(String newCriminalRecordId) {
		this.newCriminalRecordId = newCriminalRecordId;
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
