package controllers;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import entities.entries.Person;


@ManagedBean(name = "controllerPerson")
@ViewScoped
public class ControllerPerson extends AbstarctController<Person> implements Serializable {

	private static final long serialVersionUID = -328811918930855338L;

}
