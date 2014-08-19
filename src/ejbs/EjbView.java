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



	public void save(Relatable r) {
		em.merge(r);
//		em.flush();
	}

}
