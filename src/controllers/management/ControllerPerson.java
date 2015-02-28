package controllers.management;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import entities.entries.AliasNameOrMoniker;
import entities.entries.Person;
import entities.entries.ScarMarkTattoo;
import entities.entries.YouthRiskFactors;


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
public class ControllerPerson extends AbstractController<Person> implements Serializable {

	private static final long serialVersionUID = -328811918930855338L;
	private AliasNameOrMoniker newAliasNameOrMoniker = new AliasNameOrMoniker();
	private ScarMarkTattoo newScarMarkTattoo = new ScarMarkTattoo();



	/**
	 * will be called automatically right after the class is constructed since
	 * it has the PostConstruct annotation
	 */
	@PostConstruct
	public void init() {
		// at the beginning, set the entitiy name to be Person
		this.type = "Person";
	}



	/**
	 * to initiate new object of Person. This function will be called from
	 * addPerson.xhtml page at preRenderView phase
	 */
	public void createNewPerson() {
		this.relatable = new Person();
		super.setNewRelatable(true);
	}



	public Person getPerson() {
		return super.getRelatable();
	}



	public void setPerson(Person person) {
		this.relatable = person;
	}



	public List<Person> getPersonsList() {
		return super.getList();
	}



	public void setPersonsList(List<Person> list) {
		super.setList(list);
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



	public YouthRiskFactors getYouthRiskFactors() {
		return getPerson().getYouthRiskFactors();
	}

}
