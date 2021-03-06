package entities.entries;

import java.util.Arrays;
import java.util.List;

import javax.persistence.Embeddable;


@Embeddable
public class PhysicalCharacteristic {

	private static String[] buildCharacteristicsSuggestions = { "Plump", "Stocky", "Overweight", "Fat", "Slim", "Trim",
			"Skinny", "Buff", "Well built" };

	private static String[] heightCharacteristicsSuggestions = { "Short", "Tall", "Petite", "Average height" };

	private static String[] complexionCharacteristicsSuggestions = { "Dark", "Light", "Fair", "Olive", "Pale", "Tan",
			"Pimply", "Freckles", "Spots", "Pimples" };

	private static String[] hairCharacteristicsSuggestions = { "Blond", "Fair", "Red", "Brown", "Black", "Grey",
			"White", "Long", "Short", "Curly", "Frizzy", "Straight", "Bald", "Receding" };

	private String buildCharacteristics;
	private String heightCharacteristics;
	private String complexionCharacteristics;
	private String hairCharacteristics;



	public PhysicalCharacteristic() {
		this.buildCharacteristics = new String();
		this.heightCharacteristics = new String();
		this.complexionCharacteristics = new String();
		this.hairCharacteristics = new String();
	}



	public PhysicalCharacteristic(String buildCharacteristics, String heightCharacteristics,
			String complexionCharacteristics, String hairCharacteristics) {
		this.buildCharacteristics = buildCharacteristics;
		this.heightCharacteristics = heightCharacteristics;
		this.complexionCharacteristics = complexionCharacteristics;
		this.hairCharacteristics = hairCharacteristics;
	}



	public List<String> getBuildCharacteristicsSuggestions() {
		return Arrays.asList(buildCharacteristicsSuggestions);
	}



	public List<String> getHeightCharacteristicsSuggestions() {
		return Arrays.asList(heightCharacteristicsSuggestions);
	}



	public List<String> getComplexionCharacteristicsSuggestions() {
		return Arrays.asList(complexionCharacteristicsSuggestions);
	}



	public List<String> getHairCharacteristicsSuggestions() {
		return Arrays.asList(hairCharacteristicsSuggestions);
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



	public boolean isEqual(PhysicalCharacteristic another) {
		return (this.buildCharacteristics.equals(another.buildCharacteristics)
				&& this.complexionCharacteristics.equals(another.complexionCharacteristics)
				&& this.hairCharacteristics.equals(another.hairCharacteristics) && this.heightCharacteristics
					.equals(another.heightCharacteristics));
	}



	@Override
	public String toString() {
		return this.buildCharacteristics + " " + this.complexionCharacteristics + " " + this.heightCharacteristics
				+ " " + this.hairCharacteristics;
	}

}
