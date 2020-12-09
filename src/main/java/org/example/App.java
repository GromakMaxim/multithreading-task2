package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Callable<Integer>> tasks = new ArrayList<>();//оллекция для invokeAny

        //создаём пул потоков
        final ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        //заполняем коллекцию
        tasks.add(new MyCallable("задача A"));
        tasks.add(new MyCallable("задача B"));
        tasks.add(new MyCallable("задача C"));
        tasks.add(new MyCallable("задача D"));

        System.out.println(executor.invokeAny(tasks));
        executor.shutdownNow();

    }
}
