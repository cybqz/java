package com.cyb.blog.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.crypto.hash.SimpleHash;

public class MyStringUtils {

	public static String encryptionMD5(String str) {
        Object obj = new SimpleHash("MD5", str, null, 1024);
		return obj.toString();
	}
	
	public static String formatDate(String format, Date date) {
		
		if(StringUtils.isBlank(format)) {
			format = "yyyyMMDDHHmmss";
		}
		if(date == null) {
			date = new Date();
		}
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		return dateFormat.format(date);
	}
}
