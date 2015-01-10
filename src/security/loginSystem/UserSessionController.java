package security.loginSystem;

import java.io.Serializable;
import java.security.Principal;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

import security.loginSystem.qualifiers.UserId;
import security.loginSystem.qualifiers.Username;
import ejbs.UserGroupEJB;


@Named
@SessionScoped
public class UserSessionController implements Serializable {

	@EJB
	private UserGroupEJB userGroupEJB;

	private static final long serialVersionUID = -4999739921114335774L;



	@Produces
	@Username
	public String getUsername() {

		try {
			// get request object
			HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
					.getRequest();

			// get userEntity principals
			Principal principal = request.getUserPrincipal();

			// get username and save into this session bean
			if (principal != null)
				return principal.getName();
		} catch (Exception e) {
			return "";
		}
		return "";
	}



	@Produces
	@UserId
	public int getUserId() {
		return (userGroupEJB.findUser(getUsername())).getUserId();
	}

}
