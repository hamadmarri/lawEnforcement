package ejbs;

import java.util.Calendar;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.entries.Person;
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
		return (OffenderProfile) em.createNamedQuery("OffenderProfile.findById").setParameter("id", id).getResultList()
				.get(0);
	}



	/**
	 * @param t
	 *            entity to be added in DB
	 */
	public void add(OffenderProfile t) {
		em.persist(t);
	}



	/**
	 * Checks if the entity is OffenderProfile first to log the changes. Then,
	 * saves
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



	@SuppressWarnings("unchecked")
	public List<Person> getSuspects(OffenderProfile op) {
		List<Person> suspects; // = new ArrayList<Person>();

		StringBuilder queryString = new StringBuilder("select p from Person p ");

		setupQueryString(queryString, op);

		Query nq = em.createQuery(queryString.toString());

		setupParameters(op, nq);

		suspects = nq.getResultList();
		return suspects;
	}



	private void setupQueryString(StringBuilder queryString, OffenderProfile op) {
		boolean isWhareSet = false;

		if (op.getMale() && setIsWhare(queryString, isWhareSet))
			queryString.append("p.gender = :gender ");

		if (op.getYoungOffenderBetween17And21Years() && setIsWhare(queryString, isWhareSet))
			queryString.append("p.dateOfBirth >= :startDate AND p.dateOfBirth <= :endDate");
	}



	private boolean setIsWhare(StringBuilder queryString, boolean isWhareSet) {
		if (!isWhareSet)
			queryString.append("where ");

		return true;
	}



	private void setupParameters(OffenderProfile op, Query nq) {
		if (op.getMale())
			nq.setParameter("gender", "Male");

		if (op.getYoungOffenderBetween17And21Years()) {
			Calendar startDate = Calendar.getInstance();
			Calendar endDate = Calendar.getInstance();
			
			startDate.add(Calendar.YEAR, -22);
			nq.setParameter("startDate", startDate.getTime());

			endDate.add(Calendar.YEAR, -17);
			nq.setParameter("endDate", endDate.getTime());
		}
	}
}
