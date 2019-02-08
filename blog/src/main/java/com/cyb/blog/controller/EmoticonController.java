package com.cyb.blog.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cyb.blog.service.EmoticonServices;

@CrossOrigin
@Controller
@RequestMapping(value="/emoticonController")
public class EmoticonController {
	
	@Autowired
	private EmoticonServices emoticonServices;
	
	@RequestMapping(value="/getEmoticonList")
	@ResponseBody
	public List<Map<String,String[]>> getEmoticonList(HttpSession session) {
		String url = session.getServletContext().getRealPath("/");
		return emoticonServices.getEmoticonList(url);
	}
}
