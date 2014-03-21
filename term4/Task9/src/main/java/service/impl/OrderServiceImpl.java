package service.impl;

import service.OrderService;

public class OrderServiceImpl implements OrderService{
    public String getOrder(String orderNumber) {
        throw new NullPointerException();
    }

    public String addOrder(String orderNumber, Long amount) {
        System.out.println("Saving order " + orderNumber + " to database");
        return orderNumber;
    }
}
