package by.VDemyanov.JMS_Lab14.multithreading;

import java.util.concurrent.Semaphore;

public class Example2 {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);

        for (int i = 0; i < 6; i++) {
            new Philosopher(semaphore, i).start();
        }
    }
}

class Philosopher extends Thread {
    private Semaphore semaphore;
    int num = 0;
    private int id;

    public Philosopher(Semaphore semaphore, int id) {
        this.semaphore = semaphore;
        this.id = id;
    }

    public void run() {
        try {
            while (num < 3) {
                semaphore.acquire();
                System.out.println("Философ " + id + " садится за стол");
                sleep(500);
                num++;

                System.out.println("Философ " + id + " выходит из-за стол");
                semaphore.release();
                sleep(500);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}