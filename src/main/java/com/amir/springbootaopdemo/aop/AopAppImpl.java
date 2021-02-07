package com.amir.springbootaopdemo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class AopAppImpl {

	@Pointcut("execution(* com.amir.springbootaopdemo.TestController.*(..))")
	public void applyForTestController() {
		
	}
	
	@Before("applyForTestController()")
	public void beforeTestMethod(JoinPoint joinpoint) {
		System.out.println("applyForTestController Hello from @Before  "+joinpoint.getArgs()[0]);
	}
	
	@After("applyForTestController()")
	public void afterTestMethod(JoinPoint joinpoint) {
		System.out.println("applyForTestController Hello from @After  "+joinpoint.getArgs()[0]);
	}
	
	@AfterReturning("applyForTestController()")
	public void afterReturningTestMethod(JoinPoint joinpoint) {
		System.out.println("applyForTestController Hello from @AfterReturning  "+joinpoint.getArgs()[0]);
	}
	
	@AfterThrowing("applyForTestController()")
	public void afterThrowingTestMethod(JoinPoint joinpoint) {
		System.out.println("applyForTestController Hello from @AfterThrowing  "+joinpoint.getArgs()[0]);
	}
	@Around("applyForTestController()")
	public Object aroundTestMethod(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("before applyForTestController Hello from @Around  "+pjp.getArgs()[0]);
		String name = (String) pjp.getArgs()[0];
		name = name +"adding @Around";
		Object[] object = new Object[] {name};
		Object ret = pjp.proceed(object);
		System.out.println("after applyForTestController Hello from @Around  "+pjp.getArgs()[0]);
		return ret+"output";
	}
	
	
}
