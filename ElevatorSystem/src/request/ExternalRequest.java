package request;

import entities.Direction;

public class ExternalRequest {
    public int floor;
    Direction direction;

    public ExternalRequest(int floor, Direction direction) {
        this.floor = floor;
        this.direction = direction;
    }
}
