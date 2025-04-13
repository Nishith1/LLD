package entities;

public class EmailChannel implements Channel {
    public boolean send(Notification notification, User user) {
        // logic to send email
        return true;
    }
}