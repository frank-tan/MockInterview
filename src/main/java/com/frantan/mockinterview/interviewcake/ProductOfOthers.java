package com.frantan.mockinterview.interviewcake;

/**
 * Created by tan on 1/05/2016.
 */
public class ProductOfOthers {
    /*
        You have an array of integers, and for each index you want to find the product of every
        integer except the integer at that index.

        Worst case time complexity: O(n)
        Space complexity: O(n)
     */
    public static int[] getProductsOfAllIntsExceptAtIndex(int[] array) throws IllegalArgumentException {
        if(array == null || array.length <= 0){
            throw new IllegalArgumentException("The input array cannot be null");
        }
        int length = array.length;
        if(length == 1){
            return new int[]{1};
        }
        int[] productOfLeft = new int[length];
        productOfLeft[0] = 1;

        // in the first loop, we calculate product of the elements before the current element
        for(int i = 1; i < length; i++) {
            productOfLeft[i] = productOfLeft[i-1] * array[i-1];
        }

        int[] productOfRight = new int[length];
        productOfRight[length-1] = 1;

        // in the second loop, we calculate the product of the elements after the current element,
        // and multiply it to the existing result array
        for(int j = length - 2; j >= 0; j--) {
            productOfRight[j] = productOfRight[j+1] * array[j+1];
        }

        // in the third loop, we multiply each element from the two arrays above
        int[] resultArray = new int[length];
        for(int k = 0; k < length; k++) {
            resultArray[k] = productOfLeft[k] * productOfRight[k];
        }
        return resultArray;
    }
}
