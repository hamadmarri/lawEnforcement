package security;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import security.mocks.UserSessionMock;
import ejbs.AbstractEjb;
import entities.Relatable;
import entities.police.InvestigativeGroup;


@ManagedBean(name = "controllerAccessManager")
@ViewScoped
public class AccessManager implements Serializable {

	private static final long serialVersionUID = 2775544037209151640L;

	@EJB
	AbstractEjb<Relatable> ejbRelatable;

	@EJB
	AbstractEjb<Authorizable> ejbAuthorizable;

	private String RelatableId;
	private String userId;



	@PostConstruct
	void init() {
		this.ejbRelatable.setEntityName("InvestigativeCase");
		this.userId = UserSessionMock.userId.toString();
	}



	public void manage() {
//		System.out.println("******* manage ******");
		Relatable r = this.ejbRelatable.getEntity(Long.parseLong(this.RelatableId));
		Authorizable a = this.ejbAuthorizable.getEntity(Long.parseLong(this.userId), "Authorizable");
		List<InvestigativeGroup> igs = a.getInvestigativeGroups();

		List<Permission> permissions = r.getPermissions();

		if (permissions == null || permissions.size() == 0) {
//			System.out.println("******** it is public ***********");
			return;
		} else {
//			System.out.println("******** it is not public ***********");
			for (Permission p : permissions) {
				System.out.println(p.getId());
				System.out.println(p.getOwner().getId());
				System.out.println(p.getAuthorizable().getId());
				System.out.println(p.isReadPermission());
				System.out.println(p.isWritePermission());

				if (p.getOwner().getId() == a.getId()) {
//					System.out.println("user is the owner of this relatable");
					return;
				} else if (a.getId() == p.getAuthorizable().getId()) {
//					System.out.println("user has access to this relatable");
					return;
				} else if (igs != null && igs.size() > 0) {
					for (InvestigativeGroup ig : igs) {
						if (ig.getId() == p.getAuthorizable().getId()) {
//							System.out.println("user in a group that has access to this relatable");
							return;
						}
					}
				}
			}
		}
//		System.out.println("Access denied !!!!");
		FacesContext fc = FacesContext.getCurrentInstance();
		try {
			fc.getExternalContext().redirect("/lawEnforcement");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}



	public String getRelatableId() {
		return RelatableId;
	}



	public void setRelatableId(String relatableId) {
		RelatableId = relatableId;
	}



	public String getUserId() {
		return userId;
	}



	public void setUserId(String userId) {
		this.userId = userId;
	}

}
