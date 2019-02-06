package com.cyb.blog.entity;

import java.util.HashSet;
import java.util.Set;

public class Constant {

	public static String SESSION_NAME = "SESSION_NAME";
	
	/***
	 * reading modals
	 */
	public static Set<String> READING_MODALS = new HashSet<String>();
	
	
	
	static{
		READING_MODALS.add("bk");
		READING_MODALS.add("me");
		READING_MODALS.add("mc");
	}
}
