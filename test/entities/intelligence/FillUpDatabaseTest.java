package entities.intelligence;

import static org.junit.Assert.*;
import intelligence.FillUpDatabaseWithCrimeScenesAndOffenderProfiles;

import org.junit.Test;

import entities.police.CrimeScene;
import entities.police.OffenderProfile;


public class FillUpDatabaseTest {

	FillUpDatabaseWithCrimeScenesAndOffenderProfiles fudb = new FillUpDatabaseWithCrimeScenesAndOffenderProfiles();



	@Test
	public void testGetNumberOfOffenderVariables() {
		int numberOfOffenderVariables;

		for (int i = 0; i < 100000; i++) {
			numberOfOffenderVariables = fudb.getNumberOfOffenderVariables();
			assertTrue(numberOfOffenderVariables > 0 && numberOfOffenderVariables <= 3);
		}
	}



	@Test
	public void testGetRandomOffenderVariable() {
		int randomOffenderVariable;

		for (int i = 0; i < 100000; i++) {
			randomOffenderVariable = fudb.getRandomOffenderVariable();
			assertTrue(randomOffenderVariable > 0 && randomOffenderVariable <= 21);
		}
	}



	@Test
	public void priorTheftTest() {
		CrimeScene cs = new CrimeScene();
		OffenderProfile op = new OffenderProfile();
		fudb.priorTheft(cs, op);

		assertTrue(op.getCriminalRecordOfTheft());
		assertTrue(op.getCriminalRecordOfBurglary());
		assertFalse(op.getCriminalRecordOfViolence());
		assertFalse(op.getCriminalRecordOfCommittingDamage());
		assertFalse(op.getCriminalRecordOfDisorderlyConduct());
		assertFalse(op.getRecordOfImprisonment());
		assertFalse(op.getYoungOffenderBetween17And21Years());
		assertTrue(op.getUnemployedAtTheTimeOfOffense());
		assertFalse(op.getSexualRelatedCriminalRecord());
		assertFalse(op.getArmedServices_PastOrPresent());
		assertFalse(op.getFamiliarWithAreaOfOffenseOccurrence());
		assertFalse(op.getMale());
		assertFalse(op.getKnewVictim());
		assertFalse(op.getHistoryOfAbusivenessInPastRelationships());
		assertFalse(op.getAttemptsOfSuicide());
		assertFalse(op.getPsychiatricDisorders());
		assertFalse(op.getCriminalRecordOfFraud());
		assertFalse(op.getRelatedToVictim());
		assertFalse(op.getRelationshipWithVictim());
		assertFalse(op.getBloodRelativeToVictim());
		assertTrue(op.getTurnedSelfIntoPolice());

		assertFalse(cs.getAnalPenetration());
		assertFalse(cs.getArsonToCrimeSceneOrBody());
		assertFalse(cs.getBodyHidden());
		assertFalse(cs.getBodyTransported());
		assertFalse(cs.getBound());
		assertFalse(cs.getDeliberateClothingDamaged());
		assertFalse(cs.getFaceNotDeliberatelyHidden());
		assertFalse(cs.getFaceUp());
		assertFalse(cs.getForeignObjectPenetration());
		assertFalse(cs.getGunshotWounds());
		assertTrue(cs.getIdentifiablePropertyStolen());
		assertFalse(cs.getManualInjuries());
		assertFalse(cs.getMultipleWoundsDistributedAcrossDifferentBodyParts());
		assertFalse(cs.getMultipleWoundsToOneBodyArea());
		assertTrue(cs.getNonidentifiablePropertyStolen());
		assertFalse(cs.getOffenderForensicallyAware());
		assertFalse(cs.getSexualCrime());
		assertFalse(cs.getStabbingInjuries());
		assertFalse(cs.getSuffocation());
		assertFalse(cs.getVaginalPenetration());
		assertFalse(cs.getValuablePropertyStolen());
		assertFalse(cs.getVictimCovered());
		assertFalse(cs.getVictimDruggedAndOrPoisoned());
		assertFalse(cs.getVictimFoundAtTheSameSceneWhereTheyWereKilled());
		assertFalse(cs.getVictimFoundInWater());
		assertFalse(cs.getVictimNaked());
		assertFalse(cs.getVictimPartiallyUndressed());
		assertTrue(cs.getVictimWasBlindfolded());
		assertFalse(cs.getWeaponBroughtToScene());
		assertFalse(cs.getWeaponFromTheScene());
		assertFalse(cs.getWoundsCausedByBluntInstrument());
		assertFalse(cs.getWoundsToTheFace());
		assertFalse(cs.getWoundsToTheHead());
		assertFalse(cs.getWoundsToTheLimbs());
		assertFalse(cs.getWoundsToTheNeck());
		assertFalse(cs.getWoundsToTheTorso());
	}



	@Test
	public void priorBurglaryTest() {
		CrimeScene cs = new CrimeScene();
		OffenderProfile op = new OffenderProfile();
		fudb.priorBurglary(cs, op);

		assertFalse(op.getCriminalRecordOfTheft());
		assertTrue(op.getCriminalRecordOfBurglary());
		assertTrue(op.getCriminalRecordOfViolence());
		assertTrue(op.getCriminalRecordOfCommittingDamage());
		assertFalse(op.getCriminalRecordOfDisorderlyConduct());
		assertTrue(op.getRecordOfImprisonment());
		assertFalse(op.getYoungOffenderBetween17And21Years());
		assertFalse(op.getUnemployedAtTheTimeOfOffense());
		assertTrue(op.getSexualRelatedCriminalRecord());
		assertFalse(op.getArmedServices_PastOrPresent());
		assertFalse(op.getFamiliarWithAreaOfOffenseOccurrence());
		assertTrue(op.getMale());
		assertFalse(op.getKnewVictim());
		assertFalse(op.getHistoryOfAbusivenessInPastRelationships());
		assertFalse(op.getAttemptsOfSuicide());
		assertFalse(op.getPsychiatricDisorders());
		assertFalse(op.getCriminalRecordOfFraud());
		assertFalse(op.getRelatedToVictim());
		assertFalse(op.getRelationshipWithVictim());
		assertFalse(op.getBloodRelativeToVictim());
		assertFalse(op.getTurnedSelfIntoPolice());

		assertFalse(cs.getAnalPenetration());
		assertFalse(cs.getArsonToCrimeSceneOrBody());
		assertFalse(cs.getBodyHidden());
		assertFalse(cs.getBodyTransported());
		assertFalse(cs.getBound());
		assertFalse(cs.getDeliberateClothingDamaged());
		assertFalse(cs.getFaceNotDeliberatelyHidden());
		assertFalse(cs.getFaceUp());
		assertFalse(cs.getForeignObjectPenetration());
		assertFalse(cs.getGunshotWounds());
		assertFalse(cs.getIdentifiablePropertyStolen());
		assertFalse(cs.getManualInjuries());
		assertFalse(cs.getMultipleWoundsDistributedAcrossDifferentBodyParts());
		assertFalse(cs.getMultipleWoundsToOneBodyArea());
		assertFalse(cs.getNonidentifiablePropertyStolen());
		assertFalse(cs.getOffenderForensicallyAware());
		assertFalse(cs.getSexualCrime());
		assertFalse(cs.getStabbingInjuries());
		assertFalse(cs.getSuffocation());
		assertFalse(cs.getVaginalPenetration());
		assertTrue(cs.getValuablePropertyStolen());
		assertFalse(cs.getVictimCovered());
		assertFalse(cs.getVictimDruggedAndOrPoisoned());
		assertFalse(cs.getVictimFoundAtTheSameSceneWhereTheyWereKilled());
		assertFalse(cs.getVictimFoundInWater());
		assertFalse(cs.getVictimNaked());
		assertFalse(cs.getVictimPartiallyUndressed());
		assertFalse(cs.getVictimWasBlindfolded());
		assertFalse(cs.getWeaponBroughtToScene());
		assertFalse(cs.getWeaponFromTheScene());
		assertFalse(cs.getWoundsCausedByBluntInstrument());
		assertFalse(cs.getWoundsToTheFace());
		assertFalse(cs.getWoundsToTheHead());
		assertFalse(cs.getWoundsToTheLimbs());
		assertFalse(cs.getWoundsToTheNeck());
		assertFalse(cs.getWoundsToTheTorso());
	}



	@Test
	public void priorViolenceTest() {
		CrimeScene cs = new CrimeScene();
		OffenderProfile op = new OffenderProfile();
		fudb.priorViolence(cs, op);

		assertFalse(op.getCriminalRecordOfTheft());
		assertFalse(op.getCriminalRecordOfBurglary());
		assertTrue(op.getCriminalRecordOfViolence());
		assertTrue(op.getCriminalRecordOfCommittingDamage());
		assertFalse(op.getCriminalRecordOfDisorderlyConduct());
		assertFalse(op.getRecordOfImprisonment());
		assertFalse(op.getYoungOffenderBetween17And21Years());
		assertFalse(op.getUnemployedAtTheTimeOfOffense());
		assertFalse(op.getSexualRelatedCriminalRecord());
		assertFalse(op.getArmedServices_PastOrPresent());
		assertFalse(op.getFamiliarWithAreaOfOffenseOccurrence());
		assertFalse(op.getMale());
		assertFalse(op.getKnewVictim());
		assertFalse(op.getHistoryOfAbusivenessInPastRelationships());
		assertFalse(op.getAttemptsOfSuicide());
		assertFalse(op.getPsychiatricDisorders());
		assertFalse(op.getCriminalRecordOfFraud());
		assertFalse(op.getRelatedToVictim());
		assertFalse(op.getRelationshipWithVictim());
		assertFalse(op.getBloodRelativeToVictim());
		assertFalse(op.getTurnedSelfIntoPolice());

		assertFalse(cs.getAnalPenetration());
		assertFalse(cs.getArsonToCrimeSceneOrBody());
		assertFalse(cs.getBodyHidden());
		assertFalse(cs.getBodyTransported());
		assertFalse(cs.getBound());
		assertTrue(cs.getDeliberateClothingDamaged());
		assertFalse(cs.getFaceNotDeliberatelyHidden());
		assertFalse(cs.getFaceUp());
		assertFalse(cs.getForeignObjectPenetration());
		assertFalse(cs.getGunshotWounds());
		assertFalse(cs.getIdentifiablePropertyStolen());
		assertFalse(cs.getManualInjuries());
		assertFalse(cs.getMultipleWoundsDistributedAcrossDifferentBodyParts());
		assertFalse(cs.getMultipleWoundsToOneBodyArea());
		assertFalse(cs.getNonidentifiablePropertyStolen());
		assertFalse(cs.getOffenderForensicallyAware());
		assertFalse(cs.getSexualCrime());
		assertFalse(cs.getStabbingInjuries());
		assertFalse(cs.getSuffocation());
		assertFalse(cs.getVaginalPenetration());
		assertFalse(cs.getValuablePropertyStolen());
		assertFalse(cs.getVictimCovered());
		assertFalse(cs.getVictimDruggedAndOrPoisoned());
		assertFalse(cs.getVictimFoundAtTheSameSceneWhereTheyWereKilled());
		assertFalse(cs.getVictimFoundInWater());
		assertFalse(cs.getVictimNaked());
		assertFalse(cs.getVictimPartiallyUndressed());
		assertFalse(cs.getVictimWasBlindfolded());
		assertFalse(cs.getWeaponBroughtToScene());
		assertFalse(cs.getWeaponFromTheScene());
		assertTrue(cs.getWoundsCausedByBluntInstrument());
		assertFalse(cs.getWoundsToTheFace());
		assertFalse(cs.getWoundsToTheHead());
		assertFalse(cs.getWoundsToTheLimbs());
		assertFalse(cs.getWoundsToTheNeck());
		assertFalse(cs.getWoundsToTheTorso());
	}



	@Test
	public void priorDamageTest() {
		CrimeScene cs = new CrimeScene();
		OffenderProfile op = new OffenderProfile();
		fudb.priorDamage(cs, op);

		assertFalse(op.getCriminalRecordOfTheft());
		assertFalse(op.getCriminalRecordOfBurglary());
		assertFalse(op.getCriminalRecordOfViolence());
		assertTrue(op.getCriminalRecordOfCommittingDamage());
		assertTrue(op.getCriminalRecordOfDisorderlyConduct());
		assertFalse(op.getRecordOfImprisonment());
		assertFalse(op.getYoungOffenderBetween17And21Years());
		assertFalse(op.getUnemployedAtTheTimeOfOffense());
		assertFalse(op.getSexualRelatedCriminalRecord());
		assertFalse(op.getArmedServices_PastOrPresent());
		assertFalse(op.getFamiliarWithAreaOfOffenseOccurrence());
		assertFalse(op.getMale());
		assertFalse(op.getKnewVictim());
		assertFalse(op.getHistoryOfAbusivenessInPastRelationships());
		assertFalse(op.getAttemptsOfSuicide());
		assertFalse(op.getPsychiatricDisorders());
		assertFalse(op.getCriminalRecordOfFraud());
		assertFalse(op.getRelatedToVictim());
		assertFalse(op.getRelationshipWithVictim());
		assertTrue(op.getBloodRelativeToVictim());
		assertFalse(op.getTurnedSelfIntoPolice());

		assertFalse(cs.getAnalPenetration());
		assertFalse(cs.getArsonToCrimeSceneOrBody());
		assertFalse(cs.getBodyHidden());
		assertFalse(cs.getBodyTransported());
		assertFalse(cs.getBound());
		assertFalse(cs.getDeliberateClothingDamaged());
		assertFalse(cs.getFaceNotDeliberatelyHidden());
		assertFalse(cs.getFaceUp());
		assertFalse(cs.getForeignObjectPenetration());
		assertFalse(cs.getGunshotWounds());
		assertFalse(cs.getIdentifiablePropertyStolen());
		assertFalse(cs.getManualInjuries());
		assertFalse(cs.getMultipleWoundsDistributedAcrossDifferentBodyParts());
		assertFalse(cs.getMultipleWoundsToOneBodyArea());
		assertFalse(cs.getNonidentifiablePropertyStolen());
		assertFalse(cs.getOffenderForensicallyAware());
		assertFalse(cs.getSexualCrime());
		assertFalse(cs.getStabbingInjuries());
		assertFalse(cs.getSuffocation());
		assertFalse(cs.getVaginalPenetration());
		assertFalse(cs.getValuablePropertyStolen());
		assertFalse(cs.getVictimCovered());
		assertFalse(cs.getVictimDruggedAndOrPoisoned());
		assertFalse(cs.getVictimFoundAtTheSameSceneWhereTheyWereKilled());
		assertFalse(cs.getVictimFoundInWater());
		assertFalse(cs.getVictimNaked());
		assertFalse(cs.getVictimPartiallyUndressed());
		assertFalse(cs.getVictimWasBlindfolded());
		assertFalse(cs.getWeaponBroughtToScene());
		assertFalse(cs.getWeaponFromTheScene());
		assertFalse(cs.getWoundsCausedByBluntInstrument());
		assertFalse(cs.getWoundsToTheFace());
		assertFalse(cs.getWoundsToTheHead());
		assertFalse(cs.getWoundsToTheLimbs());
		assertFalse(cs.getWoundsToTheNeck());
		assertFalse(cs.getWoundsToTheTorso());
	}



	@Test
	public void recordOfImprisonmentTest() {
		CrimeScene cs = new CrimeScene();
		OffenderProfile op = new OffenderProfile();
		fudb.recordOfImprisonment(cs, op);

		assertFalse(op.getCriminalRecordOfTheft());
		assertFalse(op.getCriminalRecordOfBurglary());
		assertFalse(op.getCriminalRecordOfViolence());
		assertFalse(op.getCriminalRecordOfCommittingDamage());
		assertFalse(op.getCriminalRecordOfDisorderlyConduct());
		assertTrue(op.getRecordOfImprisonment());
		assertFalse(op.getYoungOffenderBetween17And21Years());
		assertFalse(op.getUnemployedAtTheTimeOfOffense());
		assertTrue(op.getSexualRelatedCriminalRecord());
		assertFalse(op.getArmedServices_PastOrPresent());
		assertFalse(op.getFamiliarWithAreaOfOffenseOccurrence());
		assertTrue(op.getMale());
		assertFalse(op.getKnewVictim());
		assertFalse(op.getHistoryOfAbusivenessInPastRelationships());
		assertFalse(op.getAttemptsOfSuicide());
		assertFalse(op.getPsychiatricDisorders());
		assertFalse(op.getCriminalRecordOfFraud());
		assertFalse(op.getRelatedToVictim());
		assertFalse(op.getRelationshipWithVictim());
		assertFalse(op.getBloodRelativeToVictim());
		assertFalse(op.getTurnedSelfIntoPolice());

		assertFalse(cs.getAnalPenetration());
		assertFalse(cs.getArsonToCrimeSceneOrBody());
		assertFalse(cs.getBodyHidden());
		assertFalse(cs.getBodyTransported());
		assertFalse(cs.getBound());
		assertFalse(cs.getDeliberateClothingDamaged());
		assertFalse(cs.getFaceNotDeliberatelyHidden());
		assertFalse(cs.getFaceUp());
		assertTrue(cs.getForeignObjectPenetration());
		assertFalse(cs.getGunshotWounds());
		assertFalse(cs.getIdentifiablePropertyStolen());
		assertFalse(cs.getManualInjuries());
		assertFalse(cs.getMultipleWoundsDistributedAcrossDifferentBodyParts());
		assertFalse(cs.getMultipleWoundsToOneBodyArea());
		assertFalse(cs.getNonidentifiablePropertyStolen());
		assertFalse(cs.getOffenderForensicallyAware());
		assertFalse(cs.getSexualCrime());
		assertFalse(cs.getStabbingInjuries());
		assertFalse(cs.getSuffocation());
		assertFalse(cs.getVaginalPenetration());
		assertFalse(cs.getValuablePropertyStolen());
		assertFalse(cs.getVictimCovered());
		assertFalse(cs.getVictimDruggedAndOrPoisoned());
		assertFalse(cs.getVictimFoundAtTheSameSceneWhereTheyWereKilled());
		assertFalse(cs.getVictimFoundInWater());
		assertFalse(cs.getVictimNaked());
		assertFalse(cs.getVictimPartiallyUndressed());
		assertFalse(cs.getVictimWasBlindfolded());
		assertFalse(cs.getWeaponBroughtToScene());
		assertFalse(cs.getWeaponFromTheScene());
		assertFalse(cs.getWoundsCausedByBluntInstrument());
		assertFalse(cs.getWoundsToTheFace());
		assertFalse(cs.getWoundsToTheHead());
		assertFalse(cs.getWoundsToTheLimbs());
		assertFalse(cs.getWoundsToTheNeck());
		assertFalse(cs.getWoundsToTheTorso());
	}



	@Test
	public void youngOffenderTest() {
		CrimeScene cs = new CrimeScene();
		OffenderProfile op = new OffenderProfile();
		fudb.youngOffender(cs, op);

		assertFalse(op.getCriminalRecordOfTheft());
		assertFalse(op.getCriminalRecordOfBurglary());
		assertFalse(op.getCriminalRecordOfViolence());
		assertFalse(op.getCriminalRecordOfCommittingDamage());
		assertFalse(op.getCriminalRecordOfDisorderlyConduct());
		assertFalse(op.getRecordOfImprisonment());
		assertTrue(op.getYoungOffenderBetween17And21Years());
		assertFalse(op.getUnemployedAtTheTimeOfOffense());
		assertFalse(op.getSexualRelatedCriminalRecord());
		assertTrue(op.getArmedServices_PastOrPresent());
		assertFalse(op.getFamiliarWithAreaOfOffenseOccurrence());
		assertFalse(op.getMale());
		assertFalse(op.getKnewVictim());
		assertFalse(op.getHistoryOfAbusivenessInPastRelationships());
		assertFalse(op.getAttemptsOfSuicide());
		assertFalse(op.getPsychiatricDisorders());
		assertTrue(op.getCriminalRecordOfFraud());
		assertFalse(op.getRelatedToVictim());
		assertFalse(op.getRelationshipWithVictim());
		assertFalse(op.getBloodRelativeToVictim());
		assertFalse(op.getTurnedSelfIntoPolice());

		assertTrue(cs.getAnalPenetration());
		assertFalse(cs.getArsonToCrimeSceneOrBody());
		assertFalse(cs.getBodyHidden());
		assertFalse(cs.getBodyTransported());
		assertTrue(cs.getBound());
		assertFalse(cs.getDeliberateClothingDamaged());
		assertFalse(cs.getFaceNotDeliberatelyHidden());
		assertFalse(cs.getFaceUp());
		assertTrue(cs.getForeignObjectPenetration());
		assertFalse(cs.getGunshotWounds());
		assertFalse(cs.getIdentifiablePropertyStolen());
		assertFalse(cs.getManualInjuries());
		assertFalse(cs.getMultipleWoundsDistributedAcrossDifferentBodyParts());
		assertFalse(cs.getMultipleWoundsToOneBodyArea());
		assertFalse(cs.getNonidentifiablePropertyStolen());
		assertFalse(cs.getOffenderForensicallyAware());
		assertFalse(cs.getSexualCrime());
		assertFalse(cs.getStabbingInjuries());
		assertFalse(cs.getSuffocation());
		assertFalse(cs.getVaginalPenetration());
		assertFalse(cs.getValuablePropertyStolen());
		assertFalse(cs.getVictimCovered());
		assertFalse(cs.getVictimDruggedAndOrPoisoned());
		assertFalse(cs.getVictimFoundAtTheSameSceneWhereTheyWereKilled());
		assertFalse(cs.getVictimFoundInWater());
		assertFalse(cs.getVictimNaked());
		assertFalse(cs.getVictimPartiallyUndressed());
		assertFalse(cs.getVictimWasBlindfolded());
		assertFalse(cs.getWeaponBroughtToScene());
		assertFalse(cs.getWeaponFromTheScene());
		assertFalse(cs.getWoundsCausedByBluntInstrument());
		assertFalse(cs.getWoundsToTheFace());
		assertFalse(cs.getWoundsToTheHead());
		assertFalse(cs.getWoundsToTheLimbs());
		assertFalse(cs.getWoundsToTheNeck());
		assertFalse(cs.getWoundsToTheTorso());
	}



	@Test
	public void unemployedAtTheTimeOfOffenseTest() {
		CrimeScene cs = new CrimeScene();
		OffenderProfile op = new OffenderProfile();
		fudb.unemployedAtTheTimeOfOffense(cs, op);

		assertFalse(op.getCriminalRecordOfTheft());
		assertFalse(op.getCriminalRecordOfBurglary());
		assertFalse(op.getCriminalRecordOfViolence());
		assertFalse(op.getCriminalRecordOfCommittingDamage());
		assertFalse(op.getCriminalRecordOfDisorderlyConduct());
		assertFalse(op.getRecordOfImprisonment());
		assertFalse(op.getYoungOffenderBetween17And21Years());
		assertTrue(op.getUnemployedAtTheTimeOfOffense());
		assertFalse(op.getSexualRelatedCriminalRecord());
		assertFalse(op.getArmedServices_PastOrPresent());
		assertTrue(op.getFamiliarWithAreaOfOffenseOccurrence());
		assertFalse(op.getMale());
		assertFalse(op.getKnewVictim());
		assertFalse(op.getHistoryOfAbusivenessInPastRelationships());
		assertFalse(op.getAttemptsOfSuicide());
		assertFalse(op.getPsychiatricDisorders());
		assertFalse(op.getCriminalRecordOfFraud());
		assertFalse(op.getRelatedToVictim());
		assertFalse(op.getRelationshipWithVictim());
		assertFalse(op.getBloodRelativeToVictim());
		assertFalse(op.getTurnedSelfIntoPolice());

		assertFalse(cs.getAnalPenetration());
		assertFalse(cs.getArsonToCrimeSceneOrBody());
		assertFalse(cs.getBodyHidden());
		assertFalse(cs.getBodyTransported());
		assertFalse(cs.getBound());
		assertFalse(cs.getDeliberateClothingDamaged());
		assertFalse(cs.getFaceNotDeliberatelyHidden());
		assertFalse(cs.getFaceUp());
		assertFalse(cs.getForeignObjectPenetration());
		assertTrue(cs.getGunshotWounds());
		assertFalse(cs.getIdentifiablePropertyStolen());
		assertFalse(cs.getManualInjuries());
		assertFalse(cs.getMultipleWoundsDistributedAcrossDifferentBodyParts());
		assertFalse(cs.getMultipleWoundsToOneBodyArea());
		assertFalse(cs.getNonidentifiablePropertyStolen());
		assertFalse(cs.getOffenderForensicallyAware());
		assertFalse(cs.getSexualCrime());
		assertFalse(cs.getStabbingInjuries());
		assertTrue(cs.getSuffocation());
		assertFalse(cs.getVaginalPenetration());
		assertFalse(cs.getValuablePropertyStolen());
		assertFalse(cs.getVictimCovered());
		assertFalse(cs.getVictimDruggedAndOrPoisoned());
		assertFalse(cs.getVictimFoundAtTheSameSceneWhereTheyWereKilled());
		assertFalse(cs.getVictimFoundInWater());
		assertFalse(cs.getVictimNaked());
		assertFalse(cs.getVictimPartiallyUndressed());
		assertFalse(cs.getVictimWasBlindfolded());
		assertFalse(cs.getWeaponBroughtToScene());
		assertFalse(cs.getWeaponFromTheScene());
		assertFalse(cs.getWoundsCausedByBluntInstrument());
		assertFalse(cs.getWoundsToTheFace());
		assertFalse(cs.getWoundsToTheHead());
		assertFalse(cs.getWoundsToTheLimbs());
		assertFalse(cs.getWoundsToTheNeck());
		assertFalse(cs.getWoundsToTheTorso());
	}



	@Test
	public void historyOfSexCrimeTest() {
		CrimeScene cs = new CrimeScene();
		OffenderProfile op = new OffenderProfile();
		fudb.historyOfSexCrime(cs, op);

		assertFalse(op.getCriminalRecordOfTheft());
		assertFalse(op.getCriminalRecordOfBurglary());
		assertFalse(op.getCriminalRecordOfViolence());
		assertFalse(op.getCriminalRecordOfCommittingDamage());
		assertFalse(op.getCriminalRecordOfDisorderlyConduct());
		assertFalse(op.getRecordOfImprisonment());
		assertFalse(op.getYoungOffenderBetween17And21Years());
		assertFalse(op.getUnemployedAtTheTimeOfOffense());
		assertTrue(op.getSexualRelatedCriminalRecord());
		assertFalse(op.getArmedServices_PastOrPresent());
		assertFalse(op.getFamiliarWithAreaOfOffenseOccurrence());
		assertFalse(op.getMale());
		assertTrue(op.getKnewVictim());
		assertFalse(op.getHistoryOfAbusivenessInPastRelationships());
		assertFalse(op.getAttemptsOfSuicide());
		assertFalse(op.getPsychiatricDisorders());
		assertFalse(op.getCriminalRecordOfFraud());
		assertFalse(op.getRelatedToVictim());
		assertFalse(op.getRelationshipWithVictim());
		assertFalse(op.getBloodRelativeToVictim());
		assertFalse(op.getTurnedSelfIntoPolice());

		assertFalse(cs.getAnalPenetration());
		assertFalse(cs.getArsonToCrimeSceneOrBody());
		assertFalse(cs.getBodyHidden());
		assertFalse(cs.getBodyTransported());
		assertFalse(cs.getBound());
		assertFalse(cs.getDeliberateClothingDamaged());
		assertFalse(cs.getFaceNotDeliberatelyHidden());
		assertFalse(cs.getFaceUp());
		assertFalse(cs.getForeignObjectPenetration());
		assertFalse(cs.getGunshotWounds());
		assertFalse(cs.getIdentifiablePropertyStolen());
		assertFalse(cs.getManualInjuries());
		assertFalse(cs.getMultipleWoundsDistributedAcrossDifferentBodyParts());
		assertFalse(cs.getMultipleWoundsToOneBodyArea());
		assertFalse(cs.getNonidentifiablePropertyStolen());
		assertFalse(cs.getOffenderForensicallyAware());
		assertFalse(cs.getSexualCrime());
		assertFalse(cs.getStabbingInjuries());
		assertFalse(cs.getSuffocation());
		assertFalse(cs.getVaginalPenetration());
		assertFalse(cs.getValuablePropertyStolen());
		assertFalse(cs.getVictimCovered());
		assertFalse(cs.getVictimDruggedAndOrPoisoned());
		assertFalse(cs.getVictimFoundAtTheSameSceneWhereTheyWereKilled());
		assertFalse(cs.getVictimFoundInWater());
		assertFalse(cs.getVictimNaked());
		assertFalse(cs.getVictimPartiallyUndressed());
		assertFalse(cs.getVictimWasBlindfolded());
		assertFalse(cs.getWeaponBroughtToScene());
		assertFalse(cs.getWeaponFromTheScene());
		assertFalse(cs.getWoundsCausedByBluntInstrument());
		assertFalse(cs.getWoundsToTheFace());
		assertFalse(cs.getWoundsToTheHead());
		assertFalse(cs.getWoundsToTheLimbs());
		assertFalse(cs.getWoundsToTheLimbs());
		assertFalse(cs.getWoundsToTheNeck());
		assertFalse(cs.getWoundsToTheTorso());
	}



	@Test
	public void maleTest() {
		CrimeScene cs = new CrimeScene();
		OffenderProfile op = new OffenderProfile();
		fudb.male(cs, op);

		assertFalse(op.getCriminalRecordOfTheft());
		assertFalse(op.getCriminalRecordOfBurglary());
		assertFalse(op.getCriminalRecordOfViolence());
		assertFalse(op.getCriminalRecordOfCommittingDamage());
		assertFalse(op.getCriminalRecordOfDisorderlyConduct());
		assertFalse(op.getRecordOfImprisonment());
		assertFalse(op.getYoungOffenderBetween17And21Years());
		assertFalse(op.getUnemployedAtTheTimeOfOffense());
		assertFalse(op.getSexualRelatedCriminalRecord());
		assertFalse(op.getArmedServices_PastOrPresent());
		assertFalse(op.getFamiliarWithAreaOfOffenseOccurrence());
		assertTrue(op.getMale());
		assertFalse(op.getKnewVictim());
		assertFalse(op.getHistoryOfAbusivenessInPastRelationships());
		assertFalse(op.getAttemptsOfSuicide());
		assertFalse(op.getPsychiatricDisorders());
		assertFalse(op.getCriminalRecordOfFraud());
		assertFalse(op.getRelatedToVictim());
		assertFalse(op.getRelationshipWithVictim());
		assertFalse(op.getBloodRelativeToVictim());
		assertFalse(op.getTurnedSelfIntoPolice());

		assertFalse(cs.getAnalPenetration());
		assertFalse(cs.getArsonToCrimeSceneOrBody());
		assertFalse(cs.getBodyHidden());
		assertFalse(cs.getBodyTransported());
		assertFalse(cs.getBound());
		assertFalse(cs.getDeliberateClothingDamaged());
		assertTrue(cs.getFaceNotDeliberatelyHidden());
		assertFalse(cs.getFaceUp());
		assertFalse(cs.getForeignObjectPenetration());
		assertFalse(cs.getGunshotWounds());
		assertFalse(cs.getIdentifiablePropertyStolen());
		assertFalse(cs.getManualInjuries());
		assertFalse(cs.getMultipleWoundsDistributedAcrossDifferentBodyParts());
		assertFalse(cs.getMultipleWoundsToOneBodyArea());
		assertFalse(cs.getNonidentifiablePropertyStolen());
		assertFalse(cs.getOffenderForensicallyAware());
		assertTrue(cs.getSexualCrime());
		assertFalse(cs.getStabbingInjuries());
		assertFalse(cs.getSuffocation());
		assertFalse(cs.getVaginalPenetration());
		assertFalse(cs.getValuablePropertyStolen());
		assertTrue(cs.getVictimCovered());
		assertTrue(cs.getVictimDruggedAndOrPoisoned());
		assertFalse(cs.getVictimFoundAtTheSameSceneWhereTheyWereKilled());
		assertFalse(cs.getVictimFoundInWater());
		assertFalse(cs.getVictimNaked());
		assertFalse(cs.getVictimPartiallyUndressed());
		assertFalse(cs.getVictimWasBlindfolded());
		assertFalse(cs.getWeaponBroughtToScene());
		assertFalse(cs.getWeaponFromTheScene());
		assertTrue(cs.getWoundsCausedByBluntInstrument());
		assertFalse(cs.getWoundsToTheFace());
		assertFalse(cs.getWoundsToTheHead());
		assertFalse(cs.getWoundsToTheLimbs());
		assertFalse(cs.getWoundsToTheNeck());
		assertFalse(cs.getWoundsToTheTorso());
	}



	@Test
	public void knewVictimTest() {
		CrimeScene cs = new CrimeScene();
		OffenderProfile op = new OffenderProfile();
		fudb.knewVictim(cs, op);

		assertFalse(op.getCriminalRecordOfTheft());
		assertFalse(op.getCriminalRecordOfBurglary());
		assertFalse(op.getCriminalRecordOfViolence());
		assertFalse(op.getCriminalRecordOfCommittingDamage());
		assertFalse(op.getCriminalRecordOfDisorderlyConduct());
		assertFalse(op.getRecordOfImprisonment());
		assertFalse(op.getYoungOffenderBetween17And21Years());
		assertFalse(op.getUnemployedAtTheTimeOfOffense());
		assertFalse(op.getSexualRelatedCriminalRecord());
		assertFalse(op.getArmedServices_PastOrPresent());
		assertFalse(op.getFamiliarWithAreaOfOffenseOccurrence());
		assertFalse(op.getMale());
		assertTrue(op.getKnewVictim());
		assertFalse(op.getHistoryOfAbusivenessInPastRelationships());
		assertTrue(op.getAttemptsOfSuicide());
		assertFalse(op.getPsychiatricDisorders());
		assertFalse(op.getCriminalRecordOfFraud());
		assertFalse(op.getRelatedToVictim());
		assertTrue(op.getRelationshipWithVictim());
		assertTrue(op.getBloodRelativeToVictim());
		assertFalse(op.getTurnedSelfIntoPolice());

		assertFalse(cs.getAnalPenetration());
		assertFalse(cs.getArsonToCrimeSceneOrBody());
		assertTrue(cs.getBodyHidden());
		assertTrue(cs.getBodyTransported());
		assertFalse(cs.getBound());
		assertFalse(cs.getDeliberateClothingDamaged());
		assertFalse(cs.getFaceNotDeliberatelyHidden());
		assertFalse(cs.getFaceUp());
		assertFalse(cs.getForeignObjectPenetration());
		assertFalse(cs.getGunshotWounds());
		assertFalse(cs.getIdentifiablePropertyStolen());
		assertFalse(cs.getManualInjuries());
		assertFalse(cs.getMultipleWoundsDistributedAcrossDifferentBodyParts());
		assertFalse(cs.getMultipleWoundsToOneBodyArea());
		assertFalse(cs.getNonidentifiablePropertyStolen());
		assertFalse(cs.getOffenderForensicallyAware());
		assertFalse(cs.getSexualCrime());
		assertFalse(cs.getStabbingInjuries());
		assertFalse(cs.getSuffocation());
		assertFalse(cs.getVaginalPenetration());
		assertFalse(cs.getValuablePropertyStolen());
		assertFalse(cs.getVictimCovered());
		assertFalse(cs.getVictimDruggedAndOrPoisoned());
		assertTrue(cs.getVictimFoundAtTheSameSceneWhereTheyWereKilled());
		assertFalse(cs.getVictimFoundInWater());
		assertFalse(cs.getVictimNaked());
		assertFalse(cs.getVictimPartiallyUndressed());
		assertFalse(cs.getVictimWasBlindfolded());
		assertFalse(cs.getWeaponBroughtToScene());
		assertFalse(cs.getWeaponFromTheScene());
		assertFalse(cs.getWoundsCausedByBluntInstrument());
		assertFalse(cs.getWoundsToTheFace());
		assertFalse(cs.getWoundsToTheHead());
		assertFalse(cs.getWoundsToTheLimbs());
		assertFalse(cs.getWoundsToTheNeck());
		assertFalse(cs.getWoundsToTheTorso());
	}



	@Test
	public void suicideTest() {
		CrimeScene cs = new CrimeScene();
		OffenderProfile op = new OffenderProfile();
		fudb.suicide(cs, op);

		assertFalse(op.getCriminalRecordOfTheft());
		assertFalse(op.getCriminalRecordOfBurglary());
		assertFalse(op.getCriminalRecordOfViolence());
		assertFalse(op.getCriminalRecordOfCommittingDamage());
		assertFalse(op.getCriminalRecordOfDisorderlyConduct());
		assertFalse(op.getRecordOfImprisonment());
		assertFalse(op.getYoungOffenderBetween17And21Years());
		assertFalse(op.getUnemployedAtTheTimeOfOffense());
		assertFalse(op.getSexualRelatedCriminalRecord());
		assertFalse(op.getArmedServices_PastOrPresent());
		assertFalse(op.getFamiliarWithAreaOfOffenseOccurrence());
		assertFalse(op.getMale());
		assertFalse(op.getKnewVictim());
		assertFalse(op.getHistoryOfAbusivenessInPastRelationships());
		assertTrue(op.getAttemptsOfSuicide());
		assertTrue(op.getPsychiatricDisorders());
		assertFalse(op.getCriminalRecordOfFraud());
		assertFalse(op.getRelatedToVictim());
		assertFalse(op.getRelationshipWithVictim());
		assertFalse(op.getBloodRelativeToVictim());
		assertFalse(op.getTurnedSelfIntoPolice());

		assertFalse(cs.getAnalPenetration());
		assertFalse(cs.getArsonToCrimeSceneOrBody());
		assertFalse(cs.getBodyHidden());
		assertFalse(cs.getBodyTransported());
		assertFalse(cs.getBound());
		assertFalse(cs.getDeliberateClothingDamaged());
		assertFalse(cs.getFaceNotDeliberatelyHidden());
		assertFalse(cs.getFaceUp());
		assertFalse(cs.getForeignObjectPenetration());
		assertFalse(cs.getGunshotWounds());
		assertFalse(cs.getIdentifiablePropertyStolen());
		assertFalse(cs.getManualInjuries());
		assertTrue(cs.getMultipleWoundsDistributedAcrossDifferentBodyParts());
		assertFalse(cs.getMultipleWoundsToOneBodyArea());
		assertFalse(cs.getNonidentifiablePropertyStolen());
		assertFalse(cs.getOffenderForensicallyAware());
		assertFalse(cs.getSexualCrime());
		assertFalse(cs.getStabbingInjuries());
		assertFalse(cs.getSuffocation());
		assertFalse(cs.getVaginalPenetration());
		assertFalse(cs.getValuablePropertyStolen());
		assertFalse(cs.getVictimCovered());
		assertFalse(cs.getVictimDruggedAndOrPoisoned());
		assertFalse(cs.getVictimFoundAtTheSameSceneWhereTheyWereKilled());
		assertFalse(cs.getVictimFoundInWater());
		assertFalse(cs.getVictimNaked());
		assertFalse(cs.getVictimPartiallyUndressed());
		assertFalse(cs.getVictimWasBlindfolded());
		assertFalse(cs.getWeaponBroughtToScene());
		assertFalse(cs.getWeaponFromTheScene());
		assertFalse(cs.getWoundsCausedByBluntInstrument());
		assertFalse(cs.getWoundsToTheFace());
		assertFalse(cs.getWoundsToTheHead());
		assertFalse(cs.getWoundsToTheLimbs());
		assertFalse(cs.getWoundsToTheLimbs());
		assertFalse(cs.getWoundsToTheNeck());
		assertFalse(cs.getWoundsToTheTorso());
	}



	@Test
	public void psychiatricOrSocialProblemsTest() {
		CrimeScene cs = new CrimeScene();
		OffenderProfile op = new OffenderProfile();
		fudb.psychiatricOrSocialProblems(cs, op);

		assertFalse(op.getCriminalRecordOfTheft());
		assertFalse(op.getCriminalRecordOfBurglary());
		assertFalse(op.getCriminalRecordOfViolence());
		assertFalse(op.getCriminalRecordOfCommittingDamage());
		assertFalse(op.getCriminalRecordOfDisorderlyConduct());
		assertFalse(op.getRecordOfImprisonment());
		assertFalse(op.getYoungOffenderBetween17And21Years());
		assertFalse(op.getUnemployedAtTheTimeOfOffense());
		assertFalse(op.getSexualRelatedCriminalRecord());
		assertFalse(op.getArmedServices_PastOrPresent());
		assertFalse(op.getFamiliarWithAreaOfOffenseOccurrence());
		assertFalse(op.getMale());
		assertFalse(op.getKnewVictim());
		assertFalse(op.getHistoryOfAbusivenessInPastRelationships());
		assertFalse(op.getAttemptsOfSuicide());
		assertTrue(op.getPsychiatricDisorders());
		assertFalse(op.getCriminalRecordOfFraud());
		assertFalse(op.getRelatedToVictim());
		assertFalse(op.getRelationshipWithVictim());
		assertFalse(op.getBloodRelativeToVictim());
		assertFalse(op.getTurnedSelfIntoPolice());

		assertFalse(cs.getAnalPenetration());
		assertFalse(cs.getArsonToCrimeSceneOrBody());
		assertFalse(cs.getBodyHidden());
		assertTrue(cs.getBodyTransported());
		assertFalse(cs.getBound());
		assertFalse(cs.getDeliberateClothingDamaged());
		assertFalse(cs.getFaceNotDeliberatelyHidden());
		assertFalse(cs.getFaceUp());
		assertFalse(cs.getForeignObjectPenetration());
		assertFalse(cs.getGunshotWounds());
		assertFalse(cs.getIdentifiablePropertyStolen());
		assertFalse(cs.getManualInjuries());
		assertFalse(cs.getMultipleWoundsDistributedAcrossDifferentBodyParts());
		assertFalse(cs.getMultipleWoundsToOneBodyArea());
		assertFalse(cs.getNonidentifiablePropertyStolen());
		assertFalse(cs.getOffenderForensicallyAware());
		assertFalse(cs.getSexualCrime());
		assertFalse(cs.getStabbingInjuries());
		assertFalse(cs.getSuffocation());
		assertFalse(cs.getVaginalPenetration());
		assertFalse(cs.getValuablePropertyStolen());
		assertFalse(cs.getVictimCovered());
		assertFalse(cs.getVictimDruggedAndOrPoisoned());
		assertFalse(cs.getVictimFoundAtTheSameSceneWhereTheyWereKilled());
		assertTrue(cs.getVictimFoundInWater());
		assertFalse(cs.getVictimNaked());
		assertFalse(cs.getVictimPartiallyUndressed());
		assertFalse(cs.getVictimWasBlindfolded());
		assertFalse(cs.getWeaponBroughtToScene());
		assertFalse(cs.getWeaponFromTheScene());
		assertFalse(cs.getWoundsCausedByBluntInstrument());
		assertFalse(cs.getWoundsToTheFace());
		assertFalse(cs.getWoundsToTheHead());
		assertFalse(cs.getWoundsToTheLimbs());
		assertFalse(cs.getWoundsToTheNeck());
		assertFalse(cs.getWoundsToTheTorso());
	}

	
	@Test
	public void priorFraudTest() {
		CrimeScene cs = new CrimeScene();
		OffenderProfile op = new OffenderProfile();
		fudb.priorFraud(cs, op);

		assertFalse(op.getCriminalRecordOfTheft());
		assertFalse(op.getCriminalRecordOfBurglary());
		assertFalse(op.getCriminalRecordOfViolence());
		assertFalse(op.getCriminalRecordOfCommittingDamage());
		assertFalse(op.getCriminalRecordOfDisorderlyConduct());
		assertFalse(op.getRecordOfImprisonment());
		assertFalse(op.getYoungOffenderBetween17And21Years());
		assertFalse(op.getUnemployedAtTheTimeOfOffense());
		assertFalse(op.getSexualRelatedCriminalRecord());
		assertFalse(op.getArmedServices_PastOrPresent());
		assertFalse(op.getFamiliarWithAreaOfOffenseOccurrence());
		assertFalse(op.getMale());
		assertFalse(op.getKnewVictim());
		assertFalse(op.getHistoryOfAbusivenessInPastRelationships());
		assertFalse(op.getAttemptsOfSuicide());
		assertFalse(op.getPsychiatricDisorders());
		assertTrue(op.getCriminalRecordOfFraud());
		assertFalse(op.getRelatedToVictim());
		assertTrue(op.getRelationshipWithVictim());
		assertFalse(op.getBloodRelativeToVictim());
		assertFalse(op.getTurnedSelfIntoPolice());

		assertFalse(cs.getAnalPenetration());
		assertTrue(cs.getArsonToCrimeSceneOrBody());
		assertFalse(cs.getBodyHidden());
		assertFalse(cs.getBodyTransported());
		assertFalse(cs.getBound());
		assertFalse(cs.getDeliberateClothingDamaged());
		assertFalse(cs.getFaceNotDeliberatelyHidden());
		assertFalse(cs.getFaceUp());
		assertFalse(cs.getForeignObjectPenetration());
		assertTrue(cs.getGunshotWounds());
		assertFalse(cs.getIdentifiablePropertyStolen());
		assertFalse(cs.getManualInjuries());
		assertFalse(cs.getMultipleWoundsDistributedAcrossDifferentBodyParts());
		assertFalse(cs.getMultipleWoundsToOneBodyArea());
		assertFalse(cs.getNonidentifiablePropertyStolen());
		assertFalse(cs.getOffenderForensicallyAware());
		assertFalse(cs.getSexualCrime());
		assertFalse(cs.getStabbingInjuries());
		assertFalse(cs.getSuffocation());
		assertFalse(cs.getVaginalPenetration());
		assertFalse(cs.getValuablePropertyStolen());
		assertFalse(cs.getVictimCovered());
		assertFalse(cs.getVictimDruggedAndOrPoisoned());
		assertFalse(cs.getVictimFoundAtTheSameSceneWhereTheyWereKilled());
		assertFalse(cs.getVictimFoundInWater());
		assertFalse(cs.getVictimNaked());
		assertFalse(cs.getVictimPartiallyUndressed());
		assertFalse(cs.getVictimWasBlindfolded());
		assertFalse(cs.getWeaponBroughtToScene());
		assertFalse(cs.getWeaponFromTheScene());
		assertFalse(cs.getWoundsCausedByBluntInstrument());
		assertFalse(cs.getWoundsToTheFace());
		assertFalse(cs.getWoundsToTheHead());
		assertFalse(cs.getWoundsToTheLimbs());
		assertFalse(cs.getWoundsToTheNeck());
		assertFalse(cs.getWoundsToTheTorso());
	}


	@Test
	public void relatedToVictimTest() {
		CrimeScene cs = new CrimeScene();
		OffenderProfile op = new OffenderProfile();
		fudb.relatedToVictim(cs, op);

		assertFalse(op.getCriminalRecordOfTheft());
		assertFalse(op.getCriminalRecordOfBurglary());
		assertFalse(op.getCriminalRecordOfViolence());
		assertFalse(op.getCriminalRecordOfCommittingDamage());
		assertFalse(op.getCriminalRecordOfDisorderlyConduct());
		assertFalse(op.getRecordOfImprisonment());
		assertFalse(op.getYoungOffenderBetween17And21Years());
		assertFalse(op.getUnemployedAtTheTimeOfOffense());
		assertFalse(op.getSexualRelatedCriminalRecord());
		assertFalse(op.getArmedServices_PastOrPresent());
		assertFalse(op.getFamiliarWithAreaOfOffenseOccurrence());
		assertFalse(op.getMale());
		assertFalse(op.getKnewVictim());
		assertFalse(op.getHistoryOfAbusivenessInPastRelationships());
		assertFalse(op.getAttemptsOfSuicide());
		assertFalse(op.getPsychiatricDisorders());
		assertFalse(op.getCriminalRecordOfFraud());
		assertTrue(op.getRelatedToVictim());
		assertFalse(op.getRelationshipWithVictim());
		assertFalse(op.getBloodRelativeToVictim());
		assertFalse(op.getTurnedSelfIntoPolice());

		assertFalse(cs.getAnalPenetration());
		assertFalse(cs.getArsonToCrimeSceneOrBody());
		assertFalse(cs.getBodyHidden());
		assertFalse(cs.getBodyTransported());
		assertFalse(cs.getBound());
		assertFalse(cs.getDeliberateClothingDamaged());
		assertFalse(cs.getFaceNotDeliberatelyHidden());
		assertFalse(cs.getFaceUp());
		assertFalse(cs.getForeignObjectPenetration());
		assertFalse(cs.getGunshotWounds());
		assertTrue(cs.getIdentifiablePropertyStolen());
		assertFalse(cs.getManualInjuries());
		assertTrue(cs.getMultipleWoundsDistributedAcrossDifferentBodyParts());
		assertFalse(cs.getMultipleWoundsToOneBodyArea());
		assertFalse(cs.getNonidentifiablePropertyStolen());
		assertFalse(cs.getOffenderForensicallyAware());
		assertFalse(cs.getSexualCrime());
		assertTrue(cs.getStabbingInjuries());
		assertFalse(cs.getSuffocation());
		assertFalse(cs.getVaginalPenetration());
		assertFalse(cs.getValuablePropertyStolen());
		assertFalse(cs.getVictimCovered());
		assertFalse(cs.getVictimDruggedAndOrPoisoned());
		assertFalse(cs.getVictimFoundAtTheSameSceneWhereTheyWereKilled());
		assertFalse(cs.getVictimFoundInWater());
		assertFalse(cs.getVictimNaked());
		assertTrue(cs.getVictimPartiallyUndressed());
		assertFalse(cs.getVictimWasBlindfolded());
		assertFalse(cs.getWeaponBroughtToScene());
		assertFalse(cs.getWeaponFromTheScene());
		assertFalse(cs.getWoundsCausedByBluntInstrument());
		assertFalse(cs.getWoundsToTheFace());
		assertFalse(cs.getWoundsToTheHead());
		assertTrue(cs.getWoundsToTheLimbs());
		assertFalse(cs.getWoundsToTheNeck());
		assertFalse(cs.getWoundsToTheTorso());
	}

	
	@Test
	public void relationshipWithVictimTest() {
		CrimeScene cs = new CrimeScene();
		OffenderProfile op = new OffenderProfile();
		fudb.relationshipWithVictim(cs, op);

		assertFalse(op.getCriminalRecordOfTheft());
		assertFalse(op.getCriminalRecordOfBurglary());
		assertFalse(op.getCriminalRecordOfViolence());
		assertFalse(op.getCriminalRecordOfCommittingDamage());
		assertFalse(op.getCriminalRecordOfDisorderlyConduct());
		assertFalse(op.getRecordOfImprisonment());
		assertFalse(op.getYoungOffenderBetween17And21Years());
		assertFalse(op.getUnemployedAtTheTimeOfOffense());
		assertFalse(op.getSexualRelatedCriminalRecord());
		assertFalse(op.getArmedServices_PastOrPresent());
		assertFalse(op.getFamiliarWithAreaOfOffenseOccurrence());
		assertFalse(op.getMale());
		assertFalse(op.getKnewVictim());
		assertFalse(op.getHistoryOfAbusivenessInPastRelationships());
		assertFalse(op.getAttemptsOfSuicide());
		assertFalse(op.getPsychiatricDisorders());
		assertFalse(op.getCriminalRecordOfFraud());
		assertFalse(op.getRelatedToVictim());
		assertTrue(op.getRelationshipWithVictim());
		assertTrue(op.getBloodRelativeToVictim());
		assertFalse(op.getTurnedSelfIntoPolice());

		assertFalse(cs.getAnalPenetration());
		assertFalse(cs.getArsonToCrimeSceneOrBody());
		assertFalse(cs.getBodyHidden());
		assertFalse(cs.getBodyTransported());
		assertFalse(cs.getBound());
		assertFalse(cs.getDeliberateClothingDamaged());
		assertFalse(cs.getFaceNotDeliberatelyHidden());
		assertFalse(cs.getFaceUp());
		assertFalse(cs.getForeignObjectPenetration());
		assertFalse(cs.getGunshotWounds());
		assertFalse(cs.getIdentifiablePropertyStolen());
		assertFalse(cs.getManualInjuries());
		assertFalse(cs.getMultipleWoundsDistributedAcrossDifferentBodyParts());
		assertFalse(cs.getMultipleWoundsToOneBodyArea());
		assertFalse(cs.getNonidentifiablePropertyStolen());
		assertFalse(cs.getOffenderForensicallyAware());
		assertFalse(cs.getSexualCrime());
		assertFalse(cs.getStabbingInjuries());
		assertFalse(cs.getSuffocation());
		assertFalse(cs.getVaginalPenetration());
		assertFalse(cs.getValuablePropertyStolen());
		assertFalse(cs.getVictimCovered());
		assertTrue(cs.getVictimDruggedAndOrPoisoned());
		assertFalse(cs.getVictimFoundAtTheSameSceneWhereTheyWereKilled());
		assertFalse(cs.getVictimFoundInWater());
		assertFalse(cs.getVictimNaked());
		assertFalse(cs.getVictimPartiallyUndressed());
		assertTrue(cs.getVictimWasBlindfolded());
		assertFalse(cs.getWeaponBroughtToScene());
		assertFalse(cs.getWeaponFromTheScene());
		assertFalse(cs.getWoundsCausedByBluntInstrument());
		assertFalse(cs.getWoundsToTheFace());
		assertFalse(cs.getWoundsToTheHead());
		assertFalse(cs.getWoundsToTheLimbs());
		assertFalse(cs.getWoundsToTheNeck());
		assertFalse(cs.getWoundsToTheTorso());
	}
	
	
	@Test
	public void bloodRelatedToVictimTest() {
		CrimeScene cs = new CrimeScene();
		OffenderProfile op = new OffenderProfile();
		fudb.bloodRelatedToVictim(cs, op);

		assertFalse(op.getCriminalRecordOfTheft());
		assertFalse(op.getCriminalRecordOfBurglary());
		assertFalse(op.getCriminalRecordOfViolence());
		assertFalse(op.getCriminalRecordOfCommittingDamage());
		assertFalse(op.getCriminalRecordOfDisorderlyConduct());
		assertFalse(op.getRecordOfImprisonment());
		assertFalse(op.getYoungOffenderBetween17And21Years());
		assertFalse(op.getUnemployedAtTheTimeOfOffense());
		assertFalse(op.getSexualRelatedCriminalRecord());
		assertFalse(op.getArmedServices_PastOrPresent());
		assertFalse(op.getFamiliarWithAreaOfOffenseOccurrence());
		assertFalse(op.getMale());
		assertFalse(op.getKnewVictim());
		assertFalse(op.getHistoryOfAbusivenessInPastRelationships());
		assertFalse(op.getAttemptsOfSuicide());
		assertFalse(op.getPsychiatricDisorders());
		assertFalse(op.getCriminalRecordOfFraud());
		assertFalse(op.getRelatedToVictim());
		assertFalse(op.getRelationshipWithVictim());
		assertTrue(op.getBloodRelativeToVictim());
		assertFalse(op.getTurnedSelfIntoPolice());

		assertFalse(cs.getAnalPenetration());
		assertFalse(cs.getArsonToCrimeSceneOrBody());
		assertFalse(cs.getBodyHidden());
		assertFalse(cs.getBodyTransported());
		assertFalse(cs.getBound());
		assertFalse(cs.getDeliberateClothingDamaged());
		assertFalse(cs.getFaceNotDeliberatelyHidden());
		assertFalse(cs.getFaceUp());
		assertFalse(cs.getForeignObjectPenetration());
		assertFalse(cs.getGunshotWounds());
		assertFalse(cs.getIdentifiablePropertyStolen());
		assertFalse(cs.getManualInjuries());
		assertFalse(cs.getMultipleWoundsDistributedAcrossDifferentBodyParts());
		assertFalse(cs.getMultipleWoundsToOneBodyArea());
		assertFalse(cs.getNonidentifiablePropertyStolen());
		assertFalse(cs.getOffenderForensicallyAware());
		assertFalse(cs.getSexualCrime());
		assertFalse(cs.getStabbingInjuries());
		assertTrue(cs.getSuffocation());
		assertFalse(cs.getVaginalPenetration());
		assertFalse(cs.getValuablePropertyStolen());
		assertFalse(cs.getVictimCovered());
		assertFalse(cs.getVictimDruggedAndOrPoisoned());
		assertFalse(cs.getVictimFoundAtTheSameSceneWhereTheyWereKilled());
		assertFalse(cs.getVictimFoundInWater());
		assertFalse(cs.getVictimNaked());
		assertFalse(cs.getVictimPartiallyUndressed());
		assertFalse(cs.getVictimWasBlindfolded());
		assertFalse(cs.getWeaponBroughtToScene());
		assertFalse(cs.getWeaponFromTheScene());
		assertFalse(cs.getWoundsCausedByBluntInstrument());
		assertFalse(cs.getWoundsToTheFace());
		assertFalse(cs.getWoundsToTheHead());
		assertFalse(cs.getWoundsToTheLimbs());
		assertFalse(cs.getWoundsToTheNeck());
		assertFalse(cs.getWoundsToTheTorso());
	}
	

	@Test
	public void turnedSelfIntoPoliceTest() {
		CrimeScene cs = new CrimeScene();
		OffenderProfile op = new OffenderProfile();
		fudb.turnedSelfIntoPolice(cs, op);

		assertFalse(op.getCriminalRecordOfTheft());
		assertFalse(op.getCriminalRecordOfBurglary());
		assertFalse(op.getCriminalRecordOfViolence());
		assertFalse(op.getCriminalRecordOfCommittingDamage());
		assertFalse(op.getCriminalRecordOfDisorderlyConduct());
		assertFalse(op.getRecordOfImprisonment());
		assertFalse(op.getYoungOffenderBetween17And21Years());
		assertFalse(op.getUnemployedAtTheTimeOfOffense());
		assertFalse(op.getSexualRelatedCriminalRecord());
		assertFalse(op.getArmedServices_PastOrPresent());
		assertFalse(op.getFamiliarWithAreaOfOffenseOccurrence());
		assertFalse(op.getMale());
		assertFalse(op.getKnewVictim());
		assertFalse(op.getHistoryOfAbusivenessInPastRelationships());
		assertFalse(op.getAttemptsOfSuicide());
		assertFalse(op.getPsychiatricDisorders());
		assertFalse(op.getCriminalRecordOfFraud());
		assertFalse(op.getRelatedToVictim());
		assertFalse(op.getRelationshipWithVictim());
		assertFalse(op.getBloodRelativeToVictim());
		assertTrue(op.getTurnedSelfIntoPolice());

		assertFalse(cs.getAnalPenetration());
		assertTrue(cs.getArsonToCrimeSceneOrBody());
		assertFalse(cs.getBodyHidden());
		assertFalse(cs.getBodyTransported());
		assertFalse(cs.getBound());
		assertFalse(cs.getDeliberateClothingDamaged());
		assertFalse(cs.getFaceNotDeliberatelyHidden());
		assertTrue(cs.getFaceUp());
		assertFalse(cs.getForeignObjectPenetration());
		assertFalse(cs.getGunshotWounds());
		assertTrue(cs.getIdentifiablePropertyStolen());
		assertFalse(cs.getManualInjuries());
		assertFalse(cs.getMultipleWoundsDistributedAcrossDifferentBodyParts());
		assertFalse(cs.getMultipleWoundsToOneBodyArea());
		assertFalse(cs.getNonidentifiablePropertyStolen());
		assertTrue(cs.getOffenderForensicallyAware());
		assertTrue(cs.getSexualCrime());
		assertFalse(cs.getStabbingInjuries());
		assertFalse(cs.getSuffocation());
		assertTrue(cs.getVaginalPenetration());
		assertFalse(cs.getValuablePropertyStolen());
		assertFalse(cs.getVictimCovered());
		assertFalse(cs.getVictimDruggedAndOrPoisoned());
		assertFalse(cs.getVictimFoundAtTheSameSceneWhereTheyWereKilled());
		assertFalse(cs.getVictimFoundInWater());
		assertFalse(cs.getVictimNaked());
		assertTrue(cs.getVictimPartiallyUndressed());
		assertFalse(cs.getVictimWasBlindfolded());
		assertFalse(cs.getWeaponBroughtToScene());
		assertFalse(cs.getWeaponFromTheScene());
		assertFalse(cs.getWoundsCausedByBluntInstrument());
		assertFalse(cs.getWoundsToTheFace());
		assertFalse(cs.getWoundsToTheHead());
		assertFalse(cs.getWoundsToTheLimbs());
		assertFalse(cs.getWoundsToTheNeck());
		assertFalse(cs.getWoundsToTheTorso());
	}

}
