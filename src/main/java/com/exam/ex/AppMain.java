package com.exam.ex;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppMain {

	public static void main(String[] args) {
	
//		ApplicationContext ctx = new ClassPathXmlApplicationContext("/com/exam/ex/context.xml");
		
		ApplicationContext ctx = new AnnotationConfigApplicationContext(MyConfig.class);
		MyApp app = (MyApp) ctx.getBean("ma");
		app.say();
	}
}