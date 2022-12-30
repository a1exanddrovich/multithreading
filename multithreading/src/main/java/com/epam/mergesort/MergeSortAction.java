package com.epam.mergesort;

import lombok.AllArgsConstructor;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;

@AllArgsConstructor
public class MergeSortAction extends RecursiveAction {

    private final int[] array;
    private final int left;
    private final int right;

    public MergeSortAction(int[] array) {
        this(array, 0, array.length - 1);
    }

    @Override
    protected void compute() {
        ForkJoinTask.invokeAll(createSubActions());
    }

    private List<RecursiveAction> createSubActions() {
        if (left < right) {
            int middle = (left + right) / 2;

            return Arrays.asList(new MergeSortAction(array, left, middle),
                    new MergeSortAction(array, middle + 1, right),
                    new MergeAction(array, left, middle, right));
        }
        return Collections.emptyList();
    }

}
