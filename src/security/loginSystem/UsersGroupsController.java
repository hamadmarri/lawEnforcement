package security.loginSystem;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import security.ErrorMessages;
import security.Password;
import ejbs.UserGroupEJB;
import entities.Users;
import entities.VUsersGroup;


@Named
@RequestScoped
public class UsersGroupsController {

	@EJB
	private UserGroupEJB userGroupEJB;
	private String username = new String("");
	private String password = new String("");

	@Inject
	private UserPage userPage;



	public List<VUsersGroup> getAll() {
		return userGroupEJB.findAll();
	}



	public List<Users> getAllUsers() {
		return userGroupEJB.findAllUsers();
	}



	public void deleteUser(int userId) {
		userGroupEJB.deleteUser(userId);
	}



	public void sendEmail(String email) throws IOException {
		userGroupEJB.setEmailTo(email);
		FacesContext fc = FacesContext.getCurrentInstance();
		fc.getExternalContext().redirect("/ENSE353Project/admin/email.xhtml");
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public void CookieLogin() throws InvalidKeyException {

		if (userPage.isLoggedIn())
			return;

		System.out.println("******* not logged in *******");

		String userId, cookieValue, salt, hashedPasswd;

		try {
			cookieValue = (new CookieManager()).getCookie(FacesContext.getCurrentInstance(), "style");
		} catch (NullPointerException e) {
			return;
		}

		userId = cookieValue.substring(0, cookieValue.indexOf(":"));

		Users user = userGroupEJB.findUser(Integer.parseInt(userId));
		if (user == null)
			return;

		salt = user.getSalt();
		hashedPasswd = cookieValue.substring(cookieValue.indexOf(":") + 1, cookieValue.indexOf(":") + 1 + 128);

		setUsername(user.getUsername());
		setPassword("");

		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		HttpServletRequest request = (HttpServletRequest) ec.getRequest();

		try {
			request.login(user.getUsername(), salt + hashedPasswd);
			ec.redirect(((HttpServletRequest) ec.getRequest()).getHeader("Referer"));
		} catch (ServletException | IOException e) {
			return;
		}
	}



	public void login() throws IOException {

		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
				.getRequest();

		Users user = userGroupEJB.findUser(username);

		if (user == null) {
			new ErrorMessages().add("errorMsgLogin", "Invalid username or password!");
			return;
		}

		Password hashedPass = new Password(password);

		try {

			System.out.println("********* before login **********");
			request.login(username, user.getSalt() + hashedPass.getPassword());

			// set cookie
			CookieManager cm = new CookieManager();
			cm.setCookie((HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse(),
					"style", user.getUserId() + ":" + hashedPass.getPassword());

			// redirect page
			FacesContext.getCurrentInstance().getExternalContext().redirect("/ENSE353Project/");

		} catch (ServletException e) {
			new ErrorMessages().add("errorMsgLogin", "Invalid username or password!");
		}
	}



	public void logout() throws IOException {
		FacesContext fc = FacesContext.getCurrentInstance();
		fc.getExternalContext().invalidateSession();

		// remove cookie
		CookieManager cm = new CookieManager();
		cm.removeCookie((HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse(),
				"style", "");

		fc.getExternalContext().redirect("/ENSE353Project/index.xhtml?faces-redirect=true");
	}

}
