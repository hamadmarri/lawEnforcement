package entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


/**
 * The persistent class for the Users database table.
 * 
 */
@Entity
@Table(name = "Users")
@XmlRootElement
@NamedQueries({
		@NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u"),
		@NamedQuery(name = "Users.findAllUsers", query = "SELECT u FROM Users u"),
		@NamedQuery(name = "Users.findByUsername", query = "SELECT u FROM Users u WHERE u.username = :username") })
public class Users implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name = "user_id", unique = true, nullable = false)
	private int user_id;

	@Column(nullable = false, length = 128)
	private String password;

	@Column(nullable = false, length = 128)
	private String salt;

	@Column(nullable = false, length = 100)
	private String username;

	@Column(nullable = false, length = 100)
	private short validated;

//	@Column(nullable = false, length = 10)
//	private String validationCode;

	@Column(insertable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date signupDate;

	@ManyToMany
	@JoinTable(name = "User_Groups", joinColumns = { @JoinColumn(name = "user_id", referencedColumnName = "user_id") }, inverseJoinColumns = { @JoinColumn(name = "group_id", referencedColumnName = "group_id") })
	private List<Groups> groupsList;



	public Users() {
	}



	public Users(Users u) {
		this.password = u.password;
		this.salt = u.salt;
		this.username = u.username;
		this.validated = u.validated;
//		this.validationCode = u.validationCode;
		this.signupDate = u.signupDate;
		this.groupsList = u.groupsList;
	}



	public Users(int userId) {
		this.user_id = userId;
	}



	public int getUserId() {
		return this.user_id;
	}



	public void setUserId(int userId) {
		this.user_id = userId;
	}



	public String getPassword() {
		return this.password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getSalt() {
		return salt;
	}



	public void setSalt(String salt) {
		this.salt = salt;
	}



	public String getUsername() {
		return this.username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public short getValidated() {
		return validated;
	}



	public void setValidated(short validated) {
		this.validated = validated;
	}



	// public String getValidationCode() {
	// return validationCode;
	// }
	//
	//
	//
	// public void setValidationCode(String validationCode) {
	// this.validationCode = validationCode;
	// }



	public Date getSignupDate() {
		return signupDate;
	}



	@XmlTransient
	public List<Groups> getGroupsList() {
		return groupsList;
	}



	public void setGroupsList(List<Groups> groupsList) {
		this.groupsList = groupsList;
	}

}