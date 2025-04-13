package service;

import entities.Cart;
import entities.CartItem;

import java.util.HashMap;
import java.util.Map;

public class CartService {
    private Map<String, Cart> cartStore = new HashMap<>(); // In-memory; in real world -> DB/cache

    public Cart getCart(String userId) {
        return cartStore.computeIfAbsent(userId, Cart::new);
    }

    public void addItem(String userId, CartItem item) {
        Cart cart = getCart(userId);
        cart.addItem(item);
    }

    public void updateItem(String userId, String productId, int qty) {
        getCart(userId).updateItem(productId, qty);
    }

    public void removeItem(String userId, String productId) {
        getCart(userId).removeItem(productId);
    }

    public double checkoutTotal(String userId) {
        return getCart(userId).calculateTotal();
    }
}
