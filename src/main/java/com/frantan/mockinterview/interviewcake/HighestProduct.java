package com.frantan.mockinterview.interviewcake;

/**
 * Created by tan on 2/05/2016.
 */
public class HighestProduct {
    /**
     * Given an arrayOfInts, find the highestProduct you can get from three of the integers.
     * The input arrayOfInts will always have at least three integers.
     *
     * The worst case time complexity is O(n). The worst case space complexity is O(1).
     */
    public static int getHighestProductOfThreeInt(int[] array) throws IllegalArgumentException {
        if (array == null || array.length < 3) {
            throw new IllegalArgumentException("Must be 3 or more products");
        }
        int length = array.length;

        int maxNum = Math.max(array[0], array[1]);
        int minNum = Math.min(array[0], array[1]);
        int maxProductOf2 = array[0] * array[1];
        int minProductOf2 = array[0] * array[1];
        int maxProduct = array[0] * array[1] * array[2];

        // Use greedy algorithm. For each element coming in, calculate the max product, the
        // max product of two, the min product of two, max number and min number
        for (int i = 2; i < length; i++) {
            int currentNum = array[i];
            int potentialMaxProduct1 = maxProductOf2 * currentNum;
            int potentialMaxProduct2 = minProductOf2 * currentNum;
            maxProduct = Math.max(Math.max(potentialMaxProduct1, potentialMaxProduct2), maxProduct);
            maxProductOf2 = Math.max(Math.max(maxNum * currentNum, minNum * currentNum), maxProductOf2);
            minProductOf2 = Math.min(Math.min(maxNum * currentNum, minNum * currentNum), minProductOf2);
            maxNum = Math.max(maxNum, currentNum);
            minNum = Math.min(minNum, currentNum);
        }
        return maxProduct;
    }
}
