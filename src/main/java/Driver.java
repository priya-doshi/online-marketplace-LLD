import exceptions.ProductDoesNotExistException;
import exceptions.UserDoesNotExistException;
import models.Cart;
import models.Order;
import models.Product;
import models.User;
import repository.CartRepository;
import repository.OrderRepository;
import repository.ProductRepository;
import repository.UserRepository;
import services.CartService;
import services.OrderService;
import services.ProductService;
import services.UserService;

import java.math.BigDecimal;
import java.util.List;

import static utils.utility.*;

public class Driver {
    public static void main(String args[]) throws UserDoesNotExistException, ProductDoesNotExistException {

        UserRepository userRepository = new UserRepository();
        UserService userService = new UserService(userRepository);

        User user = userService.registerUser("Anmol", "anmol@gamil.com", "9090909090", "Bangalore", "password");


        user = userService.getUser(user.getUserId());

        printUser(user);

//        userService.loginUser("Anmol", "xyz");
        userService.loginUser("Anmol", "password");

        ProductRepository productRepository = new ProductRepository();
        ProductService productService = new ProductService(productRepository);

        Product product1 = productService.createProduct("Maggi", "Noddles", BigDecimal.valueOf(15.00));
        Product product2 = productService.createProduct("Kit-kat", "Chocolate", BigDecimal.valueOf(10.00));
        product1 = productService.getProduct(product1.getProductId());

        printProduct(product1);
        printProduct(product2);

        CartRepository cartRepository = new CartRepository();
        CartService cartService = new CartService(cartRepository, productService, userService);
        cartService.addToCart(user.getUserId(), product1.getProductId(), 1);

        Cart cart = cartService.getCart(user.getUserId());

        printCart(cart);

        cartService.addToCart(user.getUserId(), product1.getProductId(), 1);
        cartService.addToCart(user.getUserId(), product2.getProductId(), 1);

        OrderRepository orderRepository = new OrderRepository();

        OrderService orderService = new OrderService(cartService, orderRepository, userService);

        Order order = orderService.checkout(user.getUserId());

        printOrder(order);

        List<Order> orders = orderService.getOrderHistory(user.getUserId());

        printOrderHistory(orders);

    }


}
