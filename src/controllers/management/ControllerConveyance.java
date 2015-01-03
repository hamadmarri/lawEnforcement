package controllers.management;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ejbs.AbstractEjb;
import entities.entries.Conveyance;
import entities.entries.Person;


/**
 * @author hamadalmarri
 * 
 * @Pages
 *        - addConveyance.xhtml
 *        - editConveyance.xhtml
 *        - listConveyances.xhtml
 *        - viewConveyance.xhtml
 * 
 * @Relative_Objects
 *                   - Person who owen this Conveyance
 * 
 */
@ManagedBean(name = "controllerConveyance")
@ViewScoped
public class ControllerConveyance extends AbstractController<Conveyance> implements Serializable {

	private static final long serialVersionUID = -3709992694215689104L;

	// EJB for Activity object
	@EJB
	AbstractEjb<Person> ejbPerson;

	// the id of person who owen this conveyance
	private Long registeredOwnerId = null;



	/**
	 * will be called automatically right after the class is constructed since
	 * it has the PostConstruct annotation
	 */
	@PostConstruct
	public void init() {
		// at the beginning, set the entitiy name to be Conveyance
		this.type = "Conveyance";
	}



	/**
	 * to submit changes on the Conveyance object
	 * 
	 * @return "success" which is used for navigation engine to redirect to the
	 *         proper page
	 */
	@Override
	public String submit() {
		// update person based on its id
		if (this.registeredOwnerId != null) {
			Person p = (Person) this.ejbPerson.getEntity(this.registeredOwnerId);
			this.getConveyance().setRegisteredOwner(p);
		}

		return super.submit();
	}



	/**
	 * to initiate new object of Conveyance. This function will be called from
	 * addConveyance.xhtml page at preRenderView phase
	 */
	public void createNewConveyance() {
		this.relatable = new Conveyance();
		setNewRelatable(true);
	}



	public Conveyance getConveyance() {
		// hold the id of RegisteredOwner
		Conveyance c = super.getRelatable();
		if (this.registeredOwnerId == null && c != null && c.getRegisteredOwner() != null)
			setRegisteredOwnerId(c.getRegisteredOwner().getId());

		return c;
	}



	public void setConveyance(Conveyance conveyance) {
		this.relatable = conveyance;
	}



	public List<Conveyance> getConveyancesList() {
		return super.getList();
	}



	public void setConveyancesList(List<Conveyance> list) {
		super.setList(list);
	}



	public Long getRegisteredOwnerId() {
		return registeredOwnerId;
	}



	public void setRegisteredOwnerId(Long registeredOwnerId) {
		this.registeredOwnerId = registeredOwnerId;
	}

}
