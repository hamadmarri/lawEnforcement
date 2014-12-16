package controllers;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ejbs.AbstractEjb;
import entities.Relatable;


/**
 * @author hamadalmarri
 * 
 *         It is an abstract controller that is used by other controllers. It
 *         has the basic operations so children get benefits and avoid
 *         repetitive code.
 * 
 * @param <T>
 *            should be one of Relatable children
 */
@ManagedBean(name = "abstractController")
@ViewScoped
public class AbstractController<T> {

	// EJB for Relatable object
	@EJB
	protected AbstractEjb<Relatable> ejbRelatable;

	// the id of a relatable object
	protected String id;

	// relatable object
	protected T relatable;

	// the type of the relatable object
	// i.e. Persone or Conveyance
	// this is because some operations need the
	// type to be passed
	protected String type;

	// list of relatble objects
	protected List<T> list = null;

	// to indicate if the operation is to add
	// new relatble or not
	protected boolean newRelatable = false;



	/**
	 * will be called automatically right after the class is constructed since
	 * it has the PostConstruct annotation
	 */
	@PostConstruct
	public void initAbstract() {
		// at the beginning, set the entitiy name to be Relatable
		this.ejbRelatable.setEntityName("Relatable");
	}



	/**
	 * to submit changes on the relatable object
	 * 
	 * @return "success" which is used for navigation engine to redirect to the
	 *         proper page
	 */
	public String submit() {

		// if new object it will add the object to DB,
		// otherwise, it will just update it in DB
		if (isNewRelatable())
			ejbRelatable.add((Relatable) this.relatable);
		else
			ejbRelatable.save((Relatable) this.relatable);

		// return "success" for navigation engine
		return "success";
	}



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	/**
	 * it will load the object from DB if it is not loaded yet otherwise, it
	 * will return the relatable object
	 * 
	 * @return the relatable object
	 */
	@SuppressWarnings("unchecked")
	public T getRelatable() {

		// if the object was loaded already, just return it
		if (this.relatable != null)
			return this.relatable;

		// if the id is null do not try to load it from DB, just return null
		if (this.id == null)
			return null;

		// at this point relatable must be null but id is not,
		// so load it from DB
		this.relatable = (T) ejbRelatable.getEntity(Long.parseLong(this.id));

		// return relatable
		return this.relatable;
	}



	public void setRelatable(T relatable) {
		this.relatable = relatable;
	}



	@SuppressWarnings("unchecked")
	public List<T> getList() {
		if (this.list == null)
			this.list = (List<T>) ejbRelatable.getList(this.type);

		return list;
	}



	public void setList(List<T> list) {
		this.list = list;
	}



	public boolean isNewRelatable() {
		return newRelatable;
	}



	public void setNewRelatable(boolean newRelatable) {
		this.newRelatable = newRelatable;
	}

}
