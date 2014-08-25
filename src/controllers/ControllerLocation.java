package controllers;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import entities.entries.Location;


@ManagedBean(name = "controllerLocation", eager = true)
@ViewScoped
public class ControllerLocation extends ControllerRelatable<Location> implements Serializable {

	private static final long serialVersionUID = 2681043919446615802L;



	@PostConstruct
	public void init() {
		this.type = "Location";
	}



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
