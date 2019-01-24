package com.cyb.blog.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.cyb.blog.domain.User;
import com.cyb.blog.domain.UserExample;
import com.cyb.blog.service.UserServices;

@Controller
@RequestMapping(value="/loginController")
public class LoginController {
	
	@Autowired
	private UserServices userSerivces;
	
	@RequestMapping(value="/login")
	@ResponseBody
	public Map<String, String> login (User user) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("validate", "false");
		if(user != null && StringUtils.isNotBlank(user.getName()) && StringUtils.isNotBlank(user.getPassword())) {
			UserExample example = new UserExample();
			List<User> users = userSerivces.selectByExample(example);
			if(users != null && users.size() > 0) {
				map.put("validate", "true");
			}
		}
		return map;
	}
}
