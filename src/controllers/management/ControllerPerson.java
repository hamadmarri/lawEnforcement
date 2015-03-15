package controllers.management;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ejbs.AbstractEjb;
import ejbs.EjbPerson;
import entities.entries.AliasNameOrMoniker;
import entities.entries.Conveyance;
import entities.entries.Identification;
import entities.entries.Person;
import entities.entries.ScarMarkTattoo;
import entities.entries.YouthRiskFactors;
import entities.entries.contacts.CellPhone;
import entities.entries.contacts.Contact;
import entities.entries.contacts.Email;
import entities.entries.contacts.OtherContact;
import entities.entries.contacts.Telephone;
import entities.entries.files.EntryFile;
import entities.entries.files.images.PhotographicImage;


/**
 * @author hamadalmarri
 * 
 * @Pages
 *        - listPersons.xhtml
 *        - viewPerson.xhtml
 *        - addPerson.xhtml
 *        - editPerson.xhtml
 * 
 * @Relative_Objects
 *                   - AliasNameOrMoniker
 *                   - ScarMarkTattoo
 * 
 */
@ManagedBean(name = "controllerPerson")
@ViewScoped
public class ControllerPerson implements Serializable {

	private static final long serialVersionUID = -328811918930855338L;

	@EJB
	private EjbPerson ejbPerson;

	@EJB
	private AbstractEjb<EntryFile> ejbEntryFile;

	@EJB
	private AbstractEjb<Conveyance> ejbConveyance;

	private AliasNameOrMoniker newAliasNameOrMoniker = new AliasNameOrMoniker();
	private ScarMarkTattoo newScarMarkTattoo = new ScarMarkTattoo();
	private Conveyance newConveyance = new Conveyance();
	private List<Person> filteredPersons;

	private String id;

	private Person person = null;

	// list of Investigator objects
	private List<Person> personsList = null;

	// to indicate if the operation is to add
	// new activity or not
	private boolean newEntity = false;



	// private List<String> genders = new
	// ArrayList<String>(Arrays.asList("Male", "Female"));

	/**
	 * will be called automatically right after the class is constructed since
	 * it has the PostConstruct annotation
	 */
	@PostConstruct
	public void init() {
		// at the beginning, set the entitiy name to be Person
		// this.type = "Person";
	}



	public String submit() {
		// if new object it will add the object to DB,
		// otherwise, it will just update it in DB
		if (isNewEntity())
			ejbPerson.add(this.person);
		else
			ejbPerson.save(this.person);

		// return "success" for navigation engine
		return "success";
	}



	public String saveAndContinue() {
		submit();
		return "continue";
	}



	public String saveAndContinue(Long picID) {
		submit();

		if (picID != null) {
			// update photograph image
			Person p = getPerson();
			PhotographicImage pimg = (PhotographicImage) ejbEntryFile.getEntity(picID, "PhotographicImage");
			pimg.addPerson(p);
			ejbEntryFile.save(pimg);
		}

		return "continue";
	}



	public String saveAndFinish() {
		submit();
		return "finish";
	}



	/**
	 * to initiate new object of Person. This function will be called from
	 * addPerson.xhtml page at preRenderView phase
	 */
	public void createNewPerson() {
		if (id != null && !id.isEmpty())
			return;

		this.person = new Person();
		setNewEntity(true);
	}



	public Person getPerson() {

		// if the object was loaded already, just return it
		if (this.person != null)
			return this.person;

		// if the id is null do not try to load it from DB, just return null
		if (this.id == null)
			return null;

		// at this point object must be null but id is not,
		// so load it from DB
		this.person = ejbPerson.getEntity(Long.parseLong(this.id));

		return this.person;
	}



	public void setPerson(Person person) {
		this.person = person;
	}



	public List<Person> getPersonsList() {
		if (this.personsList == null)
			this.personsList = ejbPerson.getList();

		return personsList;
	}



	public void setPersonsList(List<Person> list) {
		this.personsList = list;
	}



	/**
	 * Adds Alias name to this person. This function is called from
	 * viewPerson.xhtml page
	 */
	public void addNewAliasName() {
		this.newAliasNameOrMoniker.setPerson(this.getPerson());
		this.getPerson().addAliasNameOrMoniker(this.newAliasNameOrMoniker);
		this.submit();
		this.newAliasNameOrMoniker = new AliasNameOrMoniker();
	}



	/**
	 * Adds Scar, Mark or Tattoo to this person. This function is called from
	 * viewPerson.xhtml page
	 */
	public void addNewScarMarkTattoo() {
		this.newScarMarkTattoo.setPerson(this.getPerson());
		this.getPerson().addScars_mark_tattoo(this.newScarMarkTattoo);
		this.submit();
		this.newScarMarkTattoo = new ScarMarkTattoo();
	}



	public AliasNameOrMoniker getNewAliasNameOrMoniker() {
		return newAliasNameOrMoniker;
	}



	public void setNewAliasNameOrMoniker(AliasNameOrMoniker newAliasNameOrMoniker) {
		this.newAliasNameOrMoniker = newAliasNameOrMoniker;
	}



	public ScarMarkTattoo getNewScarMarkTattoo() {
		return newScarMarkTattoo;
	}



	public void setNewScarMarkTattoo(ScarMarkTattoo newScarMarkTattoo) {
		this.newScarMarkTattoo = newScarMarkTattoo;
	}



	public Conveyance getNewConveyance() {
		return newConveyance;
	}



	public void setNewConveyance(Conveyance newConveyance) {
		this.newConveyance = newConveyance;
	}



	public YouthRiskFactors getYouthRiskFactors() {
		return getPerson().getYouthRiskFactors();
	}



	public List<Person> getFilteredPersons() {
		return filteredPersons;
	}



	public void setFilteredPersons(List<Person> filteredPersons) {
		this.filteredPersons = filteredPersons;
	}



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public boolean isNewEntity() {
		return newEntity;
	}



	public void setNewEntity(boolean newEntity) {
		this.newEntity = newEntity;
	}



	public void addIdentification() {
		getPerson().addIdentification(new Identification(getPerson(), "", ""));
	}



	public void removeIdentification(Identification i) {
		getPerson().getIdentifications().remove(i);
	}



	public void addOtherContact() {
		getPerson().addContact(new OtherContact(getPerson(), ""));
	}



	public void addCellPhone() {
		getPerson().addContact(new CellPhone(getPerson(), ""));
	}



	public void addEmail() {
		getPerson().addContact(new Email(getPerson(), ""));
	}



	public void addTelephone() {
		getPerson().addContact(new Telephone(getPerson(), ""));
	}



	public void removeContact(Contact c) {
		getPerson().getContacts().remove(c);
	}



	public void saveConveyance() {
		newConveyance.setRegisteredOwner(getPerson());
		ejbConveyance.add(newConveyance);

		getPerson().getConveyances().add(newConveyance);

		submit();
		
		newConveyance = new Conveyance();
	}



	public void removeConveyance(Conveyance c) {
		getPerson().getConveyances().remove(c);
		c.setRegisteredOwner(null);
		ejbConveyance.save(c);
	}



	public void addAliasNamesOrMonikers() {
		getPerson().addAliasNameOrMoniker(new AliasNameOrMoniker(getPerson(), ""));
	}



	public void removeAliasNamesOrMonikers(AliasNameOrMoniker a) {
		getPerson().getAliasNamesOrMonikers().remove(a);
	}



	public void addScars_marks_tattoos() {
		getPerson().addScars_mark_tattoo(new ScarMarkTattoo(getPerson(), ""));
	}



	public void removeScars_marks_tattoos(ScarMarkTattoo s) {
		getPerson().getScars_marks_tattoos().remove(s);
	}
	
}
