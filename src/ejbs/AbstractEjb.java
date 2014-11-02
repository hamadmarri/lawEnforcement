package ejbs;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.entries.files.EntryFile;


@Stateless
public class AbstractEjb<T> {
	@PersistenceContext(unitName = "lawEnforcementPersistenceUnit")
	private EntityManager em;
	protected String entityName;



	@SuppressWarnings("unchecked")
	public T getEntity(Long id) {
		return (T) em.createNamedQuery(this.entityName + ".findById").setParameter("id", id).getResultList().get(0);
	}



	@SuppressWarnings("unchecked")
	public T getEntity(Long id, String entityName) {
		return (T) em.createNamedQuery(entityName + ".findById").setParameter("id", id).getResultList().get(0);
	}



	public void add(T t) {
		em.persist(t);
	}



	public T save(T t) {
		return em.merge(t);
	}



	public void flush() {
		em.flush();
	}



	public void refresh(T t) {
		em.refresh(t);
	}



	@SuppressWarnings("unchecked")
	public List<T> getList() {
		return em.createNamedQuery(this.entityName + ".findAll").getResultList();
	}



	@SuppressWarnings("unchecked")
	public List<T> getListByEntityName(String entityName) {
		return em.createNamedQuery(entityName + ".findAll").getResultList();
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



	public void remove(Long entityId) {
		T entity = this.getEntity(entityId);
		em.remove(entity);
	}

}
