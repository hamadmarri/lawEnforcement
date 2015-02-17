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

		// StringBuilder queryString = new
		// StringBuilder("select p from Person p JOIN p.relationsTo r1 "); //
		// JOIN
		// p.relationsTo
		// r1
		// JOIN
		// p.relationsWith
		// r2

		StringBuilder queryString = new StringBuilder("select p from Person p ");

		setupQueryString(queryString, op);

		Query nq = em.createQuery(queryString.toString());

		setupParameters(op, nq);

		suspects = nq.getResultList();
		return suspects;
	}



	private void setupQueryString(StringBuilder queryString, OffenderProfile op) {
		StringBuilder parameters = new StringBuilder();

		if (op.getYoungOffenderBetween17And21Years())
			parameters.append("(p.dateOfBirth >= :startDate AND p.dateOfBirth <= :endDate) OR ");

		if (op.getMale())
			parameters.append("(p.gender = :gender) OR ");

		if (op.getCriminalRecordOfTheft())
			parameters.append("(p.description LIKE :criminalRecordOfTheft) OR ");

		if (op.getCriminalRecordOfFraud())
			parameters.append("(p.description LIKE :criminalRecordOfFraud) OR ");

		if (op.getCriminalRecordOfBurglary())
			parameters.append("(p.description LIKE :criminalRecordOfBurglary) OR ");

		// if (op.getRelationshipWithVictim()) {
		// parameters.append("((r1.something.id = :somethingID OR r1.somethingElse.id = :somethingElseID)"
		// + " AND r1.typeOfRelation = :typeOfRelation) ");
		// parameters.append("OR ");
		// }

		// remove the last OR
		if (parameters.length() > 4 && parameters.substring(parameters.length() - 3).equals("OR "))
			parameters.replace(parameters.length() - 4, parameters.length() - 1, "");

		// add where string
		if (parameters.length() > 0)
			queryString.append("WHERE ").append(parameters);
		else
			queryString.append("WHERE -1=1");
	}



	private void setupParameters(OffenderProfile op, Query nq) {

		if (op.getYoungOffenderBetween17And21Years()) {
			Calendar startDate = Calendar.getInstance();
			Calendar endDate = Calendar.getInstance();

			startDate.add(Calendar.YEAR, -22);
			nq.setParameter("startDate", startDate.getTime());

			endDate.add(Calendar.YEAR, -17);
			nq.setParameter("endDate", endDate.getTime());
		}

		if (op.getMale())
			nq.setParameter("gender", "Male");

		if (op.getCriminalRecordOfTheft())
			nq.setParameter("criminalRecordOfTheft", "%Criminal Record Of Theft%");

		if (op.getCriminalRecordOfFraud())
			nq.setParameter("criminalRecordOfFraud", "%Criminal Record Of Fraud%");

		if (op.getCriminalRecordOfBurglary())
			nq.setParameter("criminalRecordOfBurglary", "%Criminal Record Of Burglary%");

		// if (op.getRelationshipWithVictim()) {
		// nq.setParameter("somethingID",
		// op.getCrimeScene().getVictim().getId());
		// nq.setParameter("somethingElseID",
		// op.getCrimeScene().getVictim().getId());
		// nq.setParameter("typeOfRelation", "brothers");
		// }

	}

}
