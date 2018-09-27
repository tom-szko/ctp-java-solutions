package pl.coderstrust.multithreading;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static pl.coderstrust.multithreading.ThreadColors.*;

public class MultipleConsumers {
    public static void main(String[] args) {
        BlockingQueue<Integer> stock = new ArrayBlockingQueue<>(10);
        MyProducer producer = new MyProducer(stock, 500, CYAN);
        MyConsumer consumerOne = new MyConsumer(stock, 2000, GREEN);
        MyConsumer consumerTwo = new MyConsumer(stock, 2000, PURPLE);
        MyConsumer consumerThree = new MyConsumer(stock, 2000, RED);
        ExecutorService threadPool = Executors.newFixedThreadPool(4);
        threadPool.submit(producer);
        threadPool.submit(consumerOne);
        threadPool.submit(consumerTwo);
        threadPool.submit(consumerThree);
    }
}
