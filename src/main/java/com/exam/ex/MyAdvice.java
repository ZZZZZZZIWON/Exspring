package com.exam.ex;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//@Component
//@Aspect
public class MyAdvice {
	
	 @Pointcut("execution(* com.exam.ex.My*.*(..))")
	    public void targetMethod() {
	        // pointcut annotation 값을 참조하기 위한 dummy method
	    }
	@Before("targetMethod()")
	 public void beforeTargetMethod(JoinPoint thisJoinPoint) {
	        System.out.println("MyAdvice.beforeTargetMethod executed.");
	 
	        String className = thisJoinPoint.getTarget().getClass().getSimpleName();
	        String methodName = thisJoinPoint.getSignature().getName();
	 
	        System.out.println(className + "." + methodName + " executed.");
	    }
}
