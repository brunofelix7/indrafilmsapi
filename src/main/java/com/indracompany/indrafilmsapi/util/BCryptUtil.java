package com.indracompany.indrafilmsapi.util;

import at.favre.lib.crypto.bcrypt.BCrypt;

public abstract class BCryptUtil {

	public static String crypt(String message) {
		return BCrypt.withDefaults().hashToString(12, message.toCharArray());
	}
	
	public static boolean isValid(String message, String hash) {
		return BCrypt.verifyer().verify(message.toCharArray(), hash).verified;
	}
	
}
