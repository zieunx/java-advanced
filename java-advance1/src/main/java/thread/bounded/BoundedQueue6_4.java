package thread.bounded;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

import static util.MyLogger.log;

public class BoundedQueue6_4 implements BoundedQueue {

    private BlockingQueue<String> queue;

    public BoundedQueue6_4(int max) {
        this.queue = new ArrayBlockingQueue<>(max);
    }

    @Override
    public void put(String data) {
        queue.add(data); // IllegalStateException
    }

    @Override
    public String take() {
        return queue.remove(); // NoSuchElementException
    }

    @Override
    public String toString() {
        return queue.toString();
    }
}
