package pl.coderstrust.multithreading.producer_consumer3;

import java.util.concurrent.BlockingQueue;
import static pl.coderstrust.multithreading.ThreadColors.*;

class SodaProducer implements Runnable {
    private static final Object lock = new Object();
    private static Integer item = 0;
    private BlockingQueue<Integer> stock;

    SodaProducer(BlockingQueue<Integer> stock) {
        this.stock = stock;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (lock) {
                item++;
            }
            try {
                System.out.println(ANSI_PURPLE + Thread.currentThread().getName() + " produced " + item);
                stock.put(item);
                Thread.sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
