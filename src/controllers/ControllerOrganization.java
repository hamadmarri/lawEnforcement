package controllers;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import entities.entries.Organization;


/**
 * @author hamadalmarri
 * 
 * @Pages
 *        - listOrganizations.xhtml
 *        - viewOrganization.xhtml
 *        - addOrganization.xhtml
 *        - editOrganization.xhtml
 */
@ManagedBean(name = "controllerOrganization")
@ViewScoped
public class ControllerOrganization extends AbstractController<Organization> implements Serializable {

	private static final long serialVersionUID = 1366618647447539994L;



	/**
	 * will be called automatically right after the class is constructed since
	 * it has the PostConstruct annotation
	 */
	@PostConstruct
	public void init() {
		// at the beginning, set the entitiy name to be Organization
		this.type = "Organization";
	}



	/**
	 * to initiate new object of Organization. This function will be called from
	 * addOrganization.xhtml page at preRenderView phase
	 */
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
