package core;


import service.OrderService;

public class App {
	public static void main(String[] args) throws Exception {


		Factory factory = Factory.getInstance();
		OrderService order = (OrderService) factory.getBean("orderService");
		
		order.addOrder("100", 5l);
		
		order.getOrder("10000");

	}
}