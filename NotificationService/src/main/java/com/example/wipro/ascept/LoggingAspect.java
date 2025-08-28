package com.example.wipro.ascept;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;
@Aspect
@Component
public class LoggingAspect 
{
	private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    
    @Pointcut("execution(* com.example.wipro..*(..))")
    public void applicationPackagePointcut() {}

    
    @Before("applicationPackagePointcut()")
    public void logBefore(JoinPoint joinPoint) {
        logger.info("➡ Entering method: {} | Args: {}",
                joinPoint.getSignature().toShortString(),
                Arrays.toString(joinPoint.getArgs()));
    }

    
    @AfterReturning(pointcut = "applicationPackagePointcut()", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        logger.info("✅ Method executed: {} | Returned: {}",
                joinPoint.getSignature().toShortString(),
                result);
    }

    
    @AfterThrowing(pointcut = "applicationPackagePointcut()", throwing = "error")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable error) {
        logger.error("❌ Exception in method: {} | Message: {}",
                joinPoint.getSignature().toShortString(),
                error.getMessage());
    }

   
    @Around("applicationPackagePointcut()")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        try {
            return joinPoint.proceed();
        } finally {
            long duration = System.currentTimeMillis() - start;
            logger.info("⏱ Execution time of {}: {} ms",
                    joinPoint.getSignature().toShortString(),
                    duration);
        }
    }
}

