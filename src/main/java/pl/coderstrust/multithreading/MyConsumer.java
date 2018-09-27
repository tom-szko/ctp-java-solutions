package pl.coderstrust.multithreading;

import java.util.concurrent.BlockingQueue;
import static pl.coderstrust.multithreading.ThreadColors.*;

class MyConsumer implements Runnable {
    private BlockingQueue<Integer> stock;
    private int sleepTime;
    private String colour;

    MyConsumer(BlockingQueue<Integer> stock, int sleepTime, String colour) {
        this.stock = stock;
        this.sleepTime = sleepTime;
        this.colour = colour;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println(colour + "Consumed " + stock.take());
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
    }
}
