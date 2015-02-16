package controllers.intelligence;

import intelligence.NeuralNetwork.NeuralNetwork;
import intelligence.NeuralNetwork.Trainers.OffenderProfileGeneratorTrainerFromDB;
import intelligence.NeuralNetwork.Trainers.Trainer;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ejbs.EjbCrimeScene;
import ejbs.EjbNeuralNetworkEntity;
import entities.intelligence.CrimeScene;
import entities.intelligence.NeuralNetworkEntity;
import entities.intelligence.OffenderProfile;


@ManagedBean(name = "controllerNeuralNetworkEntity")
@ViewScoped
public class ControllerNeuralNetworkEntity {

	// EJB for NN Entity object
	@EJB
	private EjbNeuralNetworkEntity ejbNeuralNetworkEntity;

	@EJB
	private EjbCrimeScene ejbCrimeScene;

	private NeuralNetworkEntity nne = null;
	private NeuralNetwork nn;
	private List<CrimeScene> crimeScenes;

	// NN trainer
	private static Trainer trainer;

	private OffenderProfile suggestedOffenderProfile = null;



	public void train() {

		// NN configuration for number of nodes in each layer
		int[] config = new int[] { 36, 24, 21 };
		double learningRate = 0.52;
		double momentum = 0.15;

		// check if it is exist
		try {
			nne = ejbNeuralNetworkEntity.getList().get(0);
			nn = nne.getNeuralNetwork();
			doTraining();
			ejbNeuralNetworkEntity.save(nne);
		} catch (ArrayIndexOutOfBoundsException e) {
			nne = new NeuralNetworkEntity();
			nn = new NeuralNetwork(config, learningRate, momentum);
			nne.setNeuralNetwork(nn);

			doTraining();
			ejbNeuralNetworkEntity.add(nne);
		}

	}



	private void doTraining() {
		crimeScenes = ejbCrimeScene.getList();
		trainer = new OffenderProfileGeneratorTrainerFromDB(nn, crimeScenes, 50000);

		trainer.train();
	}



	public OffenderProfile getSuggestedOffenderProfile(CrimeScene cs) {
		if (suggestedOffenderProfile == null) {
			double[] inputs = new double[36];
			double[] outputs;

			nn = getNne().getNeuralNetwork();
			CrimeScene.convertCrimeSceneToArray(cs, inputs);
			nn.setInputValues(inputs);
			nn.feedForward();
			outputs = nn.getResults();

			suggestedOffenderProfile = OffenderProfile.convertArrayToOffenderProfile(outputs);
		}

		return suggestedOffenderProfile;
	}



	public void setSuggestedOffenderProfile(OffenderProfile suggestedOffenderProfile) {
		this.suggestedOffenderProfile = suggestedOffenderProfile;
	}



	public NeuralNetworkEntity getNne() {
		if (nne == null)
			nne = ejbNeuralNetworkEntity.getList().get(0);

		return nne;
	}



	public void setNne(NeuralNetworkEntity nne) {
		this.nne = nne;
	}

}
