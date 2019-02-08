package com.cyb.blog.utils;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import com.cyb.blog.domain.User;
import com.cyb.blog.entity.Tips;

public class Validate {
	
	public User isLogin() {
		User user = null;
		Subject subject = SecurityUtils.getSubject();
		if(subject.isAuthenticated()) {
			user = (User) subject.getPrincipal();
		}
		return user;
	}
	
	/**
	 * 验证登录状态、角色、权限
	 * @param tips
	 * @param role
	 * @param permission
	 * @return
	 */
	public User validateAll(Tips tips, String role, String permission) {
		Subject subject = SecurityUtils.getSubject();
		User user = isLogin();
		//登录验证
		if(user != null) {
			if(StringUtils.isNoneBlank(role) && !subject.hasRole(role)) {
				tips.setMsg("您没有相关角色支持操作！");
			}else if(StringUtils.isNoneBlank(permission) && !subject.isPermitted(permission)) {
				tips.setMsg("您没有相关权限支持操作！");
			}else {
				tips.setValidate(true);
			}
		}else {
			tips.setMsg("请登录后继续操作！");
		}
		return user;
	}
}
