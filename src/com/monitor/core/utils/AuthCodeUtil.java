/**
 * 
 */
package com.monitor.core.utils;

import org.apache.commons.lang.StringUtils;

/**
 * 
 * @author jack.li
 *
 */
public class AuthCodeUtil {

	public static final String encryptAuthCode(String sep, Object... args) {
		return SecretUtil.encrypt(StringUtils.join(args, sep));
	}
	
	public static final String[] decryptAuthCode(String authcode, String sep) {
		String temp = SecretUtil.decrypt(authcode);
		return temp.split(sep);
	}
}
