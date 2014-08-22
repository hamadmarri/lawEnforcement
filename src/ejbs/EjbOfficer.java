package ejbs;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.police.Officer;


@Stateless
public class EjbOfficer {
	@PersistenceContext(unitName = "lawEnforcementPersistenceUnit")
	private EntityManager em;



	@SuppressWarnings("unchecked")
	public List<Officer> getView(Long id) {
		return em.createNamedQuery("Officer.findById").setParameter("id", id).getResultList();
	}



	public void save(Officer of) {
		em.merge(of);
	}



	@SuppressWarnings("unchecked")
	public List<Officer> getList() {
		return em.createNamedQuery("Officer.findAll").getResultList();
	}

}
