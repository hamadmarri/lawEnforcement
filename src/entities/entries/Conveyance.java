package entities.entries;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import entities.Relatable;
import entities.entries.history.Action;


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

	@ManyToOne(cascade = CascadeType.MERGE)
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
		this.vehicleIdentificationNumber = new String();
		this.licensePlateNumber = new String();
		this.licensePlateState = new String();
		this.licensePlateYear = new Date();
		this.make = new String();
		this.model = new String();
		this.year = new Date();
		this.color = new String();
		this.style = new String();
		this.attributes = new String();
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
	public void logChanges(Object old) {
		Conveyance oldC = (Conveyance) old;

		if (!this.vehicleIdentificationNumber.equals(oldC.vehicleIdentificationNumber)) {
			
			if (this.getHistory() == null)
				System.out.println("***** history is null");
			
			this.getHistory().addAction(
					new Action("vehicleIdentificationNumber", this.vehicleIdentificationNumber,
							oldC.vehicleIdentificationNumber));
		}

		if (!this.licensePlateNumber.equals(oldC.licensePlateNumber))
			this.getHistory().addAction(
					new Action("licensePlateNumber", this.licensePlateNumber, oldC.licensePlateNumber));

		if (!this.licensePlateState.equals(oldC.licensePlateState))
			this.getHistory()
					.addAction(new Action("licensePlateState", this.licensePlateState, oldC.licensePlateState));

		if (!this.make.equals(oldC.make))
			this.getHistory().addAction(new Action("make", this.make, oldC.make));

		if (!this.model.equals(oldC.model))
			this.getHistory().addAction(new Action("model", this.model, oldC.model));

		if (!this.color.equals(oldC.color))
			this.getHistory().addAction(new Action("color", this.color, oldC.color));

		if (!this.style.equals(oldC.style))
			this.getHistory().addAction(new Action("style", this.style, oldC.style));

		if (!this.attributes.equals(oldC.attributes))
			this.getHistory().addAction(new Action("attributes", this.attributes, oldC.attributes));

		if (this.licensePlateYear.compareTo(oldC.licensePlateYear) != 0)
			this.getHistory().addAction(
					new Action("licensePlateYear", this.licensePlateYear.toString(), oldC.licensePlateYear.toString()));

		if (this.year.compareTo(oldC.year) != 0)
			this.getHistory().addAction(new Action("year", this.year.toString(), oldC.year.toString()));

		if (this.registeredOwner.getId().compareTo(oldC.registeredOwner.getId()) != 0)
			this.getHistory().addAction(
					new Action("registeredOwner id", this.registeredOwner.getId().toString(), oldC.registeredOwner
							.getId().toString()));

	}



	public boolean isEqual(Conveyance another) {
		return (this.vehicleIdentificationNumber.equals(another.vehicleIdentificationNumber)
				&& this.licensePlateNumber.equals(another.licensePlateNumber)
				&& this.licensePlateState.equals(another.licensePlateState) && this.make.equals(another.make)
				&& this.model.equals(another.model) && this.color.equals(another.color) && this.style.equals(another.style)
				&& this.attributes.equals(another.attributes) && this.licensePlateYear.compareTo(another.licensePlateYear) == 0
				&& this.year.compareTo(another.year) == 0 && this.registeredOwner.getId().compareTo(
				another.registeredOwner.getId()) == 0);
	}



	@Override
	public String toString() {
		return this.vehicleIdentificationNumber + " " + this.licensePlateNumber + " " + this.licensePlateState + " "
				+ this.make + " " + this.model + " " + this.color + " " + this.style + " " + this.attributes + " "
				+ this.licensePlateYear.toString() + " " + this.year.toString() + " " + this.registeredOwner.getId();
	}

}
