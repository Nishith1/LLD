package entities;

import entities.enums.LogLevel;

public class LogMessage {
    public final LogLevel level;
    public final String message;
    public final long timestamp;

    public LogMessage(LogLevel level, String message) {
        this.level = level;
        this.message = message;
        this.timestamp = System.currentTimeMillis();
    }
}
