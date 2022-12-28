package com.epam.mergesort;

import java.util.Arrays;
import java.util.concurrent.ForkJoinTask;

public class MergeSortActionRunner {

    public static void main(String[] args) {
        int[] array = new int[] {90, 5, 4, 1, 0, 54, 78, 99, 100};

        ForkJoinTask.invokeAll(new MergeSortAction(array));

        System.out.println(Arrays.toString(array));
    }

}
