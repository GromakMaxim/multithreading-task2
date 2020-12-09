package org.example;

import java.util.Random;
import java.util.concurrent.Callable;

public class MyCallable implements Callable<Integer> {
    int messageCounter = 0;
    String name;

    public MyCallable(String name) {
        this.name = name;
    }

    @Override
    public Integer call() throws Exception {
        int iteration = 0;
        while (iteration < 5) {
            Random random = new Random();
            Thread.sleep(random.nextInt(5000));
            iteration++;
            messageCounter++;
            System.out.println( name + " Это моё " + messageCounter + " сообщение!");
        }
        return messageCounter;
    }
}
