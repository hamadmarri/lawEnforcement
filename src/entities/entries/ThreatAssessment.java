package entities.entries;

import java.util.Arrays;
import java.util.List;

import javax.persistence.Embeddable;


@Embeddable
public class ThreatAssessment {

	private static String[] threatAssessmentSuggestions = { "low", "medium", "high" };
	private String threatAssessmentLevel;



	public ThreatAssessment() {
		super();
		this.threatAssessmentLevel = new String();
	}



	public ThreatAssessment(String threatAssessmentLevel) {
		super();
		this.threatAssessmentLevel = threatAssessmentLevel;
	}



	public String getThreatAssessmentLevel() {
		return threatAssessmentLevel;
	}



	public void setThreatAssessmentLevel(String threatAssessmentLevel) {
		this.threatAssessmentLevel = threatAssessmentLevel;
	}



	public static String[] getThreatAssessmentSuggestions() {
		return threatAssessmentSuggestions;
	}



	public List<String> getThreatAssessmentSuggestionsAsList() {
		return Arrays.asList(threatAssessmentSuggestions);
	}
}
