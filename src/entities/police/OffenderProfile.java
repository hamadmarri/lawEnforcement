package entities.police;

import java.io.Serializable;

import javax.persistence.*;


/**
 * Entity implementation class for Entity: OffenderProfile
 * 
 */
@Entity
@NamedQueries({
		@NamedQuery(name = "OffenderProfile.findAll", query = "select o from OffenderProfile o"),
		@NamedQuery(name = "OffenderProfile.findById", query = "select o from OffenderProfile o WHERE o.offenderProfileId = :id") })
public class OffenderProfile implements Serializable {

	private static final long serialVersionUID = 2070383912243398153L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long offenderProfileId;

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



	public Long getOffenderProfileId() {
		return offenderProfileId;
	}



	public void setOffenderProfileId(Long offenderProfileId) {
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



	// TODO: may need to be synchronized
	public static void convertOffenderProfileToArray(OffenderProfile op, double[] outputs) {
		outputs[0] = op.getArmedServices_PastOrPresent() ? 1 : 0;
		outputs[1] = op.getAttemptsOfSuicide() ? 1 : 0;
		outputs[2] = op.getBloodRelativeToVictim() ? 1 : 0;
		outputs[3] = op.getCriminalRecordOfBurglary() ? 1 : 0;
		outputs[4] = op.getCriminalRecordOfCommittingDamage() ? 1 : 0;
		outputs[5] = op.getCriminalRecordOfDisorderlyConduct() ? 1 : 0;
		outputs[6] = op.getCriminalRecordOfFraud() ? 1 : 0;
		outputs[7] = op.getCriminalRecordOfTheft() ? 1 : 0;
		outputs[8] = op.getCriminalRecordOfViolence() ? 1 : 0;
		outputs[9] = op.getFamiliarWithAreaOfOffenseOccurrence() ? 1 : 0;
		outputs[10] = op.getHistoryOfAbusivenessInPastRelationships() ? 1 : 0;
		outputs[11] = op.getKnewVictim() ? 1 : 0;
		outputs[12] = op.getMale() ? 1 : 0;
		outputs[13] = op.getPsychiatricDisorders() ? 1 : 0;
		outputs[14] = op.getRecordOfImprisonment() ? 1 : 0;
		outputs[15] = op.getRelatedToVictim() ? 1 : 0;
		outputs[16] = op.getRelationshipWithVictim() ? 1 : 0;
		outputs[17] = op.getSexualRelatedCriminalRecord() ? 1 : 0;
		outputs[18] = op.getTurnedSelfIntoPolice() ? 1 : 0;
		outputs[19] = op.getUnemployedAtTheTimeOfOffense() ? 1 : 0;
		outputs[20] = op.getYoungOffenderBetween17And21Years() ? 1 : 0;
	}



	// TODO: may need to be synchronized
	public static OffenderProfile convertArrayToOffenderProfile(double[] outputs) {
		OffenderProfile op = new OffenderProfile();

		if (Math.round(outputs[0]) == 1)
			op.setArmedServices_PastOrPresent(true);
		else
			op.setArmedServices_PastOrPresent(false);

		if (Math.round(outputs[1]) == 1)
			op.setAttemptsOfSuicide(true);
		else
			op.setAttemptsOfSuicide(false);

		if (Math.round(outputs[2]) == 1)
			op.setBloodRelativeToVictim(true);
		else
			op.setBloodRelativeToVictim(false);

		if (Math.round(outputs[3]) == 1)
			op.setCriminalRecordOfBurglary(true);
		else
			op.setCriminalRecordOfBurglary(false);

		if (Math.round(outputs[4]) == 1)
			op.setCriminalRecordOfCommittingDamage(true);
		else
			op.setCriminalRecordOfCommittingDamage(false);

		if (Math.round(outputs[5]) == 1)
			op.setCriminalRecordOfDisorderlyConduct(true);
		else
			op.setCriminalRecordOfDisorderlyConduct(false);

		if (Math.round(outputs[6]) == 1)
			op.setCriminalRecordOfFraud(true);
		else
			op.setCriminalRecordOfFraud(false);

		if (Math.round(outputs[7]) == 1)
			op.setCriminalRecordOfTheft(true);
		else
			op.setCriminalRecordOfTheft(false);

		if (Math.round(outputs[8]) == 1)
			op.setCriminalRecordOfViolence(true);
		else
			op.setCriminalRecordOfViolence(false);

		if (Math.round(outputs[9]) == 1)
			op.setFamiliarWithAreaOfOffenseOccurrence(true);
		else
			op.setFamiliarWithAreaOfOffenseOccurrence(false);

		if (Math.round(outputs[10]) == 1)
			op.setHistoryOfAbusivenessInPastRelationships(true);
		else
			op.setHistoryOfAbusivenessInPastRelationships(false);

		if (Math.round(outputs[11]) == 1)
			op.setKnewVictim(true);
		else
			op.setKnewVictim(false);

		if (Math.round(outputs[12]) == 1)
			op.setMale(true);
		else
			op.setMale(false);

		if (Math.round(outputs[13]) == 1)
			op.setPsychiatricDisorders(true);
		else
			op.setPsychiatricDisorders(false);

		if (Math.round(outputs[14]) == 1)
			op.setRecordOfImprisonment(true);
		else
			op.setRecordOfImprisonment(false);

		if (Math.round(outputs[15]) == 1)
			op.setRelatedToVictim(true);
		else
			op.setRelatedToVictim(false);

		if (Math.round(outputs[16]) == 1)
			op.setRelationshipWithVictim(true);
		else
			op.setRelationshipWithVictim(false);

		if (Math.round(outputs[17]) == 1)
			op.setSexualRelatedCriminalRecord(true);
		else
			op.setSexualRelatedCriminalRecord(false);

		if (Math.round(outputs[18]) == 1)
			op.setTurnedSelfIntoPolice(true);
		else
			op.setTurnedSelfIntoPolice(false);

		if (Math.round(outputs[19]) == 1)
			op.setUnemployedAtTheTimeOfOffense(true);
		else
			op.setUnemployedAtTheTimeOfOffense(false);

		if (Math.round(outputs[20]) == 1)
			op.setYoungOffenderBetween17And21Years(true);
		else
			op.setYoungOffenderBetween17And21Years(false);

		return op;
	}
}
