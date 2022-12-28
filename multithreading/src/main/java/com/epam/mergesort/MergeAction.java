package com.epam.mergesort;

import lombok.AllArgsConstructor;

import java.util.Arrays;
import java.util.concurrent.RecursiveAction;

@AllArgsConstructor
public class MergeAction extends RecursiveAction {

    private final int[] array;
    private final int left;
    private final int middle;
    private final int right;

    @Override
    protected void compute() {
        int[] leftPart = Arrays.copyOfRange(array, left, middle + 1);
        int[] rightPart = Arrays.copyOfRange(array, middle + 1, right + 1);

        int i = 0;
        int j = 0;
        int index = left;

        while (i < leftPart.length && j < rightPart.length) {
            if (leftPart[i] < rightPart[j]) {
                array[index] = leftPart[i];
                i++;
            } else {
                array[index] = rightPart[j];
                j++;
            }
            index++;
        }

        while (i < leftPart.length) {
            array[index] = leftPart[i];
            i++;
        }

        while (j < rightPart.length) {
            array[index] = leftPart[j];
            j++;
        }
    }

}
