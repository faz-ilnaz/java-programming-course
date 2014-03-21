package core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import service.CustomerService;
import service.OrderService;

public class App {
	public static void main(String[] args) throws Exception {

		ApplicationContext appContext = new ClassPathXmlApplicationContext("Spring-beans.xml");

		OrderService order = (OrderService)appContext.getBean(OrderService.class);
		
		order.addOrder("10000", 5l);
		
		order.getOrder("10000");
		
//		CustomerService customer = (CustomerService) appContext.getBean(CustomerService.class);
		
//		customer.addCustomer();
//		
//		customer.addCustomerReturnValue();
//		
//		customer.addCustomerAround("customer#1");

//      customer.addCustomerThrowException();

	}
}