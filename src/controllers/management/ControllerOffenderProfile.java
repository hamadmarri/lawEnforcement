package controllers.management;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ejbs.EjbOffenderProfile;
import entities.Relation;
import entities.entries.Person;
import entities.entries.SuspectPerson;
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
	private EjbOffenderProfile ejbOffenderProfile;

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

	private List<SuspectPerson> suspects = null;

	private boolean showSuspects = false;

	private Person victim;



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



	public List<SuspectPerson> getSuspects() {

		if (suspects != null)
			return suspects;

		OffenderProfile op = getOffenderProfile();
		Long victimId = -1L;
		List<Person> persons;

		// to count how many attributes are set
		// it is used to calculate the match percentage
		int attributesCounter = getAttributeCount(op);

		victim = op.getCrimeScene().getVictim();

		if (victim != null)
			victimId = victim.getId();

		suspects = new ArrayList<SuspectPerson>();

		persons = ejbOffenderProfile.getSuspects(op);

		for (Person p : persons) {
			SuspectPerson sp = new SuspectPerson();
			sp.setPerson(p);
			suspects.add(sp);
		}

		// seting match percentage
		setingMatchPercentages(op, victimId, attributesCounter);

		return suspects;
	}



	private void setingMatchPercentages(OffenderProfile op, Long victimId, int attributesCounter) {
		for (SuspectPerson sp : suspects) {
			int matches = 0;
			String description = sp.getPerson().getDescription().toLowerCase();

			if (op.getArmedServices_PastOrPresent() && description.contains("armed") && description.contains("service"))
				matches++;

			if (op.getAttemptsOfSuicide() && description.contains("attempt") && description.contains("suicide"))
				matches++;

			if (victim != null && op.getBloodRelativeToVictim()
					&& isRelationWithVictimWithMatch(sp, victimId, ".*blood.*relat.*"))
				matches++;

			if (op.getCriminalRecordOfBurglary() && description.contains("criminal") && description.contains("record")
					&& description.contains("burglary"))
				matches++;

			if (op.getCriminalRecordOfCommittingDamage() && description.contains("criminal")
					&& description.contains("record") && description.contains("damage"))
				matches++;

			if (op.getCriminalRecordOfDisorderlyConduct() && description.contains("criminal")
					&& description.contains("record") && description.contains("disorder")
					&& description.contains("conduct"))
				matches++;

			if (op.getCriminalRecordOfFraud() && description.contains("criminal") && description.contains("record")
					&& description.contains("fraud"))
				matches++;

			if (op.getCriminalRecordOfTheft() && description.contains("criminal") && description.contains("record")
					&& description.contains("theft"))
				matches++;

			if (op.getCriminalRecordOfViolence() && description.contains("criminal") && description.contains("record")
					&& description.contains("violence"))
				matches++;

			if (op.getFamiliarWithAreaOfOffenseOccurrence() && description.contains("familiar")
					&& description.contains("with") && description.contains("offense") && description.contains("occur"))
				matches++;

			if (op.getHistoryOfAbusivenessInPastRelationships() && description.contains("history")
					&& description.contains("abusiveness") && description.contains("relationship"))
				matches++;

			if (victim != null && op.getKnewVictim() && isRelationWithVictimWithMatch(sp, victimId, ".*kn.w.*"))
				matches++;

			if (op.getMale() && sp.getPerson().getGender().equals("Male"))
				matches++;

			if (op.getPsychiatricDisorders() && description.contains("psych") && description.contains("disorder"))
				matches++;

			if (op.getRecordOfImprisonment() && description.contains("record") && description.contains("imprisonment"))
				matches++;

			if (victim != null && op.getRelatedToVictim() && isRelationWithVictimWithMatch(sp, victimId, ".*related.*"))
				matches++;

			if (victim != null && op.getRelationshipWithVictim()
					&& isRelationWithVictimWithMatch(sp, victimId, ".*relation.*ship.*"))
				matches++;
 
			if (op.getSexualRelatedCriminalRecord() && description.contains("sex") && description.contains("relate")
					&& description.contains("record"))
				matches++;

			if (op.getTurnedSelfIntoPolice() && description.contains("turn") && description.contains("self")
					&& description.contains("to") && description.contains("police"))
				matches++;

			if (op.getUnemployedAtTheTimeOfOffense() && description.contains("unemployed"))
				matches++;

			if (op.getYoungOffenderBetween17And21Years()) {
				Calendar startDate = Calendar.getInstance();
				Calendar endDate = Calendar.getInstance();
				startDate.add(Calendar.YEAR, -22);
				endDate.add(Calendar.YEAR, -17);

				if (sp.getPerson().getDateOfBirth().after(startDate.getTime())
						&& sp.getPerson().getDateOfBirth().before(endDate.getTime()))
					matches++;
			}

			// calc the percentage
			sp.setMatchPercentage((double) matches / (double) attributesCounter);
		}
	}



	public void setSuspects(List<SuspectPerson> suspects) {
		this.suspects = suspects;
	}



	private boolean isRelationWithVictimWithMatch(SuspectPerson sp, Long victimId, String regex) {
		for (Relation r : sp.getPerson().getAllRelations()) {
			if (r.getSomething().getId() == victimId || r.getSomethingElse().getId() == victimId) {
				if (r.getTypeOfRelation().matches(regex)) {
					return true;
				}
			}
		}

		return false;
	}



	private int getAttributeCount(OffenderProfile op) {
		int counter = 0;

		if (op.getArmedServices_PastOrPresent())
			counter++;

		if (op.getAttemptsOfSuicide())
			counter++;

		if (op.getBloodRelativeToVictim())
			counter++;

		if (op.getCriminalRecordOfBurglary())
			counter++;

		if (op.getCriminalRecordOfCommittingDamage())
			counter++;

		if (op.getCriminalRecordOfDisorderlyConduct())
			counter++;

		if (op.getCriminalRecordOfFraud())
			counter++;

		if (op.getCriminalRecordOfTheft())
			counter++;

		if (op.getCriminalRecordOfViolence())
			counter++;

		if (op.getFamiliarWithAreaOfOffenseOccurrence())
			counter++;

		if (op.getHistoryOfAbusivenessInPastRelationships())
			counter++;

		if (op.getKnewVictim())
			counter++;

		if (op.getMale())
			counter++;

		if (op.getPsychiatricDisorders())
			counter++;

		if (op.getRecordOfImprisonment())
			counter++;

		if (op.getRelatedToVictim())
			counter++;

		if (op.getRelationshipWithVictim())
			counter++;

		if (op.getSexualRelatedCriminalRecord())
			counter++;

		if (op.getTurnedSelfIntoPolice())
			counter++;

		if (op.getUnemployedAtTheTimeOfOffense())
			counter++;

		if (op.getYoungOffenderBetween17And21Years())
			counter++;

		return counter;
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



	public boolean isShowSuspects() {
		return showSuspects;
	}



	public void setShowSuspects(boolean showSuspects) {
		this.showSuspects = showSuspects;
	}

}
