import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class SlidingWindowLogRateLimiter {
    private final int maxRequests;
    private final long windowSizeInMillis;
    private final Map<String, Deque<Long>> userRequestLog;

    public SlidingWindowLogRateLimiter(int maxRequests, long windowSizeInSeconds) {
        this.maxRequests = maxRequests;
        this.windowSizeInMillis = windowSizeInSeconds * 1000;
        this.userRequestLog = new HashMap<>();
    }

    public synchronized boolean allowRequest(String userId) {
        long currentTime = System.currentTimeMillis();
        Deque<Long> timestamps = userRequestLog.getOrDefault(userId, new LinkedList<>());

        // Remove expired timestamps
        while (!timestamps.isEmpty() && currentTime - timestamps.peekFirst() >= windowSizeInMillis) {
            timestamps.pollFirst();
        }

        if (timestamps.size() < maxRequests) {
            timestamps.addLast(currentTime);
            userRequestLog.put(userId, timestamps);
            return true;
        }

        return false;
    }
}
