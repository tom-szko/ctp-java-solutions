package pl.coderstrust.multithreading;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static pl.coderstrust.multithreading.ThreadColour.*;

public class AlternativeScenario {
    public static void main(String[] args) {
        BlockingQueue<Integer> stock = new ArrayBlockingQueue<>(10);
        MyProducer producer = new MyProducer(stock, 0, CYAN);
        MyConsumer consumer = new MyConsumer(stock, 1000, PURPLE);
        ExecutorService threadPool = Executors.newFixedThreadPool(2);
        threadPool.submit(producer);
        threadPool.submit(consumer);
    }
}
