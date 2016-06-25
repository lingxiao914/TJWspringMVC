package com.tianjunwei.spring.listener;

import org.springframework.context.ApplicationEvent;

public class Listener extends ApplicationEvent{

	public Listener(Object source) {
		super(source);
	}
	public void save(String data){
		System.out.println(data);
	}

}
