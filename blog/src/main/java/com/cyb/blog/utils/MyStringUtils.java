package com.cyb.blog.utils;

import org.apache.shiro.crypto.hash.SimpleHash;

public class MyStringUtils {

	public static String encryptionMD5(String str) {
        Object obj = new SimpleHash("MD5", str, null, 1024);
		return obj.toString();
	}
}
