package controllers.intelligence;

import intelligence.neural_network.NeuralNetwork;
import intelligence.neural_network.trainers.CrimePreventionTrainer;
import intelligence.neural_network.trainers.OffenderProfileGeneratorTrainerFromDB;
import intelligence.neural_network.trainers.Trainer;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ejbs.EjbCrimeScene;
import ejbs.EjbNeuralNetworkEntity;
import ejbs.EjbPerson;
import ejbs.EjbYouthRiskFactors;
import entities.entries.Crime;
import entities.entries.Person;
import entities.entries.YouthRiskFactors;
import entities.intelligence.NeuralNetworkEntity;
import entities.police.CrimeScene;
import entities.police.OffenderProfile;


@ManagedBean(name = "controllerNeuralNetworkEntity")
@ViewScoped
public class ControllerNeuralNetworkEntity {

	// EJB for NN Entity object
	@EJB
	private EjbNeuralNetworkEntity ejbNeuralNetworkEntity;

	@EJB
	private EjbCrimeScene ejbCrimeScene;

	@EJB
	private EjbYouthRiskFactors ejbYouthRiskFactors;

	@EJB
	private EjbPerson ejbPerson;

	private NeuralNetworkEntity nneForOffenderProfile = null;
	private NeuralNetwork nnForOffenderProfile;
	private NeuralNetworkEntity nneForYouthRisk = null;
	private NeuralNetwork nnForYouthRisk;
	private List<CrimeScene> crimeScenes;
	private List<YouthRiskFactors> yrfs;

	// NN trainer
	private static Trainer trainer;

	private OffenderProfile suggestedOffenderProfile = null;

	private List<Person> youthInRiskList = null;



	public void trainForOffenderProfile() {

		// NN configuration for number of nodes in each layer
		int[] config = new int[] { 36, 24, 21 };
		double learningRate = 0.52;
		double momentum = 0.15;

		// check if it is exist
		try {
			nneForOffenderProfile = ejbNeuralNetworkEntity.getList().get(0);
			nnForOffenderProfile = nneForOffenderProfile.getNeuralNetwork();
			doTrainingForOffenderProfile();
			ejbNeuralNetworkEntity.save(nneForOffenderProfile);
		} catch (ArrayIndexOutOfBoundsException e) {
			nneForOffenderProfile = new NeuralNetworkEntity();
			nnForOffenderProfile = new NeuralNetwork(config, learningRate, momentum);
			nneForOffenderProfile.setNeuralNetwork(nnForOffenderProfile);

			doTrainingForOffenderProfile();
			ejbNeuralNetworkEntity.add(nneForOffenderProfile);
		}
	}



	private void doTrainingForOffenderProfile() {
		crimeScenes = ejbCrimeScene.getList();
		trainer = new OffenderProfileGeneratorTrainerFromDB(nnForOffenderProfile, crimeScenes, 50000);
		trainer.train();
	}



	public OffenderProfile getSuggestedOffenderProfile(CrimeScene cs) {
		if (suggestedOffenderProfile == null) {
			double[] inputs = new double[36];
			double[] outputs;

			nnForOffenderProfile = getNneForOffenderProfile().getNeuralNetwork();
			CrimeScene.convertCrimeSceneToArray(cs, inputs);
			nnForOffenderProfile.setInputValues(inputs);
			nnForOffenderProfile.feedForward();
			outputs = nnForOffenderProfile.getResults();

			suggestedOffenderProfile = OffenderProfile.convertArrayToOffenderProfile(outputs);
		}

		return suggestedOffenderProfile;
	}



	public void setSuggestedOffenderProfile(OffenderProfile suggestedOffenderProfile) {
		this.suggestedOffenderProfile = suggestedOffenderProfile;
	}



	public NeuralNetworkEntity getNneForOffenderProfile() {
		if (nneForOffenderProfile == null)
			nneForOffenderProfile = ejbNeuralNetworkEntity.getList().get(0);

		return nneForOffenderProfile;
	}



	public void setNneForOffenderProfile(NeuralNetworkEntity nne) {
		this.nneForOffenderProfile = nne;
	}



	public void trainForYouthRisk() {

		// NN configuration for number of nodes in each layer
		int[] config = new int[] { 27, 18, 7 };
		double learningRate = 0.52;
		double momentum = 0.15;

		// check if it is exist
		try {
			nneForYouthRisk = ejbNeuralNetworkEntity.getList().get(1);
			nnForYouthRisk = nneForYouthRisk.getNeuralNetwork();
			doTrainingForYouthRisk();
			ejbNeuralNetworkEntity.save(nneForYouthRisk);
		} catch (ArrayIndexOutOfBoundsException e) {
			nneForYouthRisk = new NeuralNetworkEntity();
			nnForYouthRisk = new NeuralNetwork(config, learningRate, momentum);
			nneForYouthRisk.setNeuralNetwork(nnForYouthRisk);

			doTrainingForYouthRisk();
			ejbNeuralNetworkEntity.add(nneForYouthRisk);
		}

		updateYouthInRiskPersonsInDB();
	}



	private void doTrainingForYouthRisk() {
		yrfs = ejbYouthRiskFactors.getList();
		trainer = new CrimePreventionTrainer(nnForYouthRisk, yrfs, 50000);
		trainer.train();
	}



	private void updateYouthInRiskPersonsInDB() {

		List<Person> persons = ejbPerson.getList();

		for (Person p : persons) {
			YouthRiskFactors yrf = p.getYouthRiskFactors();

			double[] inputs = new double[27];
			double[] outputs;

			nnForYouthRisk = getNneForYouthRisk().getNeuralNetwork();
			YouthRiskFactors.convertYouthRiskFactorsToArray(yrf, inputs);
			nnForYouthRisk.setInputValues(inputs);
			nnForYouthRisk.feedForward();
			outputs = nnForYouthRisk.getResults();

			// check if person in risk
			for (int i = 0; i < 7; i++) {
				if (Math.round(outputs[i]) == 1) {
					p.setInRisk(true);
					p.setRiskType(Crime.convertArrayToCrime(outputs).getTypeOfCrime());
					ejbPerson.save(p);
					break;
				}
			}
		}
	}



	public List<Person> getYouthInRiskList() {
		if (youthInRiskList == null)
			youthInRiskList = ejbYouthRiskFactors.getYouthInRiskList();

		return youthInRiskList;
	}



	public void setYouthInRiskList(List<Person> youthInRiskList) {
		this.youthInRiskList = youthInRiskList;
	}



	public NeuralNetworkEntity getNneForYouthRisk() {
		if (nneForYouthRisk == null)
			nneForYouthRisk = ejbNeuralNetworkEntity.getList().get(1);

		return nneForYouthRisk;
	}



	public void setNneForYouthRisk(NeuralNetworkEntity nneForYouthRisk) {
		this.nneForYouthRisk = nneForYouthRisk;
	}

}
