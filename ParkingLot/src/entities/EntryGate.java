package entities;

import java.util.UUID;

public class EntryGate {

    public Ticket generateTicket(Vehicle vehicle, ParkingLot lot) {
        ParkingSpot spot = lot.getAvailableSpot(vehicle.getType());
        if (spot == null) throw new RuntimeException("No spot available");

        spot.park(vehicle);
        String ticketId = UUID.randomUUID().toString();
        return new Ticket(ticketId, vehicle, spot);
    }
}
