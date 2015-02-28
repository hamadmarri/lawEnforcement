package ejbs;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.entries.Crime;
import entities.entries.CriminalRecord;


/**
 * @author hamadalmarri
 * 
 */
@Stateless
public class EjbCriminalRecord {

	// entity manager
	@PersistenceContext(unitName = "lawEnforcementPersistenceUnit")
	private EntityManager em;



	/**
	 * @param id
	 *            of object in DB
	 * @return Entity object
	 */
	public CriminalRecord getEntity(Long id) {
		return (CriminalRecord) em.createNamedQuery("CriminalRecord.findById").setParameter("id", id).getResultList()
				.get(0);
	}



	@SuppressWarnings("unchecked")
	public List<Crime> getAllCrimes() {
		return em.createNamedQuery("Crime.findAll").getResultList();
	}



	/**
	 * @param t
	 *            entity to be added in DB
	 */
	public void add(CriminalRecord t) {
		em.persist(t);
	}



	/**
	 * Checks if the entity is CriminalRecord first to log the changes. Then,
	 * saves
	 * changes to DB
	 * 
	 * @param t
	 *            is the entity
	 * @return the entity
	 */
	public CriminalRecord save(CriminalRecord t) {

		// Changeable chngNew = (Changeable) t;
		// Changeable chngOld = em.find(Changeable.class, chngNew.getId());
		// chngNew.logChanges(chngOld);

		return em.merge(t);
	}



	public void flush() {
		em.flush();
	}



	public void refresh(CriminalRecord t) {
		em.refresh(t);
	}



	/**
	 * @return List of entities
	 */
	@SuppressWarnings("unchecked")
	public List<CriminalRecord> getList() {
		return em.createNamedQuery("CriminalRecord.findAll").getResultList();
	}



	/**
	 * Removes entity from DB
	 * 
	 * @param entityId
	 *            id of the entity
	 */
	public void remove(Long entityId) {
		CriminalRecord entity = this.getEntity(entityId);
		em.remove(entity);
	}



	public void addCrime(Crime crime) {
		em.persist(crime);
	}



	public void saveCrime(Crime crime) {
		em.merge(crime);
	}



	public Crime getCrime(long id) {
		return (Crime) em.createNamedQuery("Crime.findById").setParameter("id", id).getResultList().get(0);
	}

}
