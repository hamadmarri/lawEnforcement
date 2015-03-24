package developmentUtilities;

import intelligence.FillUpDatabaseWithCrimeScenesAndOffenderProfiles;
import intelligence.FillUpDatabaseWithYourhRiskFactorsAndCriminalRecords;

import java.util.Calendar;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import security.Authorizable;
import security.Permission;
import entities.Relatable;
import entities.Relation;
import entities.entries.Address;
import entities.entries.AliasNameOrMoniker;
import entities.entries.Conveyance;
import entities.entries.Crime;
import entities.entries.Identification;
import entities.entries.Location;
import entities.entries.Organization;
import entities.entries.Person;
import entities.entries.PersonName;
import entities.entries.PhysicalCharacteristic;
import entities.entries.Property;
import entities.entries.Race;
import entities.entries.ScarMarkTattoo;
import entities.entries.SuspectPerson;
import entities.entries.ThreatAssessment;
import entities.entries.contacts.CellPhone;
import entities.entries.contacts.Contact;
import entities.entries.contacts.Email;
import entities.entries.history.Action;
import entities.entries.history.History;
import entities.events.ArrestReport;
import entities.events.FieldInterview;
import entities.events.IncidentReport;
import entities.police.Activity;
import entities.police.InvestigativeCase;
import entities.police.InvestigativeGroup;
import entities.police.Investigator;
import entities.police.Notification;
import entities.police.Officer;


@Stateless
public class EJB_of_test {

	@PersistenceContext(unitName = "lawEnforcementPersistenceUnit")
	private EntityManager em;

	@EJB
	private FillUpDatabaseWithCrimeScenesAndOffenderProfiles fillUpDatabaseWithCSAndOP;

	@EJB
	private FillUpDatabaseWithYourhRiskFactorsAndCriminalRecords fillUpDatabaseWithYourhRiskFactorsAndCriminalRecords;

 

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
		createMoreInvCasesForMonitorTesting();
		suspect_person_invC();
		fillUpDatabaseWithCSAndOP.fillUpData();
		createNotifications();
		createCriminalRecord();

		createYouthInRisk();

		fillUpDatabaseWithYourhRiskFactorsAndCriminalRecords.fillUpData();
	}



	/*
	 * Random names generator http://listofrandomnames.com/index.cfm?generated
	 */
	private void createYouthInRisk() {
		Calendar bd = Calendar.getInstance();

		bd.set(1991, 5, 21);
		Person p1 = new Person(new PersonName("Nathan", "Puckett"), bd.getTime(), null, "Male", null, null, null);

		bd.set(1975, 4, 1);
		Person p2 = new Person(new PersonName("Liz", "Basch"), bd.getTime(), null, "Female", null, null, null);

		bd.set(1981, 7, 20);
		Person p3 = new Person(new PersonName("Amina", "Lucey"), bd.getTime(), null, "Female", null, null, null);

		bd.set(1986, 4, 17);
		Person p4 = new Person(new PersonName("Israel", "Vandever"), bd.getTime(), null, "Male", null, null, null);

		bd.set(1976, 5, 3);
		Person p5 = new Person(new PersonName("Kanesha", "Ephraim"), bd.getTime(), null, "Female", null, null, null);

		bd.set(1970, 11, 9);
		Person p6 = new Person(new PersonName("Cythia", "Lytle"), bd.getTime(), null, "Female", null, null, null);

		bd.set(1982, 2, 5);
		Person p7 = new Person(new PersonName("Krysten", "Gaeta"), bd.getTime(), null, "Female", null, null, null);

		bd.set(1979, 6, 23);
		Person p8 = new Person(new PersonName("Milford", "Brann"), bd.getTime(), null, "Male", null, null, null);

		bd.set(1973, 11, 3);
		Person p9 = new Person(new PersonName("Lorretta", "Kuzma"), bd.getTime(), null, "Female", null, null, null);

		bd.set(1990, 10, 7);
		Person p10 = new Person(new PersonName("Shanelle", "Kieffer"), bd.getTime(), null, "Female", null, null, null);

		bd.set(1994, 5, 13);
		Person p11 = new Person(new PersonName("Abby", "Kirkwood"), bd.getTime(), null, "Female", null, null, null);

		bd.set(1996, 8, 27);
		Person p12 = new Person(new PersonName("Felice", "Moulder"), bd.getTime(), null, "Female", null, null, null);

		bd.set(1994, 8, 17);
		Person p13 = new Person(new PersonName("Lan", "Alegria"), bd.getTime(), null, "Female", null, null, null);

		bd.set(1997, 4, 18);
		Person p14 = new Person(new PersonName("Alphonso", "Warnke"), bd.getTime(), null, "Male", null, null, null);

		bd.set(1992, 5, 14);
		Person p15 = new Person(new PersonName("Kizzy", "Mounsey"), bd.getTime(), null, "Female", null, null, null);

		bd.set(1988, 4, 21);
		Person p16 = new Person(new PersonName("Sharan", "Chenard"), bd.getTime(), null, "Female", null, null, null);

		bd.set(1999, 7, 7);
		Person p17 = new Person(new PersonName("Latashia", "Guajardo"), bd.getTime(), null, "Female", null, null, null);

		bd.set(1991, 5, 1);
		Person p18 = new Person(new PersonName("Micaela", "Weiner"), bd.getTime(), null, "Female", null, null, null);

		bd.set(1991, 5, 21);
		Person p19 = new Person(new PersonName("Evangeline", "Sinkler"), bd.getTime(), null, "Female", null, null, null);

		bd.set(1991, 5, 21);
		Person p20 = new Person(new PersonName("Denise", "Mcmenamin"), bd.getTime(), null, "Female", null, null, null);

		bd.set(1991, 5, 21);
		Person p21 = new Person(new PersonName("Lenny", "Dilks"), bd.getTime(), null, "Male", null, null, null);

		bd.set(1991, 5, 21);
		Person p22 = new Person(new PersonName("Thaddeus", "Mckelvey"), bd.getTime(), null, "Male", null, null, null);

		bd.set(1991, 5, 21);
		Person p23 = new Person(new PersonName("Oliver", "Peasley"), bd.getTime(), null, "Male", null, null, null);

		bd.set(1991, 5, 21);
		Person p24 = new Person(new PersonName("Trista", "Stubbe"), bd.getTime(), null, "Female", null, null, null);

		bd.set(1991, 5, 21);
		Person p25 = new Person(new PersonName("Mercy", "Buckingham"), bd.getTime(), null, "Female", null, null, null);

		bd.set(1991, 5, 21);
		Person p26 = new Person(new PersonName("Latonya", "Benavides"), bd.getTime(), null, "Female", null, null, null);

		bd.set(1991, 5, 21);
		Person p27 = new Person(new PersonName("Latrina", "Deem"), bd.getTime(), null, "Female", null, null, null);

		bd.set(1991, 5, 21);
		Person p28 = new Person(new PersonName("Gena", "Luebbert"), bd.getTime(), null, "Female", null, null, null);

		bd.set(1991, 5, 21);
		Person p29 = new Person(new PersonName("Keturah", "Drown"), bd.getTime(), null, "Female", null, null, null);

		bd.set(1982, 5, 21);
		Person p30 = new Person(new PersonName("Heriberto", "Kopczynski"), bd.getTime(), null, "Male", null, null, null);

		Crime c1 = new Crime(p5.getCriminalRecord(), "killed her hasband", Calendar.getInstance().getTime(),
				Crime.typeOfCrimeSuggestions[0]);
		Crime c2 = new Crime(p8.getCriminalRecord(), "stole a grossary", Calendar.getInstance().getTime(),
				Crime.typeOfCrimeSuggestions[1]);
		Crime c3 = new Crime(p4.getCriminalRecord(), "phishing Bank users", Calendar.getInstance().getTime(),
				Crime.typeOfCrimeSuggestions[2]);
		Crime c4 = new Crime(p8.getCriminalRecord(), "rapped a bank", Calendar.getInstance().getTime(),
				Crime.typeOfCrimeSuggestions[3]);
		Crime c5 = new Crime(p30.getCriminalRecord(), "burned his neighbour's car", Calendar.getInstance().getTime(),
				Crime.typeOfCrimeSuggestions[5]);
		Crime c6 = new Crime(p30.getCriminalRecord(), "abused a child", Calendar.getInstance().getTime(),
				Crime.typeOfCrimeSuggestions[6]);

		p1.getYouthRiskFactors().setPoverty(true);
		p4.getYouthRiskFactors().setGangMembership(true);
		p4.getYouthRiskFactors().setAcademicFailure(true);
		p4.getYouthRiskFactors().setParentalAttitudesFavorableToSubstanceUseAndViolence(true);
		p14.getYouthRiskFactors().setDelinquentPeers(true);
		p23.getYouthRiskFactors().setPregnancyAndDeliveryComplications(true);
		p30.getYouthRiskFactors().setChildMaltreatment(true);
		p30.getYouthRiskFactors().setParentalAttitudesFavorableToSubstanceUseAndViolence(true);
		p30.getYouthRiskFactors().setAvailabilityOfDrugsAndFirearms(true);

		em.persist(p1);
		em.persist(p2);
		em.persist(p3);
		em.persist(p4);
		em.persist(p5);
		em.persist(p6);
		em.persist(p7);
		em.persist(p8);
		em.persist(p9);
		em.persist(p10);
		em.persist(p11);
		em.persist(p12);
		em.persist(p13);
		em.persist(p14);
		em.persist(p15);
		em.persist(p16);
		em.persist(p17);
		em.persist(p18);
		em.persist(p19);
		em.persist(p20);
		em.persist(p21);
		em.persist(p22);
		em.persist(p23);
		em.persist(p24);
		em.persist(p25);
		em.persist(p26);
		em.persist(p27);
		em.persist(p28);
		em.persist(p29);
		em.persist(p30);

		em.persist(c1);
		em.persist(c2);
		em.persist(c3);
		em.persist(c4);
		em.persist(c5);
		em.persist(c6);
	}



	private void createCriminalRecord() {

		Calendar bd = Calendar.getInstance();
		bd.set(1991, 5, 21);

		Person p = new Person(new PersonName("Matt", "Zoo"), bd.getTime(), null, "Male", null, null, null);
		IncidentReport ir = (IncidentReport) em.createNamedQuery("IncidentReport.findAll").getResultList().get(0);
		Crime c = new Crime(p.getCriminalRecord(), "rapped old women", Calendar.getInstance().getTime(),
				Crime.typeOfCrimeSuggestions[4]);

		c.setIncidentReport(ir);

		p.getYouthRiskFactors().setGangMembership(true);
		p.getYouthRiskFactors().setAggressiveness(true);

		em.persist(p);
		em.persist(c);
	}



	private void createNotifications() {
		Authorizable a = (Authorizable) em.createNamedQuery("Authorizable.findAll").getResultList().get(0);
		InvestigativeGroup ig = (InvestigativeGroup) em.createNamedQuery("InvestigativeGroup.findAll").getResultList()
				.get(0);
		Investigator i1 = (Investigator) em.createNamedQuery("Investigator.findAll").getResultList().get(0);
		Investigator i2 = (Investigator) em.createNamedQuery("Investigator.findAll").getResultList().get(1);

		InvestigativeCase invC1 = (InvestigativeCase) em.createNamedQuery("InvestigativeCase.findAll").getResultList()
				.get(0);

		Notification n1 = new Notification("test note to inv group", a, ig, invC1);
		Notification n2 = new Notification("to i1", a, i1, invC1);
		Notification n3 = new Notification("to i1 read", a, i1, invC1);
		Notification n4 = new Notification("to i2", a, i2, invC1);
		Notification n5 = new Notification("to i2 read", a, i2, invC1);

		n3.setState(Notification.stateSuggestions[1]);
		n5.setState(Notification.stateSuggestions[1]);

		em.persist(n1);
		em.persist(n2);
		em.persist(n3);
		em.persist(n4);
		em.persist(n5);
	}



	private void suspect_person_invC() {
		InvestigativeCase invC = (InvestigativeCase) em.createNamedQuery("InvestigativeCase.findAll").getResultList()
				.get(0);
		Person p = (Person) em.createNamedQuery("Person.findAll").getResultList().get(0);
		SuspectPerson sp = new SuspectPerson();

		sp.setPerson(p);
		invC.addSuspectPerson(sp);
		em.merge(invC);
	}



	private void createMoreInvCasesForMonitorTesting() {
		Calendar startDate = Calendar.getInstance();
		Calendar dueDate = Calendar.getInstance();
		Officer james = (Officer) em.createNamedQuery("Officer.findAll").getResultList().get(0);
		Officer lorinda = (Officer) em.createNamedQuery("Officer.findAll").getResultList().get(1);
		Investigator connan = (Investigator) em.createNamedQuery("Investigator.findAll").getResultList().get(0);
		Investigator patric = (Investigator) em.createNamedQuery("Investigator.findAll").getResultList().get(1);
		IncidentReport ir1 = (IncidentReport) em.createNamedQuery("IncidentReport.findAll").getResultList().get(0);
		IncidentReport ir2 = (IncidentReport) em.createNamedQuery("IncidentReport.findAll").getResultList().get(1);
		InvestigativeCase invC;

		/******* first case *******/
		startDate.set(2012, 1, 2);
		dueDate.set(2012, 3, 0);
		invC = new InvestigativeCase(startDate.getTime(), dueDate.getTime(), "Monitoring 1", "Closed");
		invC.addInvestigator(connan);
		invC.setOfficerWhoCreatedIt(james);
		ir1.setAssignedCase(invC);
		em.persist(invC);
		em.persist(ir1);

		/******* second case *******/
		startDate.set(2013, 5, 2);
		dueDate.set(2013, 6, 25);
		invC = new InvestigativeCase(startDate.getTime(), dueDate.getTime(), "Different description", "Pending");
		invC.addInvestigator(patric);
		invC.setOfficerWhoCreatedIt(lorinda);
		ir2.setAssignedCase(invC);
		em.persist(invC);
		em.persist(ir2);

		/******* 3 case *******/
		startDate.set(2012, 1, 2);
		dueDate.set(2012, 3, 0);
		invC = new InvestigativeCase(startDate.getTime(), dueDate.getTime(), "another one related to suzi",
				"In progress");
		invC.addInvestigator(connan);
		invC.setOfficerWhoCreatedIt(james);
		ir1.setAssignedCase(invC);
		em.persist(invC);
		em.persist(ir1);

		/******* 4 case *******/
		startDate.set(2011, 8, 22);
		dueDate.set(2011, 9, 20);
		invC = new InvestigativeCase(startDate.getTime(), dueDate.getTime(), "just test", "Refused");
		invC.addInvestigator(connan);
		invC.setOfficerWhoCreatedIt(james);
		ir1.setAssignedCase(invC);
		em.persist(invC);
		em.persist(ir1);

	}



	private void createInvestigativeGroup_Permission() {
		Officer o1 = (Officer) em.createNamedQuery("Officer.findAll").getResultList().get(0);
		// Officer o2 = (Officer)
		// em.createNamedQuery("Officer.findAll").getResultList().get(1);
		Investigator i1 = (Investigator) em.createNamedQuery("Investigator.findAll").getResultList().get(0);
		Investigator i2 = (Investigator) em.createNamedQuery("Investigator.findAll").getResultList().get(1);
		InvestigativeGroup ig = new InvestigativeGroup("First Group");
		Permission p = new Permission();
		InvestigativeCase ic = (InvestigativeCase) em.createNamedQuery("InvestigativeCase.findAll").getResultList()
				.get(0);

		// ig.addAuthorizable(o2);
		ig.addAuthorizable(i1);
		ig.addAuthorizable(i2);

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

		// invC.addIncidentReport(ir);
		ir.setAssignedCase(invC);
		invC.addInvestigator(inv);
		invC.setOfficerWhoCreatedIt(of);

		em.persist(inv);
		em.persist(invC);
		em.persist(ir);

		Officer of2 = (Officer) em.createNamedQuery("Officer.findAll").getResultList().get(1);
		InvestigativeCase invC2 = new InvestigativeCase(Calendar.getInstance().getTime(), Calendar.getInstance()
				.getTime(), "test", "Open");
		invC2.setOfficerWhoCreatedIt(of2);

		em.persist(invC2);
		em.persist(patric);

		Investigator inv3 = new Investigator(new PersonName("Medhat", "Salem"));
		em.persist(inv3);
	}



	private void createFieldInterview() {
		Officer of = (Officer) em.createNamedQuery("Officer.findAll").getResultList().get(0);
		FieldInterview fi = new FieldInterview((IncidentReport) of.getEventsResponsibleFor().get(1), em.find(
				Person.class, 1L), em.find(Person.class, 4L), Calendar.getInstance().getTime());

		((IncidentReport) of.getEventsResponsibleFor().get(1)).addFieldInterview(fi);

		em.merge(of);
	}



	private void createSuspectPerson_officer_incidentReport_Entry() {
		Calendar dateYara = Calendar.getInstance();
		dateYara.set(1988, 4, 8);

		Officer of = (Officer) em.createNamedQuery("Officer.findAll").getResultList().get(0);
		// SuspectPerson sp1 = new SuspectPerson(new PhysicalCharacteristic(
		// PhysicalCharacteristic.getBuildCharacteristicsSuggestions()[2],
		// PhysicalCharacteristic.getHeightCharacteristicsSuggestions()[0],
		// PhysicalCharacteristic.getComplexionCharacteristicsSuggestions()[3],
		// PhysicalCharacteristic.getHairCharacteristicsSuggestions()[2]), new
		// ThreatAssessment("high"), "cool");
		// SuspectPerson sp2 = new SuspectPerson(new PhysicalCharacteristic(
		// PhysicalCharacteristic.getBuildCharacteristicsSuggestions()[1],
		// PhysicalCharacteristic.getHeightCharacteristicsSuggestions()[3],
		// PhysicalCharacteristic.getComplexionCharacteristicsSuggestions()[0],
		// PhysicalCharacteristic.getHairCharacteristicsSuggestions()[1]), new
		// ThreatAssessment("medium"), "ugly");
		IncidentReport ir = new IncidentReport("flirting", IncidentReport.getStatusOptions()[0], "nothing yet");
		Location l = (Location) em.createNamedQuery("Location.findAll").getResultList().get(0);
		Person complainant = new Person(new PersonName("Yara", ""), dateYara.getTime(), null, "Female", "Libanies",
				null, null);
		Relation r = new Relation(l, "happened in", ir);
		Relation r2 = new Relation(complainant, "reported", ir);
		// ir.addSuspectPerson(sp1);
		// ir.addSuspectPerson(sp2);

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

		Identification id1;
		Identification id2;
		Contact c1;
		Contact c2;
		// PhotographicImage pi;
		// List<MugShotImage> msi;

		Person p1 = new Person(new PersonName("Hamad", "Almarri"), date1.getTime(), "Al Hasa", "Male", "Saudi", null,
				"AA");
		// p1.addIdentification(new Identification(p1, "SGI", "849839409"));
		// p1.addIdentification(new Identification(p1, "U of R", "200294236"));
		// p1.addContact(new CellPhone(p1, "3069990084"));
		// p1.addContact(new Email(p1, "almarrih@uregina.ca"));
		p1.setRace(new Race("Saudi Arabian"));
		p1.setPhysicalCharacteristic(new PhysicalCharacteristic("Overweight", "Short", "Light", "Black"));
		p1.setThreatAssessment(new ThreatAssessment("low"));
		p1.addAliasNameOrMoniker(new AliasNameOrMoniker(p1, "the monster"));
		p1.addScars_mark_tattoo(new ScarMarkTattoo(p1, "abu antar mark"));

		Person p2 = new Person(new PersonName("Mohammad", "Almarri"), date2.getTime(), "Al Khobar", "Male", "Saudi",
				null, "PI");
		p2.setThreatAssessment(new ThreatAssessment("low"));
		Relation r = new Relation(p1, "brothers", p2);

		id1 = new Identification(p1, "SGI", "849839409");
		id2 = new Identification(p1, "U of R", "200294236");
		c1 = new CellPhone(p1, "3069990084");
		c2 = new Email(p1, "almarrih@uregina.ca");

		// pi = new PhotographicImage("both", "link0");
		// pi.addPerson(p1);
		// pi.addPerson(p2);
		//
		// msi = new ArrayList<MugShotImage>();
		// msi.add(new MugShotImage("fron", "link1", p1));
		// msi.add(new MugShotImage("right", "link2", p1));
		// msi.add(new MugShotImage("left", "link3", p1));

		em.persist(p1);
		em.persist(p2);

		em.persist(id1);
		em.persist(id2);

		em.persist(c1);
		em.persist(c2);

		em.persist(r);
		// em.persist(pi);

		// for (MugShotImage mugShotImage : msi)
		// em.persist(mugShotImage);

	}



	private void createEntity_History_Actions() {
		Person p = em.find(Person.class, 1L);
		History h = new History();

		p.setHistory(h);
		h.addAction(new Action("first name", "dfg", "Dfgd"));
		h.addAction(new Action("ldkjfgl", "dfg", "Dfgd"));
		h.addAction(new Action("first name", "dfg", "Dfgd"));

		em.persist(p);

	}

}
