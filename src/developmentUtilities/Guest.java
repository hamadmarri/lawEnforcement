package developmentUtilities;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Guest implements Serializable {
	private static final long serialVersionUID = 1L;

	// Persistent Fields:
	@Id
	@GeneratedValue
	Long id;
	private String name;
	private Date signingDate;
	private int age;



	// Constructors:
	public Guest() {
	}



	public Guest(String name) {
		this.name = name;
		this.signingDate = new Date(System.currentTimeMillis());
		this.age = 30;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public Date getSigningDate() {
		return signingDate;
	}



	public void setSigningDate(Date signingDate) {
		this.signingDate = signingDate;
	}



	public int getAge() {
		return age;
	}



	public void setAge(int age) {
		this.age = age;
	}



	// String Representation:
	@Override
	public String toString() {
		return name + " (signed on " + signingDate + ")";
	}
}
