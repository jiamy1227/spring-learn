package com.jiamy.apolearn.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: jiamy
 * @create: 2024/9/24 14:06
 **/
@Aspect
@Component
public class LoggingAspect {

    @Before("execution(public * com.jiamy.apolearn.service.MailService.*(..))")
    public void doBefore(){
        System.out.println("before business...");
    }

    @Around("execution(public * com.jiamy.apolearn.service.UserService.*(..))")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("before business2...");
        Object retVal = pjp.proceed();
        System.out.println("after business...");
        return retVal;
    }
}
