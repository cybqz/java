package com.cyb.blog.controller;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.cyb.blog.domain.User;
import com.cyb.blog.entity.Constant;
import com.cyb.blog.entity.Tips;

@CrossOrigin
@Controller
@RequestMapping(value="/loginController")
public class LoginController {
	
	@RequestMapping(value="/login")
	@ResponseBody
	public Tips login (User user) {
		Tips tips = new Tips("false", false);
		if(user != null && StringUtils.isNotBlank(user.getUserName()) && StringUtils.isNotBlank(user.getPassword())) {
			Subject subject = SecurityUtils.getSubject();
	        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(user.getUserName(),user.getPassword());
	        try {
	            subject.login(usernamePasswordToken);
	            subject.getSession(true).setAttribute(Constant.SESSION_NAME, user);
	            tips = new Tips("登录成功！", true);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		}
		return tips;
	}
	
	@RequestMapping(value="/logout")
	@ResponseBody
	public Tips logout (User user) {
		Tips tips = new Tips("false", false);
		if(user != null && StringUtils.isNotBlank(user.getUserName()) && StringUtils.isNotBlank(user.getPassword())) {
			SecurityUtils.getSubject().logout();
			tips = new Tips("退出成功！", true);
		}
		return tips;
	}
}
