package entity;

public class Cab {
    String cabId;
    public Location currentLocation;

    public Cab(String cabId, Location location) {
        this.cabId = cabId;
        this.currentLocation = location;
    }

    public void updateLocation(Location loc) {
        this.currentLocation = loc;
    }
}
