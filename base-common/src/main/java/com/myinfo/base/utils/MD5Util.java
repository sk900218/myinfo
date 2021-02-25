package com.myinfo.base.utils;

import java.security.MessageDigest;

public class MD5Util {

	public final static String encrypt(String value) {
		String result = "";
		if (value != null && !"".equals(value)) {
			try {
				MessageDigest md5 = MessageDigest.getInstance("MD5");
				byte[] bytes = md5.digest(value.getBytes());
				StringBuffer hex = new StringBuffer();
				for (byte b : bytes) {
					int inner = ((int)b) & 0xff;
					if (inner < 16) hex.append("0");
					hex.append(Integer.toHexString(inner));
				}
				result = hex.toString();
			} catch (Exception e) {}
		}
		return result;
	}
	
}
