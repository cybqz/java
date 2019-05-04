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
import com.cyb.blog.domain.Fabulous;
import com.cyb.blog.domain.FabulousExample;
import com.cyb.blog.domain.User;
import com.cyb.blog.domain.FabulousExample.Criteria;
import com.cyb.blog.entity.Constant;
import com.cyb.blog.entity.Pagenation;
import com.cyb.blog.entity.Tips;
import com.cyb.blog.service.BlogServices;
import com.cyb.blog.service.FabulousServices;
import com.cyb.blog.utils.Validate;

@CrossOrigin
@Controller
@RequestMapping(value="/blogController")
public class BlogController {
	
	@Autowired
	private BlogServices blogServices;
	@Autowired
	private FabulousServices fabulousServices;
	
	@RequestMapping(value="/publish")
	@ResponseBody
	public Tips publish (Blog blog) {
		Validate validate = new Validate();
		Tips tips = new Tips("false", false);
		User user = validate.validateAll(tips, Constant.ROLE_ADMIN, Constant.PERMISSION_INTERSTING_ADD);
		if(tips.isValidate()) {
			tips.setValidate(false);
			if(StringUtils.isBlank(blog.getTitle())) {
				tips.setMsg("空的标题！");
			}else if(StringUtils.isBlank(blog.getContaint())) {
				tips.setMsg("空的内容！");
			}else {
				blog.setAuthor(user.getId());
				int count = blogServices.insert(blog);
				if(count > 0) {
					tips = new Tips("true", true);
				}
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
	
	@RequestMapping(value="/doFablous")
	@ResponseBody
	public Tips doFablous (Blog blog) {
		Validate validate = new Validate();
		Tips tips = new Tips("false", false);
		User user = validate.validateAll(tips, null, null);
		if(tips.isValidate()) {
			tips.setValidate(false);
			FabulousExample fabulousExample = new FabulousExample();
			Criteria criteria = fabulousExample.createCriteria();
			criteria.andBlogIdEqualTo(blog.getId());
			criteria.andUserIdEqualTo(user.getId());
			long count = fabulousServices.countByExample(fabulousExample);
			if(count > 0) {
				int delete = fabulousServices.deleteByExample(fabulousExample);
				if(delete > 0) {
					tips = new Tips("取消点赞成功！", true);
				}
			}else {
				Fabulous fabulous = new Fabulous();
				fabulous.setId(UUID.randomUUID().toString());
				fabulous.setBlogId(blog.getId());
				fabulous.setUserId(user.getId());
				fabulous.setFabulousDate(new Date());
				int insert = fabulousServices.insert(fabulous);
				if( insert > 0) {
					tips = new Tips("点赞成功！", true);
				}
			}
		}
		return tips;
	}
}
