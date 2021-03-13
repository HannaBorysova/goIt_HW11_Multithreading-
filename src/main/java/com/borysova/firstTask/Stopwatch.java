package main.java.com.borysova.firstTask;

public class Stopwatch {
    private int second = 0;

    public synchronized void add() {
        this.second++;
        notify();
    }

    public synchronized int last() throws InterruptedException {
        wait();
        return this.second;
    }
}
