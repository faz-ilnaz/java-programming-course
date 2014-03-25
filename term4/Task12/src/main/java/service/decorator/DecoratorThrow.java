package service.decorator;

import service.OrderService;

public class DecoratorThrow extends OrderServiceDecorator {

	public DecoratorThrow(OrderService target) {
		super(target);
	}

	@Override
	public String getOrder(String orderNumber) {
		String result = "";
		try {
			result = target.getOrder(orderNumber);			
		} catch(Exception e) {
			System.out.println("logOrderAfterThrowing() is running!");
			System.out.println("hijacked : getOrder");
			System.out.println("Exception : " + e);
			System.out.println("******");
			
			// uncomment if you want to rethrow the occurred exception 
//			throw e;
		}
		return result;
	}
	
	

}
