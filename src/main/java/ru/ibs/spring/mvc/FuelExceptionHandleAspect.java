package ru.ibs.spring.mvc;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@EnableAspectJAutoProxy
@Aspect
@Component
public class FuelExceptionHandleAspect {

    @Pointcut("@annotation(ru.ibs.spring.mvc.FuelExceptionHandle)")
    public void callAtAnnotatedMethods() {
    }

    @Around("callAtAnnotatedMethods()")
    public Object handleException(ProceedingJoinPoint pjp) throws Throwable {
        try {
            return pjp.proceed();
        } catch (Exception e) {
            return "exception";
        }
    }
}
