package controllers;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import entities.entries.Property;


@ManagedBean(name = "controllerProperty")
@ViewScoped
public class ControllerProperty extends RelatableController<Property> implements Serializable {

	private static final long serialVersionUID = 4575708242261456175L;



	@PostConstruct
	public void init() {
		this.type = "Property";
	}



	public void createNewProperty() {
		this.relatable = new Property();
		super.setNewRelatable(true);
	}



	public Property getProperty() {
		return super.getRelatable();
	}



	public void setProperty(Property property) {
		this.relatable = property;
	}



	public List<Property> getPropertiesList() {
		return super.getList();
	}



	public void setPropertiesList(List<Property> list) {
		super.setList(list);
	}

}
