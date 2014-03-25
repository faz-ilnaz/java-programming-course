package service.proxy;

import service.OrderService;

public class OrderServiceProxy implements OrderService {
	
	private OrderService target;
	
	public OrderServiceProxy(OrderService orderService) {
		target = orderService;
	}

	@Override
	public String getOrder(String orderNumber) {
		System.out.println("logOrderBefore() is running!");
		System.out.println("hijacked : " + Thread.currentThread().getStackTrace()[1].getMethodName());
		System.out.println("hijacked arguments : " + orderNumber);
		System.out.println("******");
		String result = "";
		try {
			result = target.getOrder(orderNumber);			
		} catch(Exception e) {
			System.out.println("logOrderAfterThrowing() is running!");
			System.out.println("hijacked : " + Thread.currentThread().getStackTrace()[1].getMethodName());
			System.out.println("Exception : " + e);
			System.out.println("******");
			
			// uncomment if you want to rethrow the occurred exception 
//			throw e;
		}
		return result;
	}

	@Override
	public String addOrder(String orderNumber, Long amount) {
		System.out.println("logOrderAround() is running!");
		System.out.println("hijacked method: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		System.out.println("logOrderBefore() is running!");
		System.out.println("hijacked : " + Thread.currentThread().getStackTrace()[1].getMethodName());
		System.out.println("hijacked arguments : [" + orderNumber + ", " + amount + "]");
		System.out.println("******");
		String result; 
		long startTime = System.nanoTime();
		result = target.addOrder(orderNumber, amount);
		long estimatedTime = System.nanoTime() - startTime;
		System.out.println("Total time: " + estimatedTime + " nanosecond(s).");
		System.out.println("******");
		return result;
	}

}
