package org.example.was.counter;

public class Counter implements Runnable {

    private int count = 0;

    public void increment() {
        count++;
    }

    public void decrement() {
        count--;
    }

    public int getValue() {
        return count;
    }

    @Override
    public void run() {
        // 동기화 처리
        synchronized (this) {
            this.increment();
            System.out.println("Value for Thread After increment " + Thread.currentThread().getName() + " " + this.getValue()); // 1
            this.decrement();
            System.out.println("Value for Thread After decrement " + Thread.currentThread().getName() + " " + this.getValue()); // 0
        }
    }
}
