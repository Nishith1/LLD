package service;

import entities.Channel;
import entities.Notification;

import java.util.Queue;

public class Dispatcher {
    RetryService retryService;
    Queue<Notification> notificationQueue;

    void processQueue() throws InterruptedException {
        while (!notificationQueue.isEmpty()) {
            Notification n = notificationQueue.poll();
            for (Channel c : n.channels) {
                boolean success = c.send(n, n.recipient);
                if (!success) {
                    retryService.retry(n, c);
                }
            }
        }
    }
}