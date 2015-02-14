package ejbs;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.intelligence.NeuralNetworkEntity;


/**
 * @author hamadalmarri
 * 
 */
@Stateless
public class EjbNeuralNetworkEntity {

	// entity manager
	@PersistenceContext(unitName = "lawEnforcementPersistenceUnit")
	private EntityManager em;



	/**
	 * @param id
	 *            of object in DB
	 * @return Entity object
	 */
	public NeuralNetworkEntity getEntity(Long id) {
		return (NeuralNetworkEntity) em.createNamedQuery("NeuralNetworkEntity.findById").setParameter("id", id)
				.getResultList().get(0);
	}



	/**
	 * @param t
	 *            entity to be added in DB
	 */
	public void add(NeuralNetworkEntity t) {
		em.persist(t);
	}



	/**
	 * Checks if the entity is NeuralNetworkEntity first to log the changes.
	 * Then, saves
	 * changes to DB
	 * 
	 * @param t
	 *            is the entity
	 * @return the entity
	 */
	public NeuralNetworkEntity save(NeuralNetworkEntity t) {

		// Changeable chngNew = (Changeable) t;
		// Changeable chngOld = em.find(Changeable.class, chngNew.getId());
		// chngNew.logChanges(chngOld);

		return em.merge(t);
	}



	public void flush() {
		em.flush();
	}



	public void refresh(NeuralNetworkEntity t) {
		em.refresh(t);
	}



	/**
	 * @return List of entities
	 */
	@SuppressWarnings("unchecked")
	public List<NeuralNetworkEntity> getList() {
		return em.createNamedQuery("NeuralNetworkEntity.findAll").getResultList();
	}



	/**
	 * Removes entity from DB
	 * 
	 * @param entityId
	 *            id of the entity
	 */
	public void remove(Long entityId) {
		NeuralNetworkEntity entity = this.getEntity(entityId);
		em.remove(entity);
	}

}
