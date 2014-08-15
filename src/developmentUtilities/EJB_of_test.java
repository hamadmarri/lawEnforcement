package developmentUtilities;

import java.util.Calendar;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.entries.Person;
import entities.entries.Relation;


@Stateless
public class EJB_of_test {

	@PersistenceContext(unitName = "lawEnforcementPersistenceUnit")
	private EntityManager em;



	public Person getPerson() {
		return em.find(Person.class, 17);
	}



	public void test() {

		Person p1 = new Person();
		Person p2 = new Person();
		Relation r = new Relation(p1, "brotherhood", p2);

		
		
		em.persist(r);
		em.persist(p1);
		em.persist(p2);
	}

}
