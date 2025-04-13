import java.util.HashMap;
import java.util.Map;

public class TokenBucketRateLimiter {
    static class TokenBucket {
        int capacity;
        double refillRatePerSec;
        double tokens;
        long lastRefillTimestamp;

        public TokenBucket(int capacity, double refillRatePerSec) {
            this.capacity = capacity;
            this.refillRatePerSec = refillRatePerSec;
            this.tokens = capacity; // start full
            this.lastRefillTimestamp = System.currentTimeMillis();
        }

        synchronized boolean allowRequest() {
            refillTokens();

            if (tokens >= 1) {
                tokens -= 1;
                return true;
            }
            return false;
        }

        private void refillTokens() {
            long now = System.currentTimeMillis();
            double tokensToAdd = ((now - lastRefillTimestamp) / 1000.0) * refillRatePerSec;
            tokens = Math.min(capacity, tokens + tokensToAdd);
            lastRefillTimestamp = now;
        }
    }

    private final Map<String, TokenBucket> userBuckets = new HashMap<>();

    public void createUserBucket(String userId, int capacity, double refillRatePerSec) {
        userBuckets.put(userId, new TokenBucket(capacity, refillRatePerSec));
    }

    public boolean allowRequest(String userId) {
        TokenBucket bucket = userBuckets.get(userId);
        if (bucket == null) return false;
        return bucket.allowRequest();
    }
}