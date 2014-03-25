package service.decorator;

import service.OrderService;

public class DecoratorAround extends OrderServiceDecorator {

	public DecoratorAround(OrderService target) {
		super(target);
	}

	@Override
	public String addOrder(String orderNumber, Long amount) {
		System.out.println("logOrderAround() is running!");
		String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		System.out.println("hijacked method: " + methodName);
		String result; 
		long startTime = System.nanoTime();
		result = target.addOrder(orderNumber, amount);
		long estimatedTime = System.nanoTime() - startTime;
		System.out.println("Total time: " + estimatedTime + " nanosecond(s).");
		System.out.println("******");
		return result;
	}

	
}
