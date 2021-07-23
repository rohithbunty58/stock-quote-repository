package com.cox.auto.mobility.app.config;

import java.util.concurrent.TimeUnit;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class LoggingAspect {

	@Around("@annotation(com.cox.auto.mobility.app.config.Loggable) && execution(public * *(..))")
	public Object time(final ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		final long start = System.currentTimeMillis();
		Object value;
		try {
			value = proceedingJoinPoint.proceed();
		} finally {
			final long duration = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - start);
			log.info("{}.{} took {} seconds", proceedingJoinPoint.getSignature().getDeclaringType().getSimpleName(),
					proceedingJoinPoint.getSignature().getName(), duration);
			if (duration > 10) {
				log.warn("Method execution longer than 10 seconds!");
			}
		}
		return value;
	}

}
