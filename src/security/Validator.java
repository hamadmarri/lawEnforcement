package security;

import java.util.Calendar;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


@ManagedBean(name = "validator")
@RequestScoped
public class Validator {

	private String lettersOnly = new String("[a-zA-Z]*");
	private String lettersWithWhiteSpacesOnly = new String("[a-zA-Z ]*");
	private Date currentDate = new Date();
	private Date notMore150YearsDate;



	@PostConstruct
	public void init() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.YEAR, -150);
		notMore150YearsDate = cal.getTime();
	}



	public String getLettersOnly() {
		return lettersOnly;
	}



	public void setLettersOnly(String lettersOnly) {
		this.lettersOnly = lettersOnly;
	}



	public String getLettersWithWhiteSpacesOnly() {
		return lettersWithWhiteSpacesOnly;
	}



	public void setLettersWithWhiteSpacesOnly(String lettersWithWhiteSpacesOnly) {
		this.lettersWithWhiteSpacesOnly = lettersWithWhiteSpacesOnly;
	}



	public Date getCurrentDate() {
		return currentDate;
	}



	public void setCurrentDate(Date currentDate) {
		this.currentDate = currentDate;
	}



	public Date getNotMore150YearsDate() {
		return notMore150YearsDate;
	}



	public void setNotMore150YearsDate(Date notMore150YearsDate) {
		this.notMore150YearsDate = notMore150YearsDate;
	}

}
