package intelligence.neural_network.trainers;

import intelligence.neural_network.NeuralNetwork;

import java.util.List;

import entities.intelligence.CrimeScene;
import entities.intelligence.OffenderProfile;


public class OffenderProfileGeneratorTrainerFromDB extends Trainer {

	private List<CrimeScene> crimeScenes;
	private int numberOfPassesCopy;



	public OffenderProfileGeneratorTrainerFromDB(NeuralNetwork neuralNetwork, List<CrimeScene> crimeScenes,
			int numberOfPasses) {

		super("", "", neuralNetwork, numberOfPasses);

		this.crimeScenes = crimeScenes;
		this.numberOfPassesCopy = numberOfPasses;
	}



	@Override
	public void generateTest() {
		// inputs are already exported from MySQL database under
		// crimeScene_OffenderProfileViewExport.txt filename
		return;
	}



	@Override
	public void train() {
		double[] inputs = new double[36];
		double[] outputs = new double[22];

		outputs[21] = 1;

		for (CrimeScene cs : crimeScenes) {

			if (cs.getOffenderProfile() == null)
				continue;

			CrimeScene.convertCrimeSceneToArray(cs, inputs);
			OffenderProfile.convertOffenderProfileToArray(cs.getOffenderProfile(), outputs);

			this.neuralNetwork.setInputValues(inputs);
			this.neuralNetwork.feedForward();
			this.neuralNetwork.backPropagate(outputs);

			numberOfPassesCopy--;

			if (numberOfPassesCopy == 0)
				break;
		}

		if (numberOfPassesCopy != 0)
			train();
		else
			numberOfPassesCopy = numberOfPasses;
	}

}
