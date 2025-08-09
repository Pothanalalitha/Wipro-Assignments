package com.wipro.lalitha.monorepo.controller;


	import org.aspectj.lang.JoinPoint;
	import org.aspectj.lang.annotation.*;
	import org.slf4j.Logger;
	import org.slf4j.LoggerFactory;
	import org.springframework.stereotype.Component;

	import java.util.Arrays;

	@Aspect
	@Component
	public class ControllerLoggingAspect 
	{

	    private static final Logger logger = LoggerFactory.getLogger(ControllerLoggingAspect.class);

	    @Pointcut("execution(* com.yourpackage..*Controller.*(..))")
	    public void controllerMethods() {}

	    @Before("controllerMethods()")
	    public void logBefore(JoinPoint joinPoint) {
	        logger.info("Entering {} with arguments={}", 
	                    joinPoint.getSignature().toShortString(), 
	                    Arrays.toString(joinPoint.getArgs()));
	    }

	    @AfterReturning(pointcut = "controllerMethods()", returning = "result")
	    public void logAfter(JoinPoint joinPoint, Object result) {
	        logger.info("Exiting {} with result={}", 
	                    joinPoint.getSignature().toShortString(), 
	                    result);
	    }

	    @AfterThrowing(pointcut = "controllerMethods()", throwing = "error")
	    public void logAfterThrowing(JoinPoint joinPoint, Throwable error) {
	        logger.error("Exception in {} with cause={}", 
	                     joinPoint.getSignature().toShortString(), 
	                     error.getMessage(), error);
	    }
	}

