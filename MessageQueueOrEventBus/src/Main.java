import mq.MessageQueue;
import usage.PrintSubscriber;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        // Example
        MessageQueue mq = new MessageQueue();
        mq.subscribe("sports", new PrintSubscriber("SubscriberA"));
        mq.publish("sports", "Match started");
        mq.publish("sports", "Goal!");
    }
}