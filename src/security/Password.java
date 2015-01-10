package security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Password: is a class that holds and encrypt passwords
 */
public class Password {

	private String password = null;
	private String salt = null;



	public Password() {
	}



	public Password(String password) {
		setPassword(password);
	}



	/*
	 * hash function hashes the password and return the hashed password as
	 * string
	 */
	final public String hash(String password) {

		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("SHA-512");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		md.update(password.getBytes());

		byte byteData[] = md.digest();

		// convert the byte to hex format method 1
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < byteData.length; i++) {
			sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
		}
		return sb.toString();
	}



	final public String getPassword() {
		return this.password;
	}



	/*
	 * when setting password it directly encrypt it
	 */
	final public void setPassword(String notHashedPassword) {
		this.password = hash(notHashedPassword);
	}



	final public void saltIt() {
		this.salt = generateRandomSalt();
		this.password = hash(this.salt + this.password);
	}



	private String generateRandomSalt() {
		return hash(Long.toString((long) (Math.random() * 10000000000L)) + "Ju$t_F0R_Fun! :D");
	}



	public String getSalt() {
		return this.salt;
	}

}
