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


/**
 * @author hamadalmarri
 * 
 * @Pages
 *        - addAddress.xhtml
 *        - editAddress.xhtml
 *        - listAddresses.xhtml
 *        - viewAddress.xhtml
 * 
 * @Relative_Objects
 *                   - Location who owen this Activity
 * 
 * @TODO
 *       TODO: add the ability to link an existed Address to an
 *       existed Location, for now, from
 *       viewLocation.xhtml page the user able to click on add below
 *       Addresses list and that will
 *       open addActivity.xthml page and pass the location id in
 *       page prameters.
 */
@ManagedBean(name = "controllerAddress", eager = true)
@ViewScoped
public class ControllerAddress extends AbstractController<Address> implements Serializable {

	private static final long serialVersionUID = -6208826240564103804L;

	// EJB for Location object
	@EJB
	private AbstractEjb<Location> ejbLocation;

	// get location id if any to make a relation with this address
	private String locationId;



	/**
	 * will be called automatically right after the class is constructed since
	 * it has the PostConstruct annotation
	 */
	@PostConstruct
	public void init() {
		// at the beginning, set the entitiy name to be Address
		this.type = "Address";
	}



	/**
	 * to submit changes on the Address object
	 * 
	 * @return
	 * 
	 *         "success" which is used for navigation engine to redirect to the
	 *         proper page
	 *         
	 *         "successForLocation" to redirect to location page
	 */
	@Override
	public String submit() {
		
		// submit Address first
		super.submit();

		// if location id is not null, add this address to the location object
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



	/**
	 * to initiate new object of Address. This function will be called from
	 * addAddress.xhtml page at preRenderView phase
	 */
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
