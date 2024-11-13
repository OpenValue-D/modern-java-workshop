package de.openvalue.modernjava.java.examples;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

class VirtualThreads {
    // use newVirtualThreadPerTaskExecutor here

    public static void main(String[] args) {
        Instant start = Instant.now();
        try (var executor = Executors.newCachedThreadPool()) {
            IntStream.range(0, 10_000).forEach(i -> {
                executor.submit(() -> {
                    Thread.sleep(Duration.ofSeconds(1));
                    System.out.println(i);
                    return i;
                });
            });
        }
        Instant finish = Instant.now();
        System.out.println("Time in milliseconds: " + Duration.between(start, finish).toMillis());
    }

}
