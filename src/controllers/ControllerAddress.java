package controllers;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import entities.entries.Address;


@ManagedBean(name = "controllerAddress")
@ViewScoped
public class ControllerAddress extends AbstarctController<Address> implements Serializable {

	private static final long serialVersionUID = -6208826240564103804L;



	@PostConstruct
	public void init() {
		this.type = "Address";
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
}
