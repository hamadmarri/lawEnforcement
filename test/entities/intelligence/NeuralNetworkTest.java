package entities.intelligence;

import static org.junit.Assert.*;
import intelligence.FillUpDatabase;
import intelligence.NeuralNetwork.NeuralNetwork;
import intelligence.NeuralNetwork.Trainers.OffenderProfileGeneratorTrainer;
import intelligence.NeuralNetwork.Trainers.Trainer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class NeuralNetworkTest {

	// path of input file that NN trainer will use
	private static String inputPath;

	// path of output file that NN trainer will use
	private static String outputPath;

	// NN object
	private static NeuralNetwork nw;

	// NN trainer
	private static Trainer trainer;

	private static FillUpDatabase fudb = new FillUpDatabase();

	CrimeScene cs;
	OffenderProfile op;

	double[] inputs;
	double[] expectedOutputs;
	double[] actualOutputs;

	double errorDeltaAccepted = 0.3;



	@BeforeClass
	public static void init() {

		inputPath = "./test/entities/intelligence/crimeScene_OffenderProfileViewExport.txt";
		outputPath = "./test/entities/intelligence/outputOf_crimeScene_OffenderProfile.txt";

		// String serPath =
		// "/Users/hamadalmarri/Development/eclipse/NeuralNetwork/NN_XOR.ser";
		// NeuralNetwork nw = (NeuralNetwork) deserialize(serPath);

		// NN configuration for number of nodes in each layer
		int[] config = new int[] { 36, 24, 21 };

		// creating new NN
		nw = new NeuralNetwork(config, 0.52, 0.15);


		// NN trainer
		trainer = new OffenderProfileGeneratorTrainer(inputPath, outputPath, nw, 50000);

		// serialize(serPath, nw);

		trainer.train();
	}



	@Before
	public void beforeEveryTest() {
		cs = new CrimeScene();
		op = new OffenderProfile();
		inputs = new double[36];
		expectedOutputs = new double[22];
		expectedOutputs[21] = 1;
	}



	@Test
	public void priorTheftTest() {
		fudb.priorTheft(cs, op);

		convertCrimeSceneToArray(cs, inputs);
		convertOffenderProfileToArray(op, expectedOutputs);

		nw.setInputValues(inputs);
		nw.feedForward();
		actualOutputs = nw.getResults();

		assertArrayEquals(expectedOutputs, actualOutputs, errorDeltaAccepted);
	}



	@Test
	public void priorBurglaryTest() {
		fudb.priorBurglary(cs, op);

		convertCrimeSceneToArray(cs, inputs);
		convertOffenderProfileToArray(op, expectedOutputs);

		nw.setInputValues(inputs);
		nw.feedForward();
		actualOutputs = nw.getResults();

		assertArrayEquals(expectedOutputs, actualOutputs, errorDeltaAccepted);
	}



	@Test
	public void priorViolenceTest() {
		fudb.priorViolence(cs, op);

		convertCrimeSceneToArray(cs, inputs);
		convertOffenderProfileToArray(op, expectedOutputs);

		nw.setInputValues(inputs);
		nw.feedForward();
		actualOutputs = nw.getResults();

		assertArrayEquals(expectedOutputs, actualOutputs, errorDeltaAccepted);
	}



	@Test
	public void youngOffenderTest() {
		fudb.youngOffender(cs, op);

		convertCrimeSceneToArray(cs, inputs);
		convertOffenderProfileToArray(op, expectedOutputs);

		nw.setInputValues(inputs);
		nw.feedForward();
		actualOutputs = nw.getResults();

		assertArrayEquals(expectedOutputs, actualOutputs, errorDeltaAccepted);
	}



	@Test
	public void priorFraudTest() {
		fudb.priorFraud(cs, op);

		convertCrimeSceneToArray(cs, inputs);
		convertOffenderProfileToArray(op, expectedOutputs);

		nw.setInputValues(inputs);
		nw.feedForward();
		actualOutputs = nw.getResults();

		assertArrayEquals(expectedOutputs, actualOutputs, errorDeltaAccepted);
	}



	@Test
	public void maleTest() {
		fudb.male(cs, op);

		convertCrimeSceneToArray(cs, inputs);
		convertOffenderProfileToArray(op, expectedOutputs);

		nw.setInputValues(inputs);
		nw.feedForward();
		actualOutputs = nw.getResults();

		assertArrayEquals(expectedOutputs, actualOutputs, errorDeltaAccepted);
	}



	@Test
	public void relatedToVictimTest() {
		fudb.relatedToVictim(cs, op);

		convertCrimeSceneToArray(cs, inputs);
		convertOffenderProfileToArray(op, expectedOutputs);

		nw.setInputValues(inputs);
		nw.feedForward();
		actualOutputs = nw.getResults();

		assertArrayEquals(expectedOutputs, actualOutputs, errorDeltaAccepted);
	}



	@Test
	public void psychiatricOrSocialProblemsTest() {
		fudb.psychiatricOrSocialProblems(cs, op);

		convertCrimeSceneToArray(cs, inputs);
		convertOffenderProfileToArray(op, expectedOutputs);

		nw.setInputValues(inputs);
		nw.feedForward();
		actualOutputs = nw.getResults();

		assertArrayEquals(expectedOutputs, actualOutputs, errorDeltaAccepted);
	}



	@Test
	public void recordOfImprisonmentTest() {
		fudb.recordOfImprisonment(cs, op);

		convertCrimeSceneToArray(cs, inputs);
		convertOffenderProfileToArray(op, expectedOutputs);

		nw.setInputValues(inputs);
		nw.feedForward();
		actualOutputs = nw.getResults();

		assertArrayEquals(expectedOutputs, actualOutputs, errorDeltaAccepted);
	}



	@Test
	public void unemployedAtTheTimeOfOffenseTest() {
		fudb.unemployedAtTheTimeOfOffense(cs, op);

		convertCrimeSceneToArray(cs, inputs);
		convertOffenderProfileToArray(op, expectedOutputs);

		nw.setInputValues(inputs);
		nw.feedForward();
		actualOutputs = nw.getResults();

		assertArrayEquals(expectedOutputs, actualOutputs, errorDeltaAccepted);
	}



	@Test
	public void knewVictimTest() {
		fudb.knewVictim(cs, op);

		convertCrimeSceneToArray(cs, inputs);
		convertOffenderProfileToArray(op, expectedOutputs);

		nw.setInputValues(inputs);
		nw.feedForward();
		actualOutputs = nw.getResults();

		assertArrayEquals(expectedOutputs, actualOutputs, errorDeltaAccepted);
	}



	@Test
	public void relationshipWithVictimTest() {
		fudb.relationshipWithVictim(cs, op);

		convertCrimeSceneToArray(cs, inputs);
		convertOffenderProfileToArray(op, expectedOutputs);

		nw.setInputValues(inputs);
		nw.feedForward();
		actualOutputs = nw.getResults();

		assertArrayEquals(expectedOutputs, actualOutputs, errorDeltaAccepted);
	}



	@Test
	public void suicideTest() {
		fudb.suicide(cs, op);

		convertCrimeSceneToArray(cs, inputs);
		convertOffenderProfileToArray(op, expectedOutputs);

		nw.setInputValues(inputs);
		nw.feedForward();
		actualOutputs = nw.getResults();

		assertArrayEquals(expectedOutputs, actualOutputs, errorDeltaAccepted);
	}



	@Test
	public void bloodRelatedToVictimTest() {
		fudb.bloodRelatedToVictim(cs, op);

		convertCrimeSceneToArray(cs, inputs);
		convertOffenderProfileToArray(op, expectedOutputs);

		nw.setInputValues(inputs);
		nw.feedForward();
		actualOutputs = nw.getResults();

		assertArrayEquals(expectedOutputs, actualOutputs, errorDeltaAccepted);
	}



	@Test
	public void turnedSelfIntoPoliceTest() {
		fudb.turnedSelfIntoPolice(cs, op);

		convertCrimeSceneToArray(cs, inputs);
		convertOffenderProfileToArray(op, expectedOutputs);

		nw.setInputValues(inputs);
		nw.feedForward();
		actualOutputs = nw.getResults();

		assertArrayEquals(expectedOutputs, actualOutputs, errorDeltaAccepted);
	}



	private void convertOffenderProfileToArray(OffenderProfile op, double[] outputs) {
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



	private void convertCrimeSceneToArray(CrimeScene cs, double[] inputs) {
		inputs[0] = cs.getAnalPenetration() ? 1 : 0;
		inputs[1] = cs.getArsonToCrimeSceneOrBody() ? 1 : 0;
		inputs[2] = cs.getBodyHidden() ? 1 : 0;
		inputs[3] = cs.getBodyTransported() ? 1 : 0;
		inputs[4] = cs.getBound() ? 1 : 0;
		inputs[5] = cs.getDeliberateClothingDamaged() ? 1 : 0;
		inputs[6] = cs.getFaceNotDeliberatelyHidden() ? 1 : 0;
		inputs[7] = cs.getFaceUp() ? 1 : 0;
		inputs[8] = cs.getForeignObjectPenetration() ? 1 : 0;
		inputs[9] = cs.getGunshotWounds() ? 1 : 0;
		inputs[10] = cs.getIdentifiablePropertyStolen() ? 1 : 0;
		inputs[11] = cs.getManualInjuries() ? 1 : 0;
		inputs[12] = cs.getMultipleWoundsDistributedAcrossDifferentBodyParts() ? 1 : 0;
		inputs[13] = cs.getMultipleWoundsToOneBodyArea() ? 1 : 0;
		inputs[14] = cs.getNonidentifiablePropertyStolen() ? 1 : 0;
		inputs[15] = cs.getOffenderForensicallyAware() ? 1 : 0;
		inputs[16] = cs.getSexualCrime() ? 1 : 0;
		inputs[17] = cs.getStabbingInjuries() ? 1 : 0;
		inputs[18] = cs.getSuffocation() ? 1 : 0;
		inputs[19] = cs.getSuffocation() ? 1 : 0;
		inputs[20] = cs.getValuablePropertyStolen() ? 1 : 0;
		inputs[21] = cs.getVictimCovered() ? 1 : 0;
		inputs[22] = cs.getVictimDruggedAndOrPoisoned() ? 1 : 0;
		inputs[23] = cs.getVictimFoundAtTheSameSceneWhereTheyWereKilled() ? 1 : 0;
		inputs[24] = cs.getVictimFoundInWater() ? 1 : 0;
		inputs[25] = cs.getVictimNaked() ? 1 : 0;
		inputs[26] = cs.getVictimPartiallyUndressed() ? 1 : 0;
		inputs[27] = cs.getVictimWasBlindfolded() ? 1 : 0;
		inputs[28] = cs.getWeaponBroughtToScene() ? 1 : 0;
		inputs[29] = cs.getWeaponFromTheScene() ? 1 : 0;
		inputs[30] = cs.getWoundsCausedByBluntInstrument() ? 1 : 0;
		inputs[31] = cs.getWoundsToTheFace() ? 1 : 0;
		inputs[32] = cs.getWoundsToTheHead() ? 1 : 0;
		inputs[33] = cs.getWoundsToTheLimbs() ? 1 : 0;
		inputs[34] = cs.getWoundsToTheNeck() ? 1 : 0;
		inputs[35] = cs.getWoundsToTheTorso() ? 1 : 0;
	}



	public void serialize(String path, NeuralNetwork nw) {
		ObjectOutputStream oos = null;

		try {
			oos = new ObjectOutputStream(new FileOutputStream(path));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			oos.writeObject(nw);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}



	@SuppressWarnings("resource")
	public Object deserialize(String path) {
		ObjectInputStream oos = null;

		try {
			oos = new ObjectInputStream(new FileInputStream(path));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			return oos.readObject();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return null;
	}

}
