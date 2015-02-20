package ejbs;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.Relation;
import entities.entries.Person;
import entities.entries.SuspectPerson;
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



	public List<Person> getSuspects(OffenderProfile op) {
		Set<Person> suspectsSet1;
		Set<Person> suspectsSet2;
		Set<Person> suspects = new HashSet<Person>();

		suspectsSet1 = getSet1(op);
		suspectsSet2 = getSet2(op);

		if (suspectsSet1 != null)
			suspects.addAll(suspectsSet1);

		if (suspectsSet2 != null)
			suspects.addAll(suspectsSet2);

		return new ArrayList<Person>(suspects);
	}



	@SuppressWarnings("unchecked")
	private Set<Person> getSet1(OffenderProfile op) {

		StringBuilder queryString = new StringBuilder("select p from Person p ");
		setupQueryStringForList1(queryString, op);
		Query nq = em.createQuery(queryString.toString());
		setupParametersForList1(op, nq);

		return new HashSet<Person>(nq.getResultList());
	}



	private void setupQueryStringForList1(StringBuilder queryString, OffenderProfile op) {
		StringBuilder parameters = new StringBuilder();

		if (op.getYoungOffenderBetween17And21Years())
			parameters.append("(p.dateOfBirth >= :startDate AND p.dateOfBirth <= :endDate) OR ");

		if (op.getMale())
			parameters.append("(p.gender = :gender) OR ");

		if (op.getUnemployedAtTheTimeOfOffense())
			parameters.append("(lower(p.description) LIKE :unemployedAtTheTimeOfOffense) OR ");

		if (op.getFamiliarWithAreaOfOffenseOccurrence())
			parameters.append("(lower(p.description) LIKE :familiarWithAreaOfOffenseOccurrence) OR ");

		if (op.getArmedServices_PastOrPresent())
			parameters.append("(lower(p.description) LIKE :armedServices_PastOrPresent) OR ");

		if (op.getHistoryOfAbusivenessInPastRelationships())
			parameters.append("(lower(p.description) LIKE :historyOfAbusivenessInPastRelationships) OR ");

		if (op.getAttemptsOfSuicide())
			parameters.append("(lower(p.description) LIKE :attemptsOfSuicide) OR ");

		if (op.getPsychiatricDisorders())
			parameters.append("(lower(p.description) LIKE :psychiatricDisorders) OR ");

		if (op.getTurnedSelfIntoPolice())
			parameters.append("(lower(p.description) LIKE :turnedSelfIntoPolice) OR ");

		if (op.getCriminalRecordOfTheft())
			parameters.append("(lower(p.description) LIKE :criminalRecordOfTheft) OR ");

		if (op.getCriminalRecordOfFraud())
			parameters.append("(lower(p.description) LIKE :criminalRecordOfFraud) OR ");

		if (op.getCriminalRecordOfBurglary())
			parameters.append("(lower(p.description) LIKE :criminalRecordOfBurglary) OR ");

		if (op.getCriminalRecordOfViolence())
			parameters.append("(lower(p.description) LIKE :criminalRecordOfViolence) OR ");

		if (op.getCriminalRecordOfCommittingDamage())
			parameters.append("(lower(p.description) LIKE :criminalRecordOfCommittingDamage) OR ");

		if (op.getCriminalRecordOfDisorderlyConduct())
			parameters.append("(lower(p.description) LIKE :criminalRecordOfDisorderlyConduct) OR ");

		if (op.getRecordOfImprisonment())
			parameters.append("(lower(p.description) LIKE :recordOfImprisonment) OR ");

		if (op.getSexualRelatedCriminalRecord())
			parameters.append("(lower(p.description) LIKE :sexualRelatedCriminalRecord) OR ");

		// remove the last OR
		if (parameters.length() > 4 && parameters.substring(parameters.length() - 3).equals("OR "))
			parameters.replace(parameters.length() - 4, parameters.length() - 1, "");

		// add where string
		if (parameters.length() > 0)
			queryString.append("WHERE ").append(parameters);
		else
			queryString.append("WHERE -1=1");
	}



	private void setupParametersForList1(OffenderProfile op, Query nq) {

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

		if (op.getUnemployedAtTheTimeOfOffense())
			nq.setParameter("unemployedAtTheTimeOfOffense", "%unemployed%");

		if (op.getFamiliarWithAreaOfOffenseOccurrence())
			nq.setParameter("familiarWithAreaOfOffenseOccurrence", "%familiar%with%offense%occur%");

		if (op.getArmedServices_PastOrPresent())
			nq.setParameter("armedServices_PastOrPresent", "%armed%service%");

		if (op.getHistoryOfAbusivenessInPastRelationships())
			nq.setParameter("historyOfAbusivenessInPastRelationships", "%history%abusiveness%relationship%");

		if (op.getAttemptsOfSuicide())
			nq.setParameter("attemptsOfSuicide", "%attempt%suicide%");

		if (op.getPsychiatricDisorders())
			nq.setParameter("psychiatricDisorders", "%psych%disorder%");

		if (op.getTurnedSelfIntoPolice())
			nq.setParameter("turnedSelfIntoPolice", "%turn%self%to%police%");

		if (op.getCriminalRecordOfTheft())
			nq.setParameter("criminalRecordOfTheft", "%criminal%record%theft%");

		if (op.getCriminalRecordOfFraud())
			nq.setParameter("criminalRecordOfFraud", "%criminal%record%fraud");

		if (op.getCriminalRecordOfBurglary())
			nq.setParameter("criminalRecordOfBurglary", "%criminal%record%burglary%");

		if (op.getCriminalRecordOfViolence())
			nq.setParameter("criminalRecordOfViolence", "%criminal%record%violence%");

		if (op.getCriminalRecordOfCommittingDamage())
			nq.setParameter("criminalRecordOfCommittingDamage", "%criminal%record%committ%damage%");

		if (op.getCriminalRecordOfDisorderlyConduct())
			nq.setParameter("criminalRecordOfDisorderlyConduct", "%criminal%record%disorder%conduct%");

		if (op.getRecordOfImprisonment())
			nq.setParameter("recordOfImprisonment", "%record%imprisonment%");

		if (op.getSexualRelatedCriminalRecord())
			nq.setParameter("sexualRelatedCriminalRecord", "%sex%relate%record%");
	}



	@SuppressWarnings("unchecked")
	private Set<Person> getSet2(OffenderProfile op) {

		List<Relation> relations;
		Set<Person> persons = new HashSet<Person>();

		Long victimId = op.getCrimeScene().getVictim().getId();

		StringBuilder queryString = new StringBuilder("select r from Relation r ");
		setupQueryStringForList2(queryString, op);
		Query nq = em.createQuery(queryString.toString());
		setupParametersForList2(op, nq);

		relations = nq.getResultList();
		for (Relation r : relations) {
			if (r.getSomething().getId() == victimId)
				persons.add((Person) r.getSomethingElse());
			else
				persons.add((Person) r.getSomething());
		}

		return persons;
	}



	private void setupQueryStringForList2(StringBuilder queryString, OffenderProfile op) {
		StringBuilder victimParams = new StringBuilder();
		StringBuilder parameters = new StringBuilder();
		Long victimId = op.getCrimeScene().getVictim().getId();

		// set the victim id 
		victimParams.append("( (r.something.id = ").append(victimId).append(") OR ");
		victimParams.append("(r.somethingElse.id = ").append(victimId).append(") ) AND (");

		if (op.getRelationshipWithVictim())
			parameters.append("(lower(r.typeOfRelation) LIKE :relationshipWithVictim) OR ");

		if (op.getKnewVictim())
			parameters.append("(lower(r.typeOfRelation) LIKE :knewVictim) OR ");

		if (op.getRelatedToVictim())
			parameters.append("(lower(r.typeOfRelation) LIKE :relatedToVictim) OR ");

		if (op.getBloodRelativeToVictim())
			parameters.append("(lower(r.typeOfRelation) LIKE :bloodRelativeToVictim) OR ");

		// remove the last OR
		if (parameters.length() > 4 && parameters.substring(parameters.length() - 3).equals("OR "))
			parameters.replace(parameters.length() - 4, parameters.length() - 1, "");

		// add where string
		if (parameters.length() > 0)
			queryString.append("WHERE ").append(victimParams).append(parameters).append(")");
		else
			queryString.append("WHERE -1=1");
	}



	private void setupParametersForList2(OffenderProfile op, Query nq) {
		if (op.getRelationshipWithVictim())
			nq.setParameter("relationshipWithVictim", "%relation%ship%");

		if (op.getKnewVictim())
			nq.setParameter("knewVictim", "%kn%w%");

		if (op.getRelatedToVictim())
			nq.setParameter("relatedToVictim", "%relat%");

		if (op.getBloodRelativeToVictim())
			nq.setParameter("bloodRelativeToVictim", "%blood%relat%");
	}

}
