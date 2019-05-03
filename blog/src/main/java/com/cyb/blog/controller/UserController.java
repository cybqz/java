package com.cyb.blog.controller;

import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.cyb.blog.domain.User;
import com.cyb.blog.entity.Tips;
import com.cyb.blog.service.UserServices;
import com.cyb.blog.utils.Validate;

@CrossOrigin
@Controller
@RequestMapping(value="/userController")
public class UserController {
	
	@Autowired
	private UserServices userSerivces;
	
	@RequestMapping(value="/update")
	@ResponseBody
	public Tips update (User user) {
		Validate validate = new Validate();
		Tips tips = new Tips("false", false);
		User loginedUser = validate.isLogin();
		if(loginedUser != null) {
			if(StringUtils.isBlank(user.getName())) {
				tips.setMsg("用户名不能为空！");
			}else if(StringUtils.isBlank(user.getUserName())) {
				tips.setMsg("姓名不能为空！");
			}else if(StringUtils.isBlank(user.getEmail())) {
				tips.setMsg("邮箱地址不能为空！");
			}else if(StringUtils.isBlank(user.getPhone())) {
				tips.setMsg("联系方式不能为空！");
			}else {
				loginedUser.setName(user.getName());
				loginedUser.setEmail(user.getEmail());
				loginedUser.setPhone(user.getPhone());
				loginedUser.setUserName(user.getUserName());
				int count = userSerivces.updateByPrimaryKey(loginedUser);
				if(count > 0) {
					tips = new Tips("修改成功！", true);
				}else {
					tips.setMsg("修改失败！");
				}
			}
		}
		return tips;
	}
	
	@RequestMapping(value="/updateImage")
	@ResponseBody
	public Tips updateImage (@RequestParam(value = "file", required = true) MultipartFile pictureFile) {
		Validate validate = new Validate();
		Tips tips = new Tips("false", false);
		User user = validate.validateAll(tips, null, null);
		if(tips.isValidate()) {
			tips.setValidate(false);
            try {
            	if(pictureFile != null) {
            		// 图片新名字
                    String newName = UUID.randomUUID().toString();
                    // 图片原来的名字
                    String oldName = pictureFile.getOriginalFilename();
                    // 后缀
                    String sux = oldName.substring(oldName.lastIndexOf("."));
                     //新建本地文件流
                    //File file = new File("D:\\SSMBasic\\src\\main\\webapp\\WEB-INF\\img\\" + newName + sux);
                    // 写入本地磁盘
    				//pictureFile.transferTo(file);
    				tips = new Tips("true", true);
            	}
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} /*catch (IOException e) {
				e.printStackTrace();
			}*/
		}
		return tips;
	}
}
