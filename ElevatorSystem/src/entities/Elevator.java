package entities;

import java.util.Collections;
import java.util.TreeSet;

public class Elevator {
    public int currentFloor;
    public Direction direction;
    public ElevatorStatus status;
    TreeSet<Integer> upStops;      // Sorted floors upwards
    TreeSet<Integer> downStops;    // Sorted floors downwards in reverse
    public int id;

    public Elevator(int id) {
        this.id = id;
        this.currentFloor = 0;
        this.direction = Direction.IDLE;
        this.status = ElevatorStatus.IDLE;
        this.upStops = new TreeSet<>();
        this.downStops = new TreeSet<>(Collections.reverseOrder());
    }

    public void addNewRequest(int floor) {
        if (floor == currentFloor) return;

        if (floor > currentFloor) {
            upStops.add(floor);
        } else {
            downStops.add(floor);
        }

        updateDirection();
    }

    public void moveOneStep() {
        if (direction == Direction.UP) {
            currentFloor++;
            if (upStops.contains(currentFloor)) {
                upStops.remove(currentFloor);
                status = ElevatorStatus.STOPPED;
            }
        } else if (direction == Direction.DOWN) {
            currentFloor--;
            if (downStops.contains(currentFloor)) {
                downStops.remove(currentFloor);
                status = ElevatorStatus.STOPPED;
            }
        }

        updateDirection();
    }

    private void updateDirection() {
        if (!upStops.isEmpty()) direction = Direction.UP;
        else if (!downStops.isEmpty()) direction = Direction.DOWN;
        else direction = Direction.IDLE;
    }

    public boolean isIdle() {
        return direction == Direction.IDLE;
    }
}

