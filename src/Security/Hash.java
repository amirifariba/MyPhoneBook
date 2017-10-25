package Security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash {

	String algorithm;
	String message;

	public String getAlgorithm() {
		return algorithm;
	}

	public void setAlgorithm(String algorithm) {
		this.algorithm = algorithm;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String hashWithMD5() {
		String hashed;
		if (this.message.length() == 0) {
			System.err.println("String to MD5 digest should be first and only parameter");
			return null;
		} else {
			StringBuffer sb = null;
			MessageDigest md;
			try {
				md = MessageDigest.getInstance(this.algorithm);
				md.update(this.message.getBytes());
				byte[] digest = md.digest();
				sb = new StringBuffer();
				for (byte b : digest) {
					sb.append(String.format("%02x", b & 0xff));
				}
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			hashed = sb.toString();
		}
		return hashed;
	}

	public Hash(String algorithm, String message) {
		this.algorithm = algorithm;
		this.message = message;
	}

}
