package com.cyb.blog.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.cyb.blog.domain.User;
import com.cyb.blog.entity.Tips;
import com.cyb.blog.service.LoginServices;
import com.cyb.blog.utils.Validate;

@CrossOrigin
@Controller
@RequestMapping(value="/loginController")
public class LoginController {
	
	@Autowired
	private LoginServices loginServices;
	
	@RequestMapping(value="/login")
	@ResponseBody
	public Tips login (User user) {
		return loginServices.login(user);
	}
	
	@RequestMapping(value="/loginWithQQ")
	public void loginWithQQ (HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		loginServices.loginWithQQ(request, response, session);
	}
	
	@RequestMapping(value="/afterLoginWithQQ")
	public Tips afterLoginWithQQ (HttpServletRequest request) {
		return loginServices.afterLoginWithQQ(request);
	}
	
	@RequestMapping(value="/loginWithWebChat")
	public void loginWithWebChat () {
		loginServices.loginWithWebChat();
	}
	
	@RequestMapping(value="/logout")
	@ResponseBody
	public Tips logout (User user) {
		return loginServices.logout(user);
	}
	
	@RequestMapping(value="/getUser")
	@ResponseBody
	public User getUser () {
		Validate validate = new Validate();
		return validate.isLogin();
	}
}
