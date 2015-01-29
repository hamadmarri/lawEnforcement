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
	private int OffenderProfileId;

	private boolean YoungOffenderBetween17And21Years;
	private boolean CriminalRecordOfTheft;
	private boolean CriminalRecordOfFraud;
	private boolean CriminalRecordOfBurglary;
	private boolean RelationshipWithVictim;
	private boolean UnemployedAtTheTimeOfOffense;
	private boolean Male;
	private boolean FamiliarWithAreaOfOffenseOccurrence;
	private boolean CriminalRecordOfViolence;
	private boolean CriminalRecordOfCommittingDamage;
	private boolean CriminalRecordOfDisorderlyConduct;
	private boolean RecordOfImprisonment;
	private boolean SexualRelatedCriminalRecord;
	private boolean ArmedServices_PastOrPresent;
	private boolean KnewVictim;
	private boolean HistoryOfAbusivenessInPastRelationships;
	private boolean AttemptsOfSuicide;
	private boolean PsychiatricDisorders;
	private boolean RelatedToVictim;
	private boolean BloodRelativeToVictim;
	private boolean TurnedSelfIntoPolice;



	public OffenderProfile() {
		super();
	}



	public int getOffenderProfileId() {
		return OffenderProfileId;
	}



	public void setOffenderProfileId(int offenderProfileId) {
		OffenderProfileId = offenderProfileId;
	}



	public boolean isYoungOffenderBetween17And21Years() {
		return YoungOffenderBetween17And21Years;
	}



	public void setYoungOffenderBetween17And21Years(boolean youngOffenderBetween17And21Years) {
		YoungOffenderBetween17And21Years = youngOffenderBetween17And21Years;
	}



	public boolean isCriminalRecordOfTheft() {
		return CriminalRecordOfTheft;
	}



	public void setCriminalRecordOfTheft(boolean criminalRecordOfTheft) {
		CriminalRecordOfTheft = criminalRecordOfTheft;
	}



	public boolean isCriminalRecordOfFraud() {
		return CriminalRecordOfFraud;
	}



	public void setCriminalRecordOfFraud(boolean criminalRecordOfFraud) {
		CriminalRecordOfFraud = criminalRecordOfFraud;
	}



	public boolean isCriminalRecordOfBurglary() {
		return CriminalRecordOfBurglary;
	}



	public void setCriminalRecordOfBurglary(boolean criminalRecordOfBurglary) {
		CriminalRecordOfBurglary = criminalRecordOfBurglary;
	}



	public boolean isRelationshipWithVictim() {
		return RelationshipWithVictim;
	}



	public void setRelationshipWithVictim(boolean relationshipWithVictim) {
		RelationshipWithVictim = relationshipWithVictim;
	}



	public boolean isUnemployedAtTheTimeOfOffense() {
		return UnemployedAtTheTimeOfOffense;
	}



	public void setUnemployedAtTheTimeOfOffense(boolean unemployedAtTheTimeOfOffense) {
		UnemployedAtTheTimeOfOffense = unemployedAtTheTimeOfOffense;
	}



	public boolean isMale() {
		return Male;
	}



	public void setMale(boolean male) {
		Male = male;
	}



	public boolean isFamiliarWithAreaOfOffenseOccurrence() {
		return FamiliarWithAreaOfOffenseOccurrence;
	}



	public void setFamiliarWithAreaOfOffenseOccurrence(boolean familiarWithAreaOfOffenseOccurrence) {
		FamiliarWithAreaOfOffenseOccurrence = familiarWithAreaOfOffenseOccurrence;
	}



	public boolean isCriminalRecordOfViolence() {
		return CriminalRecordOfViolence;
	}



	public void setCriminalRecordOfViolence(boolean criminalRecordOfViolence) {
		CriminalRecordOfViolence = criminalRecordOfViolence;
	}



	public boolean isCriminalRecordOfCommittingDamage() {
		return CriminalRecordOfCommittingDamage;
	}



	public void setCriminalRecordOfCommittingDamage(boolean criminalRecordOfCommittingDamage) {
		CriminalRecordOfCommittingDamage = criminalRecordOfCommittingDamage;
	}



	public boolean isCriminalRecordOfDisorderlyConduct() {
		return CriminalRecordOfDisorderlyConduct;
	}



	public void setCriminalRecordOfDisorderlyConduct(boolean criminalRecordOfDisorderlyConduct) {
		CriminalRecordOfDisorderlyConduct = criminalRecordOfDisorderlyConduct;
	}



	public boolean isRecordOfImprisonment() {
		return RecordOfImprisonment;
	}



	public void setRecordOfImprisonment(boolean recordOfImprisonment) {
		RecordOfImprisonment = recordOfImprisonment;
	}



	public boolean isSexualRelatedCriminalRecord() {
		return SexualRelatedCriminalRecord;
	}



	public void setSexualRelatedCriminalRecord(boolean sexualRelatedCriminalRecord) {
		SexualRelatedCriminalRecord = sexualRelatedCriminalRecord;
	}



	public boolean isArmedServices_PastOrPresent() {
		return ArmedServices_PastOrPresent;
	}



	public void setArmedServices_PastOrPresent(boolean armedServices_PastOrPresent) {
		ArmedServices_PastOrPresent = armedServices_PastOrPresent;
	}



	public boolean isKnewVictim() {
		return KnewVictim;
	}



	public void setKnewVictim(boolean knewVictim) {
		KnewVictim = knewVictim;
	}



	public boolean isHistoryOfAbusivenessInPastRelationships() {
		return HistoryOfAbusivenessInPastRelationships;
	}



	public void setHistoryOfAbusivenessInPastRelationships(boolean historyOfAbusivenessInPastRelationships) {
		HistoryOfAbusivenessInPastRelationships = historyOfAbusivenessInPastRelationships;
	}



	public boolean isAttemptsOfSuicide() {
		return AttemptsOfSuicide;
	}



	public void setAttemptsOfSuicide(boolean attemptsOfSuicide) {
		AttemptsOfSuicide = attemptsOfSuicide;
	}



	public boolean isPsychiatricDisorders() {
		return PsychiatricDisorders;
	}



	public void setPsychiatricDisorders(boolean psychiatricDisorders) {
		PsychiatricDisorders = psychiatricDisorders;
	}



	public boolean isRelatedToVictim() {
		return RelatedToVictim;
	}



	public void setRelatedToVictim(boolean relatedToVictim) {
		RelatedToVictim = relatedToVictim;
	}



	public boolean isBloodRelativeToVictim() {
		return BloodRelativeToVictim;
	}



	public void setBloodRelativeToVictim(boolean bloodRelativeToVictim) {
		BloodRelativeToVictim = bloodRelativeToVictim;
	}



	public boolean isTurnedSelfIntoPolice() {
		return TurnedSelfIntoPolice;
	}



	public void setTurnedSelfIntoPolice(boolean turnedSelfIntoPolice) {
		TurnedSelfIntoPolice = turnedSelfIntoPolice;
	}

}
