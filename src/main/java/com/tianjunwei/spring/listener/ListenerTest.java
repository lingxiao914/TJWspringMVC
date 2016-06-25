package com.tianjunwei.spring.listener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

public class ListenerTest implements ApplicationListener {

	public void onApplicationEvent(ApplicationEvent event) {
		 if(event instanceof Listener){
			Listener listener = (Listener) event;
			listener.save("hello listener");
			
		}
	}

}
