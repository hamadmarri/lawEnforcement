package ejbs;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class AbstractEjb<T> {
	@PersistenceContext(unitName = "lawEnforcementPersistenceUnit")
	private EntityManager em;
	protected String entityName;



	@SuppressWarnings("unchecked")
	public T getEntity(Long id) {
		return (T) em.createNamedQuery(this.entityName + ".findById").setParameter("id", id).getResultList().get(0);
	}



	public void add(T t) {
		em.persist(t);
	}



	public void save(T t) {
		em.merge(t);
	}



	@SuppressWarnings("unchecked")
	public List<T> getList() {
		return em.createNamedQuery(this.entityName + ".findAll").getResultList();
	}



	@SuppressWarnings("unchecked")
	public List<T> getList(String type) {
		return em.createNamedQuery(this.entityName + ".findAllByType").setParameter("type", type).getResultList();
	}



	public String getEntityName() {
		return entityName;
	}



	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

}
