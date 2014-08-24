package entities.entries;

import javax.persistence.Embeddable;


@Embeddable
public class Race {

	private static String[] raceSuggestions = { "Canadian", "English", "French", "Scottish", "Irish", "German",
			"Italian", "Chinese", "North American Indian", "Ukrainian", "Dutch", "Polish", "East Indian", "Russian",
			"Welsh", "Filipino", "Norwegian", "Portuguese", "Métis", "British Isles", "not included elsewhere",
			"Swedish	", "Spanish	", "American", "Hungarian (Magyar)", "Jewish", "Greek", "Jamaican", "Danish",
			"Austrian", "Romanian", "Vietnamese", "Belgian	", "Lebanese", "Québécois", "South Korean", "Swiss",
			"Finnish", "Iranian	", "Croatian", "Sri Lankan", "Haitian", "Czech", "Acadian", "Japanese", "Icelandic",
			"Arab, n.i.e.", "Serbian	", "Pakistani", "Yugoslav, n.i.e.", "Black African, n.i.e.(*)", "West Indian",
			"Trinidadian/Tobagonian", "Inuit", "Guyanese", "Slovak", "South Asian", "Oceania origins",
			"Maghrebi origins", "Punjabi	", "Latin/Central/South", "American, n.i.e.", "Egyptian", "Armenian",
			"Mexican	", "Lithuanian", "Chilean", "Somali", "Czechoslovakian", "Maltese", "Scandinavian, n.i.e.",
			"Macedonian", "Slovenian", "Bulgarian", "Salvadoran", "Australian", "Afghan", "Turkish", "Barbadian",
			"Latvian	", "Estonian", "Syrian", "Moroccan", "European, n.i.e.", "Cambodian", "Iraqi", "South African",
			"Taiwanese", "Peruvian", "Laotian", "Ghanaian", "Colombian", "Ethiopian", "Bosnian", "Algerian",
			"Albanian", "Palestinian", "Newfoundlander", "Bangladeshi", "Flemish	", "Caribbean", "Fijian", "Khmer",
			"Brazilian", "Indonesian", "Guatemalan", "Nigerian", "Argentinian", "Central/South", "American Indian",
			"West Asian, n.i.e.", "East/Southeast", "Asian, n.i.e.", "Ecuadorian", "New Zealander", "Grenadian",
			"Hispanic", "Vincentian/Grenadinian", "Eritrean", "Bengali", "Assyrian", "Thai", "Dominican",
			"Slav (European)", "Sudanese", "Congolese, n.o.s.", "Cuban", "Nicaraguan", "Malaysian", "Israeli",
			"Venezuelan", "Berber", "Tunisian", "Byelorussian", "Tibetan", "Goan", "Uruguayan", "Jordanian",
			"Sinhalese", "Frisian", "Rwandan", "Honduran", "Kenyan", "Maya", "Burmese", "Gujarati", "St. Lucian",
			"Mauritian", "Basque", "Gypsy (Roma)", "Sicilian", "Antiguan", "Luxembourger", "East African",
			"Maghrebi, n.i.e.", "Ugandan	", "Panamanian", "Cameroonian", "Cypriot	", "Asian, n.o.s.", "Hawaiian",
			"Burundian", "Zairian", "Yoruba", "Tanzanian", "Ashanti", "Bermudan", "Bolivian", "Polynesian",
			"Kittitian/Nevisian", "Mongolian", "Senegalese", "Costa Rican", "Bahamian", "Azerbaijani", "Yemeni",
			"Singaporeans", "Carib", "Maori", "Afrikaner", "Zimbabwean", "Igbo", "Kosovar", "Libyan", "Nepali",
			"Ivoirean", "Guinean, n.o.s.", "Angolan", "Saudi Arabian", "Montenegrin", "Puerto Rican", "Pashtun",
			"Oromo", "Texan", "Seychellois", "Georgian", "Tatar", "Kuwaiti", "Malian", "Malagasy", "Paraguayan",
			"Togolese", "Akan", "Belizean", "Martinique", "Hmong", "Sierra Leonean", "Kashmiri", "Pacific Islander",
			"Cornish", "Manx" };

	private String race;



	public Race() {
		this.race = new String();
	}



	public Race(String race) {
		this.race = race;
	}



	public String getRace() {
		return race;
	}



	public void setRace(String race) {
		if (this.race == null)
			this.race = new String();
		this.race = race;
	}



	public static String[] getRaceSuggestions() {
		return raceSuggestions;
	}



	@Override
	public String toString() {
		return this.race;
	}

}
