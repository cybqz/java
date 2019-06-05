package com.cyb.blog.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.cyb.blog.domain.User;
import com.cyb.blog.entity.Constant;
import com.cyb.blog.entity.Tips;
import com.cyb.blog.utils.MyStringUtils;
import com.cyb.blog.utils.UserValidate;

@CrossOrigin
@Controller
@RequestMapping(value="/talkController")
public class TalkController {
	
	@RequestMapping(value="/reciveVoice")
	@ResponseBody
	public Tips reciveVoice (@RequestParam(value = "file", required = true) MultipartFile pictureFile, HttpSession session) {
		UserValidate validate = new UserValidate();
		Tips tips = new Tips("false", false);
		User user = validate.validateAll(tips, Constant.ROLE_ADMIN, null);
		if(tips.isValidate()) {
			tips.setValidate(false);
			String url = session.getServletContext().getRealPath("/");
			String userID = user.getId();
			String path = url + "voice/recive/" + userID + "/";
			File file = new File(path);
			if(!file.exists()) {
				file.mkdirs();
			}
			if(pictureFile != null) {
				FileOutputStream ouputStream = null;
				try {
					String filename = MyStringUtils.formatDate(null, null) + ".wav";
					path += filename;
					file = new File(path);
					ouputStream = new FileOutputStream(file);
					ouputStream.write(pictureFile.getBytes());
					ouputStream.flush();
					tips = new Tips("true", true);
				} catch (Exception e) {
					e.printStackTrace();
					tips.setMsg(e.getMessage());
				}finally {
					if(ouputStream != null) {
						try {
							ouputStream.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
		return tips;
	}
	
	@RequestMapping(value="/getVoices")
	@ResponseBody
	public Tips getVoices (HttpSession session) {
		UserValidate validate = new UserValidate();
		Tips tips = new Tips("false", false);
		User user = validate.validateAll(tips, Constant.ROLE_ADMIN, null);
		if(tips.isValidate()) {
			String url = session.getServletContext().getRealPath("/");
			String userID = user.getId();
			String relativePath = "voice/recive/";
			List<String[]> list = new ArrayList<String[]>();
			File file = new File(url + relativePath);
			File[] files = file.listFiles();
			if(files != null) {
				for(File voice : files) {
					String name = voice.getName();
					String p = name.equals(userID)?"right":"left";
					File[] voices = voice.listFiles();
					if(voices != null) {
						for(File v : voices) {
							String[] strs = new String[] {p, relativePath + name + "/" + v.getName()};
							list.add(strs);
						}
					}
				}
			}
			tips.setData(list);
		}
		return tips;
	}
}
