package entities.entries;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import entities.entries.images.FingerprintImage;
import entities.entries.images.MugShotImage;
import entities.entries.images.PhotographicImage;


/**
 * Entity implementation class for Entity: Person
 * 
 */
@Entity
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

	private String name;

	@Temporal(TemporalType.DATE)
	private Calendar dateOfBirth;

	private String birthPlace;
	private String Gender;
	private String citizenship;
	private Map<String, String> identifications;
	private List<String> aliasNamesOrMonikers;
	private List<String> scars_marks_tattoos;
	private String modusOperandi;
	private String NCIC_fingerprintClassification;

	@Embedded
	private PhysicalCharacteristic physicalCharacteristic;

	@Embedded
	private Race race;

	@OneToMany(mappedBy = "person")
	private List<MugShotImage> mugShots;

	@OneToMany(mappedBy = "person")
	private List<FingerprintImage> fingerprintsImages;

	@ManyToMany(mappedBy = "persons")
	private List<PhotographicImage> photographs;

	private static String[] NCIC_fingerprintClassificationSuggestions = { "AA", "TT", "##50", "##", "PI", "PM", "PO",
			"CI", "CM", "CO", "dI", "dM", "dO", "XI", "XM", "XO", "XX", "SR" };



	public Person() {
		super();
	}



	public Person(String name, Calendar dateOfBirth, String birthPlace, String gender, String citizenship,
			String modusOperandi, String nCIC_fingerprintClassification) {
		super();
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.birthPlace = birthPlace;
		Gender = gender;
		this.citizenship = citizenship;
		this.modusOperandi = modusOperandi;
		NCIC_fingerprintClassification = nCIC_fingerprintClassification;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public Calendar getDateOfBirth() {
		return dateOfBirth;
	}



	public void setDateOfBirth(Calendar dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}



	public String getBirthPlace() {
		return birthPlace;
	}



	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}



	public String getGender() {
		return Gender;
	}



	public void setGender(String gender) {
		Gender = gender;
	}



	public String getCitizenship() {
		return citizenship;
	}



	public void setCitizenship(String citizenship) {
		this.citizenship = citizenship;
	}



	public Map<String, String> getIdentifications() {
		return identifications;
	}



	public void setIdentifications(Map<String, String> identifications) {
		this.identifications = identifications;
	}



	public List<String> getAliasNamesOrMonikers() {
		return aliasNamesOrMonikers;
	}



	public void setAliasNamesOrMonikers(List<String> aliasNamesOrMonikers) {
		this.aliasNamesOrMonikers = aliasNamesOrMonikers;
	}



	public List<String> getScars_marks_tattoos() {
		return scars_marks_tattoos;
	}



	public void setScars_marks_tattoos(List<String> scars_marks_tattoos) {
		this.scars_marks_tattoos = scars_marks_tattoos;
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
		return physicalCharacteristic;
	}



	public void setPhysicalCharacteristic(PhysicalCharacteristic physicalCharacteristic) {
		this.physicalCharacteristic = physicalCharacteristic;
	}



	public Race getRace() {
		return race;
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



	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
