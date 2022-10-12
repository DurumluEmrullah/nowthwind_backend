package com.edurumluemrullah.northwind_backend.common.aspects.log;


import com.edurumluemrullah.northwind_backend.common.results.DataResult;
import com.edurumluemrullah.northwind_backend.common.services.abstracts.ExceptionLogService;
import com.edurumluemrullah.northwind_backend.models.pojos.Log;
import com.edurumluemrullah.northwind_backend.models.pojos.dtos.CreateExceptionLogDto;
import com.edurumluemrullah.northwind_backend.common.services.abstracts.LogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

@Aspect
@Configuration
public class ServiceAspect {


    private final LogService logService;

    private final ExceptionLogService exceptionLogService;

    public ServiceAspect(LogService logService, ExceptionLogService exceptionLogService) {
        this.logService = logService;
        this.exceptionLogService = exceptionLogService;
    }

    @Before("execution(* com.edurumluemrullah.northwind_backend.common.services.abstracts.BaseService.*(..))")
    public void logBeforeForParentMethods(JoinPoint joinPoint){
        Log log = new Log();
        log.setMessage(joinPoint.getSignature() +" worked");

        Object[] args = joinPoint.getArgs();

        StringBuilder parameters = new StringBuilder();
        for (Object arg : args) {
            parameters.append(arg.toString()).append(System.lineSeparator());
        }

        log.setParameter(parameters.toString());

        log.setMethod(joinPoint.getSignature().toString());

        log.setStatus(true);
        log.setDate(new Date());

        logService.createLog(log);

        // TODO refactor edilecek !!!
    }

    @Before("execution(* com.edurumluemrullah.northwind_backend.services.impl.*.*(..))")
    public void logBeforeForChildMethods(JoinPoint joinPoint){
        Log log = new Log();
        log.setMessage(joinPoint.getSignature() +" worked");

        Object[] args = joinPoint.getArgs();

        StringBuilder parameters = new StringBuilder();
        for (Object arg : args) {
            parameters.append(arg.toString()).append(System.lineSeparator());
        }

        log.setParameter(parameters.toString());

        log.setMethod(joinPoint.getSignature().toString());

        log.setStatus(true);
        log.setDate(new Date());

        logService.createLog(log);

        // TODO refactor edilecek !!!
    }


    @AfterThrowing(value = "execution(* com.edurumluemrullah.northwind_backend.common.services.abstracts.BaseService.*(..))",throwing = "exception")
    public void logWhenExceptionOnParentMethods(JoinPoint joinPoint ,Throwable exception){
        System.out.println("Merhabaaa2");
    }

    @AfterThrowing(value = "execution(* com.edurumluemrullah.northwind_backend.services.impl.*.*(..))",throwing = "exception")
    public void logWhenExceptionOnChildMethods(JoinPoint joinPoint ,Throwable exception){
    // TODO refactor edilecek !!!
        Log log = new Log();
        log.setMessage(joinPoint.getSignature() +" occur exception while working");

        Object[] args = joinPoint.getArgs();

        StringBuilder parameters = new StringBuilder();
        for (Object arg : args) {
            parameters.append(arg.toString()).append(System.lineSeparator());
        }

        log.setParameter(parameters.toString());

        log.setMethod(joinPoint.getSignature().toString());

        log.setStatus(false);
        log.setDate(new Date());

        DataResult<Log> registeredLog = logService.createLog(log);

        if(registeredLog.isSuccess()){
            StackTraceElement[] stackTrace = exception.getStackTrace();
            StringBuilder stackTraceBuilder=new StringBuilder();
            stackTraceBuilder.append("\tat ");

            for (StackTraceElement stackTraceElement : stackTrace) {

                stackTraceBuilder.append(stackTraceElement).append("\n\tat ");
            }

            CreateExceptionLogDto createExceptionLogDto = new CreateExceptionLogDto();
            createExceptionLogDto.setLogId(registeredLog.getData().getId());
            createExceptionLogDto.setExceptionTypeName(exception.getClass().getName());
            createExceptionLogDto.setStackTrace(stackTraceBuilder.toString());
            createExceptionLogDto.setExceptionMessage(log.getMessage());



            exceptionLogService.create(createExceptionLogDto);
        }




    }


}
