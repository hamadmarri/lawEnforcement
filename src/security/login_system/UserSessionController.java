package security.login_system;

import java.io.IOException;
import java.io.Serializable;
import java.security.Principal;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import security.mocks.UserSessionMock;
import ejbs.EjbUserGroup;
import entities.Users;


@ManagedBean(name = "userSessionController")
@SessionScoped
public class UserSessionController implements Serializable { 

	private static final long serialVersionUID = -4999739921114335774L;

	@EJB
	private EjbUserGroup userGroupEJB;

	private Integer userId = null; 
	private Integer profileId = null;
	private String username = null;
	private boolean loggedIn = false;
	private boolean isValidated = false;

 

	/*
	 * TODO: should be removed when deploying
	 */
	@PostConstruct
	public void mocking() {
//		 profileId = (int) (long) UserSessionMock.userId;
//		 loggedIn = true;
//		 username = "hamad"; 
	}



	public int getUserId() {
		if (userId == null && isLoggedIn()) {
			Users user = (userGroupEJB.findUser(getUsername()));
			userId = new Integer(user.getUserId());
			
			if (user.getProfile_id() != null)
				profileId = new Integer(user.getProfile_id());
			
			isValidated = user.getValidated() > 0 ? true : false;
			user = null;
		}

		return userId;
	}



	public void setUserId(Integer userId) {
		this.userId = userId;
	}



	public Integer getProfileId() {
		if (profileId != null)
			return profileId;

		// just to initialize profile id
		getUserId();

		return profileId;
	}



	public void setProfileId(Integer profileId) {
		this.profileId = profileId;
	}



	public String getUsername() {

		if (username != null)
			return username;  

		try {
			// get request object
			HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
					.getRequest();

			// get userEntity principals
			Principal principal = request.getUserPrincipal();

			// get username and save into this session bean
			if (principal != null) {
				username = principal.getName();
				return username;
			}

		} catch (Exception e) {
			return "";
		}
		return "";
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public boolean isLoggedIn() {
		if (loggedIn == true)
			return true;

		// otherwise double check
		if (!getUsername().isEmpty())
			loggedIn = true;

		return loggedIn;
	}



	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}



	public void insistNotLogedIn() {
		if (isLoggedIn()) {
			try {
				FacesContext.getCurrentInstance().getExternalContext().redirect("/adala/");
			} catch (IOException e) {
				return;
			}
		}
	}



	public boolean isInvestigator() {
		if (isLoggedIn()) {
			Users user = (userGroupEJB.findUser(getUsername()));
			return user.getGroupsList().get(0).getGroupName().equals("investigator");
		}

		return false;
	}



	public boolean isSupervisor() {
		if (isLoggedIn()) {
			Users user = (userGroupEJB.findUser(getUsername()));
			return user.getGroupsList().get(0).getGroupName().equals("supervisor");
		}

		return false;
	}



	public boolean isValidated() {
		if (isLoggedIn() && isValidated)
			return true;

		return false;
	}

}
