package pl.coderstrust.multithreading;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static pl.coderstrust.multithreading.ThreadColors.*;

public class BaseScenario {
    public static void main(String[] args) {
        BlockingQueue<Integer> stock = new ArrayBlockingQueue<>(10);
        MyProducer producer = new MyProducer(stock, 1000, CYAN);
        MyConsumer consumer = new MyConsumer(stock, 0, PURPLE);
        ExecutorService threadPool = Executors.newFixedThreadPool(2);
        threadPool.submit(producer);
        threadPool.submit(consumer);
    }
}
