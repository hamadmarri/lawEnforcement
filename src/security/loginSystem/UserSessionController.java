package security.loginSystem;

import java.io.IOException;
import java.io.Serializable;
import java.security.Principal;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import ejbs.UserGroupEJB;
import entities.Users;


@ManagedBean(name = "userSessionController")
@SessionScoped
public class UserSessionController implements Serializable {

	private static final long serialVersionUID = -4999739921114335774L;

	@EJB
	private UserGroupEJB userGroupEJB;

	private Integer userId = null;
	private Integer profileId = null;
	private String username = null;
	private boolean loggedIn = false;



	// @Produces
	// @UserId
	public int getUserId() {
		if (userId == null && isLoggedIn()) {
			Users user = (userGroupEJB.findUser(getUsername()));
			userId = new Integer(user.getUserId());
			profileId = new Integer(user.getProfile_id());
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



	// @Produces
	// @Username
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

}
