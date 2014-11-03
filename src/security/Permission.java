package security;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import entities.Relatable;
import entities.entries.history.Action;
import entities.entries.history.Changeable;
import entities.police.Officer;


@Entity
@NamedQueries({ @NamedQuery(name = "Permission.findAll", query = "select p from Permission p"),
		@NamedQuery(name = "Permission.findById", query = "select p from Permission p WHERE p.id = :id") })
public class Permission extends Changeable implements Serializable {

	private static final long serialVersionUID = 4848790233272623774L;

	// @Id
	// @GeneratedValue
	// Long id;

	@ManyToOne(cascade = CascadeType.MERGE)
	private Officer owner;

	@ManyToOne(cascade = CascadeType.MERGE)
	private Relatable relatable;

	@ManyToOne(cascade = CascadeType.MERGE)
	private Authorizable authorizable;

	private String readPermission;

	private String writePermission;



	public Permission() {
		super();
	}



	// public Long getId() {
	// return id;
	// }

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
		setReadPermissionBoolean(read);
		setWritePermissionBoolean(write);
	}



	public boolean isReadPermission() {
		if (this.readPermission.equals("T"))
			return true;

		return false;
	}



	public void setReadPermissionBoolean(boolean read) {
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



	public void setWritePermissionBoolean(boolean write) {
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



	@Override
	public void logChanges(Object old) {

		Permission oldPerm = (Permission) old;

		if (!this.readPermission.equals(oldPerm.readPermission))
			this.getHistory().addAction(new Action("readPermission", this.readPermission, oldPerm.readPermission));

		if (!this.writePermission.equals(oldPerm.writePermission))
			this.getHistory().addAction(new Action("writePermission", this.writePermission, oldPerm.writePermission));

		if (this.owner != null & oldPerm.owner != null && this.owner.getId().compareTo(oldPerm.owner.getId()) != 0)
			this.getHistory().addAction(
					new Action("owner id", this.owner.getId().toString(), oldPerm.owner.getId().toString()));

		if (this.relatable != null & oldPerm.relatable != null
				&& this.relatable.getId().compareTo(oldPerm.relatable.getId()) != 0)
			this.getHistory()
					.addAction(
							new Action("relatable id", this.relatable.getId().toString(), oldPerm.relatable.getId()
									.toString()));

		if (this.authorizable != null & oldPerm.authorizable != null
				&& this.authorizable.getId().compareTo(oldPerm.authorizable.getId()) != 0)
			this.getHistory().addAction(
					new Action("authorizable id", this.authorizable.getId().toString(), oldPerm.authorizable.getId()
							.toString()));
	}

}
