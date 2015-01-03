package controllers.management;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import entities.entries.Location;


/**
 * @author hamadalmarri
 * 
 * @Pages
 *        - listLocations.xhtml
 *        - viewLocation.xhtml
 *        - addLocation.xhtml
 *        - editLocation.xhtml
 */
@ManagedBean(name = "controllerLocation", eager = true)
@ViewScoped
public class ControllerLocation extends AbstractController<Location> implements Serializable {

	private static final long serialVersionUID = 2681043919446615802L;



	/**
	 * will be called automatically right after the class is constructed since
	 * it has the PostConstruct annotation
	 */
	@PostConstruct
	public void init() {
		// at the beginning, set the entitiy name to be Location
		this.type = "Location";
	}



	/**
	 * to initiate new object of Location. This function will be called from
	 * addLocation.xhtml page at preRenderView phase
	 */
	public void createNewLocation() {
		this.relatable = new Location();
		super.setNewRelatable(true);
	}



	public Location getLocation() {
		return super.getRelatable();
	}



	public void setLocation(Location location) {
		this.relatable = location;
	}



	public List<Location> getLocationsList() {
		return super.getList();
	}



	public void setLocationsList(List<Location> list) {
		super.setList(list);
	}

}
