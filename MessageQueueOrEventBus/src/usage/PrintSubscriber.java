package usage;

import mq.Subscriber;

public class PrintSubscriber implements Subscriber {
    private String name;

    public PrintSubscriber(String name) {
        this.name = name;
    }

    public void consume(String message) {
        System.out.println(name + " received: " + message);
    }
}


