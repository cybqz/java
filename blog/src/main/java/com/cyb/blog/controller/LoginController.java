package com.cyb.blog.controller;

import java.util.List;
import javax.servlet.http.HttpSession;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.cyb.blog.domain.User;
import com.cyb.blog.domain.UserExample;
import com.cyb.blog.domain.UserExample.Criteria;
import com.cyb.blog.entity.Constant;
import com.cyb.blog.entity.Tips;
import com.cyb.blog.service.UserServices;

@CrossOrigin
@Controller
@RequestMapping(value="/loginController")
public class LoginController {
	
	@Autowired
	private UserServices userSerivces;
	
	@RequestMapping(value="/login")
	@ResponseBody
	public Tips login (User user, HttpSession session) {
		Tips tips = new Tips("false", false);
		if(user != null && StringUtils.isNotBlank(user.getUserName()) && StringUtils.isNotBlank(user.getPassword())) {
			UserExample example = new UserExample();
			Criteria criteria = example.createCriteria();
			criteria.andUserNameEqualTo(user.getUserName());
			criteria.andPasswordEqualTo(user.getPassword());
			List<User> users = userSerivces.selectByExample(example);
			if(users != null && users.size() > 0) {
				session.setAttribute(Constant.SESSION_NAME, users.get(0));
				tips = new Tips("登录成功！", true);
			}
		}
		return tips;
	}
	
	@RequestMapping(value="/logout")
	@ResponseBody
	public Tips logout (User user, HttpSession session) {
		Tips tips = new Tips("false", false);
		if(user != null && StringUtils.isNotBlank(user.getUserName()) && StringUtils.isNotBlank(user.getPassword())) {
			session.invalidate();
			tips = new Tips("退出成功！", true);
		}
		return tips;
	}
}
