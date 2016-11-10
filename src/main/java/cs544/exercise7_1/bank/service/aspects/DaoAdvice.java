package cs544.exercise7_1.bank.service.aspects;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

import cs544.exercise7_1.bank.logging.ILogger;


@Aspect
public class DaoAdvice {
	private ILogger logger;

	public void setLogger(ILogger logger) {
		this.logger = logger;
	}
	@After("execution(* cs544.exercise7_1.bank.dao.*.*(..) )")
	public void daoLogger(JoinPoint joinPont){	
		System.out.println("Hello from dao");
		logger.log(String.format("bank.dao.%s() method has been called.", joinPont.getSignature().getName()));
	}

}
