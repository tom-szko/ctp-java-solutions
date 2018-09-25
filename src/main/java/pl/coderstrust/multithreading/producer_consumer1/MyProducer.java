package pl.coderstrust.multithreading.producer_consumer1;

import java.util.concurrent.BlockingQueue;
import static pl.coderstrust.multithreading.ThreadColors.*;

class MyProducer implements Runnable {
    private BlockingQueue<Integer> stock;

    MyProducer(BlockingQueue<Integer> stock) {
        this.stock = stock;
    }

    @Override
    public void run() {
        Integer item = 0;
        while (true) {
            item++;
            try {
                System.out.println(ANSI_PURPLE + "Produced " + item);
                stock.put(item);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
