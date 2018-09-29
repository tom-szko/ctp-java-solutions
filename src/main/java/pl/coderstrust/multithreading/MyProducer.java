package pl.coderstrust.multithreading;

import java.util.concurrent.BlockingQueue;

class MyProducer implements Runnable {
    private BlockingQueue<Integer> stock;
    private int sleepTime;
    private ThreadColour colour;

    MyProducer(BlockingQueue<Integer> stock, int sleepTime, ThreadColour colour) {
        if (stock == null) {
            throw new IllegalArgumentException("Stock cannot be null.");
        }
        if (sleepTime < 0) {
            throw new IllegalArgumentException("SleepTime cannot be less than 0.");
        }
        if (colour == null) {
            throw new IllegalArgumentException("Colour cannot be null.");
        }
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
                System.out.println(colour.getColour() + "Produced " + item);
                stock.put(item);
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
    }
}
