package security.login_system;

import java.io.IOException;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import security.ErrorMessages;
import security.Password;
import ejbs.EjbUserGroup;
import entities.Users;


@ManagedBean(name = "registrationController")
@RequestScoped
public class RegistrationController {

	@EJB
	private EjbUserGroup userGroupEJB;

	@ManagedProperty(value = "#{userSessionController}")
	private UserSessionController userSessionController;

	@ManagedProperty(value = "#{usersGroupsController}")
	private UsersGroupsController usersGroupsController;

	private Users user = new Users();
	private Password password = new Password();
	private Password rePassword = new Password();
	private Password currentPassword = new Password();

	// to show errors in view
	private ErrorMessages errorMsgs = new ErrorMessages();



	// private String activationCode = new String("");
	// private boolean isValidCode = false;

	public Users getUser() {
		return user;
	}



	public void setUser(Users user) {
		this.user = user;
	}



	public String getPassword() {
		return password.getPassword();
	}



	public void setPassword(String password) {
		this.password.setPassword(password);
	}



	public String getRePassword() {
		return rePassword.getPassword();
	}



	public void setRePassword(String rePassword) {
		this.rePassword.setPassword(rePassword);
	}



	public String getCurrentPassword() {
		return currentPassword.getPassword();
	}



	public void setCurrentPassword(String currentPassword) {
		this.currentPassword.setPassword(currentPassword);
	}



	public UsersGroupsController getUsersGroupsController() {
		return usersGroupsController;
	}



	public void setUsersGroupsController(UsersGroupsController usersGroupsController) {
		this.usersGroupsController = usersGroupsController;
	}



	public UserSessionController getUserSessionController() {
		return userSessionController;
	}



	public void setUserSessionController(UserSessionController userSessionController) {
		this.userSessionController = userSessionController;
	}



	// public String getActivationCode() {
	// return activationCode;
	// }
	//
	//
	//
	// public void setActivationCode(String activationCode) {
	// this.activationCode = activationCode;
	// }
	//
	//
	//
	// public boolean isValidCode() {
	// return isValidCode;
	// }
	//
	//
	//
	// public void setValidCode(boolean isValidCode) {
	// this.isValidCode = isValidCode;
	// }

	/*
	 * isPasswordsMatched(): compare two password objects value return: true if
	 * matches false if not
	 */
	private boolean isPasswordsMatched() {
		if (!password.getPassword().equals(rePassword.getPassword())) {
			errorMsgs.add("sighUpForm:password", "passwords don't match.");
			return false;
		}
		return true;
	}



	private boolean isPasswordsMatched(String p1, String p2) {
		if (!p1.equals(p2)) {
			errorMsgs.add("sighUpForm:password", "passwords don't match.");
			return false;
		}
		return true;
	}



	public boolean isUsernameAlreadyExist() {
		return (userGroupEJB.findUser(user.getUsername()) != null);
	}



	public void signUp() throws IOException {
		// String validationCode;

		// check if username is already existed in the DB
		if (isUsernameAlreadyExist()) {
			// show error message
			new ErrorMessages().add("errorMsgSignup", "Username is already exist!");
			return;
		}

		if (isPasswordsMatched()) {
			// validationCode = new String(Long.toString((long) (Math.random() *
			// 10000000000L)));
			password.saltIt();
			user.setSalt(password.getSalt());
			user.setPassword(password.getPassword());
			// user.setValidationCode(validationCode);
			userGroupEJB.addUser(user, 2);

			// send activation code
			// EmailController ec = new EmailController();
			// ec.sendActivationCode(user.getUsername(), validationCode);

			// redirect to send user page
			FacesContext.getCurrentInstance().getExternalContext().redirect("/adala");
		}
	}



	// public void activate() {
	// user = userGroupEJB.findByValidationCode(activationCode);
	// if (user != null) {
	// userGroupEJB.validateUser(user);
	// isValidCode = true;
	//
	// // send confiermation email
	// EmailController ec = new EmailController();
	// ec.sendRegistrationConfirmationEmail(user.getUsername());
	// } else {
	// isValidCode = false;
	// }
	// }

	public void resetPassword() throws IOException {

		// get user entity
		Users user = userGroupEJB.findUser(userSessionController.getUserId());

		if (user == null) {
			new ErrorMessages().add("errorMsgSignup", "Invalid username or password!");
			return;
		}

		// set salt operation
		currentPassword.setPassword(user.getSalt() + currentPassword.getPassword());

		// check current password
		if (!isPasswordsMatched(user.getPassword(), currentPassword.getPassword()))
			return;

		// check if new pass and re-entered pass are the same
		if (isPasswordsMatched()) {

			// set the salt
			password.saltIt();
			user.setSalt(password.getSalt());

			// set new password
			user.setPassword(password.getPassword());

			// save user
			userGroupEJB.saveUser(user);

			// logout
			usersGroupsController.logout();

			// // redirect to send user page
			// FacesContext.getCurrentInstance().getExternalContext().redirect("/adala");
		}
	}

}
