package ejbs;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.Relation;


@Stateless
public class EjbRelation {
	@PersistenceContext(unitName = "lawEnforcementPersistenceUnit")
	private EntityManager em;



	@SuppressWarnings("unchecked")
	public List<Relation> getView(Long id) {
		return em.createNamedQuery("Relation.findById").setParameter("id", id).getResultList();
	}



	public void save(Relation r) {
		em.merge(r);
	}



	@SuppressWarnings("unchecked")
	public List<Relation> getList() {
		return em.createNamedQuery("Relation.findAll").getResultList();
	}

}
