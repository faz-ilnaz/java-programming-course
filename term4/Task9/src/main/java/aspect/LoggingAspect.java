package aspect;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class LoggingAspect {

	@Before("execution(* service.CustomerService.addCustomer(..))")
	public void logBefore(JoinPoint joinPoint) {

		System.out.println("logBefore() is running!");
		System.out.println("hijacked : " + joinPoint.getSignature().getName());
		System.out.println("******");
	}

	@After("execution(* service.CustomerService.addCustomer(..))")
	public void logAfter(JoinPoint joinPoint) {

		System.out.println("logAfter() is running!");
		System.out.println("hijacked : " + joinPoint.getSignature().getName());
		System.out.println("******");

	}
	
	@AfterReturning(
			pointcut = "execution(* service.CustomerService.addCustomerReturnValue(..))",
			returning= "result")
	public void logAfterReturning(JoinPoint joinPoint, Object result) {

		System.out.println("logAfterReturning() is running!");
		System.out.println("hijacked : " + joinPoint.getSignature().getName());
		System.out.println("Method returned value is : " + result);
		System.out.println("******");

	}
	
	@AfterThrowing(
			pointcut = "execution(* service.CustomerService.addCustomerThrowException(..))",
			throwing= "error")
	public void logAfterThrowing(JoinPoint joinPoint, Throwable error) {

		System.out.println("logAfterThrowing() is running!");
		System.out.println("hijacked : " + joinPoint.getSignature().getName());
		System.out.println("Exception : " + error);
		System.out.println("******");

	}
	
	
	@Around("execution(* service.CustomerService.addCustomerAround(..))")
	public void logAround(ProceedingJoinPoint joinPoint) throws Throwable {

		System.out.println("logAround() is running!");
		System.out.println("hijacked method : " + joinPoint.getSignature().getName());
		System.out.println("hijacked arguments : " + Arrays.toString(joinPoint.getArgs()));
		
		System.out.println("Around before is running!");
		joinPoint.proceed();
		System.out.println("Around after is running!");
		
		System.out.println("******");

	}
	
	@Before("execution(* service.OrderService.*(..))")
	public void logOrderBefore(JoinPoint joinPoint) {
		System.out.println("logOrderBefore() is running!");
		System.out.println("hijacked : " + joinPoint.getSignature().getName());
		System.out.println("hijacked arguments : " + Arrays.toString(joinPoint.getArgs()));
		System.out.println("******");
	}
	
	@AfterThrowing(
			pointcut = "execution(* service.OrderService.getOrder(..))",
			throwing= "error")
	public void logOrderAfterThrowing(JoinPoint joinPoint, Throwable error) {

		System.out.println("logOrderAfterThrowing() is running!");
		System.out.println("hijacked : " + joinPoint.getSignature().getName());
		System.out.println("Exception : " + error);
		System.out.println("******");

	}
	
	@Around("execution(* service.OrderService.addOrder(..))")
	public void logOrderAround(ProceedingJoinPoint joinPoint) throws Throwable {

		System.out.println("logOrderAround() is running!");
		System.out.println("hijacked method : " + joinPoint.getSignature().getName());
		long startTime = System.nanoTime();
		joinPoint.proceed();
		long estimatedTime = System.nanoTime() - startTime;
		System.out.println("Total time: " + estimatedTime + " nanosecond(s).");
		
		System.out.println("******");

	}
}