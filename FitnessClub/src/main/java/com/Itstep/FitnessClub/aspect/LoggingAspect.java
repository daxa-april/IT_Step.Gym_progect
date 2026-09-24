package com.Itstep.FitnessClub.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author Daria Pevets
 **/
@Aspect
@Component
public class LoggingAspect {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Pointcut("within(com.Itstep.FitnessClub.service.impl.*)")
    public void serviceMethods() {
    }

    /**
     * этап вызова метода.
     */
    @Before("serviceMethods()")
    public void logBefore(JoinPoint joinPoint) {
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String methodName = joinPoint.getSignature().getName();
        int argsCount = joinPoint.getArgs().length;

        log.info("--> [Сервис] Вызов метода: {}.{}() | Аргументов: {}", className, methodName, argsCount);
    }

    /**
     * результат работы метода.
     */
    @AfterReturning(pointcut = "serviceMethods()", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String methodName = joinPoint.getSignature().getName();
        String returnType = (result != null) ? result.getClass().getSimpleName() : "void";

        log.info("<-- [Сервис] Успешно завершен: {}.{}() | Возвращено: {}", className, methodName, returnType);
    }

    /**
     * Логирование ошибок, если метод выбросил исключение.
     */
    @AfterThrowing(pointcut = "serviceMethods()", throwing = "exception")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable exception) {
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String methodName = joinPoint.getSignature().getName();

        log.error("Ошибка в методе {}.{}: {}", className, methodName, exception.getMessage(), exception);
    }
}
