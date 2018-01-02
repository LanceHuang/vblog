package com.lance.blog.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author Lance
 * @date 2018/1/2 10:09
 */
@Component
@Aspect
public class TraceAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Before("execution(* com.lance.blog.service.*.*(..))||" +
            "execution(* com.lance.blog.web.*.*(..))")
    public void before(JoinPoint jp) {
        logger.debug("{}.{}",
                jp.getTarget().getClass().getName(),
                jp.getSignature().getName());
    }
}
