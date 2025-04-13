import Dispatcher.AsyncDispatcher;
import appender.impl.ConsoleAppender;
import entities.enums.LogLevel;
import logger.Logger;

public class Main {
    public static void main(String[] args) {
        AsyncDispatcher dispatcher = new AsyncDispatcher();
        dispatcher.addAppender(new ConsoleAppender());

        Logger logger = new Logger(LogLevel.DEBUG, dispatcher);

        logger.debug("Debugging...");
        logger.info("This is info");
        logger.warn("Warning occurred");
        logger.error("Error happened");

        dispatcher.shutdown(); // Optional cleanup
    }
}