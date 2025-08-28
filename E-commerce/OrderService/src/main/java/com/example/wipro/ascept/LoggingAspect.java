package com.example.wipro.ascept;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect 
{
	private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    
    @Pointcut("execution(* com.example.wipro..*(..))")
    public void applicationPackagePointcut() {}

    
    @Before("applicationPackagePointcut()")
    public void logBefore(JoinPoint joinPoint) {
        logger.info("➡ Entering method: {} with arguments: {}",
                joinPoint.getSignature().toShortString(),
                Arrays.toString(joinPoint.getArgs()));
    }

    
    @AfterReturning(pointcut = "applicationPackagePointcut()", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        logger.info("✅ Method {} executed successfully, returned: {}",
                joinPoint.getSignature().toShortString(), result);
    }

   
    @AfterThrowing(pointcut = "applicationPackagePointcut()", throwing = "error")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable error) {
        logger.error("❌ Exception in method {}: {}",
                joinPoint.getSignature().toShortString(), error.getMessage());
    }

    
    @Around("applicationPackagePointcut()")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        try {
            return joinPoint.proceed();
        } finally {
            long duration = System.currentTimeMillis() - start;
            logger.info("⏱ Execution time of {} :: {} ms",
                    joinPoint.getSignature().toShortString(), duration);
        }
    }
}
