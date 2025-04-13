package entities;

public interface Channel {
    public boolean send(Notification notification, User user);
}
