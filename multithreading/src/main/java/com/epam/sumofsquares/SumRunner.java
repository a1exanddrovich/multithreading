package com.epam.sumofsquares;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Stream;

public class SumRunner {

    public static final int LIMIT = 500_000_000;

    public static void main(String[] args) {
        System.out.println(sumOfSquares(new ForkJoinPool(), generateRandomDoubles()));
    }

    private static double sumOfSquares(ForkJoinPool pool, Double[] array) {
        int n = array.length;
        Applyer a = new Applyer(array, 0, n, null);
        pool.invoke(a);
        return a.result;
    }

    private static Double[] generateRandomDoubles() {
        Random random = new Random();
        return Stream
                .generate(random::nextDouble)
                .limit(LIMIT)
                .toArray(Double[]::new);
    }

}
