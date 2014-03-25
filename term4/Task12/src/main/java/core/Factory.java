package core;

import service.decorator.DecoratorAround;
import service.decorator.DecoratorBefore;
import service.decorator.DecoratorThrow;
import service.impl.OrderServiceImpl;
public class Factory {
	private static Factory factory = new Factory();
	
	private Factory() {
	}
	
	public static Factory getInstance() {
		return factory;
	}
	
	public Object getBean(String name) {
		if(name.equals("orderService")) {
			return new DecoratorAround(new DecoratorBefore(new DecoratorThrow(new OrderServiceImpl())));
		}
		
		throw new IllegalArgumentException();
 	}
}
