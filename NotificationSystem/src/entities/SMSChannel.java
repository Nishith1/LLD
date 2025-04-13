package entities;

public class SMSChannel implements Channel {
    public boolean send(Notification notification, User user) {
        // logic to send SMS
        return true;
    }
}
