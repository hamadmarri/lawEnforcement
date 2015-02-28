package intelligence;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.entries.Crime;
import entities.entries.CriminalRecord;
import entities.entries.YouthRiskFactors;


@Singleton
public class FillUpDatabaseWithYourhRiskFactorsAndCriminalRecords {

	@PersistenceContext(unitName = "lawEnforcementPersistenceUnit")
	private EntityManager em;



	public void fillUpData() {
		YouthRiskFactors yrf; // max 7
		CriminalRecord cr;
		int numberOfYrfVariables = 0;
		int numberOfRecords = 1000;

		for (int i = 0; i < numberOfRecords; i++) {
			cr = new CriminalRecord();
			yrf = new YouthRiskFactors(cr);
			numberOfYrfVariables = getRandom(0, 7);
			createRecord(yrf, cr, numberOfYrfVariables);
		}
	}



	public void createRecord(YouthRiskFactors yrf, CriminalRecord cr, int numberOfYrfVariables) {
		int randomYrfVariable = 0; // max 26
		int randomCrVariable = getRandom(0, 6); // max 6
		int oldRandom = 0;
		Crime c;

		for (int j = 0; j < numberOfYrfVariables; j++) {
			while (oldRandom == randomYrfVariable)
				randomYrfVariable = getRandom(0, 26);

			switch (randomYrfVariable) {
			case 0:
				yrf.setAcademicFailure(true);
				break;

			case 1:
				yrf.setAggressiveness(true);
				break;

			case 2:
				yrf.setAvailabilityOfDrugsAndFirearms(true);
				break;

			case 3:
				yrf.setBeliefs_AttitudesFavorableToDeviantOrAntisocialBehavior(true);
				break;

			case 4:
				yrf.setChildMaltreatment(true);
				break;

			case 5:
				yrf.setCommunityDisorganization(true);
				break;

			case 6:
				yrf.setDelinquentPeers(true);
				break;

			case 7:
				yrf.setDelinquentSiblings(true);
				break;

			case 8:
				yrf.setEarlyInitiationOfViolentBehavior(true);
				break;

			case 9:
				yrf.setExposureToViolenceAndRacialPrejudice(true);
				break;

			case 10:
				yrf.setFrequentSchoolTransitions(true);
				break;

			case 11:
				yrf.setGangMembership(true);
				break;

			case 12:
				yrf.setHyperactivityConcentrationProblems_Restlessness_RiskTaking(true);
				break;

			case 13:
				yrf.setInternalizingDisorders(true);
				break;

			case 14:
				yrf.setInvolvementInOtherFormsOfAntisocialBehavior(true);
				break;

			case 15:
				yrf.setLowBondingToSchool(true);
				break;

			case 16:
				yrf.setLowLevelsOfParentalInvolvement(true);
				;
				break;

			case 17:
				yrf.setLowRestingHeartRate(true);
				break;

			case 18:
				yrf.setNeighborhoodAdultsInvolvedInCrime(true);
				break;

			case 19:
				yrf.setParentalAttitudesFavorableToSubstanceUseAndViolence(true);
				break;

			case 20:
				yrf.setParentalCriminality(true);
				break;

			case 21:
				yrf.setParentchildSeparation(true);
				break;

			case 22:
				yrf.setPoorFamilyBondingAndFamilyConflict(true);
				break;

			case 23:
				yrf.setPoorFamilyManagementPractices(true);
				break;

			case 24:
				yrf.setPoverty(true);
				break;

			case 25:
				yrf.setPregnancyAndDeliveryComplications(true);
				break;

			case 26:
				yrf.setTruancyAndDroppingOutOfSchool(true);
				break;

			default:
				break;
			} // switch

			oldRandom = randomYrfVariable;
		}

		c = new Crime(cr, "", null, Crime.typeOfCrimeSuggestions[randomCrVariable]);
		cr.addCrime(c);
		
		// save to database
		em.persist(cr);
		em.persist(c);
		em.persist(yrf);
	}



	// max to is 1000
	public int getRandom(int from, int to) {
		int n = (int) (Math.random() * 1000);

		n = n % (to + 1);
		n += from;

		return n;
	}

}
