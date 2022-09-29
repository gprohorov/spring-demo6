package edu.pro.springdemo6.aspect;

import edu.pro.springdemo6.service.ItemService;
import nonapi.io.github.classgraph.utils.Join;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Aspect
@Component
public class GeneralInterceptorAspect {

    Logger logger = LogManager.getLogger(ItemService.class);

    @Pointcut("@annotation(edu.pro.springdemo6.annotation.CustomAnnotation)")
    public void loggingPointCut(){}

    @Before("loggingPointCut()")
    public void before(JoinPoint joinPoint) {
        logger.info("Before method invoked::" + joinPoint.getSignature());
    }

    @After("loggingPointCut()")
    public void after(JoinPoint joinPoint) {
        logger.info("After method invoked::" + joinPoint.getSignature());
    }

    @Around("loggingPointCut()")
    public Object measureMethodExecutionTime(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.nanoTime();
        Object retval = pjp.proceed();
        long end = System.nanoTime();
        String methodName = pjp.getSignature().getName();
        logger.info("Execution of " + methodName + " took " + TimeUnit.NANOSECONDS.toMillis(end - start) + "ms");
        return retval;
    }
}
