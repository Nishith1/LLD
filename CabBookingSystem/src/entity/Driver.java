package entity;

public class Driver {
    public String driverId;
    public String name;
    public Cab cab;
    public boolean isAvailable;

    public Driver(String driverId, String name, Cab cab) {
        this.driverId = driverId;
        this.name = name;
        this.cab = cab;
        this.isAvailable = true;
    }
}
