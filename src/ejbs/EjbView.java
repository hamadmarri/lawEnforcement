package ejbs;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.Relatable;


@Stateless
public class EjbView {
	@PersistenceContext(unitName = "lawEnforcementPersistenceUnit")
	private EntityManager em;



	@SuppressWarnings("unchecked")
	public List<Relatable> getView(Long id) {
		return em.createNamedQuery("Relatable.findById").setParameter("id", id).getResultList();
	}



	public void add(Relatable r) {
		em.persist(r);
	}



	public void save(Relatable r) {
		em.merge(r);
	}



	@SuppressWarnings("unchecked")
	public List<Relatable> getList(String type) {
		System.out.println("*************** " + type);
		return em.createNamedQuery("Relatable.findAllByType").setParameter("type", type).getResultList();
	}

}
