package com.cyb.blog.entity;

import java.util.HashSet;
import java.util.Set;

public class Constant {

	public static String SESSION_NAME = "SESSION_NAME";
	
	public static String PROJECT_NAME = "blog";
	
	public static String ROLE_ADMIN = "admin";
	
	public static String PERMISSION_INTERSTING_ADD = "intersting_add";
	public static String PERMISSION_INTERSTING_REMOVE = "intersting_remove";
	public static String PERMISSION_INTERSTING_COMMENT = "intersting_comment";
	public static String PERMISSION_INTERSTING_FABULOUS = "intersting_fabulous";
	
	
	public static String MODAL_LYB = "lyb";
	public static String MODAL_LYB_INNER_REP = "lybinnerrep";
	public static String MODAL_DZ = "dz";
	public static String MODAL_DY = "dy";
	
	/***
	 * reading modals
	 */
	public static Set<String> READING_MODALS = new HashSet<String>();
	static{
		READING_MODALS.add("bk");
		READING_MODALS.add("me");
		READING_MODALS.add("mc");
	}
	
	/***
	 * modals
	 */
	public static Set<String> MODALS = new HashSet<String>();
	static{
		MODALS.add(MODAL_LYB);
		MODALS.add(MODAL_DZ);
		MODALS.add(MODAL_DY);
	}
}
