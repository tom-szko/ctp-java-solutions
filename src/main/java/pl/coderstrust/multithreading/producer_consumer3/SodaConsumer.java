package pl.coderstrust.multithreading.producer_consumer3;

import java.util.concurrent.BlockingQueue;
import static pl.coderstrust.multithreading.ThreadColors.*;

class SodaConsumer implements Runnable{
    private BlockingQueue<Integer> stock;

    SodaConsumer(BlockingQueue<Integer> stock) {
        this.stock = stock;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println(ANSI_CYAN + Thread.currentThread().getName() + " consumed " + stock.take());
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
