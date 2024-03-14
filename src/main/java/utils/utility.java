package utils;

import models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class utility {

    public static String generateNextId(){
        return UUID.randomUUID().toString();
    }

    public static void printUser(User user){
        System.out.println("User: ");
        System.out.println(user.getUserId() + "\n" +
                user.getName() + "\n" +
                user.getMobileNumber() + "\n" +
                user.getEmailId() + "\n" +
                user.getAddress() + "\n"
        );
    }

    public static void printProduct(Product product){
        System.out.println("Product : ");
        System.out.println(product.getProductId() + "\n" +
                product.getName() + "\n" +
                product.getDescription() + "\n" +
                product.getAmount() + "\n");
    }

    public static void printCart(Cart cart){
        System.out.println("Cart: ");
        System.out.println(cart.getCartId() + "\n" + cart.getUser().getName() + "\n" +
                cart.getCartTotal() + "\n");

        printCartItems(new ArrayList<>(cart.getCartItems().values()));
    }

    public static void printCartItems(List<CartItem> cartItems){
        System.out.println("Cart Items: ");
        cartItems.forEach(cartItem ->
                System.out.println(cartItem.getCartItemId() + "\n" +
                        cartItem.getProduct().getName() + "\n" +
                        cartItem.getQuantity() + "\n"));
    }

    public static void printOrder(Order order){
        System.out.println("Order: ");
        System.out.println(order.getOrderId() + "\n" +
                order.getOrderDate() + "\n" +
                order.getOrderStatus() + "\n");
        printUser(order.getUser());
        printCart(order.getCart());
        printCartItems(new ArrayList<>(order.getCart().getCartItems().values()));

    }

    public static void printOrderHistory(List<Order> orders){
        System.out.println("Order History: ");
        orders.forEach(order -> printOrder(order));
    }


}
