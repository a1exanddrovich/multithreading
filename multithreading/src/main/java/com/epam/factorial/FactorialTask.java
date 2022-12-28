package com.epam.factorial;

import lombok.AllArgsConstructor;

import java.math.BigInteger;
import java.util.concurrent.RecursiveTask;

@AllArgsConstructor
public class FactorialTask extends RecursiveTask<BigInteger> {

    private final BigInteger value;

    @Override
    protected BigInteger compute() {
        if (value.compareTo(BigInteger.ONE) <= 0) {
            return BigInteger.ONE;
        }

        FactorialTask factorialTask = new FactorialTask(value.subtract(BigInteger.ONE));
        factorialTask.fork();
        return value.multiply(factorialTask.join());
    }

}
