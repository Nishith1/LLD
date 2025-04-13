package operation;

import entity.Driver;
import entity.Location;

import java.util.List;

public class Dispatcher {
    List<Driver> drivers;

    public Dispatcher(List<Driver> drivers) {
        this.drivers = drivers;
    }

    public Driver findNearestCab(Location userLocation) {
        Driver nearest = null;
        double minDistance = Double.MAX_VALUE;

        for (Driver d : drivers) {
            if (!d.isAvailable) continue;
            double dist = d.cab.currentLocation.distanceTo(userLocation);
            if (dist < minDistance) {
                nearest = d;
                minDistance = dist;
            }
        }

        return nearest;
    }
}
