package controllers;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import entities.entries.Location;


@ManagedBean(name = "controllerLocation")
@ViewScoped
public class ControllerLocation extends AbstarctController<Location> implements Serializable {

	private static final long serialVersionUID = 2681043919446615802L;



	public Location getLocation() {
		return super.getRelatable();
	}



	public void setLocation(Location location) {
		this.relatable = location;
	}

}
