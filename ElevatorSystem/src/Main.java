import entities.Direction;
import request.ExternalRequest;
import request.InternalRequest;
import system.ElevatorSystem;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Hello world!");
        ElevatorSystem system = new ElevatorSystem(2);

        system.handleExternalRequest(new ExternalRequest(5, Direction.UP));
        system.handleInternalRequest(0, new InternalRequest(8));

        for (int i = 0; i < 10; i++) {
            system.status();
            system.stepSimulation();
            Thread.sleep(1000);
        }
    }
}