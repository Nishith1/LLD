package service;

import entities.Notification;

import java.util.Queue;

public class NotificationService {
    Queue<Notification> notificationQueue;
    Dispatcher dispatcher;

    public void sendNotification(Notification notification) {
        notificationQueue.add(notification);
    }
}
