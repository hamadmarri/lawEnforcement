package intelligence.neural_network.trainers;

import intelligence.neural_network.NeuralNetwork;

import java.util.List;

import entities.entries.Crime;
import entities.entries.YouthRiskFactors;


public class CrimePreventionTrainer extends Trainer {

	private List<YouthRiskFactors> yrfs;
	private int numberOfPassesCopy;



	public CrimePreventionTrainer(NeuralNetwork neuralNetwork, List<YouthRiskFactors> yrfs, int numberOfPasses) {

		super("", "", neuralNetwork, numberOfPasses);

		this.yrfs = yrfs;
		this.numberOfPassesCopy = numberOfPasses;
	}



	@Override
	public void generateTest() {
		return;
	}



	@Override
	public void train() {
		double[] inputs = new double[27];
		double[] outputs = new double[9];

		outputs[8] = 1;

		for (YouthRiskFactors y : yrfs) {

			if (y.getCriminalRecord() == null)
				continue;

			YouthRiskFactors.convertYouthRiskFactorsToArray(y, inputs);

			for (Crime c : y.getCriminalRecord().getCrimes()) {

				Crime.convertCrimeToArray(c, outputs);

				this.neuralNetwork.setInputValues(inputs);
				this.neuralNetwork.feedForward();
				this.neuralNetwork.backPropagate(outputs);
			}

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
