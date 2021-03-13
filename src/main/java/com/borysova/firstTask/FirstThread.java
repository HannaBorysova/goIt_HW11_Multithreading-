package main.java.com.borysova.firstTask;

public class FirstThread implements Runnable {
        private Stopwatch stopwatch;

        public FirstThread(Stopwatch stopwatch) {
            this.stopwatch = stopwatch;
        }

        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
                this.stopwatch.add();
            }
        }
}
