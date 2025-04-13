package appender.impl;

import appender.Appender;
import entities.LogMessage;

public class ConsoleAppender implements Appender {
    public void append(LogMessage message) {
        System.out.println("[" + message.level + "] " + message.timestamp + ": " + message.message);
    }
}
