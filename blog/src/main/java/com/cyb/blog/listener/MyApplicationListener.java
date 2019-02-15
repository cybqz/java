package com.cyb.blog.listener;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;
import com.cyb.blog.domain.Parames;
import com.cyb.blog.domain.ParamesExample;
import com.cyb.blog.service.ParamesServices;

@Service
public class MyApplicationListener implements ApplicationListener<ContextRefreshedEvent> {
	
	@Autowired
	private ParamesServices paramesServices;

	public void onApplicationEvent(ContextRefreshedEvent event) {
		if (event.getApplicationContext().getParent() == null) {//保证只执行一次
            if(paramesServices != null) {
            	System.out.println("初始化Parames.........start");
            	List<Parames> parames = paramesServices.selectByExample(new ParamesExample());
            	for(Parames parame : parames) {
            		ParamesServices.PARAMESMAP.put(parame.getName(), parame.getValue());
            	}
            	System.out.println("初始化Parames.........end:"+parames.size());
            }
        }
	}
}
