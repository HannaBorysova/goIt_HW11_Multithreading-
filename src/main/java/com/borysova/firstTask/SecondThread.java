package main.java.com.borysova.firstTask;

public class SecondThread implements Runnable {
    private Stopwatch stopwatch;
    private String message;

    public SecondThread(Stopwatch stopwatch, String message) {
        this.stopwatch = stopwatch;
        this.message = message;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            int n;
            try {
                n = stopwatch.last();
                System.out.println(Thread.currentThread().getName() + " - " + n);
                if (n % 5 == 0)
                    System.out.println(message);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
    }
}