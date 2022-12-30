package com.epam.factorial;

import java.math.BigInteger;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

public class FactorialTaskRunner {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ForkJoinTask<BigInteger> forkJoinTask = new FactorialTask(BigInteger.valueOf(5L));
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(forkJoinTask);
        System.out.println(forkJoinTask.get());
    }

}
