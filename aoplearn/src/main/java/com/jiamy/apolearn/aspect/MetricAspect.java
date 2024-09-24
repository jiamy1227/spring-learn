package com.jiamy.apolearn.aspect;

import com.jiamy.apolearn.annotation.MetricTime;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: jiamy
 * @create: 2024/9/24 14:37
 **/
@Aspect
@Component
public class MetricAspect {

    @Around("@annotation(metricTime)")
    public Object metricTime(ProceedingJoinPoint pjp, MetricTime metricTime) throws Throwable {
        long start = System.currentTimeMillis();
        Object o = pjp.proceed();
        long consume = System.currentTimeMillis() - start;
        System.out.println("方法"+metricTime.value()+"执行花费时间：" + consume+"ms");
        return o;
    }
}
