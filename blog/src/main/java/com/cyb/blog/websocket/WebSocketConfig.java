package com.cyb.blog.websocket;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import com.cyb.blog.interceptor.TalkWebSockettHandler;
import com.cyb.blog.interceptor.SiteWebSocketPushHandler;
import com.cyb.blog.interceptor.SiteWebSockettHandler;
import com.cyb.blog.interceptor.TalkWebSocketPushHandler;

@Configuration
@EnableWebSocket
public class WebSocketConfig extends WebMvcConfigurerAdapter implements WebSocketConfigurer {

	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		registry.addHandler(talkHandler(), "/talkService")
		.addInterceptors(new TalkWebSockettHandler())
		.setAllowedOrigins("*");
		
		registry.addHandler(siteHandler(), "/siteService")
		.addInterceptors(new SiteWebSockettHandler())
		.setAllowedOrigins("*");
	}
	
	@Bean
    public WebSocketHandler talkHandler() {
        return new TalkWebSocketPushHandler();
    }
	
	@Bean
    public WebSocketHandler siteHandler() {
        return new SiteWebSocketPushHandler();
    }
}
