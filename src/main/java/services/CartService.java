package services;

import exceptions.ProductDoesNotExistException;
import exceptions.UserDoesNotExistException;
import models.Cart;
import models.CartItem;
import repository.CartRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static utils.utility.generateNextId;

public class CartService {
    private CartRepository cartRepository;
    private ProductService productService;

    private UserService userService;

    public CartService(CartRepository cartRepository, ProductService productService, UserService userService) {
        this.cartRepository = cartRepository;
        this.productService = productService;
        this.userService = userService;
    }

    public Cart addToCart(String userId, String productId, int quantity) throws ProductDoesNotExistException, UserDoesNotExistException {

        Cart cart = null;
        CartItem cartItem = null;
        Map<String, CartItem> itemsMap = new HashMap<>();

        if (cartRepository.getCart(userId) != null) {
            cart = cartRepository.getCart(userId);
            itemsMap = cart.getCartItems();
            if (cart.getCartItems().containsKey(productId)) {
                cartItem = cart.getCartItems().get(productId);
                Integer quant = cartItem.getQuantity() + quantity;
                cartItem.setQuantity(quant);
                itemsMap.put(productId, cartItem);
            }
            else {
                cartItem = CartItem.builder()
                        .cartItemId(generateNextId())
                        .product(productService.getProduct(productId))
                        .quantity(quantity)
                        .build();
                itemsMap.put(productId, cartItem);
            }
            cart.setCartItems(itemsMap);
            cart.setCartTotal(calculateCartTotal(new ArrayList<>(itemsMap.values())));

        } else {
            cartItem = CartItem.builder()
                    .cartItemId(generateNextId())
                    .product(productService.getProduct(productId))
                    .quantity(quantity)
                    .build();
            itemsMap.put(productId, cartItem);
            cart = Cart.builder()
                    .cartId(generateNextId())
                    .cartItems(itemsMap)
                    .user(userService.getUser(userId))
                    .cartTotal(calculateCartTotal(new ArrayList<>(itemsMap.values())))
                    .build();
        }

        return cartRepository.addToCart(userId, cart);

    }

    public Cart getCart(String userId) {
        return cartRepository.getCart(userId);
    }

    private BigDecimal calculateCartTotal(List<CartItem> cartItems) {
        BigDecimal total = BigDecimal.ZERO;
        for (CartItem cartItem : cartItems) {
            BigDecimal itemTotal = cartItem.getProduct().getAmount().multiply(new BigDecimal(cartItem.getQuantity()));
            total = total.add(itemTotal);
        }
        return total;
    }


}
