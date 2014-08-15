package developmentUtilities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.*;
import entities.entries.*;
import entities.entries.history.*;
import entities.entries.images.*;
import entities.events.*;


@Stateless
public class EJB_of_test {

	@PersistenceContext(unitName = "lawEnforcementPersistenceUnit")
	private EntityManager em;



	public Person getPerson() {
		return em.find(Person.class, 17);
	}



	private void createpersons() {

		Calendar date1 = Calendar.getInstance();
		date1.set(1984, 7, 23);

		Calendar date2 = Calendar.getInstance();
		date1.set(1991, 7, 19);

		Person p1 = new Person("Hamad", date1, "Al Hasa", "Male", "Saudi", null, "AA");
		p1.setRace(new Race("Saudi Arabian"));
		p1.setPhysicalCharacteristic(new PhysicalCharacteristic("Overweight", "Short", "Light", "Black"));

		Person p2 = new Person("Mohammad", date2, "Al Khobar", "Male", "Saudi", null, "PI");
		Relation r = new Relation(p1, "brothers", p2);

		PhotographicImage pi = new PhotographicImage("both", "ldfjglh");
		pi.addPerson(p1);
		pi.addPerson(p2);

		List<MugShotImage> msi = new ArrayList<MugShotImage>();
		msi.add(new MugShotImage("fron", "dfgdfg", p1));
		msi.add(new MugShotImage("right", "dfgdfg", p1));
		msi.add(new MugShotImage("left", "dfgdfg", p1));

		em.persist(p1);
		em.persist(p2);
		em.persist(r);
		em.persist(pi);

		for (MugShotImage mugShotImage : msi)
			em.persist(mugShotImage);

	}



	public void test() {
		createpersons();

		// Entry e = new Entry();
		// History h = new History();
		// List<Action> actions = new ArrayList<Action>();
		//
		// actions.add(new Action(new Location(), new Location()));
		// actions.add(new Action(new Location(), new Location()));
		// actions.add(new Action(new Location(), new Location()));
		//
		// h.setActions(actions);
		//
		// e.setHistory(h);
		//
		// em.persist(e);
	}

}
