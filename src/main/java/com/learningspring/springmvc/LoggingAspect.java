package com.learningspring.springmvc;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger("LoggingAspect.class");
    @Before("execution(public * com.learningspring.springmvc.AlienController.getAliens())")
    public void logBefore(){
        logger.info("getAliens method called from aspect");
    }
    @After("execution(public * com.learningspring.springmvc.AlienController.getAliens())")
    public void logAfter(){
        logger.info("getAliens method executed from aspect");
    }
}
