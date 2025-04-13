package appender;

import entities.LogMessage;

public interface Appender {
    void append(LogMessage message);
}
