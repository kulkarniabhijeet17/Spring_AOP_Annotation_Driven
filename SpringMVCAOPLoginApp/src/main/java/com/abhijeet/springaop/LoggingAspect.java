package com.abhijeet.springaop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.DeclareParents;

import com.abhijeet.common.service.ChangePasswordService;
import com.abhijeet.common.service.impl.ChangePasswordServiceImpl;

@Aspect
public class LoggingAspect {
	@DeclareParents(value = "com.abhijeet.common.service.*+", defaultImpl = ChangePasswordServiceImpl.class)
	public static ChangePasswordService changePasswordService;

	@Before("execution(* com.abhijeet.common.controller.LoginController.*(..))")
	public void logBeforeAllMethods(JoinPoint jp) throws Throwable {
		System.out.println("****LoggingAspect.logBeforeAllMethods() " + jp.getSignature().getName());
	}

	@After("execution(* com.abhijeet.common.controller.LoginController.*(..))")
	public void logAfterAllMethods(JoinPoint jp) throws Throwable {
		System.out.println("****LoggingAspect.logAfterAllMethods() " + jp.getSignature().getName());
	}

	@AfterReturning("execution(* com.abhijeet.common.controller.LoginController.*(..))")
	public void logAfterReturningAllMethods(JoinPoint jp) throws Throwable {
		System.out.println("****LoggingAspect.logAfterReturningAllMethods() " + jp.getSignature().getName());
	}

	@AfterThrowing("execution(* com.abhijeet.common.controller.LoginController.*(..))")
	public void logAfterThrowingAllMethods(JoinPoint jp) throws Throwable {
		System.out.println("****LoggingAspect.logAfterThrowingAllMethods() " + jp.getSignature().getName());
	}

	@Around("execution(* com.abhijeet.common.controller.LoginController.*(..))")
	public Object logAroundAllMethods(ProceedingJoinPoint jp) throws Throwable {
		long start = System.currentTimeMillis();
		System.out.println("****LoggingAspect.logAroundAllMethods() " + jp.getSignature().getName());
		Object result = jp.proceed();
		long end = System.currentTimeMillis();
		System.out.println("The method took " + (end - start) + " milliseconds.");

		return result;
	}

	@Before("execution(* com.abhijeet.common.service.LoginService.login(String, String)) && args(userId, password)")
	public void logAllMethods(JoinPoint jp, String userId, String password) throws Throwable {
		System.out.println("****LoggingAspect.logAllMethods() " + jp.getSignature().getName() + " : " + userId);
	}
}