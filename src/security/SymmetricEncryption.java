package security;

import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;



public class SymmetricEncryption {

	String algorithm = "DESede";
	byte[] encodedKey = new BigInteger("2138230436436884091444436993669143287096059021235316628232", 16).toByteArray();
	Cipher c;
	SecretKey symKey;



	public SymmetricEncryption() throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException,
			BadPaddingException, IllegalBlockSizeException, InvalidKeySpecException {

		c = Cipher.getInstance(algorithm);

		DESedeKeySpec keySpec = new DESedeKeySpec(encodedKey);
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(algorithm);
		symKey = keyFactory.generateSecret(keySpec);

		// byte[] encryptionBytes = encryptF(text, symKey, c);
		// System.out.println("Encrypted: " + new String(encryptionBytes));
		// System.out.println("Decrypted: " + decryptF(encryptionBytes, symKey,
		// c));
	}



	/**
	 * encrypting text with DESede method 
	 * @param input - text to be incrypted
	 * @return encrypted text in byte[] array
	 * @throws InvalidKeyException
	 * @throws BadPaddingException
	 * @throws IllegalBlockSizeException
	 */
	public byte[] encrypt(String input) throws InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
		c.init(Cipher.ENCRYPT_MODE, symKey);
		byte[] inputBytes = input.getBytes();
		return c.doFinal(inputBytes);
	}



	public String decrypt(byte[] encryptionBytes) throws InvalidKeyException, BadPaddingException,
			IllegalBlockSizeException {

		c.init(Cipher.DECRYPT_MODE, symKey);
		return new String(c.doFinal(encryptionBytes));
	}

}
