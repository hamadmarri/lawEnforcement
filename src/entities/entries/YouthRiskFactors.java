package entities.entries;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class YouthRiskFactors implements Serializable {

	private static final long serialVersionUID = 4978442941135304567L;

	@Id
	@GeneratedValue
	private Long id;

	@OneToOne(mappedBy = "youthRiskFactors")
	private Person person;

	@OneToOne(cascade = CascadeType.MERGE)
	private CriminalRecord criminalRecord;

	// Individual factors
	private boolean pregnancyAndDeliveryComplications = false;
	private boolean lowRestingHeartRate = false;
	private boolean internalizingDisorders = false;
	private boolean hyperactivityConcentrationProblems_Restlessness_RiskTaking = false;
	private boolean aggressiveness = false;
	private boolean earlyInitiationOfViolentBehavior = false;
	private boolean involvementInOtherFormsOfAntisocialBehavior = false;
	private boolean beliefs_AttitudesFavorableToDeviantOrAntisocialBehavior = false;

	// Family factors
	private boolean parentalCriminality = false;
	private boolean childMaltreatment = false;
	private boolean poorFamilyManagementPractices = false;
	private boolean lowLevelsOfParentalInvolvement = false;
	private boolean poorFamilyBondingAndFamilyConflict = false;
	private boolean parentalAttitudesFavorableToSubstanceUseAndViolence = false;
	private boolean parentchildSeparation = false;

	// School factors
	private boolean academicFailure = false;
	private boolean lowBondingToSchool = false;
	private boolean truancyAndDroppingOutOfSchool = false;
	private boolean frequentSchoolTransitions = false;

	// Peer-related factors
	private boolean delinquentSiblings = false;
	private boolean delinquentPeers = false;
	private boolean gangMembership = false;

	// Community and neighborhood factors
	private boolean poverty = false;
	private boolean communityDisorganization = false;
	private boolean availabilityOfDrugsAndFirearms = false;
	private boolean neighborhoodAdultsInvolvedInCrime = false;
	private boolean exposureToViolenceAndRacialPrejudice = false;



	public YouthRiskFactors() {
		super();
	}



	public YouthRiskFactors(CriminalRecord criminalRecord) {
		super();
		this.criminalRecord = criminalRecord;
	}



	public YouthRiskFactors(boolean pregnancyAndDeliveryComplications, boolean lowRestingHeartRate,
			boolean internalizingDisorders, boolean hyperactivityConcentrationProblems_Restlessness_RiskTaking,
			boolean aggressiveness, boolean earlyInitiationOfViolentBehavior,
			boolean involvementInOtherFormsOfAntisocialBehavior,
			boolean beliefs_AttitudesFavorableToDeviantOrAntisocialBehavior, boolean parentalCriminality,
			boolean childMaltreatment, boolean poorFamilyManagementPractices, boolean lowLevelsOfParentalInvolvement,
			boolean poorFamilyBondingAndFamilyConflict, boolean parentalAttitudesFavorableToSubstanceUseAndViolence,
			boolean parentchildSeparation, boolean academicFailure, boolean lowBondingToSchool,
			boolean truancyAndDroppingOutOfSchool, boolean frequentSchoolTransitions, boolean delinquentSiblings,
			boolean delinquentPeers, boolean gangMembership, boolean poverty, boolean communityDisorganization,
			boolean availabilityOfDrugsAndFirearms, boolean neighborhoodAdultsInvolvedInCrime,
			boolean exposureToViolenceAndRacialPrejudice) {
		super();
		this.pregnancyAndDeliveryComplications = pregnancyAndDeliveryComplications;
		this.lowRestingHeartRate = lowRestingHeartRate;
		this.internalizingDisorders = internalizingDisorders;
		this.hyperactivityConcentrationProblems_Restlessness_RiskTaking = hyperactivityConcentrationProblems_Restlessness_RiskTaking;
		this.aggressiveness = aggressiveness;
		this.earlyInitiationOfViolentBehavior = earlyInitiationOfViolentBehavior;
		this.involvementInOtherFormsOfAntisocialBehavior = involvementInOtherFormsOfAntisocialBehavior;
		this.beliefs_AttitudesFavorableToDeviantOrAntisocialBehavior = beliefs_AttitudesFavorableToDeviantOrAntisocialBehavior;
		this.parentalCriminality = parentalCriminality;
		this.childMaltreatment = childMaltreatment;
		this.poorFamilyManagementPractices = poorFamilyManagementPractices;
		this.lowLevelsOfParentalInvolvement = lowLevelsOfParentalInvolvement;
		this.poorFamilyBondingAndFamilyConflict = poorFamilyBondingAndFamilyConflict;
		this.parentalAttitudesFavorableToSubstanceUseAndViolence = parentalAttitudesFavorableToSubstanceUseAndViolence;
		this.parentchildSeparation = parentchildSeparation;
		this.academicFailure = academicFailure;
		this.lowBondingToSchool = lowBondingToSchool;
		this.truancyAndDroppingOutOfSchool = truancyAndDroppingOutOfSchool;
		this.frequentSchoolTransitions = frequentSchoolTransitions;
		this.delinquentSiblings = delinquentSiblings;
		this.delinquentPeers = delinquentPeers;
		this.gangMembership = gangMembership;
		this.poverty = poverty;
		this.communityDisorganization = communityDisorganization;
		this.availabilityOfDrugsAndFirearms = availabilityOfDrugsAndFirearms;
		this.neighborhoodAdultsInvolvedInCrime = neighborhoodAdultsInvolvedInCrime;
		this.exposureToViolenceAndRacialPrejudice = exposureToViolenceAndRacialPrejudice;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public Person getPerson() {
		return person;
	}



	public void setPerson(Person person) {
		this.person = person;
	}



	public boolean getPregnancyAndDeliveryComplications() {
		return pregnancyAndDeliveryComplications;
	}



	public void setPregnancyAndDeliveryComplications(boolean pregnancyAndDeliveryComplications) {
		this.pregnancyAndDeliveryComplications = pregnancyAndDeliveryComplications;
	}



	public boolean getLowRestingHeartRate() {
		return lowRestingHeartRate;
	}



	public void setLowRestingHeartRate(boolean lowRestingHeartRate) {
		this.lowRestingHeartRate = lowRestingHeartRate;
	}



	public boolean getInternalizingDisorders() {
		return internalizingDisorders;
	}



	public void setInternalizingDisorders(boolean internalizingDisorders) {
		this.internalizingDisorders = internalizingDisorders;
	}



	public boolean getHyperactivityConcentrationProblems_Restlessness_RiskTaking() {
		return hyperactivityConcentrationProblems_Restlessness_RiskTaking;
	}



	public void setHyperactivityConcentrationProblems_Restlessness_RiskTaking(
			boolean hyperactivityConcentrationProblems_Restlessness_RiskTaking) {
		this.hyperactivityConcentrationProblems_Restlessness_RiskTaking = hyperactivityConcentrationProblems_Restlessness_RiskTaking;
	}



	public boolean getAggressiveness() {
		return aggressiveness;
	}



	public void setAggressiveness(boolean aggressiveness) {
		this.aggressiveness = aggressiveness;
	}



	public boolean getEarlyInitiationOfViolentBehavior() {
		return earlyInitiationOfViolentBehavior;
	}



	public void setEarlyInitiationOfViolentBehavior(boolean earlyInitiationOfViolentBehavior) {
		this.earlyInitiationOfViolentBehavior = earlyInitiationOfViolentBehavior;
	}



	public boolean getInvolvementInOtherFormsOfAntisocialBehavior() {
		return involvementInOtherFormsOfAntisocialBehavior;
	}



	public void setInvolvementInOtherFormsOfAntisocialBehavior(boolean involvementInOtherFormsOfAntisocialBehavior) {
		this.involvementInOtherFormsOfAntisocialBehavior = involvementInOtherFormsOfAntisocialBehavior;
	}



	public boolean getBeliefs_AttitudesFavorableToDeviantOrAntisocialBehavior() {
		return beliefs_AttitudesFavorableToDeviantOrAntisocialBehavior;
	}



	public void setBeliefs_AttitudesFavorableToDeviantOrAntisocialBehavior(
			boolean beliefs_AttitudesFavorableToDeviantOrAntisocialBehavior) {
		this.beliefs_AttitudesFavorableToDeviantOrAntisocialBehavior = beliefs_AttitudesFavorableToDeviantOrAntisocialBehavior;
	}



	public boolean getParentalCriminality() {
		return parentalCriminality;
	}



	public void setParentalCriminality(boolean parentalCriminality) {
		this.parentalCriminality = parentalCriminality;
	}



	public boolean getChildMaltreatment() {
		return childMaltreatment;
	}



	public void setChildMaltreatment(boolean childMaltreatment) {
		this.childMaltreatment = childMaltreatment;
	}



	public boolean getPoorFamilyManagementPractices() {
		return poorFamilyManagementPractices;
	}



	public void setPoorFamilyManagementPractices(boolean poorFamilyManagementPractices) {
		this.poorFamilyManagementPractices = poorFamilyManagementPractices;
	}



	public boolean getLowLevelsOfParentalInvolvement() {
		return lowLevelsOfParentalInvolvement;
	}



	public void setLowLevelsOfParentalInvolvement(boolean lowLevelsOfParentalInvolvement) {
		this.lowLevelsOfParentalInvolvement = lowLevelsOfParentalInvolvement;
	}



	public boolean getPoorFamilyBondingAndFamilyConflict() {
		return poorFamilyBondingAndFamilyConflict;
	}



	public void setPoorFamilyBondingAndFamilyConflict(boolean poorFamilyBondingAndFamilyConflict) {
		this.poorFamilyBondingAndFamilyConflict = poorFamilyBondingAndFamilyConflict;
	}



	public boolean getParentalAttitudesFavorableToSubstanceUseAndViolence() {
		return parentalAttitudesFavorableToSubstanceUseAndViolence;
	}



	public void setParentalAttitudesFavorableToSubstanceUseAndViolence(
			boolean parentalAttitudesFavorableToSubstanceUseAndViolence) {
		this.parentalAttitudesFavorableToSubstanceUseAndViolence = parentalAttitudesFavorableToSubstanceUseAndViolence;
	}



	public boolean getParentchildSeparation() {
		return parentchildSeparation;
	}



	public void setParentchildSeparation(boolean parentchildSeparation) {
		this.parentchildSeparation = parentchildSeparation;
	}



	public boolean getAcademicFailure() {
		return academicFailure;
	}



	public void setAcademicFailure(boolean academicFailure) {
		this.academicFailure = academicFailure;
	}



	public boolean getLowBondingToSchool() {
		return lowBondingToSchool;
	}



	public void setLowBondingToSchool(boolean lowBondingToSchool) {
		this.lowBondingToSchool = lowBondingToSchool;
	}



	public boolean getTruancyAndDroppingOutOfSchool() {
		return truancyAndDroppingOutOfSchool;
	}



	public void setTruancyAndDroppingOutOfSchool(boolean truancyAndDroppingOutOfSchool) {
		this.truancyAndDroppingOutOfSchool = truancyAndDroppingOutOfSchool;
	}



	public boolean getFrequentSchoolTransitions() {
		return frequentSchoolTransitions;
	}



	public void setFrequentSchoolTransitions(boolean frequentSchoolTransitions) {
		this.frequentSchoolTransitions = frequentSchoolTransitions;
	}



	public boolean getDelinquentSiblings() {
		return delinquentSiblings;
	}



	public void setDelinquentSiblings(boolean delinquentSiblings) {
		this.delinquentSiblings = delinquentSiblings;
	}



	public boolean getDelinquentPeers() {
		return delinquentPeers;
	}



	public void setDelinquentPeers(boolean delinquentPeers) {
		this.delinquentPeers = delinquentPeers;
	}



	public boolean getGangMembership() {
		return gangMembership;
	}



	public void setGangMembership(boolean gangMembership) {
		this.gangMembership = gangMembership;
	}



	public boolean getPoverty() {
		return poverty;
	}



	public void setPoverty(boolean poverty) {
		this.poverty = poverty;
	}



	public boolean getCommunityDisorganization() {
		return communityDisorganization;
	}



	public void setCommunityDisorganization(boolean communityDisorganization) {
		this.communityDisorganization = communityDisorganization;
	}



	public boolean getAvailabilityOfDrugsAndFirearms() {
		return availabilityOfDrugsAndFirearms;
	}



	public void setAvailabilityOfDrugsAndFirearms(boolean availabilityOfDrugsAndFirearms) {
		this.availabilityOfDrugsAndFirearms = availabilityOfDrugsAndFirearms;
	}



	public boolean getNeighborhoodAdultsInvolvedInCrime() {
		return neighborhoodAdultsInvolvedInCrime;
	}



	public void setNeighborhoodAdultsInvolvedInCrime(boolean neighborhoodAdultsInvolvedInCrime) {
		this.neighborhoodAdultsInvolvedInCrime = neighborhoodAdultsInvolvedInCrime;
	}



	public boolean getExposureToViolenceAndRacialPrejudice() {
		return exposureToViolenceAndRacialPrejudice;
	}



	public void setExposureToViolenceAndRacialPrejudice(boolean exposureToViolenceAndRacialPrejudice) {
		this.exposureToViolenceAndRacialPrejudice = exposureToViolenceAndRacialPrejudice;
	}



	public CriminalRecord getCriminalRecord() {
		return criminalRecord;
	}



	public void setCriminalRecord(CriminalRecord criminalRecord) {
		this.criminalRecord = criminalRecord;
	}



	public static void convertYouthRiskFactorsToArray(YouthRiskFactors yrf, double[] factorsArray) {
		factorsArray[0] = yrf.getAcademicFailure() ? 1 : 0;
		factorsArray[1] = yrf.getAggressiveness() ? 1 : 0;
		factorsArray[2] = yrf.getAvailabilityOfDrugsAndFirearms() ? 1 : 0;
		factorsArray[3] = yrf.getBeliefs_AttitudesFavorableToDeviantOrAntisocialBehavior() ? 1 : 0;
		factorsArray[4] = yrf.getChildMaltreatment() ? 1 : 0;
		factorsArray[5] = yrf.getCommunityDisorganization() ? 1 : 0;
		factorsArray[6] = yrf.getDelinquentPeers() ? 1 : 0;
		factorsArray[7] = yrf.getDelinquentSiblings() ? 1 : 0;
		factorsArray[8] = yrf.getEarlyInitiationOfViolentBehavior() ? 1 : 0;
		factorsArray[9] = yrf.getExposureToViolenceAndRacialPrejudice() ? 1 : 0;
		factorsArray[10] = yrf.getFrequentSchoolTransitions() ? 1 : 0;
		factorsArray[11] = yrf.getGangMembership() ? 1 : 0;
		factorsArray[12] = yrf.getHyperactivityConcentrationProblems_Restlessness_RiskTaking() ? 1 : 0;
		factorsArray[13] = yrf.getInternalizingDisorders() ? 1 : 0;
		factorsArray[14] = yrf.getInvolvementInOtherFormsOfAntisocialBehavior() ? 1 : 0;
		factorsArray[15] = yrf.getLowBondingToSchool() ? 1 : 0;
		factorsArray[16] = yrf.getLowLevelsOfParentalInvolvement() ? 1 : 0;
		factorsArray[17] = yrf.getLowRestingHeartRate() ? 1 : 0;
		factorsArray[18] = yrf.getNeighborhoodAdultsInvolvedInCrime() ? 1 : 0;
		factorsArray[19] = yrf.getParentalAttitudesFavorableToSubstanceUseAndViolence() ? 1 : 0;
		factorsArray[20] = yrf.getParentalCriminality() ? 1 : 0;
		factorsArray[21] = yrf.getParentchildSeparation() ? 1 : 0;
		factorsArray[22] = yrf.getPoorFamilyBondingAndFamilyConflict() ? 1 : 0;
		factorsArray[23] = yrf.getPoorFamilyManagementPractices() ? 1 : 0;
		factorsArray[24] = yrf.getPoverty() ? 1 : 0;
		factorsArray[25] = yrf.getPregnancyAndDeliveryComplications() ? 1 : 0;
		factorsArray[26] = yrf.getTruancyAndDroppingOutOfSchool() ? 1 : 0;
	}

}
