package ejbs;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.events.FieldInterview;


@Stateless
public class EjbFieldInterview {
	@PersistenceContext(unitName = "lawEnforcementPersistenceUnit")
	private EntityManager em;



	@SuppressWarnings("unchecked")
	public List<FieldInterview> getView(Long id) {
		return em.createNamedQuery("FieldInterview.findById").setParameter("id", id).getResultList();
	}



	public void save(FieldInterview fi) {
		em.merge(fi);
	}



	@SuppressWarnings("unchecked")
	public List<FieldInterview> getList() {
		return em.createNamedQuery("FieldInterview.findAll").getResultList();
	}

}
