package com.cyb.blog.service.impl;

import java.io.IOException;
import java.util.UUID;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;
import com.cyb.blog.dao.FabulousMapper;
import com.cyb.blog.dao.UserMapper;
import com.cyb.blog.domain.User;
import com.cyb.blog.entity.Constant;
import com.cyb.blog.entity.Tips;
import com.cyb.blog.service.LoginServices;
import com.cyb.blog.service.ParamesServices;
import com.qq.connect.QQConnectException;
import com.qq.connect.api.OpenID;
import com.qq.connect.api.qzone.UserInfo;
import com.qq.connect.javabeans.AccessToken;
import com.qq.connect.javabeans.qzone.UserInfoBean;
import com.qq.connect.oauth.Oauth;
import com.qq.connect.utils.QQConnectConfig;

@Service(value="loginServices")
public class LoginServicesImpl implements LoginServices {

	@Resource
	private FabulousMapper fabulousMapper;
	@Resource
	private UserMapper userMapper;

	public Tips login(User user) {
		Tips tips = new Tips("false", false);
		if(user != null && StringUtils.isNotBlank(user.getUserName()) && StringUtils.isNotBlank(user.getPassword())) {
			Subject subject = SecurityUtils.getSubject();
	        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(user.getUserName(),user.getPassword());
	        try {
	            subject.login(usernamePasswordToken);
	            Object object = subject.getPrincipal();
	            subject.getSession(true).setAttribute(Constant.SESSION_NAME, object);
	            tips = new Tips("登录成功！", true, object);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		}
		return tips;
	}

	public Tips logout(User user) {
		Tips tips = new Tips("false", false);
		Subject subject = SecurityUtils.getSubject();
		if(subject.isAuthenticated()) {
			subject.logout();
			tips = new Tips("退出成功！", true);
		}
		return tips;
	}

	public void loginWithQQ(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		response.setContentType("text/html;charset=utf-8");
        try {
        	QQConnectConfig.updateProperties("app_ID", ParamesServices.PARAMESMAP.get("QQ_APP_ID"));
    		QQConnectConfig.updateProperties("app_KEY", ParamesServices.PARAMESMAP.get("QQ_APP_KEY"));
    		QQConnectConfig.updateProperties("redirect_URI", ParamesServices.PARAMESMAP.get("QQ_REDIRECT_URI"));
            response.sendRedirect(new Oauth().getAuthorizeURL(request));
            session.setAttribute("beforLoginUrl",request.getHeader("Referer"));
        } catch (QQConnectException e) {
            e.printStackTrace();
        } catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Tips afterLoginWithQQ(HttpServletRequest request) {
		Tips tips = new Tips("false", false);
        try {
        	System.out.println(request);
			AccessToken accessTokenObj = (new Oauth()).getAccessTokenByRequest(request);
            String accessToken = accessTokenObj.getAccessToken();
            String openID = null;
            if (StringUtils.isBlank(accessToken)) {
                //我们的网站被CSRF攻击了或者用户取消了授权
                //做一些数据统计工作
            	tips.setMsg("没有获取到响应参数");
            } else {
            	User user = new User();
                // 利用获取到的accessToken 去获取当前用的openid -------- start
                OpenID openIDObj =  new OpenID(accessToken);
                openID = openIDObj.getUserOpenID();
                UserInfo qzoneUserInfo = new UserInfo(accessToken, openID);
                UserInfoBean userInfoBean = qzoneUserInfo.getUserInfo();
                if (userInfoBean.getRet() == 0) {
                	user.setImage(userInfoBean.getAvatar().getAvatarURL100());
                }
                user.setId(UUID.randomUUID().toString());
                String nickname = userInfoBean.getNickname();
                user.setName(nickname);
                user.setUserName(nickname);
                user.setPassword(nickname);
                userMapper.insert(user);
                tips = new Tips("true", true);
            }
        } catch (QQConnectException e) {
        	e.printStackTrace();
        	tips.setMsg(e.getMessage());
        }
        System.out.println(tips.getMsg());
		return tips;
	}

	public User loginWithWebChat() {
		// TODO Auto-generated method stub
		return null;
	}
}
