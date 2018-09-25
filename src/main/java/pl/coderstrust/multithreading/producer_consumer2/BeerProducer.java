package pl.coderstrust.multithreading.producer_consumer2;

import java.util.concurrent.BlockingQueue;
import static pl.coderstrust.multithreading.ThreadColors.*;

class BeerProducer implements Runnable {
    private BlockingQueue<Integer> stock;

    BeerProducer(BlockingQueue<Integer> stock) {
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
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
