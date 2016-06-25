package com.tianjunwei.spring.listener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tianjunwei.spring.IPersonServer;
import com.tianjunwei.spring.PersonServerImpl;

public class ListenerMain {

	public static void main(String [] args){
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		Listener listener = new Listener("test");
		applicationContext.publishEvent(listener);
	}
}
