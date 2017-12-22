package com.lance.blog.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author Lance
 */
@Component
@Aspect
public class ProfileAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Around("execution(* com.lance.blog.web.*.*(..))")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object returnVal = joinPoint.proceed();
        long endTime = System.currentTimeMillis();

        logger.debug("{}.{}: {} millisecond",
                joinPoint.getTarget().getClass().getName(),
                joinPoint.getSignature().getName(),
                endTime - startTime);

        return returnVal;
    }
}
