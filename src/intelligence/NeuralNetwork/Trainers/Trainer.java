package intelligence.NeuralNetwork.Trainers;

import intelligence.NeuralNetwork.NeuralNetwork;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;


public abstract class Trainer {
	protected Scanner inputFile;
	protected PrintWriter outputFile;
	protected NeuralNetwork neuralNetwork;
	protected int numberOfPasses = 2000; // default is 2000
	protected String inputFileName;
	protected String outputFileName;



	public Trainer(String inputFileName, String outputFileName, NeuralNetwork neuralNetwork, int numberOfPasses) {

		if (!inputFileName.isEmpty()) {
			this.inputFileName = inputFileName;
			initializeInputFile(inputFileName);

		}

		if (!outputFileName.isEmpty()) {
			this.outputFileName = outputFileName;
			initializeOutputFile(outputFileName);

		}

		this.neuralNetwork = neuralNetwork;
		this.numberOfPasses = numberOfPasses;
	}



	protected void initializeInputFile(String inputFileName) {
		File f = new File(inputFileName);
		if (!f.exists()) {
			try {
				f.createNewFile();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}

		try {
			this.inputFile = new Scanner(new FileInputStream(inputFileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}



	protected void initializeOutputFile(String outputFileName) {
		try {
			this.outputFile = new PrintWriter(outputFileName, "UTF-8");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return;
		}
	}



	public void endTraining() {
		this.inputFile.close();
		this.outputFile.close();
	}



	public abstract void generateTest();



	public abstract void train();

}
