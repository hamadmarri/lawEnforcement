package controllers;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import security.Authorizable;
import security.Permission;
import ejbs.AbstractEjb;
import entities.Relatable;
import entities.police.Officer;


/**
 * @author hamadalmarri
 * 
 * @Pages
 *        - listPermissions.xhtml
 *        - viewPermission.xhtml
 *        - addPermission.xhtml
 *        - editPermission.xhtml
 * 
 * @Relative_Objects
 *                   - Officer who created this Permission
 *                   - Relatable that this Permission is for
 *                   - Authorizable (can be authorizable group or authorizable
 *                   user) who are this permission to
 */
@ManagedBean(name = "controllerPermission")
@ViewScoped
public class ControllerPermission implements Serializable {

	private static final long serialVersionUID = -8332230579861778723L;

	// EJB for Permission object
	@EJB
	AbstractEjb<Permission> ejbPermission;

	// EJB for Relatable object
	@EJB
	AbstractEjb<Relatable> ejbRelatable;

	// EJB for Officer object
	@EJB
	AbstractEjb<Officer> ejbOfficer;

	// EJB for Authorizable object
	@EJB
	AbstractEjb<Authorizable> ejbAuthorizable;

	// the id of a Permission object
	protected String id;

	// the Permission object
	protected Permission permission = null;

	// list of Permission objects
	protected List<Permission> permissionsList = null;

	// to indicate if the operation is to add
	// new Permission or not
	protected boolean newEntity = false;

	// officer id who owen this permission
	private String ownerId;

	// related id related to this permission
	private String relatableId;

	// authorizable id related to this permission
	private String authorizableId;

	// read permission can be either "T" or "F"
	private String readPermission;

	// write permission can be either "T" or "F"
	private String writePermission;



	/**
	 * will be called automatically right after the class is constructed since
	 * it has the PostConstruct annotation
	 */
	@PostConstruct
	public void init() {
		// at the beginning, set the entitiy name to be Permission
		this.ejbPermission.setEntityName("Permission");
	}



	/**
	 * to submit changes on the Permission object
	 * 
	 * @return "success" which is used for navigation engine to redirect to the
	 *         proper page
	 */
	public String submit() {

		// set permission
		updatePermission();

		// if new object it will add the object to DB,
		// otherwise, it will just update it in DB
		if (isNewEntity())
			ejbPermission.add(this.permission);
		else
			ejbPermission.save(this.permission);

		// return "success" for navigation engine
		return "success";
	}



	/**
	 * Updates permission object with new changes
	 */
	private void updatePermission() {

		// cast owenrId from string to long
		Long ownerId = Long.parseLong(this.ownerId);

		// cast relatableId from string to long
		Long relatableId = Long.parseLong(this.relatableId);

		// cast authorizableId from string to long
		Long authorizableId = Long.parseLong(this.authorizableId);

		Officer owner;
		Relatable relatable;
		Authorizable authorizable;

		// check if new permission, set owner, relatable, authorizable
		if (this.newEntity) {
			owner = this.ejbOfficer.getEntity(ownerId, "Officer");
			relatable = this.ejbRelatable.getEntity(relatableId, "Relatable");
			authorizable = this.ejbAuthorizable.getEntity(authorizableId, "Authorizable");

			this.permission.setOwner(owner);
			this.permission.setRelatable(relatable);
			this.permission.setAuthorizable(authorizable);
		}

		// if not new permission and owner id got changed, then update it
		if (!this.newEntity && ownerId != this.permission.getOwner().getId()) {
			owner = this.ejbOfficer.getEntity(ownerId, "Officer");
			this.permission.setOwner(owner);
		}

		// if not new permission and relatable id got changed, then update it
		if (!this.newEntity && relatableId != this.permission.getRelatable().getId()) {
			relatable = this.ejbRelatable.getEntity(relatableId, "Relatable");
			this.permission.setRelatable(relatable);
		}

		// if not new permission and authorizable id got changed, then update it
		if (!this.newEntity && authorizableId != this.permission.getAuthorizable().getId()) {
			authorizable = this.ejbAuthorizable.getEntity(authorizableId, "Authorizable");
			this.permission.setAuthorizable(authorizable);
		}

		// read permission must be either "T" or "F" to be updated
		if (readPermission.equals("T") || readPermission.equals("F")) {
			permission.setReadPermission(readPermission);
		}

		// write permission must be either "T" or "F" to be updated
		if (writePermission.equals("T") || writePermission.equals("F")) {
			permission.setWritePermission(writePermission);
		}
	}



	/**
	 * to initiate new object of Permission. This function will be called from
	 * addPermission.xhtml page at preRenderView phase
	 */
	public void createNewPermission() {
		this.permission = new Permission();
		this.setNewEntity(true);
	}



	/**
	 * it will load the object from DB if it is not loaded yet otherwise, it
	 * will return the Permission object
	 * 
	 * @return the Permission object
	 */
	public Permission getPermission() {

		// if the object was loaded already, just return it
		if (this.permission != null)
			return this.permission;

		// if the id is null do not try to load it from DB, just return null
		if (this.id == null)
			return null;

		// at this point object must be null but id is not,
		// so load it from DB
		this.permission = ejbPermission.getEntity(Long.parseLong(this.id));

		// get owner id
		this.ownerId = this.permission.getOwner().getId().toString();

		// get relatable id
		this.relatableId = this.permission.getRelatable().getId().toString();

		// get authorizable id
		this.authorizableId = this.permission.getAuthorizable().getId().toString();

		// get read permission
		this.readPermission = this.permission.getReadPermission();

		// get write permission
		this.writePermission = this.permission.getWritePermission();

		return this.permission;
	}



	public void setPermission(Permission permission) {
		this.permission = permission;
	}



	public List<Permission> getPermissionsList() {
		if (this.permissionsList == null)
			this.permissionsList = ejbPermission.getList();

		return permissionsList;
	}



	public void setPermissionsList(List<Permission> list) {
		this.permissionsList = list;
	}



	public boolean isNewEntity() {
		return newEntity;
	}



	public String getOwnerId() {
		return ownerId;
	}



	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}



	public String getRelatableId() {
		return relatableId;
	}



	public void setRelatableId(String relatableId) {
		this.relatableId = relatableId;
	}



	public String getAuthorizableId() {
		return authorizableId;
	}



	public void setAuthorizableId(String authorizableId) {
		this.authorizableId = authorizableId;
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



	public void setNewEntity(boolean newEntity) {
		this.newEntity = newEntity;
	}



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}

}
