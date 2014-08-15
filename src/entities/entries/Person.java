package entities.entries;

import java.util.List;
import java.util.Map;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Transient;


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

	@Embedded
	private PhysicalCharacteristic physicalCharacteristic;

	@Embedded
	private Race race;

	@OneToMany(mappedBy = "personOfMugShots")
	private List<Image> mugShots;

	@OneToMany(mappedBy = "personOfFingerprints")
	private List<Image> fingerprintsImages;

	@ManyToMany(mappedBy = "personsOfPhotos")
	private List<Image> photographs;

	private List<String> aliasNamesOrMonikers;

	private List<String> scars_marks_tattoos;

	private String modusOperandi;

	private Map<String, String> identifications;

	private String NCIC_fingerprintClassification;

	@Transient
	private static String[] NCIC_fingerprintClassificationSuggestions = { "AA", "TT", "##50", "##", "PI", "PM", "PO",
			"CI", "CM", "CO", "dI", "dM", "dO", "XI", "XM", "XO", "XX", "SR" };


}
