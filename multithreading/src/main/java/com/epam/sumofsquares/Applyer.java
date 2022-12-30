package com.epam.sumofsquares;

import lombok.RequiredArgsConstructor;

import java.util.concurrent.RecursiveAction;

@RequiredArgsConstructor
public class Applyer extends RecursiveAction {

    private final Double[] array;
    private final int lo;
    private final int hi;
    double result;
    private final Applyer next;

    @Override
    protected void compute() {
        int l = lo;
        int h = hi;
        Applyer right = null;
        while (h - l > 1 && getSurplusQueuedTaskCount() <= 3) {
            int mid = (l + h) >>> 1;
            right = new Applyer(array, mid, h, right);
            right.fork();
            h = mid;
        }
        double sum = atLeaf(l, h);
        while (right != null) {
            if (right.tryUnfork())
                sum += right.atLeaf(right.lo, right.hi);
            else {
                right.join();
                sum += right.result;
            }
            right = right.next;
        }
        result = sum;
    }

    double atLeaf(int l, int h) {
        double sum = 0;
        for (int i = l; i < h; ++i)
            sum += array[i] * array[i];
        return sum;
    }


}
