package security;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import entities.Relatable;
import entities.police.Officer;


@Entity
@NamedQueries({ @NamedQuery(name = "Permission.findAll", query = "select p from Permission p"),
		@NamedQuery(name = "Permission.findById", query = "select p from Permission p WHERE p.id = :id") })
public class Permission implements Serializable {

	private static final long serialVersionUID = 4848790233272623774L;

	@Id
	@GeneratedValue
	Long id;

	@ManyToOne(cascade = CascadeType.MERGE)
	private Officer owner;

	@ManyToOne(cascade = CascadeType.MERGE)
	private Relatable relatable;

	@ManyToOne(cascade = CascadeType.MERGE)
	private Authorizable authorizable;

	// @Column(columnDefinition = "INT(1)")
	private String readPermission;

	// @Column(columnDefinition = "INT(1)")
	private String writePermission;



	public Permission() {
		super();
	}



	public Long getId() {
		return id;
	}



	public Officer getOwner() {
		return owner;
	}



	public void setOwner(Officer owner) {
		this.owner = owner;
	}



	public Relatable getRelatable() {
		return relatable;
	}



	public void setRelatable(Relatable relatable) {
		this.relatable = relatable;
	}



	public Authorizable getAuthorizable() {
		return authorizable;
	}



	public void setAuthorizable(Authorizable authorizable) {
		this.authorizable = authorizable;
	}



	public void setPermissions(boolean read, boolean write) {
		setReadPermission(read);
		setWritePermission(write);
	}



	public boolean isReadPermission() {
		if (this.readPermission.equals("T"))
			return true;

		return false;
	}



	public void setReadPermission(boolean read) {
		if (read)
			this.readPermission = "T";
		else
			this.readPermission = "F";
	}



	public boolean isWritePermission() {
		if (this.writePermission.equals("T"))
			return true;

		return false;
	}



	public void setWritePermission(boolean write) {
		if (write)
			this.writePermission = "T";
		else
			this.writePermission = "F";
	}



	public String getReadPermission() {
		return readPermission;
	}



	public void setReadPermission(String readPermission) {
		this.readPermission = readPermission;
	}



	public String getWritePermission() {
		return writePermission;
	}



	public void setWritePermission(String writePermission) {
		this.writePermission = writePermission;
	}

}
