package source.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class CRMLoggingAspect {

    //setup logger
    private Logger logger = Logger.getLogger(getClass().getName());

    //setup pointcut declaration
    @Pointcut("execution(* source.controller.*.*(..))")
    private void forControllerPackage(){}

    @Pointcut("execution(* source.service.*.*(..))")
    private void forServicePackage(){}

    @Pointcut("execution(* source.dao.*.*(..))")
    private void forDAOPackage(){}

    @Pointcut("forControllerPackage() || forServicePackage() || forDAOPackage()")
    private void forAppFlow(){}

    //add @Before advice
    @Before("forAppFlow()")
    private void before(JoinPoint joinPoint){
        String method = joinPoint.getSignature().toShortString();
        logger.info("====>>>>> You are calling this method in @Before: "+ method);

        Object[] args = joinPoint.getArgs();

        for(Object arg: args){
            logger.info("====>>>>> argument: "+arg);
        }
    }
    //add @AfterReturning advice
    @AfterReturning(
            pointcut = "forAppFlow()",
            returning = "theResult")
    private void afterReturning(JoinPoint joinPoint, Object theResult){
        String method = joinPoint.getSignature().toShortString();
        logger.info("====>>>>> You are calling this method in @AfterReturning: "+ method);

        logger.info("====>>>>> The result: " + theResult);
    }
}
