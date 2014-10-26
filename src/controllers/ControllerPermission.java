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


//import entities.Relatable;

@ManagedBean(name = "controllerPermission")
@ViewScoped
public class ControllerPermission implements Serializable {

	private static final long serialVersionUID = -8332230579861778723L;

	@EJB
	AbstractEjb<Permission> ejbPermission;

	@EJB
	AbstractEjb<Relatable> ejbRelatable;

	@EJB
	AbstractEjb<Officer> ejbOfficer;

	@EJB
	AbstractEjb<Authorizable> ejbAuthorizable;

	protected String id;
	protected Permission permission = null;
	protected List<Permission> permissionsList = null;
	protected boolean newEntity = false;
	private String ownerId;
	private String relatableId;
	private String authorizableId;
	private String readPermission;
	private String writePermission;



	@PostConstruct
	public void init() {
		this.ejbPermission.setEntityName("Permission");
	}



	public String submit() {
		updatePermission();

		if (isNewEntity())
			ejbPermission.add(this.permission);
		else
			ejbPermission.save(this.permission);
		return "success";
	}



	private void updatePermission() {
		Long ownerId = Long.parseLong(this.ownerId);
		Long relatableId = Long.parseLong(this.relatableId);
		Long authorizableId = Long.parseLong(this.authorizableId);
		Officer owner;
		Relatable relatable;
		Authorizable authorizable;

		if (this.newEntity) {
			owner = this.ejbOfficer.getEntity(ownerId, "Officer");
			relatable = this.ejbRelatable.getEntity(relatableId, "Relatable");
			authorizable = this.ejbAuthorizable.getEntity(authorizableId, "Authorizable");
			
			this.permission.setOwner(owner);
			this.permission.setRelatable(relatable);
			this.permission.setAuthorizable(authorizable);
		}
		
		if (!this.newEntity && ownerId != this.permission.getOwner().getId()) {
			owner = this.ejbOfficer.getEntity(ownerId, "Officer");
			this.permission.setOwner(owner);
		}

		if (!this.newEntity && relatableId != this.permission.getRelatable().getId()) {
			relatable = this.ejbRelatable.getEntity(relatableId, "Relatable");
			this.permission.setRelatable(relatable);
		}

		if (!this.newEntity && authorizableId != this.permission.getAuthorizable().getId()) {
			authorizable = this.ejbAuthorizable.getEntity(authorizableId, "Authorizable");
			this.permission.setAuthorizable(authorizable);
		}

		if (readPermission.equals("T") || readPermission.equals("F")) {
			permission.setReadPermission(readPermission);
		}

		if (writePermission.equals("T") || writePermission.equals("F")) {
			permission.setWritePermission(writePermission);
		}
	}



	public void createNewPermission() {
		this.permission = new Permission();
		this.setNewEntity(true);
	}


	public Permission getPermission() {
		if (this.permission != null)
			return this.permission;

		if (this.id == null)
			return null;

		this.permission = ejbPermission.getEntity(Long.parseLong(this.id));
		this.ownerId = this.permission.getOwner().getId().toString();
		this.relatableId = this.permission.getRelatable().getId().toString();
		this.authorizableId = this.permission.getAuthorizable().getId().toString();
		this.readPermission = this.permission.getReadPermission();
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
