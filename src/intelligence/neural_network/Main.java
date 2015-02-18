package intelligence.neural_network;

import intelligence.neural_network.trainers.Trainer;
import intelligence.neural_network.trainers.XorTrainer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class Main {

	public static void main_(String[] args) {
		// int[] config = new int[] { 2, 4, 1 };
		// NeuralNetwork nw = new NeuralNetwork(config, 0.02, 0.15);
		String inputPath = "/Users/hamadalmarri/Development/eclipse/NeuralNetwork/input.txt";
		String outputPath = "/Users/hamadalmarri/Development/eclipse/NeuralNetwork/output.txt";
		String serPath = "/Users/hamadalmarri/Development/eclipse/NeuralNetwork/NN_XOR.ser";

		NeuralNetwork nw = (NeuralNetwork) deserialize(serPath);
		Trainer trainer = new XorTrainer(inputPath, outputPath, nw, 100000);

		train(trainer);

		serialize(serPath, nw);
	}



	private static void train(Trainer trainer) {
		long startTime;
		long endTime;

		trainer.generateTest();
		startTime = System.currentTimeMillis();
		trainer.train();
		endTime = System.currentTimeMillis();
		System.out.println("took: " + (endTime - startTime) + "ms");
	}



	private static void serialize(String path, NeuralNetwork nw) {
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
	private static Object deserialize(String path) {
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
