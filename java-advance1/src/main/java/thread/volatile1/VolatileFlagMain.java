package thread.volatile1;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class VolatileFlagMain {

    public static void main(String[] args) {
        MyTask task = new MyTask();
        Thread t = new Thread(task);

        log("runFlag = " + task.runFlag);
        t.start();

        sleep(1000);
        log("runFlag 를 flase로 변경 시도");
        task.runFlag = false;
        log("runFlag = " + task.runFlag);
        log("main 종료");

    }

    static class MyTask implements Runnable {

//        boolean runFlag = true;
        volatile boolean runFlag = true;

        @Override
        public void run() {
            log("task 시작");

            while (runFlag) {
                /**
                 * 출력작업이나 다른 작업을 일부러 작성하지 않은 이유:
                 * '컨텍스트 스위칭'이 발생하면 캐시메모리가 메인메모리에서 읽어오면서 '메모리가시성'현상을 제대로 확인하지못할 수 있어서.
                 */
            }

            log("task 종료");
        }
    }
}
