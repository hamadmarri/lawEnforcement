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
	public List<InvestigativeCase> getInvestigativeCasesList(String search, Date startDate, Date dueDate,
			String[] status) {

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

		// check for status
		if (status.length != 0) {
			if (needAND)
				queryString.append(" AND (");

			for (int i = 0; i < status.length; i++) {
				queryString.append(" ic.status = :st" + i);

				if (i != status.length - 1)
					queryString.append(" OR");
			}

			queryString.append(" )");
		}

		System.out.println("EJB ********\n" + queryString.toString());
		
		// create query
		query = em.createQuery(queryString.toString(), InvestigativeCase.class);

		// set parameters
		if (!search.isEmpty())
			query.setParameter("search", "%" + search + "%");

		if (startDate != null)
			query.setParameter("startDate", startDate, TemporalType.TIMESTAMP);

		if (dueDate != null)
			query.setParameter("dueDate", dueDate, TemporalType.TIMESTAMP);

		if (status.length != 0) {
			for (int i = 0; i < status.length; i++)
				query.setParameter("st" + i, status[i]);
		}

		return query.getResultList();
	}
}
