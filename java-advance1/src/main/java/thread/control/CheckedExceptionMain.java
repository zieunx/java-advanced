package thread.control;

import util.ThreadUtils;

public class CheckedExceptionMain {

    public static void main(String[] args) throws Exception {
        throw new Exception();
    }

    static class CheckRunnable implements Runnable {

        @Override
        public void run() {
            ThreadUtils.sleep(1000);
        }
    }
}
