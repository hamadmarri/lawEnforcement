package entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the V_USERS_GROUPS database table.
 * 
 */
@Entity
@Table(name = "V_USERS_GROUPS")
@NamedQueries({
		@NamedQuery(name = "VUsersGroup.findAll", query = "SELECT v FROM VUsersGroup v"),
		@NamedQuery(name = "VUsersGroup.findByUsername", query = "SELECT v FROM VUsersGroup v WHERE v.username = :username") })
public class VUsersGroup implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "group_name", length = 20)
	private String groupName;

	@Column(nullable = false, length = 128)
	private String password;

	@Id
	@Column(nullable = false, length = 100)
	private String username;



	public VUsersGroup() {
	}



	public String getGroupName() {
		return this.groupName;
	}



	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}



	public String getPassword() {
		return this.password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getUsername() {
		return this.username;
	}



	public void setUsername(String username) {
		this.username = username;
	}

}