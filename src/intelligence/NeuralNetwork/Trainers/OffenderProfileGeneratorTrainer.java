package intelligence.NeuralNetwork.Trainers;

import intelligence.NeuralNetwork.NeuralNetwork;


public class OffenderProfileGeneratorTrainer extends Trainer {

	public OffenderProfileGeneratorTrainer(String inputFileName, String outputFileName, NeuralNetwork neuralNetwork,
			int numberOfPasses) {
		super(inputFileName, outputFileName, neuralNetwork, numberOfPasses);
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

		for (int i = 0; i < this.numberOfPasses; i++) {
//			this.outputFile
//					.println("\n############################ pass: " + (i + 1) + " ############################");

			for (int inputIndex = 0; inputIndex < inputs.length; inputIndex++)
				inputs[inputIndex] = inputFile.nextInt();

			for (int outputIndex = 0; outputIndex < outputs.length - 1; outputIndex++)
				outputs[outputIndex] = inputFile.nextInt();

			outputs[21] = 1;

			this.neuralNetwork.setInputValues(inputs);
			this.neuralNetwork.feedForward();
			this.neuralNetwork.backPropagate(outputs);
			
//			this.neuralNetwork.printResult(this.outputFile);
//
//			outputFile.println("expected outputs:");
//			for (int outputIndex = 0; outputIndex < outputs.length - 1; outputIndex++)
//				outputFile.println(outputIndex + ")\t" + outputs[outputIndex]);

			if (!inputFile.hasNext())
				initializeInputFile(inputFileName);
			
		} // for

		endTraining();
	}

}
