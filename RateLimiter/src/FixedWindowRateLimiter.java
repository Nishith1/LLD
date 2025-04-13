import java.util.concurrent.ConcurrentHashMap;

public class FixedWindowRateLimiter {
    private static class Counter {
        long windowStart;
        int count;

        Counter(long windowStart) {
            this.windowStart = windowStart;
            this.count = 1;
        }
    }

    private final int maxRequests;
    private final long windowSizeInMillis;
    private final ConcurrentHashMap<String, Counter> userRequestMap;

    public FixedWindowRateLimiter(int maxRequests, long windowSizeInSeconds) {
        this.maxRequests = maxRequests;
        this.windowSizeInMillis = windowSizeInSeconds * 1000;
        this.userRequestMap = new ConcurrentHashMap<>();
    }

    public boolean allowRequest(String userId) {
        long currentTime = System.currentTimeMillis();
        Counter counter = userRequestMap.get(userId);

        if (counter == null || currentTime - counter.windowStart >= windowSizeInMillis) {
            // Start new window
            counter = new Counter(currentTime);
            userRequestMap.put(userId, counter);
            return true;
        }

        if (counter.count < maxRequests) {
            counter.count++;
            return true;
        }

        return false; // Rate limit exceeded
    }
}
