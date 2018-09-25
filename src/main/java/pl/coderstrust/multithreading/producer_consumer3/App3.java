package pl.coderstrust.multithreading.producer_consumer3;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App3 {
    public static void main(String[] args) {
        BlockingQueue<Integer> sodaStock = new ArrayBlockingQueue<>(10);
        SodaProducer sodaProducer = new SodaProducer(sodaStock);
        SodaConsumer sodaConsumerOne = new SodaConsumer(sodaStock);
        SodaConsumer sodaConsumerTwo = new SodaConsumer(sodaStock);
        SodaConsumer sodaConsumerThree = new SodaConsumer(sodaStock);
        ExecutorService threadPool3 = Executors.newFixedThreadPool(4);
        threadPool3.submit(sodaProducer);
        threadPool3.submit(sodaConsumerOne);
        threadPool3.submit(sodaConsumerTwo);
        threadPool3.submit(sodaConsumerThree);
    }
}
