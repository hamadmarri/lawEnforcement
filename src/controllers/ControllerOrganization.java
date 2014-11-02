package controllers;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import entities.entries.Organization;


@ManagedBean(name = "controllerOrganization")
@ViewScoped
public class ControllerOrganization extends AbstractController<Organization> implements Serializable {

	private static final long serialVersionUID = 1366618647447539994L;



	@PostConstruct
	public void init() {
		this.type = "Organization";
	}



	public void createNewOrganization() {
		this.relatable = new Organization();
		super.setNewRelatable(true);
	}



	public Organization getOrganization() {
		return super.getRelatable();
	}



	public void setOrganization(Organization organization) {
		this.relatable = organization;
	}



	public List<Organization> getOrganizationsList() {
		return super.getList();
	}



	public void setOrganizationsList(List<Organization> list) {
		super.setList(list);
	}

}
