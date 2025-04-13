import java.util.concurrent.RejectedExecutionException;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 10);

        for (int i = 0; i < 20; i++) {
            int taskId = i;
            try {
                executor.submit(() -> {
                    System.out.println(Thread.currentThread().getName() + " is executing task " + taskId);
                    try { Thread.sleep(1000); } catch (InterruptedException e) {}
                });
            } catch (RejectedExecutionException e) {
                System.out.println("Task " + taskId + " rejected: " + e.getMessage());
            }
        }

        Thread.sleep(5000);
        executor.shutdown();
    }
}