package com.epam.fibonacci;

import java.util.concurrent.ForkJoinPool;

public class FibonacciTaskRunner {

    public static void main(String[] args) {
        FibonacciTask task = new FibonacciTask(45);
        int result = new ForkJoinPool().invoke(task);
        System.out.println(result);
    }

}
