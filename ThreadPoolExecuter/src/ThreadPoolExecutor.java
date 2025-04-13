import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutor {
    private final BlockingQueue<Runnable> taskQueue;
    private final List<Worker> workers;
    private volatile boolean isShutdown = false;

    public ThreadPoolExecutor(int numberOfThreads, int maxQueueSize) {
        taskQueue = new LinkedBlockingQueue<>(maxQueueSize);
        workers = new ArrayList<>();

        for (int i = 0; i < numberOfThreads; i++) {
            Worker worker = new Worker("ThreadPool-Worker-" + i);
            workers.add(worker);
            worker.start();
        }
    }

    public void submit(Runnable task) throws RejectedExecutionException {
        if (isShutdown) {
            throw new RejectedExecutionException("ThreadPool is shutting down. Cannot accept new tasks.");
        }

        boolean accepted = taskQueue.offer(task);
        if (!accepted) {
            throw new RejectedExecutionException("Task queue is full.");
        }
    }

    public void shutdown() {
        isShutdown = true;
        for (Worker worker : workers) {
            worker.interrupt(); // Wake up workers waiting on empty queue
        }
    }

    private class Worker extends Thread {
        public Worker(String name) {
            super(name);
        }

        public void run() {
            while (!isShutdown || !taskQueue.isEmpty()) {
                try {
                    Runnable task = taskQueue.poll(1, TimeUnit.SECONDS);
                    if (task != null) {
                        task.run();
                    }
                } catch (InterruptedException e) {
                    // Thread interrupted: check shutdown flag
                    if (isShutdown) break;
                }
            }
        }
    }
}
