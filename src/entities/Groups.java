package entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


/**
 * The persistent class for the Groups database table.
 * 
 */
@Entity
@Table(name = "Groups")
@XmlRootElement
@NamedQuery(name = "Groups.findAll", query = "SELECT g FROM Groups g")
public class Groups implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	// @Column(name = "group_id", nullable = false)
	private int group_id;

	@Column(name = "group_name", length = 20)
	private String groupName;

	@ManyToMany(mappedBy = "groupsList")
	private List<Users> usersList;



	public Groups() {
	}



	public Groups(Groups g) {
		super();
		this.groupName = g.groupName;
		this.usersList = g.usersList;
	}



	public int getGroupId() {
		return this.group_id;
	}



	public void setGroupId(int groupId) {
		this.group_id = groupId;
	}



	public String getGroupName() {
		return this.groupName;
	}



	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}



	@XmlTransient
	public List<Users> getUsersList() {
		return usersList;
	}



	public void setUsersList(List<Users> usersList) {
		this.usersList = usersList;
	}

}