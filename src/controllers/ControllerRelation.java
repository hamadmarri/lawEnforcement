package controllers;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ejbs.AbstractEjb;
import ejbs.EjbRelatable;
import entities.Relatable;
import entities.Relation;


/**
 * @author hamadalmarri
 * 
 * @Pages
 *        - listRelations.xhtml
 *        - viewRelation.xhtml
 *        - addRelation.xhtml
 *        - editRelation.xhtml
 * 
 * @Relative_Objects
 *                   - Relatable: two relatables in this relation
 * 
 */
@ManagedBean(name = "controllerRelation")
@ViewScoped
public class ControllerRelation implements Serializable {

	private static final long serialVersionUID = -3794654476345847009L;

	// EJB for Relation object
	@EJB
	protected AbstractEjb<Relation> ejbRelation;

	// EJB for Relatable object
	@EJB
	private EjbRelatable ejbRelatable;

	// the id of a Relation object
	protected String id;

	// the Relation object
	protected Relation relation;

	// list of Relation objects
	protected List<Relation> relationsList = null;

	// to indicate if the operation is to add
	// new Relation or not
	protected boolean newEntity = false;

	// first relatable id
	private Long somethingId;

	// second relatable id
	private Long somethingElseId;



	/**
	 * will be called automatically right after the class is constructed since
	 * it has the PostConstruct annotation
	 */
	@PostConstruct
	public void init() {
		// at the beginning, set the entitiy name to be Relation
		this.ejbRelation.setEntityName("Relation");
	}



	/**
	 * to submit changes on the Relation object
	 * 
	 * @return "success" which is used for navigation engine to redirect to the
	 *         proper page
	 */
	public String submit() {

		// setup the relation
		setupRelation();

		// if new object it will add the object to DB,
		// otherwise, it will just update it in DB
		if (isNewEntity())
			ejbRelation.add(this.relation);
		else
			ejbRelation.save(this.relation);

		// return "success" for navigation engine
		return "success";
	}



	/**
	 * to initiate new object of Relation. This function will be called from
	 * addRelation.xhtml page at preRenderView phase
	 */
	public void createNewRelation() {
		this.relation = new Relation();
		this.setNewEntity(true);
	}



	/**
	 * Updates changes for first and second relatables on this relation
	 */
	private void setupRelation() {
		Relatable something = this.ejbRelatable.getEntity(somethingId);
		Relatable somethingElse = this.ejbRelatable.getEntity(somethingElseId);
		this.relation.setSomething(something);
		this.relation.setSomethingElse(somethingElse);
	}



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
		getRelation();
	}



	/**
	 * it will load the object from DB if it is not loaded yet otherwise, it
	 * will return the Relation object
	 * 
	 * @return the Relation object
	 */
	public Relation getRelation() {

		// if the object was loaded already, just return it
		if (this.relation != null)
			return this.relation;

		// if the id is null do not try to load it from DB, just return null
		if (this.id == null)
			return null;

		// at this point object must be null but id is not,
		// so load it from DB
		this.relation = ejbRelation.getEntity(Long.parseLong(this.id));

		// get first and second relatables
		setSomethingId(this.relation.getSomething().getId());
		setSomethingElseId(this.relation.getSomethingElse().getId());

		return this.relation;
	}



	public void setRelation(Relation relation) {
		this.relation = relation;
	}



	public List<Relation> getRelationsList() {
		if (this.relationsList == null)
			this.relationsList = ejbRelation.getList();

		return relationsList;
	}



	public void setRelationsList(List<Relation> list) {
		this.relationsList = list;
	}



	public boolean isNewEntity() {
		return newEntity;
	}



	public void setNewEntity(boolean newEntity) {
		this.newEntity = newEntity;
	}



	public Long getSomethingId() {
		return somethingId;
	}



	public void setSomethingId(Long somethingId) {
		this.somethingId = somethingId;
	}



	public Long getSomethingElseId() {
		return somethingElseId;
	}



	public void setSomethingElseId(Long somethingElseId) {
		this.somethingElseId = somethingElseId;
	}

}
