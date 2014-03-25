package service.decorator;

import service.OrderService;

public class DecoratorBefore extends OrderServiceDecorator {

	public DecoratorBefore(OrderService target) {
		super(target);
	}

	@Override
	public String getOrder(String orderNumber) {
		System.out.println("logOrderBefore() is running!");
		String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		System.out.println("hijacked : " + methodName);
		System.out.println("hijacked arguments : " + orderNumber);
		System.out.println("******");
		return super.getOrder(orderNumber);
	}

	@Override
	public String addOrder(String orderNumber, Long amount) {
		System.out.println("logOrderBefore() is running!");
		String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		System.out.println("hijacked : " + methodName);
		System.out.println("hijacked arguments : [" + orderNumber + ", " + amount + "]");
		System.out.println("******");
		return super.addOrder(orderNumber, amount);
	}
	
}
