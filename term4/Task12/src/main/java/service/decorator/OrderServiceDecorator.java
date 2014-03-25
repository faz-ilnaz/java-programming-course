package service.decorator;

import service.OrderService;

public class OrderServiceDecorator implements OrderService {
	
	protected OrderService target;
	
	public OrderServiceDecorator(OrderService target) {
		this.target = target;
	}

	@Override
	public String getOrder(String orderNumber) {
		return target.getOrder(orderNumber);
	}

	@Override
	public String addOrder(String orderNumber, Long amount) {
		return target.addOrder(orderNumber, amount);
	}

}
