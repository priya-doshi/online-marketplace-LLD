package repository;

import models.Cart;
import models.CartItem;

import java.util.HashMap;
import java.util.Map;

public class CartRepository {


    public CartRepository() {
    }

    private Map<String, Cart> userCartMap = new HashMap<>();

    private Map<String, CartItem> cartItemMap = new HashMap<>();


    public Cart addToCart(String userId, Cart cart) {
        userCartMap.put(userId, cart);
        return cart;
    }

    public Cart getCart(String userId) {

        Cart cart = null;

        if (userCartMap.containsKey(userId))
            cart = userCartMap.get(userId);

        return cart;
    }


}
