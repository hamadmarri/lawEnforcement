package intelligence;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.intelligence.CrimeScene;
import entities.intelligence.OffenderProfile;


//@Startup
@Singleton
public class FillUpDatabase {

	@PersistenceContext(unitName = "lawEnforcementPersistenceUnit")
	private EntityManager em;



	@PostConstruct
	public void fill() {
//		fillUpData();
	}



	public void fillUpData() {
		CrimeScene cs;
		OffenderProfile op;
		int numberOfOffenderVariables = 0; // max is 3
		int numberOfCases = 1000;

		for (int i = 0; i < numberOfCases; i++) {
			cs = new CrimeScene(false, false, false, false, false, false, false, false, false, false, false, false,
					false, false, false, false, false, false, false, false, false, false, false, false, false, false,
					false, false, false, false, false, false, false, false, false, false);

			op = new OffenderProfile(false, false, false, false, false, false, false, false, false, false, false,
					false, false, false, false, false, false, false, false, false, false);

			cs.setOffenderProfile(op);
			
			numberOfOffenderVariables = getNumberOfOffenderVariables();

			createRecord(cs, op, numberOfOffenderVariables);
		}
	}



	public void createRecord(CrimeScene cs, OffenderProfile op, int numberOfOffenderVariables) {
		int randomOffenderVariable = 0; // max 21
		int oldRandom = 0;

		for (int j = 0; j < numberOfOffenderVariables; j++) {

			while (oldRandom == randomOffenderVariable)
				randomOffenderVariable = getRandomOffenderVariable();

			oldRandom = randomOffenderVariable;

			switch (randomOffenderVariable) {
			case 1: // Prior theft
				priorTheft(cs, op);
				break;

			case 2: // Prior burglary
				priorBurglary(cs, op);
				break;

			case 3: // Prior violence
				priorViolence(cs, op);
				break;

			case 4: // Prior damage
				priorDamage(cs, op);
				break;

			case 5: // Prior disorder
				priorDisorder(cs, op);
				break;

			case 6: // Prison
				recordOfImprisonment(cs, op);
				break;

			case 7:
				youngOffender(cs, op);
				break;

			case 8:
				unemployedAtTheTimeOfOffense(cs, op);
				break;

			case 9:
				historyOfSexCrime(cs, op);
				break;

			case 10:
				op.setArmedServices_PastOrPresent(true);
				break;

			case 11:
				op.setFamiliarWithAreaOfOffenseOccurrence(true);
				break;

			case 12:
				male(cs, op);
				break;

			case 13:
				knewVictim(cs, op);
				break;

			case 14:
				historyOfAbuse(cs, op);
				break;

			case 15:
				suicide(cs, op);
				break;

			case 16:
				psychiatricOrSocialProblems(cs, op);
				break;

			case 17:
				priorFraud(cs, op);
				break;

			case 18:
				relatedToVictim(cs, op);
				break;

			case 19:
				relationshipWithVictim(cs, op);
				break;

			case 20:
				bloodRelatedToVictim(cs, op);
				break;

			case 21:
				turnedSelfIntoPolice(cs, op);
				break;

			default:
				break;
			} // switch
		} // for

		// save to database
		em.persist(cs);
	}



	public void priorTheft(CrimeScene cs, OffenderProfile op) {
		op.setCriminalRecordOfTheft(true);
		op.setCriminalRecordOfBurglary(true);
		op.setUnemployedAtTheTimeOfOffense(true);
		op.setTurnedSelfIntoPolice(true);

		// priorBurglary(cs, op);
		// unemployedAtTheTimeOfOffense(cs, op);
		// turnedSelfIntoPolice(cs, op);

		cs.setVictimWasBlindfolded(true);
		cs.setIdentifiablePropertyStolen(true);
		cs.setNonidentifiablePropertyStolen(true);
	}



	public void priorBurglary(CrimeScene cs, OffenderProfile op) {
		op.setCriminalRecordOfBurglary(true);
		op.setCriminalRecordOfViolence(true);
		op.setCriminalRecordOfCommittingDamage(true);
		op.setRecordOfImprisonment(true);
		op.setSexualRelatedCriminalRecord(true);
		op.setMale(true);

		// priorViolence(cs, op);
		// priorDamage(cs, op);
		// recordOfImprisonment(cs, op);
		// historyOfSexCrime(cs, op);
		// male(cs, op);

		cs.setValuablePropertyStolen(true);
	}



	public void priorViolence(CrimeScene cs, OffenderProfile op) {
		op.setCriminalRecordOfViolence(true);
		op.setCriminalRecordOfCommittingDamage(true);

		// priorDamage(cs, op);

		cs.setDeliberateClothingDamaged(true);
		cs.setWoundsCausedByBluntInstrument(true);
	}



	public void priorDamage(CrimeScene cs, OffenderProfile op) {
		op.setCriminalRecordOfCommittingDamage(true);
		op.setCriminalRecordOfDisorderlyConduct(true);
		op.setBloodRelativeToVictim(true);

		// priorDisorder(cs, op);
		// bloodRelatedToVictim(cs, op);
	}



	public void priorDisorder(CrimeScene cs, OffenderProfile op) {
		op.setCriminalRecordOfDisorderlyConduct(true);
	}



	public void youngOffender(CrimeScene cs, OffenderProfile op) {
		op.setYoungOffenderBetween17And21Years(true);
		op.setArmedServices_PastOrPresent(true);
		op.setCriminalRecordOfFraud(true);

		// priorFraud(cs, op);

		cs.setAnalPenetration(true);
		cs.setForeignObjectPenetration(true);
		cs.setBound(true);
	}



	public void priorFraud(CrimeScene cs, OffenderProfile op) {
		op.setCriminalRecordOfFraud(true);
		op.setRelationshipWithVictim(true);

		// relationshipWithVictim(cs, op);

		cs.setGunshotWounds(true);
		cs.setArsonToCrimeSceneOrBody(true);
	}



	public void male(CrimeScene cs, OffenderProfile op) {
		op.setMale(true);

		cs.setFaceNotDeliberatelyHidden(true);
		cs.setWoundsCausedByBluntInstrument(true);
		cs.setSexualCrime(true);
		cs.setVictimDruggedAndOrPoisoned(true);
		cs.setVictimCovered(true);
	}



	public void relatedToVictim(CrimeScene cs, OffenderProfile op) {
		op.setRelatedToVictim(true);

		cs.setVictimPartiallyUndressed(true);
		cs.setStabbingInjuries(true);
		cs.setWoundsToTheLimbs(true);
		cs.setMultipleWoundsDistributedAcrossDifferentBodyParts(true);
		cs.setIdentifiablePropertyStolen(true);
	}



	public void psychiatricOrSocialProblems(CrimeScene cs, OffenderProfile op) {
		op.setPsychiatricDisorders(true);

		cs.setBodyTransported(true);
		cs.setVictimFoundInWater(true);
	}



	public void historyOfAbuse(CrimeScene cs, OffenderProfile op) {
		op.setHistoryOfAbusivenessInPastRelationships(true);
	}



	public void recordOfImprisonment(CrimeScene cs, OffenderProfile op) {
		op.setRecordOfImprisonment(true);
		op.setSexualRelatedCriminalRecord(true);
		op.setMale(true);

		// historyOfSexCrime(cs, op);
		// male(cs, op);

		cs.setForeignObjectPenetration(true);
	}



	public void unemployedAtTheTimeOfOffense(CrimeScene cs, OffenderProfile op) {
		op.setUnemployedAtTheTimeOfOffense(true);
		op.setFamiliarWithAreaOfOffenseOccurrence(true);

		cs.setGunshotWounds(true);
		cs.setSuffocation(true);
	}



	public void historyOfSexCrime(CrimeScene cs, OffenderProfile op) {
		op.setSexualRelatedCriminalRecord(true);
		op.setKnewVictim(true);

		// knewVictim(cs, op);
	}



	public void knewVictim(CrimeScene cs, OffenderProfile op) {
		op.setKnewVictim(true);
		op.setAttemptsOfSuicide(true);
		op.setRelationshipWithVictim(true);
		op.setBloodRelativeToVictim(true);

		// suicide(cs, op);
		// relationshipWithVictim(cs, op);
		// bloodRelatedToVictim(cs, op);

		cs.setBodyHidden(true);
		cs.setBodyTransported(true);
		cs.setVictimFoundAtTheSameSceneWhereTheyWereKilled(true);
	}



	public void relationshipWithVictim(CrimeScene cs, OffenderProfile op) {
		op.setRelationshipWithVictim(true);
		op.setBloodRelativeToVictim(true);

		// bloodRelatedToVictim(cs, op);

		cs.setVictimWasBlindfolded(true);
		cs.setVictimDruggedAndOrPoisoned(true);
	}



	public void suicide(CrimeScene cs, OffenderProfile op) {
		op.setAttemptsOfSuicide(true);
		op.setPsychiatricDisorders(true);

		// psychiatricOrSocialProblems(cs, op);

		cs.setMultipleWoundsDistributedAcrossDifferentBodyParts(true);
	}



	public void bloodRelatedToVictim(CrimeScene cs, OffenderProfile op) {
		op.setBloodRelativeToVictim(true);
		cs.setSuffocation(true);
	}



	public void turnedSelfIntoPolice(CrimeScene cs, OffenderProfile op) {
		op.setTurnedSelfIntoPolice(true);
		cs.setVaginalPenetration(true);
		cs.setFaceUp(true);
		cs.setVictimPartiallyUndressed(true);
		cs.setIdentifiablePropertyStolen(true);
		cs.setOffenderForensicallyAware(true);
		cs.setSexualCrime(true);
		cs.setArsonToCrimeSceneOrBody(true);
	}



	public int getNumberOfOffenderVariables() {
		int n = (int) (Math.random() * 10);

		n = n % 2;
		n++;

		return n;
	}



	public int getRandomOffenderVariable() {
		int n = (int) (Math.random() * 100);

		n = n % 21;
		n++;

		return n;
	}

}
