package org.example.aspect;

import lombok.extern.java.Log;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.example.springproject.entity.Comment;
import org.springframework.core.annotation.Order;

import java.util.Arrays;

@Aspect
@Order(1)
@Log
public class SecurityAspect {

    @Around("@annotation(org.example.springproject.annotation.ToLog))")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        Object methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        log.info(this.getClass().getSimpleName());
        log.info("Method: " + methodName + " with parameters: " + Arrays.asList(args));
        Comment comment = new Comment("theAuthor", "theText");
        Object[] newArgs = new Object[]{comment};
        Object returnedByMethod = joinPoint.proceed(newArgs);
        log.info("ReturnedByMethod: " + returnedByMethod);
        return "SUCCESS";
    }
}
