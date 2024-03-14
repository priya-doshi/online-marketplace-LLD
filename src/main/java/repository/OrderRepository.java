package repository;

import models.Order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderRepository {

    private Map<String, List<Order>> orderMap = new HashMap<>();


    public Order createOrder(String userId, Order order) {
        List<Order> orders = new ArrayList<>();
        orders.add(order);
        if (orderMap.containsKey(userId)) {
            orders = orderMap.get(userId);
            orderMap.put(userId, orders);
        } else
            orderMap.put(userId, orders);

        return order;
    }

    public List<Order> orderHistory(String userId) {
        if (orderMap.containsKey(userId))
            return orderMap.get(userId);

        return null;
    }
}
