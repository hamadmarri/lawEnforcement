package entities.entries;

import javax.persistence.Entity;


/**
 * Entity implementation class for Entity: Organization
 * 
 */
@Entity
public class Organization extends Entry {

	private static final long serialVersionUID = -2612388572963932408L;

	private static String[] organizationTypeSuggestions = { "gang", "business", "school", "shopping center", };

	private String organizationType;

	private String name;



	public Organization() {
		super();
		this.type = "Organization";
	}



	public Organization(String name, String organizationType) {
		super();
		this.type = "Organization";
		this.name = name;
		this.organizationType = organizationType;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getOrganizationType() {
		return organizationType;
	}



	public void setOrganizationType(String organizationType) {
		this.organizationType = organizationType;
	}



	public static String[] getOrganizationTypeSuggestions() {
		return organizationTypeSuggestions;
	}



	@Override
	public String toString() {
		return this.name + " " + this.organizationType;
	}

}
