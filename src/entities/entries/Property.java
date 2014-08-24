package entities.entries;

import javax.persistence.Entity;


/**
 * Entity implementation class for Entity: Property
 * 
 */
@Entity
public class Property extends Entry {

	private static final long serialVersionUID = -3977967330523305535L;

	private String serialNumber;
	private String make;
	private String model;
	private String brand;
	private String distinguishingCharacteristics;



	public Property() {
		super();
		this.type = "Property";
		this.serialNumber = new String();
		this.make = new String();
		this.model = new String();
		this.brand = new String();
		this.distinguishingCharacteristics = new String();
	}



	public Property(String serialNumber, String make, String model, String brand, String distinguishingCharacteristics) {
		super();
		this.type = "Property";
		this.serialNumber = serialNumber;
		this.make = make;
		this.model = model;
		this.brand = brand;
		this.distinguishingCharacteristics = distinguishingCharacteristics;
	}



	public String getSerialNumber() {
		return serialNumber;
	}



	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}



	public String getMake() {
		return make;
	}



	public void setMake(String make) {
		this.make = make;
	}



	public String getModel() {
		return model;
	}



	public void setModel(String model) {
		this.model = model;
	}



	public String getBrand() {
		return brand;
	}



	public void setBrand(String brand) {
		this.brand = brand;
	}



	public String getDistinguishingCharacteristics() {
		return distinguishingCharacteristics;
	}



	public void setDistinguishingCharacteristics(String distinguishingCharacteristics) {
		this.distinguishingCharacteristics = distinguishingCharacteristics;
	}

}
