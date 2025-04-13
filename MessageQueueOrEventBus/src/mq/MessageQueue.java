package mq;

import java.util.*;

public class MessageQueue {
    private Map<String, List<Subscriber>> subscribers = new HashMap<>();
    private Map<String, Queue<String>> messageQueues = new HashMap<>();

    public synchronized void subscribe(String topic, Subscriber subscriber) {
        subscribers.putIfAbsent(topic, new ArrayList<>());
        subscribers.get(topic).add(subscriber);
    }

    public synchronized void publish(String topic, String message) {
        messageQueues.putIfAbsent(topic, new LinkedList<>());
        messageQueues.get(topic).offer(message);

        if (subscribers.containsKey(topic)) {
            for (Subscriber sub : subscribers.get(topic)) {
                sub.consume(message); // In real-world, you'd enqueue and process async
            }
        }
    }
}
