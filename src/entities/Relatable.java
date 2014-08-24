package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;


/**
 * Entity implementation class for Entity: Relatable
 * 
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@NamedQueries({
		@NamedQuery(name = "Relatable.findAll", query = "select r from Relatable r ORDER BY r.id"),
		@NamedQuery(name = "Relatable.findAllByType", query = "select r from Relatable r WHERE r.type = :type ORDER BY r.id"),
		@NamedQuery(name = "Relatable.findById", query = "select r from Relatable r WHERE r.id = :id") })
public class Relatable implements Serializable, Describable {

	private static final long serialVersionUID = -2946296455927470657L;

	@Id
	@GeneratedValue
	protected Long id;

	@OneToMany(mappedBy = "something")
	private List<Relation> relationsTo;

	@OneToMany(mappedBy = "somethingElse")
	private List<Relation> relationsWith;

	@Transient
	private List<Relation> allRelations;

	protected String type;

	protected String description;



	public Relatable() {
		super();
		this.type = new String();
		this.description = new String();
	}



	public Long getId() {
		return id;
	}



	public List<Relation> getAllRelations() {
		if (this.allRelations == null) {
			allRelations = new ArrayList<Relation>();
			allRelations.addAll(relationsTo);
			allRelations.addAll(relationsWith);
		}
		return allRelations;
	}



	public String getType() {
		return type;
	}



	@Override
	public String toString() {
		return "Relatable";
	}



	@Override
	public void setDescription(String description) {
		this.description = description;
	}



	@Override
	public String getDescription() {
		return this.description;
	}

}
