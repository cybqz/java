package com.cyb.blog.controller;

import java.util.List;
import java.util.UUID;
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
import com.cyb.blog.entity.Tips;
import com.cyb.blog.service.UserServices;

@CrossOrigin
@Controller
@RequestMapping(value="/registerController")
public class RegisterController {
	
	@Autowired
	private UserServices userSerivces;
	
	@RequestMapping(value="/register")
	@ResponseBody
	public Tips register (User user, HttpSession session) {
		Tips tips = new Tips("false", false);
		if(user != null && StringUtils.isNotBlank(user.getUserName()) && StringUtils.isNotBlank(user.getPassword())) {
			//检查用户名是否存在
			UserExample example = new UserExample();
			Criteria criteria = example.createCriteria();
			criteria.andUserNameEqualTo(user.getUserName());
			List<User> users = userSerivces.selectByExample(example);
			if(users != null && users.size() > 0) {
				tips.setMsg("用户已存在！");
			}else {
				user.setId(UUID.randomUUID().toString());
				int count = userSerivces.insert(user);
				if(count > 0) {
					tips = new Tips("true", true);
				}
			}
		}
		return tips;
	}
}
