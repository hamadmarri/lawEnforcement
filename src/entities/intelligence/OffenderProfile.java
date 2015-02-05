package entities.intelligence;

import java.io.Serializable;

import javax.persistence.*;


/**
 * Entity implementation class for Entity: OffenderProfile
 * 
 */
@Entity
public class OffenderProfile implements Serializable {

	private static final long serialVersionUID = 2070383912243398153L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int offenderProfileId;

	private boolean youngOffenderBetween17And21Years;
	private boolean criminalRecordOfTheft;
	private boolean criminalRecordOfFraud;
	private boolean criminalRecordOfBurglary;
	private boolean relationshipWithVictim;
	private boolean unemployedAtTheTimeOfOffense;
	private boolean male;
	private boolean familiarWithAreaOfOffenseOccurrence;
	private boolean criminalRecordOfViolence;
	private boolean criminalRecordOfCommittingDamage;
	private boolean criminalRecordOfDisorderlyConduct;
	private boolean recordOfImprisonment;
	private boolean sexualRelatedCriminalRecord;
	private boolean armedServices_PastOrPresent;
	private boolean knewVictim;
	private boolean historyOfAbusivenessInPastRelationships;
	private boolean attemptsOfSuicide;
	private boolean psychiatricDisorders;
	private boolean relatedToVictim;
	private boolean bloodRelativeToVictim;
	private boolean turnedSelfIntoPolice;

	@OneToOne(mappedBy = "offenderProfile")
	private CrimeScene crimeScene;



	public OffenderProfile() {
		super();

		this.youngOffenderBetween17And21Years = false;
		this.criminalRecordOfTheft = false;
		this.criminalRecordOfFraud = false;
		this.criminalRecordOfBurglary = false;
		this.relationshipWithVictim = false;
		this.unemployedAtTheTimeOfOffense = false;
		this.male = false;
		this.familiarWithAreaOfOffenseOccurrence = false;
		this.criminalRecordOfViolence = false;
		this.criminalRecordOfCommittingDamage = false;
		this.criminalRecordOfDisorderlyConduct = false;
		this.recordOfImprisonment = false;
		this.sexualRelatedCriminalRecord = false;
		this.armedServices_PastOrPresent = false;
		this.knewVictim = false;
		this.historyOfAbusivenessInPastRelationships = false;
		this.attemptsOfSuicide = false;
		this.psychiatricDisorders = false;
		this.relatedToVictim = false;
		this.bloodRelativeToVictim = false;
		this.turnedSelfIntoPolice = false;
	}



	public OffenderProfile(boolean youngOffenderBetween17And21Years, boolean criminalRecordOfTheft,
			boolean criminalRecordOfFraud, boolean criminalRecordOfBurglary, boolean relationshipWithVictim,
			boolean unemployedAtTheTimeOfOffense, boolean male, boolean familiarWithAreaOfOffenseOccurrence,
			boolean criminalRecordOfViolence, boolean criminalRecordOfCommittingDamage,
			boolean criminalRecordOfDisorderlyConduct, boolean recordOfImprisonment,
			boolean sexualRelatedCriminalRecord, boolean armedServices_PastOrPresent, boolean knewVictim,
			boolean historyOfAbusivenessInPastRelationships, boolean attemptsOfSuicide, boolean psychiatricDisorders,
			boolean relatedToVictim, boolean bloodRelativeToVictim, boolean turnedSelfIntoPolice) {
		super();
		this.youngOffenderBetween17And21Years = youngOffenderBetween17And21Years;
		this.criminalRecordOfTheft = criminalRecordOfTheft;
		this.criminalRecordOfFraud = criminalRecordOfFraud;
		this.criminalRecordOfBurglary = criminalRecordOfBurglary;
		this.relationshipWithVictim = relationshipWithVictim;
		this.unemployedAtTheTimeOfOffense = unemployedAtTheTimeOfOffense;
		this.male = male;
		this.familiarWithAreaOfOffenseOccurrence = familiarWithAreaOfOffenseOccurrence;
		this.criminalRecordOfViolence = criminalRecordOfViolence;
		this.criminalRecordOfCommittingDamage = criminalRecordOfCommittingDamage;
		this.criminalRecordOfDisorderlyConduct = criminalRecordOfDisorderlyConduct;
		this.recordOfImprisonment = recordOfImprisonment;
		this.sexualRelatedCriminalRecord = sexualRelatedCriminalRecord;
		this.armedServices_PastOrPresent = armedServices_PastOrPresent;
		this.knewVictim = knewVictim;
		this.historyOfAbusivenessInPastRelationships = historyOfAbusivenessInPastRelationships;
		this.attemptsOfSuicide = attemptsOfSuicide;
		this.psychiatricDisorders = psychiatricDisorders;
		this.relatedToVictim = relatedToVictim;
		this.bloodRelativeToVictim = bloodRelativeToVictim;
		this.turnedSelfIntoPolice = turnedSelfIntoPolice;
	}



	public int getOffenderProfileId() {
		return offenderProfileId;
	}



	public void setOffenderProfileId(int offenderProfileId) {
		this.offenderProfileId = offenderProfileId;
	}



	public boolean getYoungOffenderBetween17And21Years() {
		return youngOffenderBetween17And21Years;
	}



	public void setYoungOffenderBetween17And21Years(boolean youngOffenderBetween17And21Years) {
		this.youngOffenderBetween17And21Years = youngOffenderBetween17And21Years;
	}



	public boolean getCriminalRecordOfTheft() {
		return criminalRecordOfTheft;
	}



	public void setCriminalRecordOfTheft(boolean criminalRecordOfTheft) {
		this.criminalRecordOfTheft = criminalRecordOfTheft;
	}



	public boolean getCriminalRecordOfFraud() {
		return criminalRecordOfFraud;
	}



	public void setCriminalRecordOfFraud(boolean criminalRecordOfFraud) {
		this.criminalRecordOfFraud = criminalRecordOfFraud;
	}



	public boolean getCriminalRecordOfBurglary() {
		return criminalRecordOfBurglary;
	}



	public void setCriminalRecordOfBurglary(boolean criminalRecordOfBurglary) {
		this.criminalRecordOfBurglary = criminalRecordOfBurglary;
	}



	public boolean getRelationshipWithVictim() {
		return relationshipWithVictim;
	}



	public void setRelationshipWithVictim(boolean relationshipWithVictim) {
		this.relationshipWithVictim = relationshipWithVictim;
	}



	public boolean getUnemployedAtTheTimeOfOffense() {
		return unemployedAtTheTimeOfOffense;
	}



	public void setUnemployedAtTheTimeOfOffense(boolean unemployedAtTheTimeOfOffense) {
		this.unemployedAtTheTimeOfOffense = unemployedAtTheTimeOfOffense;
	}



	public boolean getMale() {
		return male;
	}



	public void setMale(boolean male) {
		this.male = male;
	}



	public boolean getFamiliarWithAreaOfOffenseOccurrence() {
		return familiarWithAreaOfOffenseOccurrence;
	}



	public void setFamiliarWithAreaOfOffenseOccurrence(boolean familiarWithAreaOfOffenseOccurrence) {
		this.familiarWithAreaOfOffenseOccurrence = familiarWithAreaOfOffenseOccurrence;
	}



	public boolean getCriminalRecordOfViolence() {
		return criminalRecordOfViolence;
	}



	public void setCriminalRecordOfViolence(boolean criminalRecordOfViolence) {
		this.criminalRecordOfViolence = criminalRecordOfViolence;
	}



	public boolean getCriminalRecordOfCommittingDamage() {
		return criminalRecordOfCommittingDamage;
	}



	public void setCriminalRecordOfCommittingDamage(boolean criminalRecordOfCommittingDamage) {
		this.criminalRecordOfCommittingDamage = criminalRecordOfCommittingDamage;
	}



	public boolean getCriminalRecordOfDisorderlyConduct() {
		return criminalRecordOfDisorderlyConduct;
	}



	public void setCriminalRecordOfDisorderlyConduct(boolean criminalRecordOfDisorderlyConduct) {
		this.criminalRecordOfDisorderlyConduct = criminalRecordOfDisorderlyConduct;
	}



	public boolean getRecordOfImprisonment() {
		return recordOfImprisonment;
	}



	public void setRecordOfImprisonment(boolean recordOfImprisonment) {
		this.recordOfImprisonment = recordOfImprisonment;
	}



	public boolean getSexualRelatedCriminalRecord() {
		return sexualRelatedCriminalRecord;
	}



	public void setSexualRelatedCriminalRecord(boolean sexualRelatedCriminalRecord) {
		this.sexualRelatedCriminalRecord = sexualRelatedCriminalRecord;
	}



	public boolean getArmedServices_PastOrPresent() {
		return armedServices_PastOrPresent;
	}



	public void setArmedServices_PastOrPresent(boolean armedServices_PastOrPresent) {
		this.armedServices_PastOrPresent = armedServices_PastOrPresent;
	}



	public boolean getKnewVictim() {
		return knewVictim;
	}



	public void setKnewVictim(boolean knewVictim) {
		this.knewVictim = knewVictim;
	}



	public boolean getHistoryOfAbusivenessInPastRelationships() {
		return historyOfAbusivenessInPastRelationships;
	}



	public void setHistoryOfAbusivenessInPastRelationships(boolean historyOfAbusivenessInPastRelationships) {
		this.historyOfAbusivenessInPastRelationships = historyOfAbusivenessInPastRelationships;
	}



	public boolean getAttemptsOfSuicide() {
		return attemptsOfSuicide;
	}



	public void setAttemptsOfSuicide(boolean attemptsOfSuicide) {
		this.attemptsOfSuicide = attemptsOfSuicide;
	}



	public boolean getPsychiatricDisorders() {
		return psychiatricDisorders;
	}



	public void setPsychiatricDisorders(boolean psychiatricDisorders) {
		this.psychiatricDisorders = psychiatricDisorders;
	}



	public boolean getRelatedToVictim() {
		return relatedToVictim;
	}



	public void setRelatedToVictim(boolean relatedToVictim) {
		this.relatedToVictim = relatedToVictim;
	}



	public boolean getBloodRelativeToVictim() {
		return bloodRelativeToVictim;
	}



	public void setBloodRelativeToVictim(boolean bloodRelativeToVictim) {
		this.bloodRelativeToVictim = bloodRelativeToVictim;
	}



	public boolean getTurnedSelfIntoPolice() {
		return turnedSelfIntoPolice;
	}



	public void setTurnedSelfIntoPolice(boolean turnedSelfIntoPolice) {
		this.turnedSelfIntoPolice = turnedSelfIntoPolice;
	}



	public CrimeScene getCrimeScene() {
		return crimeScene;
	}



	public void setCrimeScene(CrimeScene crimeScene) {
		this.crimeScene = crimeScene;
	}

}
