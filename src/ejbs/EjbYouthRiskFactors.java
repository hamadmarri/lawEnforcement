package ejbs;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.entries.Person;
import entities.entries.YouthRiskFactors;


/**
 * @author hamadalmarri
 * 
 */
@Stateless
public class EjbYouthRiskFactors {

	// entity manager
	@PersistenceContext(unitName = "lawEnforcementPersistenceUnit")
	private EntityManager em;



	/**
	 * @param id
	 *            of object in DB
	 * @return Entity object
	 */
	public YouthRiskFactors getEntity(Long id) {
		return (YouthRiskFactors) em.createNamedQuery("YouthRiskFactors.findById").setParameter("id", id)
				.getResultList().get(0);
	}



	/**
	 * @param t
	 *            entity to be added in DB
	 */
	public void add(YouthRiskFactors t) {
		em.persist(t);
	}



	/**
	 * Checks if the entity is YouthRiskFactors first to log the changes. Then,
	 * saves
	 * changes to DB
	 * 
	 * @param t
	 *            is the entity
	 * @return the entity
	 */
	public YouthRiskFactors save(YouthRiskFactors t) {

		// Changeable chngNew = (Changeable) t;
		// Changeable chngOld = em.find(Changeable.class, chngNew.getId());
		// chngNew.logChanges(chngOld);

		return em.merge(t);
	}



	public void flush() {
		em.flush();
	}



	public void refresh(YouthRiskFactors t) {
		em.refresh(t);
	}



	/**
	 * @return List of entities
	 */
	@SuppressWarnings("unchecked")
	public List<YouthRiskFactors> getList() {
		return em.createNamedQuery("YouthRiskFactors.findAll").getResultList();
	}



	/**
	 * Removes entity from DB
	 * 
	 * @param entityId
	 *            id of the entity
	 */
	public void remove(Long entityId) {
		YouthRiskFactors entity = this.getEntity(entityId);
		em.remove(entity);
	}



	@SuppressWarnings("unchecked")
	public List<Person> getYouthInRiskList() {
		String queryString = "select p from Person p where p.inRisk = 1";
		Query query = em.createQuery(queryString);

		return query.getResultList();
	}

}
