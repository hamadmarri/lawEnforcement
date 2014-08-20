package ejbs;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.events.SuspectPerson;


@Stateless
public class EjbSuspectPerson {
	@PersistenceContext(unitName = "lawEnforcementPersistenceUnit")
	private EntityManager em;



	@SuppressWarnings("unchecked")
	public List<SuspectPerson> getView(Long id) {
		return em.createNamedQuery("SuspectPerson.findById").setParameter("id", id).getResultList();
	}



	public void save(SuspectPerson r) {
		em.merge(r);
	}



	@SuppressWarnings("unchecked")
	public List<SuspectPerson> getList() {
		return em.createNamedQuery("SuspectPerson.findAll").getResultList();
	}

}
