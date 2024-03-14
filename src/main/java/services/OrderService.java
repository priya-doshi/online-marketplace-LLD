package services;

import enums.OrderStatus;
import exceptions.UserDoesNotExistException;
import models.Cart;
import models.Order;
import repository.OrderRepository;

import java.util.Date;
import java.util.List;

import static utils.utility.generateNextId;

public class OrderService {

    private CartService cartService;
    private OrderRepository orderRepository;

    private UserService userService;

    public OrderService(CartService cartService, OrderRepository orderRepository, UserService userService) {
        this.cartService = cartService;
        this.orderRepository = orderRepository;
        this.userService = userService;
    }

    public Order checkout(String userId) throws UserDoesNotExistException {
        Cart cart = cartService.getCart(userId);

        Order order = Order.builder()
                .orderDate(new Date())
                .orderStatus(OrderStatus.COMPLETED)
                .orderId(generateNextId())
                .user(userService.getUser(userId))
                .cart(cart)
                .build();
        return orderRepository.createOrder(userId, order);

    }

    public List<Order> getOrderHistory(String userId) {
        return orderRepository.orderHistory(userId);
    }
}
