package com.cyb.blog.utils;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import com.cyb.blog.domain.User;
import com.cyb.blog.entity.Constant;
import com.cyb.blog.entity.Tips;

public class Validate {

	/**
	 * 验证登录状态、角色、权限
	 * @param tips
	 * @param role
	 * @param permission
	 * @return
	 */
	public User validateAll(Tips tips, String role, String permission) {
		Subject subject = SecurityUtils.getSubject();
		User user = null;
		//登录验证
		if(subject.isAuthenticated()) {
			if(StringUtils.isNoneBlank(role) && !subject.hasRole(role)) {
				tips.setMsg("您没有相关角色支持操作！");
			}else if(StringUtils.isNoneBlank(permission) && !subject.isPermitted(permission)) {
				tips.setMsg("您没有相关权限支持操作！");
			}else {
				tips = new Tips("true", true);
				user = (User) subject.getSession().getAttribute(Constant.SESSION_NAME);
			}
		}else {
			tips.setMsg("请登录后继续操作！");
		}
		return user;
	}
}
