package entities.entries;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * Entity implementation class for Entity: Conveyance
 * 
 */
@Entity
@NamedQueries({ @NamedQuery(name = "Conveyance.findAll", query = "select c from Conveyance c") })
public class Conveyance extends Entry {

	private static final long serialVersionUID = -3541340568029240812L;

	private String vehicleIdentificationNumber;
	private String licensePlateNumber;
	private String licensePlateState;

	@Temporal(TemporalType.DATE)
	private Date licensePlateYear;

	@ManyToOne(cascade = CascadeType.ALL)
	private Person registeredOwner;

	private String make;
	private String model;

	@Temporal(TemporalType.DATE)
	private Date year;

	private String color;
	private String style;
	private String attributes;



	public Conveyance() {
		super();
		this.type = "Conveyance";
	}



	public Conveyance(String vehicleIdentificationNumber, String licensePlateNumber, String licensePlateState,
			Date licensePlateYear, String make, String model, Date year, String color, String style, String attributes) {
		super();
		this.type = "Conveyance";
		this.vehicleIdentificationNumber = vehicleIdentificationNumber;
		this.licensePlateNumber = licensePlateNumber;
		this.licensePlateState = licensePlateState;
		this.licensePlateYear = licensePlateYear;
		this.make = make;
		this.model = model;
		this.year = year;
		this.color = color;
		this.style = style;
		this.attributes = attributes;
	}



	public String getVehicleIdentificationNumber() {
		return vehicleIdentificationNumber;
	}



	public void setVehicleIdentificationNumber(String vehicleIdentificationNumber) {
		this.vehicleIdentificationNumber = vehicleIdentificationNumber;
	}



	public String getLicensePlateNumber() {
		return licensePlateNumber;
	}



	public void setLicensePlateNumber(String licensePlateNumber) {
		this.licensePlateNumber = licensePlateNumber;
	}



	public String getLicensePlateState() {
		return licensePlateState;
	}



	public void setLicensePlateState(String licensePlateState) {
		this.licensePlateState = licensePlateState;
	}



	public Date getLicensePlateYear() {
		return licensePlateYear;
	}



	public void setLicensePlateYear(Date licensePlateYear) {
		this.licensePlateYear = licensePlateYear;
	}



	public Person getRegisteredOwner() {
		return registeredOwner;
	}



	public void setRegisteredOwner(Person registeredOwner) {
		this.registeredOwner = registeredOwner;
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



	public Date getYear() {
		return year;
	}



	public void setYear(Date year) {
		this.year = year;
	}



	public String getColor() {
		return color;
	}



	public void setColor(String color) {
		this.color = color;
	}



	public String getStyle() {
		return style;
	}



	public void setStyle(String style) {
		this.style = style;
	}



	public String getAttributes() {
		return attributes;
	}



	public void setAttributes(String attributes) {
		this.attributes = attributes;
	}



	@Override
	public String toString() {
		return this.vehicleIdentificationNumber + " " + this.make + " " + this.model;
	}

}
