package service;

import entities.Channel;
import entities.Notification;

import java.util.Map;

import static java.rmi.server.LogStream.log;

public class RetryService {
    Map<Notification, Integer> retryCountMap;

    void retry(Notification notification, Channel channel) throws InterruptedException {
        int count = retryCountMap.getOrDefault(notification, 0);
        if (count < 3) {
            wait(exponentialBackoff(count));
            retryCountMap.put(notification, count + 1);
            channel.send(notification, notification.recipient);
        } else {
            log("Failed after retries");
        }
    }

    public long exponentialBackoff(int retryCount) {
        return (long) (Math.pow(2, retryCount) * 1000); // milliseconds
    }
}
