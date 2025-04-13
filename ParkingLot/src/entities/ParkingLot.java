package entities;

import enums.SpotType;
import enums.VehicleType;

import java.util.List;

public class ParkingLot {
    private List<ParkingSpot> spots;

    public ParkingLot(List<ParkingSpot> spots) {
        this.spots = spots;
    }

    public ParkingSpot getAvailableSpot(VehicleType type) {
        SpotType requiredType = mapVehicleToSpot(type);
        for (ParkingSpot spot : spots) {
            if (spot.isAvailable() && spot.getType() == requiredType) {
                return spot;
            }
        }
        return null;
    }

    private SpotType mapVehicleToSpot(VehicleType type) {
        return switch (type) {
            case BIKE -> SpotType.BIKE;
            case CAR -> SpotType.COMPACT;
            case TRUCK -> SpotType.LARGE;
        };
    }
}
