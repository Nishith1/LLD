package mq;

public interface Subscriber {
    void consume(String message);
}
