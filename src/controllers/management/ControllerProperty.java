package controllers.management;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import entities.entries.Property;


/**
 * @author hamadalmarri
 * 
 * @Pages
 *        - listProperties.xhtml
 *        - viewProperty.xhtml
 *        - addProperty.xhtml
 *        - editProperty.xhtml
 * 
 */
@ManagedBean(name = "controllerProperty")
@ViewScoped
public class ControllerProperty extends AbstractController<Property> implements Serializable {

	private static final long serialVersionUID = 4575708242261456175L;



	/**
	 * will be called automatically right after the class is constructed since
	 * it has the PostConstruct annotation
	 */
	@PostConstruct
	public void init() {
		// at the beginning, set the entitiy name to be Property
		this.type = "Property";
	}



	/**
	 * to initiate new object of Property. This function will be called from
	 * addProperty.xhtml page at preRenderView phase
	 */
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
