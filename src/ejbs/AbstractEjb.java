package ejbs;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.entries.history.Changeable;


/**
 * @author hamadalmarri
 * 
 *         this EJB class is for JPA entities. This class has the basic CRUD
 *         functionalities
 * 
 * @param <T>
 *            must be one of Relatable object children
 */
@Stateless
public class AbstractEjb<T> {

	// entity manager
	@PersistenceContext(unitName = "lawEnforcementPersistenceUnit")
	private EntityManager em;

	// the type of the relatable object
	// i.e. Persone or Conveyance
	// this is because some operations need the
	// type to be passed
	protected String entityName;



	/**
	 * @param id
	 *            of object in DB
	 * @return Entity object
	 */
	@SuppressWarnings("unchecked")
	public T getEntity(Long id) {
		return (T) em.createNamedQuery(this.entityName + ".findById").setParameter("id", id).getResultList().get(0);
	}



	/**
	 * @param id
	 *            of object in DB
	 * @param entityName
	 *            specified entity name
	 * @return Entity object
	 */
	@SuppressWarnings("unchecked")
	public T getEntity(Long id, String entityName) {
		return (T) em.createNamedQuery(entityName + ".findById").setParameter("id", id).getResultList().get(0);
	}



	/**
	 * @param t
	 *            entity to be added in DB
	 */
	public void add(T t) {
		em.persist(t);
	}



	/**
	 * Checks if the entity is Changable first to log the changes. Then, saves
	 * changes to DB
	 * 
	 * @param t
	 *            is the entity
	 * @return the entity
	 */
	public T save(T t) {

		if (t.getClass().getSuperclass() == Changeable.class
				|| t.getClass().getSuperclass().getSuperclass() == Changeable.class
				|| t.getClass().getSuperclass().getSuperclass().getSuperclass() == Changeable.class
				|| t.getClass().getSuperclass().getSuperclass().getSuperclass().getSuperclass() == Changeable.class) {
			Changeable chngNew = (Changeable) t;
			Changeable chngOld = em.find(Changeable.class, chngNew.getId());
			chngNew.logChanges(chngOld);
		}

		return em.merge(t);
	}



	public void flush() {
		em.flush();
	}



	public void refresh(T t) {
		em.refresh(t);
	}



	/**
	 * @return List of entities
	 */
	@SuppressWarnings("unchecked")
	public List<T> getList() {
		return em.createNamedQuery(this.entityName + ".findAll").getResultList();
	}



	/**
	 * @param entityName
	 *            specified entity name
	 * @return List of entities
	 */
	@SuppressWarnings("unchecked")
	public List<T> getListByEntityName(String entityName) {
		return em.createNamedQuery(entityName + ".findAll").getResultList();
	}



	/**
	 * @param type
	 *            specific type of entities
	 * @return List of entities
	 */
	@SuppressWarnings("unchecked")
	public List<T> getList(String type) {
		return em.createNamedQuery(this.entityName + ".findAllByType").setParameter("type", type).getResultList();
	}



	public String getEntityName() {
		return entityName;
	}



	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}



	/**
	 * Removes entity from DB
	 * 
	 * @param entityId
	 *            id of the entity
	 */
	public void remove(Long entityId) {
		T entity = this.getEntity(entityId);
		em.remove(entity);
	}

}
