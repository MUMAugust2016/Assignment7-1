package cs544.exercise7_1.bank.service.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.util.StopWatch;

@Aspect
public class TimeAdvice {
	
	@Around("within(cs544.exercise7_1.bank.service.*)")
	public Object methodTime(ProceedingJoinPoint joinPoint) throws Throwable {
		
		StopWatch clock = new StopWatch();
		
		clock.start(joinPoint.toShortString());

		Object object = joinPoint.proceed();

		clock.stop();

		System.out.println("Time taken: " + clock.getLastTaskTimeMillis() + " ms");

		return object;
	}

}
