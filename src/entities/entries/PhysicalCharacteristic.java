package entities.entries;

import javax.persistence.Embeddable;
import javax.persistence.Transient;


@Embeddable
public class PhysicalCharacteristic {

	@Transient
	private static String[] buildCharacteristicsSuggestions = { "Plump", "Stocky", "Overweight", "Fat", "Slim", "Trim",
			"Skinny", "Buff", "Well built" };

	@Transient
	private static String[] heightCharacteristicsSuggestions = { "Short", "Tall", "Petite", "Average height" };

	@Transient
	private static String[] complexionCharacteristicsSuggestions = { "Dark", "Light", "Fair", "Olive", "Pale", "Tan",
			"Pimply", "Freckles", "Spots", "Pimples" };

	@Transient
	private static String[] hairCharacteristicsSuggestions = { "Blond", "Fair", "Red", "Brown", "Black", "Grey",
			"White", "Long", "Short", "Curly", "Frizzy", "Straight", "Bald", "Receding" };

	private String buildCharacteristics;
	private String heightCharacteristics;
	private String complexionCharacteristics;
	private String hairCharacteristics;



	public static String[] getBuildCharacteristicsSuggestions() {
		return buildCharacteristicsSuggestions;
	}



	public static String[] getHeightCharacteristicsSuggestions() {
		return heightCharacteristicsSuggestions;
	}



	public static String[] getComplexionCharacteristicsSuggestions() {
		return complexionCharacteristicsSuggestions;
	}



	public static String[] getHairCharacteristicsSuggestions() {
		return hairCharacteristicsSuggestions;
	}



	public String getBuildCharacteristics() {
		return buildCharacteristics;
	}



	public void setBuildCharacteristics(String buildCharacteristics) {
		this.buildCharacteristics = buildCharacteristics;
	}



	public String getHeightCharacteristics() {
		return heightCharacteristics;
	}



	public void setHeightCharacteristics(String heightCharacteristics) {
		this.heightCharacteristics = heightCharacteristics;
	}



	public String getComplexionCharacteristics() {
		return complexionCharacteristics;
	}



	public void setComplexionCharacteristics(String complexionCharacteristics) {
		this.complexionCharacteristics = complexionCharacteristics;
	}



	public String getHairCharacteristics() {
		return hairCharacteristics;
	}



	public void setHairCharacteristics(String hairCharacteristics) {
		this.hairCharacteristics = hairCharacteristics;
	}

}
