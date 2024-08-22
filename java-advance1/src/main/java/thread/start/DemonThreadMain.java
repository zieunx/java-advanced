package thread.start;

public class DemonThreadMain {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + " : main() start");

        DemonThead demonThead = new DemonThead();
        demonThead.setDaemon(true); // 데몬스레드 여부
        demonThead.start();
        System.out.println(Thread.currentThread().getName() + " : main() end");
        // demon 스레드는 1000ms 이후에 종료되는 코드지만, user스레드가 종료되기 때문에 demon 스레드도 종료된다.
    }

    static class DemonThead extends Thread {

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " : run() start");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println(Thread.currentThread().getName() + " : run() end");
        }
    }
}
