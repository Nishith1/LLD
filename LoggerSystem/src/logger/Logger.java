package logger;

import Dispatcher.AsyncDispatcher;
import entities.LogMessage;
import entities.enums.LogLevel;

public class Logger {
    private final LogLevel currentLevel;
    private final AsyncDispatcher dispatcher;

    public Logger(LogLevel level, AsyncDispatcher dispatcher) {
        this.currentLevel = level;
        this.dispatcher = dispatcher;
    }

    public void log(LogLevel level, String message) {
        if (level.ordinal() >= currentLevel.ordinal()) {
            dispatcher.submit(new LogMessage(level, message));
        }
    }

    public void debug(String msg) { log(LogLevel.DEBUG, msg); }
    public void info(String msg)  { log(LogLevel.INFO, msg); }
    public void warn(String msg)  { log(LogLevel.WARN, msg); }
    public void error(String msg) { log(LogLevel.ERROR, msg); }
}
