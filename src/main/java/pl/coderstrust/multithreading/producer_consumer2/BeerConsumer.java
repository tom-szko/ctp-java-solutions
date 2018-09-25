package pl.coderstrust.multithreading.producer_consumer2;

import java.util.concurrent.BlockingQueue;
import static pl.coderstrust.multithreading.ThreadColors.*;

class BeerConsumer implements Runnable{
    private BlockingQueue<Integer> stock;

    BeerConsumer(BlockingQueue<Integer> stock) {
        this.stock = stock;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println(ANSI_CYAN + "Consumed " + stock.take());
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
