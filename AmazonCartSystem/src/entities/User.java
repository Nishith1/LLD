package entities;

public class User {
    private String userId;
    private String email;
    private Cart cart;

    public User(String userId, String email) {
        this.userId = userId;
        this.email = email;
        this.cart = new Cart(userId);
    }

    public Cart getCart() {
        return cart;
    }
}
