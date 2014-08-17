package developmentUtilities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.*;
import entities.entries.*;
import entities.entries.Location.Coordinate;
import entities.entries.contacts.CellPhone;
import entities.entries.contacts.Email;
import entities.entries.contacts.Telephone;
import entities.entries.history.*;
import entities.entries.images.*;
import entities.events.*;
import entities.police.Officer;


@Stateless
public class EJB_of_test {

	@PersistenceContext(unitName = "lawEnforcementPersistenceUnit")
	private EntityManager em;



	public List<Entry> getView() {
		@SuppressWarnings("unchecked")
		List<Entry> r = (List<Entry>) em.createNamedQuery("Address.findAll").getResultList();
		return r;
	}



	public void test() {
		createpersons();
		createEntity_History_Actions();
		createLocation_Addresses();
		createConveyance_person();
		creatRelations();
		createOrgAndProperty();
		createOfficer_Entry_Event();
		createSuspectPerson_officer_incidentReport_Entry();

	}



	private void createSuspectPerson_officer_incidentReport_Entry() {
		Officer of = em.find(Officer.class, 20L);
		SuspectPerson sp1 = new SuspectPerson(new PhysicalCharacteristic(
				PhysicalCharacteristic.getBuildCharacteristicsSuggestions()[2],
				PhysicalCharacteristic.getHeightCharacteristicsSuggestions()[0],
				PhysicalCharacteristic.getComplexionCharacteristicsSuggestions()[3],
				PhysicalCharacteristic.getHairCharacteristicsSuggestions()[2]), "cool");
		SuspectPerson sp2 = new SuspectPerson(new PhysicalCharacteristic(
				PhysicalCharacteristic.getBuildCharacteristicsSuggestions()[1],
				PhysicalCharacteristic.getHeightCharacteristicsSuggestions()[3],
				PhysicalCharacteristic.getComplexionCharacteristicsSuggestions()[0],
				PhysicalCharacteristic.getHairCharacteristicsSuggestions()[1]), "ugly");
		IncidentReport ir = new IncidentReport("flirting", IncidentReport.getStatusOptions()[0], "nothing yet");
		Location l = em.find(Location.class, 10L);
		Person complainant = new Person(new PersonName("Yara", null), null, null, "Female", "Libanies", null, null);
		Relation r = new Relation(l, "happened in", ir);
		Relation r2 = new Relation(complainant, "reported", ir);
		ir.addSuspectPerson(sp1);
		ir.addSuspectPerson(sp2);

		of.addEventResponsibleFor(ir);

		em.persist(r);
		em.persist(r2);
		em.persist(of);
	}



	private void createOfficer_Entry_Event() {
		Officer of1 = new Officer(new PersonName("Jims", "Richard"), "Male");
		Officer of2 = new Officer(new PersonName("Lorinda", "dfjkhld"), "Female");
		Person p = em.find(Person.class, 1L);
		IncidentReport ir = new IncidentReport();
		Conveyance c = em.find(Conveyance.class, 13L);
		Relation r1 = new Relation(c, "the car hit the cat", ir);
		Relation r2 = new Relation(p, "the person who reported", ir);

		ir.setDescription("hitting a cat");
		// ir.addEntryAssociatedWith(c);
		of1.addEventResponsibleFor(ir);
		of2.addEventResponsibleFor(ir);

		em.persist(of1);
		em.persist(of2);
		em.persist(r1);
		em.persist(r2);
	}



	private void createOrgAndProperty() {
		Organization o = new Organization("alwan", Organization.getOrganizationTypeSuggestions()[1]);
		Property p = new Property("3kljfdg8", "Sony", "D300s", "Sony", "fkldgldkfjgld");
		em.persist(o);
		em.persist(p);
	}



	private void creatRelations() {
		Person p = em.find(Person.class, 2L);
		Conveyance c = em.find(Conveyance.class, 14L);
		Relation r = new Relation(p, "drove", c);

		em.persist(r);
	}



	private void createConveyance_person() {
		Calendar cc = Calendar.getInstance();
		cc.set(1986, 0, 0);

		Calendar ca = Calendar.getInstance();
		ca.set(1997, 0, 0);

		Person p = em.find(Person.class, 1L);
		Conveyance caprice = new Conveyance("1G1BN69H6GX181007", "155IZY", "SK", Calendar.getInstance(), "CHEV CAPRIC",
				"LV", cc, "RED", "FOOR DOOR CAR", "");
		Conveyance honda = new Conveyance("1HGCD5631VA815858", "701HXJ", "SK", Calendar.getInstance(), "HONDA ACCORD",
				"EX SERIES 4DR", ca, "GREEN", "FOOR DOOR CAR", "");

		caprice.setRegisteredOwner(p);
		honda.setRegisteredOwner(p);

		em.persist(caprice);
		em.persist(honda);
	}



	private void createLocation_Addresses() {
		Location l = new Location("B", new Location.Coordinate(65, 987, 234), "few", "second floor", "offices");
		l.addAddress(new Address("Centenial St", "183", "Regina", "SK", "Canada", "S4S 6W3"));
		l.addAddress(new Address("Wascana Parkway", "LA612", "Regina", "SK", "Canada", "S4S 0A2"));

		em.persist(l);
	}



	private void createpersons() {

		Calendar date1 = Calendar.getInstance();
		date1.set(1984, 7, 23);

		Calendar date2 = Calendar.getInstance();
		date1.set(1991, 7, 19);

		Person p1 = new Person(new PersonName("Hamad", "Almarri"), date1, "Al Hasa", "Male", "Saudi", null, "AA");
		p1.addContact(new CellPhone(p1, "3069990084"));
		p1.addContact(new Email(p1, "almarrih@uregina.ca"));
		p1.setRace(new Race("Saudi Arabian"));
		p1.setPhysicalCharacteristic(new PhysicalCharacteristic("Overweight", "Short", "Light", "Black"));

		Person p2 = new Person(new PersonName("Mohammad", "Almarri"), date2, "Al Khobar", "Male", "Saudi", null, "PI");
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



	private void createEntity_History_Actions() {
		Entry e = new Entry();
		History h = new History();
		List<Action> actions = new ArrayList<Action>();

		e.setHistory(h);

		// actions.add(new Action("dfg", "Dfgd", h));
		// actions.add(new Action("dfg", "Dfgd", h));
		// actions.add(new Action("dfg", "Dfgd", h));
		// h.setActions(actions);
		h.addAction(new Action("dfg", "Dfgd"));
		h.addAction(new Action("dfg", "Dfgd"));
		h.addAction(new Action("dfg", "Dfgd"));

		em.persist(e);

		// for (Action action : actions)
		// em.persist(action);
	}

}
