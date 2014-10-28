package developmentUtilities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import security.Permission;
import entities.Relatable;
import entities.Relation;
import entities.entries.Address;
import entities.entries.AliasNameOrMoniker;
import entities.entries.Conveyance;
import entities.entries.Entry;
import entities.entries.Identification;
import entities.entries.Location;
import entities.entries.Organization;
import entities.entries.Person;
import entities.entries.PersonName;
import entities.entries.PhysicalCharacteristic;
import entities.entries.Property;
import entities.entries.Race;
import entities.entries.ScarMarkTattoo;
import entities.entries.ThreatAssessment;
import entities.entries.contacts.CellPhone;
import entities.entries.contacts.Email;
import entities.entries.history.Action;
import entities.entries.history.History;
import entities.entries.images.MugShotImage;
import entities.entries.images.PhotographicImage;
import entities.events.ArrestReport;
import entities.events.FieldInterview;
import entities.events.IncidentReport;
import entities.events.SuspectPerson;
import entities.police.Activity;
import entities.police.InvestigativeCase;
import entities.police.InvestigativeGroup;
import entities.police.Investigator;
import entities.police.Officer;


@Stateless
public class EJB_of_test {

	@PersistenceContext(unitName = "lawEnforcementPersistenceUnit")
	private EntityManager em;



	@SuppressWarnings("unchecked")
	public List<Relatable> getView(Long id) {
		// return
		// em.createNamedQuery("Person.findByIdentification").setParameter("identification",
		// "200294236")
		// .getResultList();
		return em.createNamedQuery("Relatable.findById").setParameter("id", id).getResultList();
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
		createFieldInterview();
		createOfficer_InvestigativeCase_IncidentReport_Investigator();
		createArrestReportAccordingToIncidentReport();
		createActivity_InvCase_Inv();
		createInvestigativeGroup_Permission();

	}



	private void createInvestigativeGroup_Permission() {
		Officer o1 = (Officer) em.createNamedQuery("Officer.findAll").getResultList().get(0);
//		Officer o2 = (Officer) em.createNamedQuery("Officer.findAll").getResultList().get(1);
		Investigator i1 = (Investigator) em.createNamedQuery("Investigator.findAll").getResultList().get(0);
		InvestigativeGroup ig = new InvestigativeGroup("First Group");
		Permission p = new Permission();
		InvestigativeCase ic = (InvestigativeCase) em.createNamedQuery("InvestigativeCase.findAll").getResultList()
				.get(0);

//		ig.addAuthorizable(o2);
		ig.addAuthorizable(i1);

		p.setOwner(o1);
		p.setAuthorizable(ig);
		p.setRelatable(ic);

		p.setPermissions(true, false);

		em.persist(ig);
		em.persist(p);

	}



	private void createActivity_InvCase_Inv() {
		InvestigativeCase ic1 = (InvestigativeCase) em.createNamedQuery("InvestigativeCase.findAll").getResultList()
				.get(0);
		InvestigativeCase ic2 = new InvestigativeCase(Calendar.getInstance().getTime(), Calendar.getInstance()
				.getTime(), "test", "Open");
		Investigator i = (Investigator) em.createNamedQuery("Investigator.findAll").getResultList().get(0);

		Activity a1 = new Activity(ic1, "evidence", "testing data");
		Activity a2 = new Activity(ic1, "supplemental reports", "testing data");
		Activity a3 = new Activity(ic2, "requesting warrants", "testing data");

		ic2.setOfficerWhoCreatedIt(ic1.getOfficerWhoCreatedIt());
		ic2.addInvestigator(ic1.getInvestigators().get(0));
		a1.setInvestigator(i);
		a2.setInvestigator(i);
		a3.setInvestigator(i);

		em.persist(ic2);
		em.persist(a1);
		em.persist(a2);
		em.persist(a3);
	}



	private void createArrestReportAccordingToIncidentReport() {
		IncidentReport ir = (IncidentReport) em.createNamedQuery("IncidentReport.findAll").getResultList().get(1);
		ArrestReport ar = new ArrestReport();
		ar.addIncidentReportAccordingTo(ir);
		ar.setDocument("bla bla bla");

		em.persist(ar);
	}



	private void createOfficer_InvestigativeCase_IncidentReport_Investigator() {
		Calendar dueDate = Calendar.getInstance();
		dueDate.set(2013, 11, 30);

		Officer of = (Officer) em.createNamedQuery("Officer.findAll").getResultList().get(0);
		IncidentReport ir = (IncidentReport) em.createNamedQuery("IncidentReport.findAll").getResultList().get(1);
		Investigator inv = new Investigator(new PersonName("Cannon", "m."));
		InvestigativeCase invC = new InvestigativeCase(Calendar.getInstance().getTime(), dueDate.getTime(), "test",
				"Open");
		Investigator patric = new Investigator(new PersonName("Patric", "Lencon"));
		
		
//		invC.addIncidentReport(ir);
		ir.setAssignedCase(invC);
		invC.addInvestigator(inv);
		invC.setOfficerWhoCreatedIt(of);

		em.persist(inv);
		em.persist(invC);
		em.persist(ir);

		Officer of2 = (Officer) em.createNamedQuery("Officer.findAll").getResultList().get(1);
		InvestigativeCase invC2 = new InvestigativeCase(Calendar.getInstance().getTime(),
				Calendar.getInstance().getTime(), "test", "Open");
		invC2.setOfficerWhoCreatedIt(of2);

		em.persist(invC2);
		em.persist(patric);
	}



	private void createFieldInterview() {
		Officer of = (Officer) em.createNamedQuery("Officer.findAll").getResultList().get(0);
		FieldInterview fi = new FieldInterview((IncidentReport) of.getEventsResponsibleFor().get(1), em.find(
				Person.class, 1L), em.find(Person.class, 4L), Calendar.getInstance().getTime(), "yes i saw him");

		((IncidentReport) of.getEventsResponsibleFor().get(1)).addFieldInterview(fi);

		em.merge(of);
	}



	private void createSuspectPerson_officer_incidentReport_Entry() {
		Calendar dateYara = Calendar.getInstance();
		dateYara.set(1988, 4, 8);

		Officer of = (Officer) em.createNamedQuery("Officer.findAll").getResultList().get(0);
		SuspectPerson sp1 = new SuspectPerson(new PhysicalCharacteristic(
				PhysicalCharacteristic.getBuildCharacteristicsSuggestions()[2],
				PhysicalCharacteristic.getHeightCharacteristicsSuggestions()[0],
				PhysicalCharacteristic.getComplexionCharacteristicsSuggestions()[3],
				PhysicalCharacteristic.getHairCharacteristicsSuggestions()[2]), new ThreatAssessment("high"), "cool");
		SuspectPerson sp2 = new SuspectPerson(new PhysicalCharacteristic(
				PhysicalCharacteristic.getBuildCharacteristicsSuggestions()[1],
				PhysicalCharacteristic.getHeightCharacteristicsSuggestions()[3],
				PhysicalCharacteristic.getComplexionCharacteristicsSuggestions()[0],
				PhysicalCharacteristic.getHairCharacteristicsSuggestions()[1]), new ThreatAssessment("medium"), "ugly");
		IncidentReport ir = new IncidentReport("flirting", IncidentReport.getStatusOptions()[0], "nothing yet");
		Location l = (Location) em.createNamedQuery("Location.findAll").getResultList().get(0);
		Person complainant = new Person(new PersonName("Yara", ""), null, null, "Female", "Libanies", null, null);
		Relation r = new Relation(l, "happened in", ir);
		Relation r2 = new Relation(complainant, "reported", ir);
		ir.addSuspectPerson(sp1);
		ir.addSuspectPerson(sp2);

		of.addEventResponsibleFor(ir);

		em.persist(complainant);
		em.persist(r);
		em.persist(r2);
		em.persist(of);
	}



	private void createOfficer_Entry_Event() {
		Officer of1 = new Officer(new PersonName("Jims", "Richard"), "Male");
		Officer of2 = new Officer(new PersonName("Lorinda", "dfjkhld"), "Female");
		Person p = em.find(Person.class, 1L);
		IncidentReport ir = new IncidentReport("hitting car", "open", "");
		Conveyance c = (Conveyance) em.createNamedQuery("Conveyance.findAll").getResultList().get(0);
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
		Person p = (Person) em.createNamedQuery("Person.findAll").getResultList().get(1);
		Conveyance c = (Conveyance) em.createNamedQuery("Conveyance.findAll").getResultList().get(1);
		Relation r = new Relation(p, "drove", c);

		em.persist(r);
	}



	private void createConveyance_person() {
		Calendar cc = Calendar.getInstance();
		cc.set(1986, 0, 0);

		Calendar ca = Calendar.getInstance();
		ca.set(1997, 0, 0);

		Person p = em.find(Person.class, 1L);
		Conveyance caprice = new Conveyance("1G1BN69H6GX181007", "155IZY", "SK", Calendar.getInstance().getTime(),
				"CHEV CAPRIC", "LV", cc.getTime(), "RED", "FOOR DOOR CAR", "");
		Conveyance honda = new Conveyance("1HGCD5631VA815858", "701HXJ", "SK", Calendar.getInstance().getTime(),
				"HONDA ACCORD", "EX SERIES 4DR", ca.getTime(), "GREEN", "FOOR DOOR CAR", "");

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
		date1.set(1984, 6, 23);

		Calendar date2 = Calendar.getInstance();
		date2.set(1991, 6, 19);

		Person p1 = new Person(new PersonName("Hamad", "Almarri"), date1.getTime(), "Al Hasa", "Male", "Saudi", null,
				"AA");
		p1.addIdentification(new Identification(p1, "SGI", "849839409"));
		p1.addIdentification(new Identification(p1, "U of R", "200294236"));
		p1.addContact(new CellPhone(p1, "3069990084"));
		p1.addContact(new Email(p1, "almarrih@uregina.ca"));
		p1.setRace(new Race("Saudi Arabian"));
		p1.setPhysicalCharacteristic(new PhysicalCharacteristic("Overweight", "Short", "Light", "Black"));
		p1.setThreatAssessment(new ThreatAssessment("low"));
		p1.addAliasNameOrMoniker(new AliasNameOrMoniker(p1, "the monster"));
		p1.addScars_mark_tattoo(new ScarMarkTattoo(p1, "abu antar mark"));

		Person p2 = new Person(new PersonName("Mohammad", "Almarri"), date2.getTime(), "Al Khobar", "Male", "Saudi",
				null, "PI");
		p2.setThreatAssessment(new ThreatAssessment("low"));
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
