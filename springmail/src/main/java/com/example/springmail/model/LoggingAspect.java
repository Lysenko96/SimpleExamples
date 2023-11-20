package com.example.springmail.model;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
@Slf4j
public class LoggingAspect {

    @Pointcut("@annotation(Loggable)")
    public void executeLogging(){

    }

    @Before("executeLogging()")
    public void setLogBefore(JoinPoint joinPoint){
        StringBuilder message = new StringBuilder("Before Method: ");
        message.append(joinPoint.getSignature().getName()).append(" ");
        message.append("args: ").append(Arrays.toString(joinPoint.getArgs()));
        log.info(message.toString());
    }

    @AfterReturning(pointcut = "executeLogging()", returning = "returning")
    public void setLogAfter(JoinPoint joinPoint, Object returning){
        StringBuilder message = new StringBuilder("AfterReturning Method: ");
        message.append(joinPoint.getSignature().getName()).append(" ");
        message.append("return: ").append(returning);
        log.info(message.toString());
    }

    @Around("executeLogging()")
    public Object setLogAround(ProceedingJoinPoint joinPoint) {
        long startTime = System.currentTimeMillis();
        StringBuilder message = new StringBuilder("Around Method: ");
        message.append(joinPoint.getSignature().getName()).append(" ");
        Object returning = null;
        try {
            returning = joinPoint.proceed();
            long endTime = System.currentTimeMillis() - startTime;
            message.append("time: ").append(endTime);
            log.info(message.toString());
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
        return returning;
    }
}
