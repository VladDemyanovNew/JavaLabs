package by.VDemyanov.JMS_Lab14.multithreading;

public class Example1 {
    public static void main(String[] args) {
        Store store = new Store();
        Thread producer = new Thread(new Producer(store));
        Consumer consumer = new Consumer(store, "Consumer");

        producer.start();
        consumer.start();
    }
}

class Store {
    private int product = 0;

    public synchronized void get() throws InterruptedException {
        while (product < 1) {
            wait();
        }
        product--;
        System.out.println("Покупатель купил 1 товар");
        System.out.println("В магазине осталось " + product + " товаров.");
        notify();
    }

    public synchronized void put() throws InterruptedException {
        while (product >= 3) {
            wait();
        }
        product++;
        System.out.println("Поставщик добавил 1 товар");
        System.out.println("В магазине осталось " + product + " товар(ов)");
        notify();
    }
}

class Producer implements Runnable {
    private Store store;

    public Producer(Store store) {
        this.store = store;
    }

    public void run() {
        for (int i = 0; i < 6; i++) {
            try {
                this.store.put();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer extends Thread {
    private Store store;

    public Consumer(Store store, String name) {
        super(name);
        this.store = store;
    }

    public void run() {
        for (int i = 0; i < 6; i++) {
            try {
                this.store.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
