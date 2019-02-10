package com.cyb.blog.controller;

import java.util.Date;
import java.util.UUID;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cyb.blog.domain.Comment;
import com.cyb.blog.domain.Fabulous;
import com.cyb.blog.domain.FabulousExample;
import com.cyb.blog.domain.User;
import com.cyb.blog.domain.FabulousExample.Criteria;
import com.cyb.blog.domain.Message;
import com.cyb.blog.entity.Pagenation;
import com.cyb.blog.entity.Tips;
import com.cyb.blog.service.CommentServices;
import com.cyb.blog.service.FabulousServices;
import com.cyb.blog.service.MessageServices;
import com.cyb.blog.utils.Validate;

@CrossOrigin
@Controller
@RequestMapping(value="/messageController")
public class MessageController {
	
	@Autowired
	private MessageServices messageServices;
	@Autowired
	private FabulousServices fabulousServices;
	@Autowired
	private CommentServices commentServices;
	
	@RequestMapping(value="/publish")
	@ResponseBody
	public Tips publish (Message message) {
		Validate validate = new Validate();
		Tips tips = new Tips("false", false);
		User user = validate.validateAll(tips, null, null);
		if(tips.isValidate()) {
			tips.setValidate(false);
			if(StringUtils.isBlank(message.getMessage())) {
				tips.setMsg("空的内容！");
			}else {
				message.setAuthor(user.getId());
				int count = messageServices.insert(message);
				if(count > 0) {
					tips = new Tips("true", true);
				}
			}
		}
		return tips;
	}
	
	@RequestMapping(value="/getList")
	@ResponseBody
	public Pagenation getList (Message message, Pagenation pagenation) {
		pagenation = messageServices.getList(message, pagenation);
		return pagenation;
	}
	
	@RequestMapping(value="/reply")
	@ResponseBody
	public Tips reply (Comment comment) {
		Validate validate = new Validate();
		Tips tips = new Tips("false", false);
		User user = validate.validateAll(tips, null, null);
		if(tips.isValidate()) {
			tips.setValidate(false);
			if(StringUtils.isBlank(comment.getCommentContaint())){
				tips.setMsg("空的内容");
			}else if(StringUtils.isBlank(comment.getBlogId())){
				tips.setMsg("空的评论对象");
			}else {
				comment.setCommentUserId(user.getId());
				int count = commentServices.insert(comment);
				if(count > 0) {
					tips = new Tips("true", true);
				}
			}
		}
		return tips;
	}
	
	@RequestMapping(value="/doFablous")
	@ResponseBody
	public Tips doFablous (Message message) {
		Validate validate = new Validate();
		Tips tips = new Tips("false", false);
		User user = validate.validateAll(tips, null, null);
		if(tips.isValidate()) {
			tips.setValidate(false);
			FabulousExample fabulousExample = new FabulousExample();
			Criteria criteria = fabulousExample.createCriteria();
			criteria.andBlogIdEqualTo(message.getId());
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
				fabulous.setBlogId(message.getId());
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