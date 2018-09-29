package pl.coderstrust.multithreading;

import java.util.concurrent.BlockingQueue;

class MyConsumer implements Runnable {
    private BlockingQueue<Integer> stock;
    private int sleepTime;
    private ThreadColour colour;

    MyConsumer(BlockingQueue<Integer> stock, int sleepTime, ThreadColour colour) {
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
        while (true) {
            try {
                System.out.println(colour.getColour() + "Consumed " + stock.take());
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
    }
}
