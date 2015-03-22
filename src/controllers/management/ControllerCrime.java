package controllers.management;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ejbs.AbstractEjb;
import ejbs.EjbCriminalRecord;
import entities.entries.Crime;
import entities.entries.CriminalRecord;
import entities.events.IncidentReport;


/**
 * @author hamadalmarri
 * 
 * @Pages
 *        - listCrimes.xhtml
 *        - viewCrime.xhtml
 *        - addCrime.xhtml
 *        - editCrime.xhtml
 * 
 * @Relative_Objects
 *                   - InvisigativeCase/s that this Crime responsible
 *                   of
 * 
 */
@ManagedBean(name = "controllerCrime")
@ViewScoped
public class ControllerCrime implements Serializable {

	private static final long serialVersionUID = 7094250779326075491L;

	// EJB for Crime object
	@EJB
	EjbCriminalRecord ejbCriminalRecord;

	@EJB
	AbstractEjb<IncidentReport> ejbIncidentReport;

	// the id of a Crime object
	protected String id;

	// the Crime object
	protected Crime crime = null;

	// list of Crime objects
	protected List<Crime> CrimesList = null;

	// to indicate if the operation is to add
	// new activity or not
	protected boolean newEntity = false;

	// Crime id who will be added to investigative case
	private String newCrimeId;

	private Long criminalRecordId = null;
	private Long incidentReportId = null;



	/**
	 * will be called automatically right after the class is constructed since
	 * it has the PostConstruct annotation
	 */
	@PostConstruct
	public void init() {
		ejbIncidentReport.setEntityName("IncidentReport");
	}



	/**
	 * to submit changes on the Crime object
	 * 
	 * @return "success" which is used for navigation engine to redirect to the
	 *         proper page
	 */
	public String submit() {

		if (criminalRecordId != null) {
			CriminalRecord cr = ejbCriminalRecord.getEntity(criminalRecordId);
			crime.setCriminalRecord(cr);
		}

		if (incidentReportId != null) {
			IncidentReport ir = ejbIncidentReport.getEntity(incidentReportId);
			crime.setIncidentReport(ir);
		}

		// if new object it will add the object to DB,
		// otherwise, it will just update it in DB
		if (isNewEntity())
			ejbCriminalRecord.addCrime(this.crime);
		else
			ejbCriminalRecord.saveCrime(this.crime);

		// return "success" for navigation engine
		return "success";
	}



	/**
	 * to initiate new object of Crime. This function will be called
	 * from
	 * addCrime.xhtml page at preRenderView phase
	 */
	public void createNewCrime() {
		this.crime = new Crime();
		this.setNewEntity(true);
	}



	/**
	 * it will load the object from DB if it is not loaded yet otherwise, it
	 * will return the Crime object
	 * 
	 * @return the Crime object
	 */
	public Crime getCrime() {

		// if the object was loaded already, just return it
		if (this.crime != null)
			return this.crime;

		// if the id is null do not try to load it from DB, just return null
		if (this.id == null)
			return null;

		// at this point object must be null but id is not,
		// so load it from DB
		this.crime = ejbCriminalRecord.getCrime(Long.parseLong(this.id));

		if (crime.getCriminalRecord() != null)
			criminalRecordId = crime.getCriminalRecord().getId();

		if (crime.getIncidentReport() != null)
			incidentReportId = crime.getIncidentReport().getId();

		return this.crime;
	}



	public void setCrime(Crime Crime) {
		this.crime = Crime;
	}



	public List<Crime> getCrimesList() {
		if (this.CrimesList == null)
			this.CrimesList = ejbCriminalRecord.getAllCrimes();

		return CrimesList;
	}



	public void setCrimesList(List<Crime> list) {
		this.CrimesList = list;
	}



	public boolean isNewEntity() {
		return newEntity;
	}



	public String getNewCrimeId() {
		return newCrimeId;
	}



	public void setNewCrimeId(String newCrimeId) {
		this.newCrimeId = newCrimeId;
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



	public Long getCriminalRecordId() {
		return criminalRecordId;
	}



	public void setCriminalRecordId(Long criminalRecordId) {
		this.criminalRecordId = criminalRecordId;
	}



	public Long getIncidentReportId() {
		return incidentReportId;
	}



	public void setIncidentReportId(Long incidentReportId) {
		this.incidentReportId = incidentReportId;
	}

}
