package thread.start.test;

import static util.MyLogger.log;

public class StartTest4Main {

    public static void main(String[] args) {
        Thread threadA = new Thread(new IntervalWorker(1000, "A"), "thread-A");
        Thread threadB = new Thread(new IntervalWorker(500, "B"), "thread-B");

        threadA.start();
        threadB.start();
    }

    static class IntervalWorker implements Runnable {
        private int sleepMs;
        private String content;

        public IntervalWorker(int sleepMs, String content) {
            this.sleepMs = sleepMs;
            this.content = content;
        }

        @Override
        public void run() {
            while (true) {
                log(content);
                try {
                    Thread.sleep(this.sleepMs);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
