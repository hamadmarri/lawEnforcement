package ejbs;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.intelligence.OffenderProfile;


/**
 * @author hamadalmarri
 * 
 */
@Stateless
public class EjbOffenderProfile {

	// entity manager
	@PersistenceContext(unitName = "lawEnforcementPersistenceUnit")
	private EntityManager em;



	/**
	 * @param id
	 *            of object in DB
	 * @return Entity object
	 */
	public OffenderProfile getEntity(Long id) {
		return (OffenderProfile) em.createNamedQuery("OffenderProfile.findById").setParameter("id", id).getResultList().get(0);
	}



	/**
	 * @param t
	 *            entity to be added in DB
	 */
	public void add(OffenderProfile t) {
		em.persist(t);
	}



	/**
	 * Checks if the entity is OffenderProfile first to log the changes. Then, saves
	 * changes to DB
	 * 
	 * @param t
	 *            is the entity
	 * @return the entity
	 */
	public OffenderProfile save(OffenderProfile t) {

		// Changeable chngNew = (Changeable) t;
		// Changeable chngOld = em.find(Changeable.class, chngNew.getId());
		// chngNew.logChanges(chngOld);

		return em.merge(t);
	}



	public void flush() {
		em.flush();
	}



	public void refresh(OffenderProfile t) {
		em.refresh(t);
	}



	/**
	 * @return List of entities
	 */
	@SuppressWarnings("unchecked")
	public List<OffenderProfile> getList() {
		return em.createNamedQuery("OffenderProfile.findAll").getResultList();
	}



	/**
	 * Removes entity from DB
	 * 
	 * @param entityId
	 *            id of the entity
	 */
	public void remove(Long entityId) {
		OffenderProfile entity = this.getEntity(entityId);
		em.remove(entity);
	}

}
