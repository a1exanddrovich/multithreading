package com.epam.blurring;

import java.util.concurrent.ForkJoinPool;

public class BlurActionRunner {

    public static void main(String[] args) {
        int[] src = new int[] {1, 2, 3, 4, 5, 6, 7};
        int[] dst = new int[] {9, 0, 5, 1, 5, 9, 2};

        BlurAction blurAction = new BlurAction(src, 0, src.length, dst);
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(blurAction);
    }

}
