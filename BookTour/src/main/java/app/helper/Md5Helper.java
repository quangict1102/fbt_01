package app.helper;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5Helper {
	public static String getCodeMd5(String password) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(password.getBytes());
			byte[] bytes = md.digest();
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < bytes.length; i++) {
				sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
			}
			return sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return password;
	}
	public static void main(String[] args) {
		System.out.println(getCodeMd5("12345678"));
	}

}
