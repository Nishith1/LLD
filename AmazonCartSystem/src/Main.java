import entities.CartItem;
import service.CartService;

public class Main {
    public static void main(String[] args) {
        CartService cartService = new CartService();

        cartService.addItem("user1", new CartItem("P1001", "iPhone 15", 79999.0, 1));
        cartService.addItem("user1", new CartItem("P1002", "AirPods Pro", 24999.0, 1));

        double total = cartService.checkoutTotal("user1");
        System.out.println("Total = " + total);
    }
}