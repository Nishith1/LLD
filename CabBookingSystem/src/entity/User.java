package entity;

public class User {
    public String userId;
    public String name;
    public Location currentLocation;

    public User(String userId, String name, Location loc) {
        this.userId = userId;
        this.name = name;
        this.currentLocation = loc;
    }
}