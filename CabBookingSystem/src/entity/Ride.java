package entity;

public class Ride {
    public String rideId;
    public User user;
    public Driver driver;
    public Location source;
    public Location destination;
    public RideStatus status;

    public Ride(String rideId, User user, Driver driver, Location src, Location dest) {
        this.rideId = rideId;
        this.user = user;
        this.driver = driver;
        this.source = src;
        this.destination = dest;
        this.status = RideStatus.REQUESTED;
    }

    public void startRide() {
        this.status = RideStatus.ONGOING;
    }

    public void completeRide() {
        this.status = RideStatus.COMPLETED;
        driver.isAvailable = true;
    }

    public void cancelRide() {
        this.status = RideStatus.CANCELLED;
        driver.isAvailable = true;
    }
}