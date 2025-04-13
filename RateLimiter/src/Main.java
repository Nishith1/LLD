public class Main {
    public static void main(String[] args) throws InterruptedException {
        // Fixed Window

        System.out.println("Fixed Window Hello world!");
        FixedWindowRateLimiter limiter = new FixedWindowRateLimiter(5, 10); // 5 reqs per 10 secs
        String userId = "nishith";

        for (int i = 1; i <= 7; i++) {
            boolean allowed = limiter.allowRequest(userId);
            System.out.println("Request " + i + ": " + (allowed ? "Allowed" : "Blocked"));
            Thread.sleep(1000); // simulate 1 second between requests
        }

        //Sliding Window

        System.out.println("Sliding Window Hello world!");

        SlidingWindowLogRateLimiter limiter2 = new SlidingWindowLogRateLimiter(3, 5); // 3 reqs per 5 seconds
        String userId2 = "nishith2";

        for (int i = 1; i <= 5; i++) {
            boolean allowed = limiter2.allowRequest(userId2);
            System.out.println("Request " + i + ": " + (allowed ? "Allowed" : "Blocked"));
            Thread.sleep(1000);
        }

        //Sliding Window Counter
        System.out.println("Sliding Window Counter Hello world!");

        SlidingWindowCounterRateLimiter limiter3 = new SlidingWindowCounterRateLimiter(5, 10, 5); // 5 reqs in 10s, split into 5 buckets
        String userId3 = "nishith3";

        for (int i = 1; i <= 7; i++) {
            boolean allowed = limiter3.allowRequest(userId3);
            System.out.println("Request " + i + ": " + (allowed ? "Allowed" : "Blocked"));
            Thread.sleep(1000);
        }


        // Token Bucket
        System.out.println("Token Bucket Counter Hello world!");

        TokenBucketRateLimiter limiter4 = new TokenBucketRateLimiter();
        limiter4.createUserBucket("nishith", 5, 1); // max 5 tokens, refill 1 token/sec

        String userId4 = "nishith4";

        for (int i = 1; i <= 10; i++) {
            boolean allowed = limiter4.allowRequest(userId);
            System.out.println("Request " + i + ": " + (allowed ? "Allowed" : "Blocked"));
            Thread.sleep(500); // simulate 0.5s between requests
        }
    }







}
