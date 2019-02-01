package com.cyb.blog.controller;

import java.util.Date;
import java.util.UUID;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.cyb.blog.domain.Blog;
import com.cyb.blog.entity.Pagenation;
import com.cyb.blog.entity.Tips;
import com.cyb.blog.service.BlogServices;

@CrossOrigin
@Controller
@RequestMapping(value="/blogController")
public class BlogController {
	
	@Autowired
	private BlogServices blogServices;
	
	@RequestMapping(value="/publish")
	@ResponseBody
	public Tips publish (Blog blog) {
		Tips tips = new Tips("false", false);
		if(StringUtils.isBlank(blog.getTitle())) {
			tips.setMsg("空的标题！");
		}else if(StringUtils.isBlank(blog.getContaint())) {
			tips.setMsg("空的内容！");
		}else {
			blog.setAuthor("author");
			blog.setCreatetime(new Date());
			blog.setId(UUID.randomUUID().toString());
			int count = blogServices.insert(blog);
			if(count > 1) {
				tips = new Tips("true", true);
			}
		}
		return tips;
	}
	
	@RequestMapping(value="/getList")
	@ResponseBody
	public Pagenation getList (Blog blog, Pagenation pagenation) {
		pagenation = blogServices.getList(blog, pagenation);
		return pagenation;
	}
}
