package ejbs;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.entries.Person;



/**
 * @author hamadalmarri
 * 
 */
@Stateless
public class EjbPerson {

	// entity manager
	@PersistenceContext(unitName = "lawEnforcementPersistenceUnit")
	private EntityManager em;



	/**
	 * @param id
	 *            of object in DB
	 * @return Entity object
	 */
	public Person getEntity(Long id) {
		return (Person) em.createNamedQuery("Person.findById").setParameter("id", id).getResultList().get(0);
	}



	/**
	 * @param t
	 *            entity to be added in DB
	 */
	public void add(Person t) {
		em.persist(t);
	}



	/**
	 * Checks if the entity is Person first to log the changes. Then, saves
	 * changes to DB
	 * 
	 * @param t
	 *            is the entity
	 * @return the entity
	 */
	public Person save(Person t) {

		// Changeable chngNew = (Changeable) t;
		// Changeable chngOld = em.find(Changeable.class, chngNew.getId());
		// chngNew.logChanges(chngOld);

		return em.merge(t);
	}



	public void flush() {
		em.flush();
	}



	public void refresh(Person t) {
		em.refresh(t);
	}



	/**
	 * @return List of entities
	 */
	@SuppressWarnings("unchecked")
	public List<Person> getList() {
		return em.createNamedQuery("Person.findAll").getResultList();
	}



	/**
	 * Removes entity from DB
	 * 
	 * @param entityId
	 *            id of the entity
	 */
	public void remove(Long entityId) {
		Person entity = this.getEntity(entityId);
		em.remove(entity);
	}

}
