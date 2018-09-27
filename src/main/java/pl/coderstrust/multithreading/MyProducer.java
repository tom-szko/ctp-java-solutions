package pl.coderstrust.multithreading;

import java.util.concurrent.BlockingQueue;
import static pl.coderstrust.multithreading.ThreadColors.*;

class MyProducer implements Runnable {
    private BlockingQueue<Integer> stock;
    private int sleepTime;
    private String colour;

    MyProducer(BlockingQueue<Integer> stock, int sleepTime, String colour) {
        this.stock = stock;
        this.sleepTime = sleepTime;
        this.colour = colour;
    }

    @Override
    public void run() {
        Integer item = 0;
        while (true) {
            item++;
            try {
                System.out.println(colour + "Produced " + item);
                stock.put(item);
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
    }
}
