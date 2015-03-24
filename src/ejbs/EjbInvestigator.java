package ejbs;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.entries.history.Changeable;
import entities.police.Investigator;


/**
 * @author hamadalmarri
 * 
 */
@Stateless
public class EjbInvestigator {

	// entity manager
	@PersistenceContext(unitName = "lawEnforcementPersistenceUnit")
	private EntityManager em;

	// the type of the relatable object
	// i.e. Persone or Conveyance
	// this is because some operations need the
	// type to be passed
	protected String entityName = "Investigator";



	/**
	 * @param id
	 *            of object in DB
	 * @return Entity object
	 */
	public Investigator getEntity(Long id) {
		return (Investigator) em.createNamedQuery("Investigator.findById").setParameter("id", id).getResultList()
				.get(0);
	}



	/**
	 * @param t
	 *            entity to be added in DB
	 */
	public void add(Investigator t) {
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
	public Investigator save(Investigator t) {

		Changeable chngNew = (Changeable) t;
		Changeable chngOld = em.find(Changeable.class, chngNew.getId());
		chngNew.logChanges(chngOld);

		return em.merge(t);
	}



	public void flush() {
		em.flush();
	}



	public void refresh(Investigator t) {
		em.refresh(t);
	}



	/**
	 * @return List of entities
	 */
	@SuppressWarnings("unchecked")
	public List<Investigator> getList() {
		return em.createNamedQuery(this.entityName + ".findAll").getResultList();
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
		Investigator entity = this.getEntity(entityId);
		em.remove(entity);
	}

}
