import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class SlidingWindowCounterRateLimiter {
    private static class Bucket {
        long timestamp;
        int count;

        Bucket(long timestamp, int count) {
            this.timestamp = timestamp;
            this.count = count;
        }
    }

    private final int maxRequests;
    private final long windowSizeInMillis;
    private final long bucketSizeInMillis;
    private final Map<String, LinkedList<Bucket>> userBuckets;

    public SlidingWindowCounterRateLimiter(int maxRequests, long windowSizeInSeconds, int numBuckets) {
        this.maxRequests = maxRequests;
        this.windowSizeInMillis = windowSizeInSeconds * 1000;
        this.bucketSizeInMillis = windowSizeInMillis / numBuckets;
        this.userBuckets = new HashMap<>();
    }

    public synchronized boolean allowRequest(String userId) {
        long now = System.currentTimeMillis();
        long currentBucketTimestamp = now - (now % bucketSizeInMillis);

        LinkedList<Bucket> buckets = userBuckets.getOrDefault(userId, new LinkedList<>());

        // Remove expired buckets
        while (!buckets.isEmpty() && now - buckets.getFirst().timestamp >= windowSizeInMillis) {
            buckets.removeFirst();
        }

        // Count requests in valid window
        int totalRequests = buckets.stream().mapToInt(b -> b.count).sum();
        if (totalRequests >= maxRequests) {
            return false;
        }

        // Add request to current bucket
        if (!buckets.isEmpty() && buckets.getLast().timestamp == currentBucketTimestamp) {
            buckets.getLast().count++;
        } else {
            buckets.add(new Bucket(currentBucketTimestamp, 1));
        }

        userBuckets.put(userId, buckets);
        return true;
    }
}
