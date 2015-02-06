package ejbs;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.intelligence.CrimeScene;


/**
 * @author hamadalmarri
 * 
 */
@Stateless
public class EjbCrimeScene {

	// entity manager
	@PersistenceContext(unitName = "lawEnforcementPersistenceUnit")
	private EntityManager em;



	/**
	 * @param id
	 *            of object in DB
	 * @return Entity object
	 */
	public CrimeScene getEntity(Long id) {
		return (CrimeScene) em.createNamedQuery("CrimeScene.findById").setParameter("id", id).getResultList().get(0);
	}



	/**
	 * @param t
	 *            entity to be added in DB
	 */
	public void add(CrimeScene t) {
		em.persist(t);
	}



	/**
	 * Checks if the entity is CrimeScene first to log the changes. Then, saves
	 * changes to DB
	 * 
	 * @param t
	 *            is the entity
	 * @return the entity
	 */
	public CrimeScene save(CrimeScene t) {

		// Changeable chngNew = (Changeable) t;
		// Changeable chngOld = em.find(Changeable.class, chngNew.getId());
		// chngNew.logChanges(chngOld);

		return em.merge(t);
	}



	public void flush() {
		em.flush();
	}



	public void refresh(CrimeScene t) {
		em.refresh(t);
	}



	/**
	 * @return List of entities
	 */
	@SuppressWarnings("unchecked")
	public List<CrimeScene> getList() {
		return em.createNamedQuery("CrimeScene.findAll").getResultList();
	}



	/**
	 * Removes entity from DB
	 * 
	 * @param entityId
	 *            id of the entity
	 */
	public void remove(Long entityId) {
		CrimeScene entity = this.getEntity(entityId);
		em.remove(entity);
	}

}
