package com.epam.aspects;

import java.util.HashMap;
import java.util.Map;





import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;



@Aspect
public class StatisticsAspect {
	private Map<Class<?>, Integer> counter = new HashMap<>();
	
	
	
	public Map<Class<?>, Integer> getCounter() {
		return counter;
	}

	
	@Pointcut("execution(* *.logEvent(..))")
	private void allLogEventMethods() {
	}

	@AfterReturning("allLogEventMethods()")
	public void count(JoinPoint jp) {
		if(jp == null || jp.getTarget() == null) return;
		
		Class<?> clazz = jp.getTarget().getClass();
		counter.put(clazz, counter.getOrDefault(clazz, 0) + 1);
	}
}
