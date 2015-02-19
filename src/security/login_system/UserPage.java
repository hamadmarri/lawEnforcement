package security.login_system;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import ejbs.EjbUserGroup;
import entities.Users;


@ManagedBean
@RequestScoped
public class UserPage {

	@EJB
	private EjbUserGroup userGroupEJB;

//	@Inject
//	@Username
//	private String username;
	private Users user = null;
//	private LineChartModel lineModel;
//	private boolean loggedIn = false;



	@PostConstruct
	void init() {
//		this.loggedIn = !this.username.isEmpty();
	}



	public void checkUserIfValidated() {
//		this.user = userGroupEJB.findUser(username);
	}



	public Users getUser() {
		return user;
	}



	public void setUser(Users user) {
		this.user = user;
	}



//	public String getUsername() {
//		return username;
//	}
//
//
//
//	public void setUsername(String username) {
//		this.username = username;
//	}



//	public boolean isLoggedIn() {
//		return this.loggedIn;
//	}



//	public void insistNotLogedIn() {
//		if (isLoggedIn()) {
//			try {
//				FacesContext.getCurrentInstance().getExternalContext().redirect("/adala/");
//			} catch (IOException e) {
//				return;
//			}
//		}
//	}



}
