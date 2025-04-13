package entities;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Cart {
    private String userId;
    private Map<String, CartItem> items; // key = productId

    public Cart(String userId) {
        this.userId = userId;
        this.items = new HashMap<>();
    }

    public void addItem(CartItem item) {
        if (items.containsKey(item.getProductId())) {
            CartItem existing = items.get(item.getProductId());
            existing.setQuantity(existing.getQuantity() + item.getQuantity());
        } else {
            items.put(item.getProductId(), item);
        }
    }

    public void removeItem(String productId) {
        items.remove(productId);
    }

    public void updateItem(String productId, int quantity) {
        if (items.containsKey(productId)) {
            if (quantity <= 0) {
                removeItem(productId);
            } else {
                items.get(productId).setQuantity(quantity);
            }
        }
    }

    public double calculateTotal() {
        return items.values().stream()
                .mapToDouble(i -> i.getPrice() * i.getQuantity())
                .sum();
    }

    public Collection<CartItem> getItems() {
        return items.values();
    }
}
