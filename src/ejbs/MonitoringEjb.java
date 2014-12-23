package ejbs;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.police.InvestigativeCase;


/**
 * @author hamadalmarri
 * 
 *         this EJB class is for JPA entities. This class has the basic CRUD
 *         functionalities
 * 
 * @param must
 *            be one of Relatable object children
 */
@Stateless
public class MonitoringEjb {

	// entity manager
	@PersistenceContext(unitName = "lawEnforcementPersistenceUnit")
	private EntityManager em;



	/**
	 * @return List of entities
	 */
	@SuppressWarnings("unchecked")
	public List<InvestigativeCase> getAllInvestigativeCasesList() {
		return (List<InvestigativeCase>) em.createNamedQuery("InvestigativeCase.findAll").getResultList();
	}

}
