package Dispatcher;

import appender.Appender;
import entities.LogMessage;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class AsyncDispatcher {
    private final BlockingQueue<LogMessage> queue = new LinkedBlockingQueue<>();
    private final List<Appender> appenders = new ArrayList<>();
    private final Thread worker;

    public AsyncDispatcher() {
        worker = new Thread(() -> {
            try {
                while (true) {
                    LogMessage message = queue.take();
                    for (Appender appender : appenders) {
                        appender.append(message);
                    }
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // Shutdown signal
            }
        });
        worker.start();
    }

    public void addAppender(Appender appender) {
        appenders.add(appender);
    }

    public void submit(LogMessage message) {
        queue.offer(message);
    }

    public void shutdown() {
        worker.interrupt();
    }
}
