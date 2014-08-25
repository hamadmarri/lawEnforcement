package controllers;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ejbs.AbstractEjb;
import entities.entries.Address;
import entities.entries.Location;


@ManagedBean(name = "controllerAddress", eager = true)
@ViewScoped
public class ControllerAddress extends ControllerRelatable<Address> implements Serializable {

	private static final long serialVersionUID = -6208826240564103804L;

	@EJB
	private AbstractEjb<Location> ejbLocation;
	private String locationId;



	@PostConstruct
	public void init() {
		this.type = "Address";
	}



	@Override
	public String submit() {
		super.submit();

		if (this.locationId != null) {

			// update location based on this address
			Location l = (Location) this.ejbLocation.getEntity(Long.parseLong(this.getLocationId()));
			l.addAddress(this.relatable);
			this.ejbLocation.save(l);

			return "successForLocation";
		} else {
			return "success";
		}
	}



	public void createNewAddress() {
		this.relatable = new Address();
		super.setNewRelatable(true);
	}



	public Address getAddress() {
		return super.getRelatable();
	}



	public void setAddress(Address address) {
		this.relatable = address;
	}



	public List<Address> getAddressesList() {
		return super.getList();
	}



	public void setAddressesList(List<Address> list) {
		super.setList(list);
	}



	public String getLocationId() {
		return locationId;
	}



	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}

}
