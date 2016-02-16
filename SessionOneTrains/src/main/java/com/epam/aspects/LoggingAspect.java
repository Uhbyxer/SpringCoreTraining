package com.epam.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	
	@Pointcut("execution(* *.logEvent(..))")
	private void allLogEventMethods() {
	}
	
	@Pointcut("allLogEventMethods()")
	private void consoleLogEventMethods() {
	}	
	
	@Before("allLogEventMethods()")
	public void logBefore(JoinPoint joinPoint) {
		System.out.println("BEFORE : " + joinPoint.getTarget().getClass().getSimpleName() + " " +
				joinPoint.getSignature().getName());
	}
	
	@Around("consoleLogEventMethods()")
	public void aroundLogEvent(ProceedingJoinPoint joinPoint) {
		System.out.println("BEFORE CONSOLE: " + joinPoint.getTarget().getClass().getSimpleName() + " " +
				joinPoint.getSignature().getName());
		
		try {
			joinPoint.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	
	@AfterReturning(pointcut = "allLogEventMethods()", returning = "retVal")
	public void logAfter(Object retVal) {
		System.out.println("ret val: " + retVal);
	}
	
	@AfterThrowing(pointcut = "allLogEventMethods()", throwing = "t")
	public void logAfterThrow(Throwable t) {
		System.out.println("THROWN : " + t);
	}
	
	
	
}
