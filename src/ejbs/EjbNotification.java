package ejbs;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import security.Authorizable;
import entities.police.InvestigativeGroup;
import entities.police.Notification;


/**
 * @author hamadalmarri
 * 
 */
@Stateless
public class EjbNotification {

	// entity manager
	@PersistenceContext(unitName = "lawEnforcementPersistenceUnit")
	private EntityManager em;



	/**
	 * @param id
	 *            of object in DB
	 * @return Entity object
	 */
	public Notification getEntity(Long id) {
		return (Notification) em.createNamedQuery("Notification.findById").setParameter("id", id).getResultList()
				.get(0);
	}



	/**
	 * @param t
	 *            entity to be added in DB
	 */
	public void add(Notification t) {
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
	public Notification save(Notification t) {
		return em.merge(t);
	}



	public void flush() {
		em.flush();
	}



	public void refresh(Notification t) {
		em.refresh(t);
	}



	/**
	 * @return List of entities
	 */
	@SuppressWarnings("unchecked")
	public List<Notification> getList() {
		return em.createNamedQuery("Notification.findAll").getResultList();
	}



	/**
	 * @return List of entities
	 */
	@SuppressWarnings("unchecked")
	public List<Notification> getList(Authorizable a) {
		// CriteriaBuilder cb = em.getCriteriaBuilder();
		// CriteriaQuery<Notification> cQuery =
		// cb.createQuery(Notification.class);
		// Root<Notification> n = cQuery.from(Notification.class);
		//
		// List<Long> ids = new ArrayList<Long>();
		// for (InvestigativeGroup igs : a.getInvestigativeGroups())
		// ids.add(igs.getId());
		//
		//
		// Predicate authOrItsGroup = cb.or(cb.equal(n.get("to"), a),
		// n.get("to.id").in(ids));
		// Predicate pred = cb.and(authOrItsGroup, cb.equal(n.get("state"),
		// "sent"));
		//
		// cQuery.select(n).where(pred);
		//
		// TypedQuery<Notification> query = em.createQuery(cQuery);
		//
		// return query.getResultList();

		// the below code is just equivalent to the top one
		List<Long> ids = new ArrayList<Long>();
		for (InvestigativeGroup igs : a.getInvestigativeGroups())
			ids.add(igs.getId());

		String queryString = "select n From Notification n where n.state = 'sent' and ( n.to.id = " + a.getId()
				+ " or n.to.id in :invList )";
		Query query = em.createQuery(queryString);

		query.setParameter("invList", ids);

		return query.getResultList();
	}



	public short getCountNewNotifications(Authorizable a) {

		List<Long> ids = new ArrayList<Long>();
		for (InvestigativeGroup igs : a.getInvestigativeGroups())
			ids.add(igs.getId());

		String queryString = "select count(n.id) From Notification n where n.state = 'sent' and ( n.to.id = "
				+ a.getId() + " or n.to.id in :invList )";
		Query query = em.createQuery(queryString);

		query.setParameter("invList", ids);

		if (query.getResultList() == null || query.getResultList().isEmpty())
			return -1;

		return (short) (long) query.getSingleResult();
	}



	/**
	 * Removes entity from DB
	 * 
	 * @param entityId
	 *            id of the entity
	 */
	public void remove(Long entityId) {
		Notification entity = this.getEntity(entityId);
		em.remove(entity);
	}

}
