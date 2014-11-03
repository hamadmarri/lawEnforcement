package entities.entries;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import entities.Relatable;
import entities.entries.history.Action;


/**
 * Entity implementation class for Entity: Address
 * 
 */
@Entity
@NamedQueries({ @NamedQuery(name = "Address.findAll", query = "select a from Address a") })
public class Address extends Entry {

	private static final long serialVersionUID = 4813533643600059461L;

	private String streetName;
	private String aptNo;
	private String city;
	private String province;
	private String country;
	private String postalCode;

	@ManyToMany(mappedBy = "addresses")
	List<Location> locations;



	public Address() {
		super();
		this.type = "Address";
		this.streetName = new String();
		this.aptNo = new String();
		this.city = new String();
		this.province = new String();
		this.country = new String();
		this.postalCode = new String();
	}



	public Address(String streetName, String aptNo, String city, String province, String country, String postalCode) {
		super();
		this.type = "Address";
		setStreetName(streetName);
		setAptNo(aptNo);
		setCity(city);
		setProvince(province);
		setCountry(country);
		setPostalCode(postalCode);
	}



	public String getStreetName() {
		return streetName;
	}



	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}



	public String getAptNo() {
		return aptNo;
	}



	public void setAptNo(String aptNo) {
		this.aptNo = aptNo;
	}



	public String getCity() {
		return city;
	}



	public void setCity(String city) {
		this.city = city;
	}



	public String getProvince() {
		return province;
	}



	public void setProvince(String province) {
		this.province = province;
	}



	public String getCountry() {
		return country;
	}



	public void setCountry(String country) {
		this.country = country;
	}



	public String getPostalCode() {
		return postalCode;
	}



	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}



	public List<Location> getLocations() {
		return locations;
	}



	@Override
	public void logChanges(Object old) {
		Address oldA = (Address) old;

		if (!this.streetName.equals(oldA.streetName))
			this.getHistory().addAction(new Action("streetName", this.streetName, oldA.streetName));

		if (!this.aptNo.equals(oldA.aptNo))
			this.getHistory().addAction(new Action("aptNo", this.aptNo, oldA.aptNo));

		if (!this.city.equals(oldA.city))
			this.getHistory().addAction(new Action("city", this.city, oldA.city));

		if (!this.province.equals(oldA.province))
			this.getHistory().addAction(new Action("province", this.province, oldA.province));

		if (!this.country.equals(oldA.country))
			this.getHistory().addAction(new Action("country", this.country, oldA.country));

		if (!this.postalCode.equals(oldA.postalCode))
			this.getHistory().addAction(new Action("postalCode", this.postalCode, oldA.postalCode));
	}



	@Override
	public String toString() {
		return this.streetName + " " + this.getAptNo() + this.city + " " + this.province + " " + this.postalCode;
	}

}
