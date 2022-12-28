package com.epam.fibonacci;

import lombok.AllArgsConstructor;

import java.util.concurrent.RecursiveTask;

@AllArgsConstructor
public class FibonacciTask extends RecursiveTask<Integer> {

    private final int n;

    @Override
    protected Integer compute() {
        if (n <= 10) {
            return calculateLinearly(n);
        }

        FibonacciTask fibonacciTaskFirst = new FibonacciTask(n - 1);
        fibonacciTaskFirst.fork();
        FibonacciTask fibonacciTaskSecond = new FibonacciTask(n - 2);
        return fibonacciTaskSecond.compute() + fibonacciTaskFirst.join();
    }

    private Integer calculateLinearly(Integer n) {
        if (n <= 1) {
            return n;
        }

        int previous = 0;
        int current = 1;
        int next = 0;

        for (int i = 1; i < n; i++) {
            next = previous + current;
            previous = current;
            current = next;
        }

        return next;
    }

}
