package main.java.com.borysova.firstTask;

public class FirstTask {

    public FirstTask(int lifetime) throws InterruptedException {
        Stopwatch sw = new Stopwatch();
        FirstThread firstThread = new FirstThread(sw);
        SecondThread secondThread = new SecondThread(sw,    Thread.currentThread().getName()
                + " - It took 5 seconds");
        Thread thread1 = new Thread(firstThread);
        Thread thread2 = new Thread(secondThread);
        thread1.start();
        thread2.start();
        Thread.sleep(lifetime * 1000 + 100);
        thread1.interrupt();
        thread2.interrupt();
    }

    public static void main(String[] args) throws InterruptedException {
        new FirstTask(21);
    }
}