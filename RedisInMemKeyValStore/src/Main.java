import store.InMemoryKeyValueStore;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        InMemoryKeyValueStore redis = new InMemoryKeyValueStore();

        redis.put("foo", "bar", 3000); // expires in 3s
        System.out.println(redis.get("foo")); // bar
        Thread.sleep(4000);
        System.out.println(redis.get("foo")); // null

        redis.shutdown();
    }
}