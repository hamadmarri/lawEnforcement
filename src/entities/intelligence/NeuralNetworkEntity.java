package entities.intelligence;

import intelligence.neural_network.NeuralNetwork;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;


/**
 * Entity implementation class for Entity: NeuralNetworkEntity
 * 
 */
@Entity
@NamedQueries({
		@NamedQuery(name = "NeuralNetworkEntity.findAll", query = "select n from NeuralNetworkEntity n"),
		@NamedQuery(name = "NeuralNetworkEntity.findById", query = "select n from NeuralNetworkEntity n WHERE n.id = :id") })
public class NeuralNetworkEntity implements Serializable {

	private static final long serialVersionUID = -4682302327271726508L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Lob
	private NeuralNetwork neuralNetwork;



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public NeuralNetwork getNeuralNetwork() {
		return neuralNetwork;
	}



	public void setNeuralNetwork(NeuralNetwork neuralNetwork) {
		this.neuralNetwork = neuralNetwork;
	}

}
