package main.java.com.borysova.secondTask;

import java.util.function.IntConsumer;

class FizzBuzz {
    private int endNumber;
    int startNumber = 1;
    public FizzBuzz(int endNumber) {
        this.endNumber = endNumber;
    }

    public synchronized void displayFizz(Runnable printFizz) throws InterruptedException {
        while(startNumber <= endNumber) {
            if(startNumber % 3 == 0 && startNumber % 5 != 0) {
                printFizz.run();
                startNumber++;
                notifyAll();
            } else {
                wait();
            }
        }
    }

    public synchronized void displayBuzz(Runnable printBuzz) throws InterruptedException {
        while(startNumber <= endNumber) {
            if(startNumber % 3 != 0 && startNumber % 5 == 0) {
                printBuzz.run();
                startNumber++;
                notifyAll();
            } else {
                wait();
            }
        }
    }

    public synchronized void displayFizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while(startNumber <= endNumber) {
            if(startNumber % 15 == 0) {
                printFizzBuzz.run();
                startNumber++;
                notifyAll();
            } else {
                wait();
            }
        }
    }

    public synchronized void displayNumber(IntConsumer printNumber) throws InterruptedException {
        while(startNumber <= endNumber) {
            if(startNumber % 3 != 0 && startNumber % 5 != 0) {
                printNumber.accept(startNumber);
                startNumber++;
                notifyAll();
            } else {
                wait();
            }
        }
    }
}