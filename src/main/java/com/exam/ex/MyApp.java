package com.exam.ex;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("ma")
public class MyApp {
	
	@Autowired
	private MyService myService;
	
	public void say() {
		System.out.println(myService.getMessage());
	}

	public MyService getMyService() {
		return myService;
	}

	public void setMyService(MyService myService) {
		this.myService = myService;
	}
	
	
}
