import entity.*;
import operation.Dispatcher;
import service.RideService;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        // Setup
        var user = new User("u1", "Nishith", new Location(12.0, 78.0));
        Driver driver = new Driver("d1", "John", new Cab("c1", new Location(12.01, 78.01)));

        List<Driver> drivers = Arrays.asList(driver);
        Dispatcher dispatcher = new Dispatcher(drivers);
        RideService rideService = new RideService(dispatcher);

// Book a ride
        Ride ride = rideService.bookRide(user, new Location(12.02, 78.03));
        if (ride != null) {
            System.out.println("Ride booked with driver: " + ride.driver.name);
            ride.startRide();
            rideService.completeRide(ride.rideId);
        }
    }
}