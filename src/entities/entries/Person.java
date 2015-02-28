package entities.entries;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import entities.entries.contacts.Contact;
import entities.entries.files.images.FingerprintImage;
import entities.entries.files.images.MugShotImage;
import entities.entries.files.images.PhotographicImage;
import entities.entries.history.Action;
import entities.events.FieldInterview;


/**
 * Entity implementation class for Entity: Person
 * 
 */
@Entity
@NamedQueries({
		@NamedQuery(name = "Person.findAll", query = "select p from Person p"),
		@NamedQuery(name = "Person.findByIdentification", query = "select p from Person p"
				+ " join p.identifications i WHERE VALUE(i) = :identification") })
public class Person extends Entry {

	/*
	 * -Location history (current and past residences) -Employer information
	 * -TelephoneNumbers -Known associates -Alias names/monikers -Available mug
	 * shot(s) and photographs -Scars, marks, and tattoos -Modus operandi (i.e.,
	 * unique method of operation for a specific type of crime) -Identification
	 * (e.g., social security, driver’s license, and local and county
	 * identification) -NCIC fingerprint classification
	 */

	private static final long serialVersionUID = -8786554206930842361L;

	@Embedded
	private PersonName personName;

	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;

	private String birthPlace;
	private String gender;
	private String citizenship;

	@OneToMany(mappedBy = "person")
	private List<Identification> identifications;

	@OneToMany(mappedBy = "person")
	private List<Contact> contacts;

	@OneToMany(cascade = CascadeType.ALL)
	private List<AliasNameOrMoniker> aliasNamesOrMonikers;

	@OneToMany(cascade = CascadeType.ALL)
	private List<ScarMarkTattoo> scars_marks_tattoos;

	private String modusOperandi;
	private String NCIC_fingerprintClassification;

	@Embedded
	private PhysicalCharacteristic physicalCharacteristic;

	@Embedded
	private ThreatAssessment threatAssessment;

	@Embedded
	private Race race = new Race();

	@OneToMany(mappedBy = "person")
	private List<MugShotImage> mugShots;

	@OneToMany(mappedBy = "person")
	private List<FingerprintImage> fingerprintsImages;

	@ManyToMany(mappedBy = "persons")
	private List<PhotographicImage> photographs;

	@OneToMany(mappedBy = "registeredOwner")
	private List<Conveyance> conveyances;

	@OneToMany(mappedBy = "subscriber")
	private List<FieldInterview> fieldInterviewsAsSubscriber;

	@OneToMany(mappedBy = "inCaseOfEmergencyPerson")
	private List<FieldInterview> fieldInterviewsAsInCaseOfEmergencyPerson;

	@OneToOne(mappedBy = "person")
	private SuspectPerson suspectPerson;

	@OneToOne(cascade = CascadeType.ALL)
	private CriminalRecord criminalRecord;

	@OneToOne(cascade = CascadeType.ALL)
	private YouthRiskFactors youthRiskFactors;

	private boolean inRisk;
	private String riskType;

	private static String[] NCIC_fingerprintClassificationSuggestions = { "AA", "TT", "##50", "##", "PI", "PM", "PO",
			"CI", "CM", "CO", "dI", "dM", "dO", "XI", "XM", "XO", "XX", "SR" };

	/*
	 * The Java compiler copies initializer blocks into every constructor.
	 * Therefore, this approach can be used to share a block of code between
	 * multiple constructors.
	 */
	{
		this.type = "Person";
		this.physicalCharacteristic = new PhysicalCharacteristic();
		this.personName = new PersonName();
		// this.dateOfBirth = new Date();
		this.birthPlace = new String();
		this.gender = new String();
		this.citizenship = new String();
		this.modusOperandi = new String();
		this.NCIC_fingerprintClassification = new String();
		this.threatAssessment = new ThreatAssessment();
		this.race = new Race();
		this.identifications = new ArrayList<Identification>();
		this.contacts = new ArrayList<Contact>();
		this.aliasNamesOrMonikers = new ArrayList<AliasNameOrMoniker>();
		this.scars_marks_tattoos = new ArrayList<ScarMarkTattoo>();
		this.mugShots = new ArrayList<MugShotImage>();
		this.fingerprintsImages = new ArrayList<FingerprintImage>();
		this.photographs = new ArrayList<PhotographicImage>();
		this.conveyances = new ArrayList<Conveyance>();
		this.fieldInterviewsAsSubscriber = new ArrayList<FieldInterview>();
		this.fieldInterviewsAsInCaseOfEmergencyPerson = new ArrayList<FieldInterview>();
		this.criminalRecord = new CriminalRecord();
		this.youthRiskFactors = new YouthRiskFactors(this.criminalRecord);
		this.inRisk = false;
		this.riskType = new String();
	}



	public Person() {
		super();
	}



	public Person(PersonName personName, Date dateOfBirth, String birthPlace, String gender, String citizenship,
			String modusOperandi, String nCIC_fingerprintClassification) {
		super();
		this.personName = personName;
		this.dateOfBirth = dateOfBirth;
		this.birthPlace = birthPlace;
		this.gender = gender;
		this.citizenship = citizenship;
		this.modusOperandi = modusOperandi;
		NCIC_fingerprintClassification = nCIC_fingerprintClassification;
	}



	public PersonName getPersonName() {
		return personName;
	}



	public void setPersonName(PersonName name) {
		this.personName = name;
	}



	public Date getDateOfBirth() {
		return dateOfBirth;
	}



	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}



	public String getBirthPlace() {
		return birthPlace;
	}



	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}



	public String getGender() {
		return this.gender;
	}



	public void setGender(String gender) {
		this.gender = gender;
	}



	public String getCitizenship() {
		return citizenship;
	}



	public void setCitizenship(String citizenship) {
		this.citizenship = citizenship;
	}



	public List<Identification> getIdentifications() {
		return identifications;
	}



	public void setIdentifications(List<Identification> identifications) {
		this.identifications = identifications;
	}



	public void addIdentification(Identification identification) {
		if (this.identifications == null)
			this.identifications = new ArrayList<Identification>();

		this.identifications.add(identification);
	}



	public List<Contact> getContacts() {
		return contacts;
	}



	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}



	public void addContact(Contact contact) {
		if (this.contacts == null)
			this.contacts = new ArrayList<Contact>();

		this.contacts.add(contact);
	}



	public List<AliasNameOrMoniker> getAliasNamesOrMonikers() {
		return aliasNamesOrMonikers;
	}



	public void setAliasNamesOrMonikers(List<AliasNameOrMoniker> aliasNamesOrMonikers) {
		this.aliasNamesOrMonikers = aliasNamesOrMonikers;
	}



	public void addAliasNameOrMoniker(AliasNameOrMoniker aliasNameOrMoniker) {
		if (this.aliasNamesOrMonikers == null)
			this.aliasNamesOrMonikers = new ArrayList<AliasNameOrMoniker>();

		this.aliasNamesOrMonikers.add(aliasNameOrMoniker);
	}



	public List<ScarMarkTattoo> getScars_marks_tattoos() {
		return scars_marks_tattoos;
	}



	public void setScars_marks_tattoos(List<ScarMarkTattoo> scars_marks_tattoos) {
		this.scars_marks_tattoos = scars_marks_tattoos;
	}



	public void addScars_mark_tattoo(ScarMarkTattoo scar_mark_tattoo) {
		if (this.scars_marks_tattoos == null)
			this.scars_marks_tattoos = new ArrayList<ScarMarkTattoo>();

		this.scars_marks_tattoos.add(scar_mark_tattoo);
	}



	public String getModusOperandi() {
		return modusOperandi;
	}



	public void setModusOperandi(String modusOperandi) {
		this.modusOperandi = modusOperandi;
	}



	public String getNCIC_fingerprintClassification() {
		return NCIC_fingerprintClassification;
	}



	public void setNCIC_fingerprintClassification(String nCIC_fingerprintClassification) {
		NCIC_fingerprintClassification = nCIC_fingerprintClassification;
	}



	public PhysicalCharacteristic getPhysicalCharacteristic() {
		// if (this.physicalCharacteristic == null)
		// this.physicalCharacteristic = new PhysicalCharacteristic();

		return physicalCharacteristic;
	}



	public void setPhysicalCharacteristic(PhysicalCharacteristic physicalCharacteristic) {
		this.physicalCharacteristic = physicalCharacteristic;
	}



	public ThreatAssessment getThreatAssessment() {
		return threatAssessment;
	}



	public void setThreatAssessment(ThreatAssessment threatAssessment) {
		this.threatAssessment = threatAssessment;
	}



	public Race getRace() {
		return this.race;
	}



	public void setRace(Race race) {
		this.race = race;
	}



	public List<MugShotImage> getMugShots() {
		return mugShots;
	}



	public void setMugShots(List<MugShotImage> mugShots) {
		this.mugShots = mugShots;
	}



	public List<FingerprintImage> getFingerprintsImages() {
		return fingerprintsImages;
	}



	public void setFingerprintsImages(List<FingerprintImage> fingerprintsImages) {
		this.fingerprintsImages = fingerprintsImages;
	}



	public List<PhotographicImage> getPhotographs() {
		return photographs;
	}



	public void setPhotographs(List<PhotographicImage> photographs) {
		this.photographs = photographs;
	}



	public static String[] getNCIC_fingerprintClassificationSuggestions() {
		return NCIC_fingerprintClassificationSuggestions;
	}



	public static void setNCIC_fingerprintClassificationSuggestions(String[] nCIC_fingerprintClassificationSuggestions) {
		NCIC_fingerprintClassificationSuggestions = nCIC_fingerprintClassificationSuggestions;
	}



	public List<Conveyance> getConveyances() {
		return conveyances;
	}



	public List<FieldInterview> getFieldInterviewsAsSubscriber() {
		return fieldInterviewsAsSubscriber;
	}



	public List<FieldInterview> getFieldInterviewsAsInCaseOfEmergencyPerson() {
		return fieldInterviewsAsInCaseOfEmergencyPerson;
	}



	public SuspectPerson getSuspectPerson() {
		return suspectPerson;
	}



	public void setSuspectPerson(SuspectPerson suspectPerson) {
		this.suspectPerson = suspectPerson;
	}



	public CriminalRecord getCriminalRecord() {
		return criminalRecord;
	}



	public void setCriminalRecord(CriminalRecord criminalRecord) {
		this.criminalRecord = criminalRecord;
	}



	public YouthRiskFactors getYouthRiskFactors() {
		return youthRiskFactors;
	}



	public void setYouthRiskFactors(YouthRiskFactors youthRiskFactors) {
		this.youthRiskFactors = youthRiskFactors;
	}



	public boolean isInRisk() {
		return inRisk;
	}



	public void setInRisk(boolean inRisk) {
		this.inRisk = inRisk;
	}



	public String getRiskType() {
		return riskType;
	}



	public void setRiskType(String riskType) {
		this.riskType = riskType;
	}



	@Override
	public void logChanges(Object old) {

		Person oldP = (Person) old;

		if (!this.personName.getFirstName().equals(oldP.personName.getFirstName()))
			this.getHistory().addAction(
					new Action("first name", this.personName.getFirstName(), oldP.personName.getFirstName()));

		if (!this.personName.getLastName().equals(oldP.personName.getLastName()))
			this.getHistory().addAction(
					new Action("last name", this.personName.getLastName(), oldP.personName.getLastName()));

		if (this.dateOfBirth != null && oldP.dateOfBirth != null && this.dateOfBirth.compareTo(oldP.dateOfBirth) != 0)
			this.getHistory().addAction(
					new Action("date of birth", this.dateOfBirth.toString(), oldP.dateOfBirth.toString()));

		if (this.birthPlace != null && !this.birthPlace.equals(oldP.birthPlace))
			this.getHistory().addAction(new Action("birth place", this.birthPlace, oldP.birthPlace));

		if (this.citizenship != null && !this.citizenship.equals(oldP.citizenship))
			this.getHistory().addAction(new Action("citizenship", this.citizenship, oldP.citizenship));

		if (this.modusOperandi != null && !this.modusOperandi.equals(oldP.modusOperandi))
			this.getHistory().addAction(new Action("modusOperandi", this.modusOperandi, oldP.modusOperandi));

		if (this.NCIC_fingerprintClassification != null && !this.NCIC_fingerprintClassification.equals(oldP.NCIC_fingerprintClassification))
			this.getHistory().addAction(
					new Action("NCIC fingerprint classification", this.NCIC_fingerprintClassification,
							oldP.NCIC_fingerprintClassification));

		if (this.physicalCharacteristic != null && !this.physicalCharacteristic.isEqual(oldP.physicalCharacteristic))
			this.getHistory().addAction(
					new Action("physical characteristic", this.physicalCharacteristic.toString(),
							oldP.physicalCharacteristic.toString()));

		if (this.threatAssessment != null && !this.threatAssessment.getThreatAssessmentLevel().equals(oldP.threatAssessment.getThreatAssessmentLevel()))
			this.getHistory().addAction(
					new Action("threat assessment", this.threatAssessment.getThreatAssessmentLevel(),
							oldP.threatAssessment.getThreatAssessmentLevel()));

		if (this.race != null && !this.race.getRace().equals(oldP.race.getRace()))
			this.getHistory().addAction(new Action("race", this.race.getRace(), oldP.race.getRace()));

		if (this.identifications.size() != oldP.identifications.size()) {
			StringBuilder newData = new StringBuilder();
			StringBuilder oldData = new StringBuilder();

			for (Identification id : this.identifications)
				newData.append(id.toString() + " ");

			for (Identification id : oldP.identifications)
				oldData.append(id.toString() + " ");

			this.getHistory().addAction(new Action("identifications", newData.toString(), oldData.toString()));
		} else {
			for (int i = 0; i < this.identifications.size(); i++) {
				if (!this.identifications.get(i).isEqual(oldP.identifications.get(i)))
					this.getHistory().addAction(
							new Action("identification", this.identifications.get(i).toString(), oldP.identifications
									.get(i).toString()));
			}
		}

		if (this.contacts.size() != oldP.contacts.size()) {
			StringBuilder newData = new StringBuilder();
			StringBuilder oldData = new StringBuilder();

			for (Contact id : this.contacts)
				newData.append(id.toString() + " ");

			for (Contact id : oldP.contacts)
				oldData.append(id.toString() + " ");

			this.getHistory().addAction(new Action("contacts", newData.toString(), oldData.toString()));
		} else {
			for (int i = 0; i < this.contacts.size(); i++) {
				if (!this.contacts.get(i).isEqual(oldP.contacts.get(i)))
					this.getHistory().addAction(
							new Action("contacts", this.contacts.get(i).toString(), oldP.contacts.get(i).toString()));
			}
		}

		if (this.aliasNamesOrMonikers.size() != oldP.aliasNamesOrMonikers.size()) {
			StringBuilder newData = new StringBuilder();
			StringBuilder oldData = new StringBuilder();

			for (AliasNameOrMoniker id : this.aliasNamesOrMonikers)
				newData.append(id.toString() + " ");

			for (AliasNameOrMoniker id : oldP.aliasNamesOrMonikers)
				oldData.append(id.toString() + " ");

			this.getHistory().addAction(new Action("aliasNamesOrMonikers", newData.toString(), oldData.toString()));
		} else {
			for (int i = 0; i < this.aliasNamesOrMonikers.size(); i++) {
				if (!this.aliasNamesOrMonikers.get(i).isEqual(oldP.aliasNamesOrMonikers.get(i)))
					this.getHistory().addAction(
							new Action("aliasNamesOrMonikers", this.aliasNamesOrMonikers.get(i).toString(),
									oldP.aliasNamesOrMonikers.get(i).toString()));
			}
		}

		if (this.scars_marks_tattoos.size() != oldP.scars_marks_tattoos.size()) {
			StringBuilder newData = new StringBuilder();
			StringBuilder oldData = new StringBuilder();

			for (ScarMarkTattoo id : this.scars_marks_tattoos)
				newData.append(id.toString() + " ");

			for (ScarMarkTattoo id : oldP.scars_marks_tattoos)
				oldData.append(id.toString() + " ");

			this.getHistory().addAction(new Action("scars_marks_tattoos", newData.toString(), oldData.toString()));
		} else {
			for (int i = 0; i < this.scars_marks_tattoos.size(); i++) {
				if (!this.scars_marks_tattoos.get(i).isEqual(oldP.scars_marks_tattoos.get(i)))
					this.getHistory().addAction(
							new Action("scars_marks_tattoos", this.scars_marks_tattoos.get(i).toString(),
									oldP.scars_marks_tattoos.get(i).toString()));
			}
		}

		if (this.mugShots.size() != oldP.mugShots.size()) {
			StringBuilder newData = new StringBuilder();
			StringBuilder oldData = new StringBuilder();

			for (MugShotImage id : this.mugShots)
				newData.append(id.toString() + " ");

			for (MugShotImage id : oldP.mugShots)
				oldData.append(id.toString() + " ");

			this.getHistory().addAction(new Action("mugShots", newData.toString(), oldData.toString()));
		} else {
			for (int i = 0; i < this.mugShots.size(); i++) {
				if (!this.mugShots.get(i).isEqual(oldP.mugShots.get(i)))
					this.getHistory().addAction(
							new Action("mugShots", this.mugShots.get(i).toString(), oldP.mugShots.get(i).toString()));
			}
		}

		if (this.fingerprintsImages.size() != oldP.fingerprintsImages.size()) {
			StringBuilder newData = new StringBuilder();
			StringBuilder oldData = new StringBuilder();

			for (FingerprintImage id : this.fingerprintsImages)
				newData.append(id.toString() + " ");

			for (FingerprintImage id : oldP.fingerprintsImages)
				oldData.append(id.toString() + " ");

			this.getHistory().addAction(new Action("fingerprintsImages", newData.toString(), oldData.toString()));
		} else {
			for (int i = 0; i < this.fingerprintsImages.size(); i++) {
				if (!this.fingerprintsImages.get(i).isEqual(oldP.fingerprintsImages.get(i)))
					this.getHistory().addAction(
							new Action("fingerprintsImages", this.fingerprintsImages.get(i).toString(),
									oldP.fingerprintsImages.get(i).toString()));
			}
		}

		if (this.photographs.size() != oldP.photographs.size()) {
			StringBuilder newData = new StringBuilder();
			StringBuilder oldData = new StringBuilder();

			for (PhotographicImage id : this.photographs)
				newData.append(id.toString() + " ");

			for (PhotographicImage id : oldP.photographs)
				oldData.append(id.toString() + " ");

			this.getHistory().addAction(new Action("photographs", newData.toString(), oldData.toString()));
		} else {
			for (int i = 0; i < this.photographs.size(); i++) {
				if (!this.photographs.get(i).isEqual(oldP.photographs.get(i)))
					this.getHistory().addAction(
							new Action("photographs", this.photographs.get(i).toString(), oldP.photographs.get(i)
									.toString()));
			}
		}

		if (this.conveyances.size() != oldP.conveyances.size()) {
			StringBuilder newData = new StringBuilder();
			StringBuilder oldData = new StringBuilder();

			for (Conveyance id : this.conveyances)
				newData.append("id:" + id.getId() + " ");

			for (Conveyance id : oldP.conveyances)
				oldData.append("id:" + id.getId() + " ");

			this.getHistory().addAction(new Action("conveyances", newData.toString(), oldData.toString()));
		} else {
			for (int i = 0; i < this.conveyances.size(); i++) {
				if (this.conveyances.get(i).getId().compareTo(oldP.conveyances.get(i).getId()) != 0)
					this.getHistory().addAction(
							new Action("conveyances", this.conveyances.get(i).getId().toString(), oldP.conveyances
									.get(i).getId().toString()));
			}
		}

	}



	@Override
	public String toString() {
		return this.personName.toString();
	}

}
