import entities.*;
import enums.VehicleType;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Parking Lot Hello world!");

        Vehicle vehicle = new Vehicle("TS09AB1234", VehicleType.CAR);
        EntryGate gate = new EntryGate();
        List<ParkingSpot> parkingSpotList = new ArrayList<>();
        ParkingLot parkingLot = new ParkingLot(parkingSpotList);
        Ticket ticket = gate.generateTicket(vehicle, parkingLot);

    }
}