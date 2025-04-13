package entities;

import entities.enums.NotificationPriority;
import entities.enums.NotificationStatus;

import java.util.Date;
import java.util.List;

public class Notification {
    public String id;
    public String message;
    public NotificationPriority priority;
    public NotificationStatus status;
    public List<Channel> channels;
    public User recipient;
    public Date scheduledTime;

    public Notification(String message, NotificationPriority priority, List<Channel> channels, User recipient, Date scheduledTime) {
        this.message = message;
        this.priority = priority;
        this.channels = channels;
        this.recipient = recipient;
        this.scheduledTime = scheduledTime;
    }


}

