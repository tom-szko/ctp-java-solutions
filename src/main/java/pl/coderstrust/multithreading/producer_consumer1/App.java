package pl.coderstrust.multithreading.producer_consumer1;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {
    public static void main(String[] args) {
        BlockingQueue<Integer> stock = new ArrayBlockingQueue<>(10);
        MyProducer producer = new MyProducer(stock);
        MyConsumer consumer = new MyConsumer(stock);
        ExecutorService threadPool = Executors.newFixedThreadPool(2);
        threadPool.submit(producer);
        threadPool.submit(consumer);
    }
}
