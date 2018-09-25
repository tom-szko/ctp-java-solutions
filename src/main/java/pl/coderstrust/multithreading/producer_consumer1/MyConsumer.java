package pl.coderstrust.multithreading.producer_consumer1;

import java.util.concurrent.BlockingQueue;
import static pl.coderstrust.multithreading.ThreadColors.*;

class MyConsumer implements Runnable {
    private BlockingQueue<Integer> stock;

    MyConsumer(BlockingQueue<Integer> stock) {
        this.stock = stock;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println(ANSI_CYAN + "Consumed " + stock.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
