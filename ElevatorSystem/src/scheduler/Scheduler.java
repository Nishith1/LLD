package scheduler;

import entities.Elevator;
import request.ExternalRequest;

import java.util.List;

public class Scheduler {

    public Elevator assignElevator(List<Elevator> elevators, ExternalRequest request) {
        // Basic strategy: pick first idle or nearest elevator
        Elevator best = null;
        int minDistance = Integer.MAX_VALUE;

        for (Elevator e : elevators) {
            int distance = Math.abs(e.currentFloor - request.floor);
            if (e.isIdle() && distance < minDistance) {
                best = e;
                minDistance = distance;
            }
        }

        return best;
    }
}
