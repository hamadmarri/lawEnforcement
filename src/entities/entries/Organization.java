package entities.entries;

import java.util.Arrays;
import java.util.List;

import javax.persistence.Entity;

import entities.entries.history.Action;


/**
 * Entity implementation class for Entity: Organization
 * 
 */
@Entity
public class Organization extends Entry {

	private static final long serialVersionUID = -2612388572963932408L;

	private static String[] organizationTypeSuggestions = { "gang", "business", "school", "shopping center", "other" };

	private String organizationType;

	private String name;



	public Organization() {
		super();
		this.type = "Organization";
		this.organizationType = new String();
		this.name = new String();
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



	public List<String> getOrganizationTypeSuggestionsAsList() {
		return Arrays.asList(organizationTypeSuggestions);
	}



	@Override
	public void logChanges(Object old) {
		Organization oldO = (Organization) old;

		if (!this.organizationType.equals(oldO.organizationType))
			this.getHistory().addAction(new Action("organizationType", this.organizationType, oldO.organizationType));

		if (!this.name.equals(oldO.name))
			this.getHistory().addAction(new Action("name", this.name, oldO.name));

	}



	@Override
	public String toString() {
		return this.name + " " + this.organizationType;
	}

}
