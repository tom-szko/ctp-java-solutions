package pl.coderstrust.multithreading.producer_consumer2;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App2 {
    public static void main(String[] args) {
        BlockingQueue<Integer> beerStock = new ArrayBlockingQueue<>(10);
        BeerProducer beerProducer = new BeerProducer(beerStock);
        BeerConsumer beerConsumer = new BeerConsumer(beerStock);
        ExecutorService threadPool2 = Executors.newFixedThreadPool(2);
        threadPool2.submit(beerProducer);
        threadPool2.submit(beerConsumer);
    }
}
