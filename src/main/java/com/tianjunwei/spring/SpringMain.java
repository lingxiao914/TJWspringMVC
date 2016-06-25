package com.tianjunwei.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain {
	
	@SuppressWarnings({ "resource" })
	public static void main(String [] args){
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		IPersonServer personServer = (IPersonServer) applicationContext.getBean("personserver");
		personServer.save(" hello spring");
		System.out.println(applicationContext.getId());
		System.out.println(applicationContext.getApplicationName());
		System.out.println(applicationContext.isPrototype("personserver"));
		System.out.println(applicationContext.isSingleton("personserver"));
	}

}
