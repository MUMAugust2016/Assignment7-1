package cs544.exercise7_1.bank.service.aspects;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

import cs544.exercise7_1.bank.logging.ILogger;


@Aspect
public class JMSAdvice {

	private ILogger logger;

	public void setLogger(ILogger logger) {
		this.logger = logger;
	}

	@After("execution(public void cs544.exercise7_1.bank.jms.IJMSSender.sendJMSMessage(String))")
	public void logJMSMessage() {
		logger.log("JMS Message has been sent.");
	}
}
