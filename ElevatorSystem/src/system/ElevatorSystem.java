package system;

import entities.Elevator;
import request.ExternalRequest;
import request.InternalRequest;
import scheduler.Scheduler;

import java.util.ArrayList;
import java.util.List;

public class ElevatorSystem {
    List<Elevator> elevators;
    Scheduler scheduler;

    public ElevatorSystem(int numElevators) {
        elevators = new ArrayList<>();
        for (int i = 0; i < numElevators; i++) {
            elevators.add(new Elevator(i));
        }
        scheduler = new Scheduler();
    }

    public void handleExternalRequest(ExternalRequest request) {
        Elevator elevator = scheduler.assignElevator(elevators, request);
        if (elevator != null) {
            elevator.addNewRequest(request.floor);
        }
    }

    public void handleInternalRequest(int elevatorId, InternalRequest request) {
        elevators.get(elevatorId).addNewRequest(request.destinationFloor);
    }

    public void stepSimulation() {
        for (Elevator e : elevators) {
            e.moveOneStep();
        }
    }

    public void status() {
        for (Elevator e : elevators) {
            System.out.println("Elevator " + e.id + " is at floor " + e.currentFloor + " in direction " + e.direction);
        }
    }
}