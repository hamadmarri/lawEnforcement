package entities.intelligence;

import static org.junit.Assert.assertArrayEquals;
import intelligence.FillUpDatabaseWithCrimeScenesAndOffenderProfiles;
import intelligence.neural_network.NeuralNetwork;
import intelligence.neural_network.trainers.OffenderProfileGeneratorTrainer;
import intelligence.neural_network.trainers.Trainer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import entities.police.CrimeScene;
import entities.police.OffenderProfile;


public class NeuralNetworkTest {

	// path of input file that NN trainer will use
	private static String inputPath;

	// path of output file that NN trainer will use
	private static String outputPath;

	// NN object
	private static NeuralNetwork nw;

	// NN trainer
	private static Trainer trainer;

	private static FillUpDatabaseWithCrimeScenesAndOffenderProfiles fudb = new FillUpDatabaseWithCrimeScenesAndOffenderProfiles();

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

//		String serPath = "./test/entities/intelligence/nn.ser";
//		nw = (NeuralNetwork) deserialize(serPath);

		// NN configuration for number of nodes in each layer
		 int[] config = new int[] { 36, 24, 21 };

		// creating new NN
		 nw = new NeuralNetwork(config, 0.52, 0.15);

		// NN trainer
		 trainer = new OffenderProfileGeneratorTrainer(inputPath, outputPath,
		 nw, 50000);

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

		CrimeScene.convertCrimeSceneToArray(cs, inputs);
		OffenderProfile.convertOffenderProfileToArray(op, expectedOutputs);

		nw.setInputValues(inputs);
		nw.feedForward();
		actualOutputs = nw.getResults();

		assertArrayEquals(expectedOutputs, actualOutputs, errorDeltaAccepted);
	}



	@Test
	public void priorBurglaryTest() {
		fudb.priorBurglary(cs, op);

		CrimeScene.convertCrimeSceneToArray(cs, inputs);
		OffenderProfile.convertOffenderProfileToArray(op, expectedOutputs);

		nw.setInputValues(inputs);
		nw.feedForward();
		actualOutputs = nw.getResults();

		assertArrayEquals(expectedOutputs, actualOutputs, errorDeltaAccepted);
	}



	@Test
	public void priorViolenceTest() {
		fudb.priorViolence(cs, op);

		CrimeScene.convertCrimeSceneToArray(cs, inputs);
		OffenderProfile.convertOffenderProfileToArray(op, expectedOutputs);

		nw.setInputValues(inputs);
		nw.feedForward();
		actualOutputs = nw.getResults();

		assertArrayEquals(expectedOutputs, actualOutputs, errorDeltaAccepted);
	}



	@Test
	public void youngOffenderTest() {
		fudb.youngOffender(cs, op);

		CrimeScene.convertCrimeSceneToArray(cs, inputs);
		OffenderProfile.convertOffenderProfileToArray(op, expectedOutputs);

		nw.setInputValues(inputs);
		nw.feedForward();
		actualOutputs = nw.getResults();

		assertArrayEquals(expectedOutputs, actualOutputs, errorDeltaAccepted);
	}



	@Test
	public void priorFraudTest() {
		fudb.priorFraud(cs, op);

		CrimeScene.convertCrimeSceneToArray(cs, inputs);
		OffenderProfile.convertOffenderProfileToArray(op, expectedOutputs);

		nw.setInputValues(inputs);
		nw.feedForward();
		actualOutputs = nw.getResults();

		assertArrayEquals(expectedOutputs, actualOutputs, errorDeltaAccepted);
	}



	@Test
	public void maleTest() {
		fudb.male(cs, op);

		CrimeScene.convertCrimeSceneToArray(cs, inputs);
		OffenderProfile.convertOffenderProfileToArray(op, expectedOutputs);

		nw.setInputValues(inputs);
		nw.feedForward();
		actualOutputs = nw.getResults();

		assertArrayEquals(expectedOutputs, actualOutputs, errorDeltaAccepted);
	}



	@Test
	public void relatedToVictimTest() {
		fudb.relatedToVictim(cs, op);

		CrimeScene.convertCrimeSceneToArray(cs, inputs);
		OffenderProfile.convertOffenderProfileToArray(op, expectedOutputs);

		nw.setInputValues(inputs);
		nw.feedForward();
		actualOutputs = nw.getResults();

		assertArrayEquals(expectedOutputs, actualOutputs, errorDeltaAccepted);
	}



	@Test
	public void psychiatricOrSocialProblemsTest() {
		fudb.psychiatricOrSocialProblems(cs, op);

		CrimeScene.convertCrimeSceneToArray(cs, inputs);
		OffenderProfile.convertOffenderProfileToArray(op, expectedOutputs);

		nw.setInputValues(inputs);
		nw.feedForward();
		actualOutputs = nw.getResults();

		assertArrayEquals(expectedOutputs, actualOutputs, errorDeltaAccepted);
	}



	@Test
	public void recordOfImprisonmentTest() {
		fudb.recordOfImprisonment(cs, op);

		CrimeScene.convertCrimeSceneToArray(cs, inputs);
		OffenderProfile.convertOffenderProfileToArray(op, expectedOutputs);

		nw.setInputValues(inputs);
		nw.feedForward();
		actualOutputs = nw.getResults();

		assertArrayEquals(expectedOutputs, actualOutputs, errorDeltaAccepted);
	}



	@Test
	public void unemployedAtTheTimeOfOffenseTest() {
		fudb.unemployedAtTheTimeOfOffense(cs, op);

		CrimeScene.convertCrimeSceneToArray(cs, inputs);
		OffenderProfile.convertOffenderProfileToArray(op, expectedOutputs);

		nw.setInputValues(inputs);
		nw.feedForward();
		actualOutputs = nw.getResults();

		assertArrayEquals(expectedOutputs, actualOutputs, errorDeltaAccepted);
	}



	@Test
	public void knewVictimTest() {
		fudb.knewVictim(cs, op);

		CrimeScene.convertCrimeSceneToArray(cs, inputs);
		OffenderProfile.convertOffenderProfileToArray(op, expectedOutputs);

		nw.setInputValues(inputs);
		nw.feedForward();
		actualOutputs = nw.getResults();

		assertArrayEquals(expectedOutputs, actualOutputs, errorDeltaAccepted);
	}



	@Test
	public void relationshipWithVictimTest() {
		fudb.relationshipWithVictim(cs, op);

		CrimeScene.convertCrimeSceneToArray(cs, inputs);
		OffenderProfile.convertOffenderProfileToArray(op, expectedOutputs);

		nw.setInputValues(inputs);
		nw.feedForward();
		actualOutputs = nw.getResults();

		assertArrayEquals(expectedOutputs, actualOutputs, errorDeltaAccepted);
	}



	@Test
	public void suicideTest() {
		fudb.suicide(cs, op);

		CrimeScene.convertCrimeSceneToArray(cs, inputs);
		OffenderProfile.convertOffenderProfileToArray(op, expectedOutputs);

		nw.setInputValues(inputs);
		nw.feedForward();
		actualOutputs = nw.getResults();

		assertArrayEquals(expectedOutputs, actualOutputs, errorDeltaAccepted);
	}



	@Test
	public void bloodRelatedToVictimTest() {
		fudb.bloodRelatedToVictim(cs, op);

		CrimeScene.convertCrimeSceneToArray(cs, inputs);
		OffenderProfile.convertOffenderProfileToArray(op, expectedOutputs);

		nw.setInputValues(inputs);
		nw.feedForward();
		actualOutputs = nw.getResults();

		assertArrayEquals(expectedOutputs, actualOutputs, errorDeltaAccepted);
	}



	@Test
	public void turnedSelfIntoPoliceTest() {
		fudb.turnedSelfIntoPolice(cs, op);

		CrimeScene.convertCrimeSceneToArray(cs, inputs);
		OffenderProfile.convertOffenderProfileToArray(op, expectedOutputs);

		nw.setInputValues(inputs);
		nw.feedForward();
		actualOutputs = nw.getResults();

		assertArrayEquals(expectedOutputs, actualOutputs, errorDeltaAccepted);
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
	public static Object deserialize(String path) {
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
