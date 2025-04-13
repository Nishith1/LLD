package entities;

import enums.SpotType;

public class ParkingSpot {

    private String id;
    private SpotType type;
    private boolean isAvailable;
    private Vehicle parkedVehicle;

    public ParkingSpot(String id, SpotType type) {
        this.id = id;
        this.type = type;
        this.isAvailable = true;
    }

    public boolean park(Vehicle vehicle) {
        if (!isAvailable) return false;
        this.parkedVehicle = vehicle;
        this.isAvailable = false;
        return true;
    }

    public void freeUp() {
        this.parkedVehicle = null;
        this.isAvailable = true;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public SpotType getType() {
        return type;
    }

}
