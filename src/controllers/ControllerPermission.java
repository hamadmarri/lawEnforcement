package controllers;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import security.Permission;
import ejbs.AbstractEjb;
import entities.Relatable;


@ManagedBean(name = "controllerPermission")
@ViewScoped
public class ControllerPermission implements Serializable {

	private static final long serialVersionUID = -8332230579861778723L;

	@EJB
	AbstractEjb<Permission> ejbPermission;

	@EJB
	AbstractEjb<Relatable> ejbRelatable;
	
	protected String id;
	protected Permission permission = null;
	protected List<Permission> permissionsList = null;
	protected boolean newEntity = false;
//	private String newPermissionId;



	@PostConstruct
	public void init() {
		this.ejbPermission.setEntityName("Permission");
	}



	public String submit() {
		if (isNewEntity())
			ejbPermission.add(this.permission);
		else
			ejbPermission.save(this.permission);
		return "success";
	}



	public void createNewPermission() {
		this.permission = new Permission();
		this.setNewEntity(true);
	}



//	public void addPermissionForRelatable(Relatable ic) {
//		Permission inv = this.ejbPermission.getEntity(Long.parseLong(newPermissionId));
//
//		ic.addPermission(inv);
//		ic.setStatus("pending");
//		
//		this.ejbRelatable.save(ic);
//		this.newPermissionId = null;
//	}



	public Permission getPermission() {
		if (this.permission != null)
			return this.permission;

		if (this.id == null)
			return null;

		this.permission = ejbPermission.getEntity(Long.parseLong(this.id));

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



//	public String getNewPermissionId() {
//		return newPermissionId;
//	}
//
//
//
//	public void setNewPermissionId(String newPermissionId) {
//		this.newPermissionId = newPermissionId;
//	}



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
