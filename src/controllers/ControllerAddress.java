package controllers;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import entities.entries.Address;


@ManagedBean(name = "controllerAddress")
@ViewScoped
public class ControllerAddress extends AbstarctController<Address> implements Serializable {

	private static final long serialVersionUID = -6208826240564103804L;



	public Address getAddress() {
		return super.getRelatable();
	}



	public void setAddress(Address address) {
		this.relatable = address;
	}

}
