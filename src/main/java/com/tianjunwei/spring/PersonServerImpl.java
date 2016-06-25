package com.tianjunwei.spring;

import org.springframework.context.ApplicationEvent;



public class PersonServerImpl  implements IPersonServer{

	
	

	public void init(){
		System.out.println("init method");
	}
	
	
	public void end(){
		System.out.println("end method");
	}


	public void save(String data) {
		System.out.println(data);
	}
}
