package security.loginSystem;

import java.io.IOException;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import security.ErrorMessages;
import security.Password;
import ejbs.UserGroupEJB;
import entities.Users;


@ManagedBean(name = "registrationController")
@RequestScoped
public class RegistrationController {

	@EJB
	private UserGroupEJB userGroupEJB;

	private Users user = new Users();
	private Password password = new Password();
	private Password rePassword = new Password();

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

}
