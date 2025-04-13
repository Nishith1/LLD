package entities;

public class Split {
    public User user;
    public double amount;

    public Split(User user, double amount) {
        this.user = user;
        this.amount = amount;
    }
}
