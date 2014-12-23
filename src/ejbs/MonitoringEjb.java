package ejbs;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TemporalType;

import entities.police.InvestigativeCase;


/**
 * @author hamadalmarri
 * 
 */
@Stateless
public class MonitoringEjb {

	// entity manager
	@PersistenceContext(unitName = "lawEnforcementPersistenceUnit")
	private EntityManager em;

	StringBuilder queryString;



	/**
	 * @return List of entities
	 */
	@SuppressWarnings("unchecked")
	public List<InvestigativeCase> getAllInvestigativeCasesList() {
		return (List<InvestigativeCase>) em.createNamedQuery("InvestigativeCase.findAll").getResultList();
	}



	@SuppressWarnings("unchecked")
	public List<InvestigativeCase> getInvestigativeCasesList(String search, Date startDate, Date dueDate) {

		Query query;
		boolean needAND = false;
		queryString = new StringBuilder("select ic from InvestigativeCase ic WHERE");

		// check if need search in description
		if (!search.isEmpty()) {
			queryString.append(" ic.description LIKE :search ");
			needAND = true;
		}

		// check if need filter by start date
		if (startDate != null) {
			if (needAND)
				queryString.append(" AND");

			queryString.append(" ic.startDate >= :startDate");
			needAND = true;
		}

		// check if need filter by due date
		if (dueDate != null) {
			if (needAND)
				queryString.append(" AND");

			queryString.append(" ic.dueDate <= :dueDate");
			needAND = true;
		}

		System.out.println("EJB*********** " + queryString.toString() + " *************");

		// create query
		query = em.createQuery(queryString.toString(), InvestigativeCase.class);

		// set parameters
		if (!search.isEmpty())
			query.setParameter("search", "%" + search + "%");

		if (startDate != null)
			query.setParameter("startDate", startDate, TemporalType.TIMESTAMP);

		if (dueDate != null)
			query.setParameter("dueDate", dueDate, TemporalType.TIMESTAMP);

		return query.getResultList();
	}
}
