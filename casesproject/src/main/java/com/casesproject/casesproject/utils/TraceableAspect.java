package com.casesproject.casesproject.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TraceableAspect {
    @Around("@annotation(Traceable)")
    public Object trace(ProceedingJoinPoint joinPoint) throws Throwable {
        for (Object obj : joinPoint.getArgs()) {
            System.out.println("Input: " + obj);
        }
        Object object = joinPoint.proceed();
        System.out.println("Result: " + object.toString());
        return object;
    }
}
