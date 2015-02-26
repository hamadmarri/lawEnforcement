package ejbs;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import security.Authorizable;
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
	public List<Notification> getList(Authorizable a) {
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<Notification> criteriaQuery = criteriaBuilder.createQuery(Notification.class);
		Root<Notification> n = criteriaQuery.from(Notification.class);

		criteriaQuery.select(n).where(
				criteriaBuilder.and(criteriaBuilder.equal(n.get("to"), a),
						criteriaBuilder.equal(n.get("state"), "sent")));

		TypedQuery<Notification> query = em.createQuery(criteriaQuery);

		return query.getResultList();
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
