package entities.intelligence;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Startup
@Singleton
public class FillUpDataBase {

	@PersistenceContext(unitName = "lawEnforcementPersistenceUnit")
	private EntityManager em;



	@PostConstruct
	public void fill() {

		CrimeScene sc = new CrimeScene(true, true, true, true, false, true, true, true, true, true, true, true, true,
				true, true, true, true, true, false, true, true, true, true, true, false, true, true, true, true, true,
				true, true, true, true, true, true);

		OffenderProfile op = new OffenderProfile(true, false, true, true, true, true, false, true, true, true, true,
				true, true, true, true, true, true, true, false, true, true);

		sc.setOffenderProfile(op);

		em.persist(sc);
	}
	
}
