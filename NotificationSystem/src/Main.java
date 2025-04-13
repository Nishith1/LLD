import entities.*;
import entities.enums.NotificationPriority;
import service.NotificationService;

import java.util.Arrays;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        User user = new User("u1", "Nishith", "nishith@mail.com", "9999999999", "device_token_xyz");

        Notification notification = new Notification(
                "Hello! You've got a message.",
                NotificationPriority.HIGH,
                Arrays.asList(new EmailChannel(), new SMSChannel(), new PushChannel()),
                user,
                new Date()
        );

        NotificationService service = new NotificationService();
        service.sendNotification(notification);
    }
}