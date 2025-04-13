package service;

import entity.*;
import operation.Dispatcher;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class RideService {
    Dispatcher dispatcher;
    Map<String, Ride> activeRides;

    public RideService(Dispatcher dispatcher) {
        this.dispatcher = dispatcher;
        this.activeRides = new HashMap<>();
    }

    public Ride bookRide(User user, Location dest) {
        Driver driver = dispatcher.findNearestCab(user.currentLocation);
        if (driver == null) {
            System.out.println("No cabs available");
            return null;
        }

        Ride ride = new Ride(UUID.randomUUID().toString(), user, driver, user.currentLocation, dest);
        driver.isAvailable = false;
        activeRides.put(ride.rideId, ride);
        return ride;
    }

    public void completeRide(String rideId) {
        Ride ride = activeRides.get(rideId);
        if (ride != null && ride.status == RideStatus.ONGOING) {
            ride.completeRide();
            activeRides.remove(rideId);
        }
    }
}
