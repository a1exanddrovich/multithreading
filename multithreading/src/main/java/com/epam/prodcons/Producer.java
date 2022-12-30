package com.epam.prodcons;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

import java.util.concurrent.BlockingQueue;

@RequiredArgsConstructor
public class Producer implements Runnable {

    private int questionNumber;
    private final BlockingQueue<Integer> questionQueue;

    @Override
    @SneakyThrows
    public void run() {
        while (true) {
            synchronized (this) {
                int nextQuestion = questionNumber++;
                System.out.println("Next question is " + nextQuestion);
                questionQueue.put(nextQuestion);
            }
        }
    }

}
